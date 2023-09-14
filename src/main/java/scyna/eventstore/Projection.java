package scyna.eventstore;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.nio.ByteBuffer;

import com.google.protobuf.Message;
import com.google.protobuf.Parser;

public abstract class Projection<E extends Message, D extends Message> implements IProjection {
    protected abstract void Execute(E event, D data);

    private Parser<D> dataParser;
    private Parser<E> eventParser;

    @SuppressWarnings("unchecked")
    void init() throws Exception {
        var eventClass = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
        Method m = eventClass.getMethod("parser");
        this.eventParser = (Parser<E>) m.invoke(null);

        var dataClass = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[1];
        m = dataClass.getMethod("parser");
        this.dataParser = (Parser<D>) m.invoke(null);
    }

    @Override
    public void Update(ByteBuffer event, ByteBuffer data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Update'");
    }

    @Override
    public boolean Matched(String type) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Matched'");
    }

    @Override
    public String Type() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Type'");
    }

    @Override
    public Message ParseEvent(byte[] data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ParseEvent'");
    }

}
