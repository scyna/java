package scyna;

import java.io.Console;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import com.google.protobuf.Message;

public class DomainEvent {
    private DomainEvent() {
    }

    private static DomainEvent instance;

    public static DomainEvent Instance() {
        if (instance == null)
            instance = new DomainEvent();
        return instance;
    }

    public static <T extends Message> void Register(Handler<T> handler) {
        Instance().register(handler);
    }

    public static class EventData {
        long traceID;
        Message data;

        public EventData(long traceID, Message data) {
            this.traceID = traceID;
            this.data = data;
        }
    }

    public interface IHandler {
        void EventReceived(EventData data);
    }

    public static abstract class Handler<T extends Message> implements IHandler {
        protected T data;
        protected Context context;

        public abstract void execute() throws scyna.Error;

        protected void onError(Exception e) {
            context.error(e.getStackTrace().toString());
        }

        @SuppressWarnings("unchecked")
        public void EventReceived(EventData event) {
            this.data = (T) event.data;
            context = new Context(event.traceID);
            var trace = Trace.DomainEvent(this.getClass().getName(), event.traceID);
            try {
                execute();
            } catch (scyna.Error e) {
                if (e == Error.COMMAND_NOT_COMPLETED) {
                    for (int i = 0; i < 5; i++) {
                        if (retry())
                            return;
                    }
                }
                onError(e);
            } catch (Exception e) {
                onError(e);
            }
            trace.record();
        }

        private boolean retry() {
            try {
                this.execute();
            } catch (scyna.Error e) {
                if (e == Error.COMMAND_NOT_COMPLETED)
                    return false;
                onError(e);
            } catch (Exception e) {
                System.out.println("Retry Error:" + e.getMessage());
                onError(e);
            }
            return true;
        }

        @SuppressWarnings("unchecked")
        public void TestEventReceived(EventData event) throws Error {
            var trace = Trace.DomainEvent(this.getClass().getName(), event.traceID);
            this.data = (T) event.data;
            context = new Context(event.traceID);
            execute();
            trace.record();
        }

        @SuppressWarnings("unchecked")
        Class<T> getEventType() {
            return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                    .getActualTypeArguments()[0];
        }
    }

    private final BlockingQueue<EventData> events = new LinkedBlockingDeque<EventData>();
    private final Map<Class<?>, List<IHandler>> handlers = new HashMap<Class<?>, List<IHandler>>();

    public <T extends Message> void register(Handler<T> handler) {
        var type = handler.getEventType();
        System.out.println("Register DomainEvent:" + type.getName());
        if (handlers.containsKey(type)) {
            var list = handlers.get(type);
            list.add(handler);
        } else {
            System.out.println("Register DomainEvent:" + type.getName());
            var list = new LinkedList<IHandler>();
            list.add(handler);
            handlers.put(type, list);
        }
    }

    public void clear() {
        events.clear();
    }

    public void addEvent(long traceID, Message data) {
        events.add(new EventData(traceID, data));
    }

    private void run() {
        while (true) {
            try {
                var item = events.poll(5, TimeUnit.SECONDS);
                if (item == null)
                    continue;
                var type = item.data.getClass();
                if (handlers.containsKey(type)) {
                    var list = handlers.get(type);
                    for (var handler : list) {
                        handler.EventReceived(item);
                    }
                } else
                    System.out.println("DomainEvent: no handler for " + type.getName());
            } catch (InterruptedException e) {
                /* do nothing */
            }
        }
    }

    public void start() {
        new Thread(() -> run()).start();
    }

    public Message nextEvent() {
        try {
            var item = events.poll(10, TimeUnit.SECONDS);
            if (item == null)
                return null;
            return item.data;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
