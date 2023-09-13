package scyna.utils;

import java.lang.reflect.ParameterizedType;

import com.google.protobuf.ByteString;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;

public class MessageParser<T extends Message> {
    @SuppressWarnings("unchecked")
    public T parseFrom(ByteString data) {
        Class<T> cls = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
        try {
            var m = cls.getMethod("parser");
            var parser = (Parser<T>) m.invoke(null);
            return parser.parseFrom(data);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
