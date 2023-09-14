package scyna.eventstore;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.nio.ByteBuffer;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;

import scyna.Engine;

public abstract class Projection<E extends Message, D extends Message> implements IProjection {
    protected abstract void Execute(E event, D data);

    private Parser<D> dataParser;
    private Parser<E> eventParser;
    private String type;

    @SuppressWarnings("unchecked")
    void init() throws Exception {
        var eventClass = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Method m = eventClass.getMethod("parser");
        this.eventParser = (Parser<E>) m.invoke(null);
        type = eventClass.getName();

        var dataClass = (Class<D>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        m = dataClass.getMethod("parser");
        this.dataParser = (Parser<D>) m.invoke(null);
    }

    @Override
    public void update(ByteBuffer event, ByteBuffer data) {
        try {
            var dataObject = dataParser.parseFrom(data);
            var eventObject = eventParser.parseFrom(event);
            Execute(eventObject, dataObject);
        } catch (InvalidProtocolBufferException e) {
            Engine.LOG().error(e.getMessage());
        }
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public Message parseEvent(ByteBuffer data) {
        try {
            return eventParser.parseFrom(data);
        } catch (InvalidProtocolBufferException e) {
            Engine.LOG().error(e.getMessage());
        }
        return null;
    }
}
