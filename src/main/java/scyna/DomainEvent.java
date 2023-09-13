package scyna;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

import com.google.protobuf.Message;

public class DomainEvent {
    public class EventData {
        public long traceID;
        public Message data;

        public EventData(long traceID, Message data) {
            this.traceID = traceID;
            this.data = data;
        }

    }

    public interface IHandler {
        void EventReceived(EventData data);
    }

    public abstract class Handler<T> implements IHandler {
        protected T data;
        protected Context context;// = new Context();
        protected Trace trace; // = Trace.newDomainEvent(this.getClass().getName(), 0);

        public abstract void Execute() throws scyna.Error;

        protected void onError(Exception e) {
            context.error(e.getStackTrace().toString());
        }

        public void EventReceived(EventData event) {
            this.data = (T) event.data;
            context = new Context(event.traceID);
            try {
                Execute();
            } catch (scyna.Error e) {
                /* TODO */
                onError(e);
            } catch (Exception e) {
                onError(e);
            }
            trace.record();
        }
    }

    private final BlockingQueue<EventData> events = new LinkedBlockingDeque<EventData>();

    private final Map<Class, List<IHandler>> handlers = new HashMap<Class, List<IHandler>>();

    public <T> void register(Handler<T> handler) {
        var type = handler.getClass();
        System.out.println("Register DomainEvent:" + type.getName());
        if (handlers.containsKey(type)) {
            var list = handlers.get(type);
            list.add(handler);
        } else {
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

    public void start() {
        new Thread(() -> {
            while (true) {
                var item = events.poll();
                var type = item.data.getClass();
                if (handlers.containsKey(type)) {
                    var list = handlers.get(type);
                    if (list == null) {
                        System.out.println("DomainEvent: no handler for " + type.getName());
                        continue;
                    }
                    for (var handler : list) {
                        handler.EventReceived(item);
                    }
                }
            }
        }).start();
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
