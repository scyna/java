package scyna;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.util.JsonFormat;

import scyna.proto.ReadSettingRequest;
import scyna.proto.ReadSettingResponse;
import scyna.proto.SettingRemovedSignal;
import scyna.proto.SettingUpdatedSignal;
import scyna.proto.WriteSettingRequest;

import java.util.HashMap;
import java.util.Map;

public class Settings {
    Map<String, String> data = new HashMap<String, String>();

    public boolean write(String key, String value) {
        this.update(key, value);

        var request = WriteSettingRequest.newBuilder()
                .setModule(Engine.module())
                .setKey(key)
                .setValue(value).build();
        var response = Request.send(Path.SETTING_WRITE_URL, request);
        return response != null && response.getCode() == 200;
    }

    public String read(String key) {
        synchronized (this) {
            if (data.containsKey(key))
                return data.get(key);
        }

        var request = ReadSettingRequest.newBuilder()
                .setModule(Engine.module())
                .setKey(key)
                .build();
        var response = Request.send(Path.SETTING_READ_URL, request);
        if (response != null && response.getCode() == 200) {
            try {
                var r = ReadSettingResponse.parseFrom(response.getBody());
                this.update(key, r.getValue());
                return r.getValue();
            } catch (InvalidProtocolBufferException e) {
                return null;
            }
        }
        return null;
    }

    public Message read(String key, Message.Builder builder) {
        String value = read(key);
        try {
            JsonFormat.parser().merge(value, builder);
        } catch (InvalidProtocolBufferException ex) {
            return null;
        }

        return builder.build();
    }

    private void update(String key, String value) {
        synchronized (this) {
            data.put(key, value);
        }
    }

    private void remove(String key) {
        synchronized (this) {
            data.remove(key);
        }
    }

    public static class UpdateHandler extends Signal.Handler<SettingUpdatedSignal> {
        @Override
        public void execute() {
            if (data.getModule() == Engine.module()) {
                Engine.settings().update(data.getKey(), data.getValue());
            }
        }
    }

    public static class RemoveHandler extends Signal.Handler<SettingRemovedSignal> {
        @Override
        public void execute() {
            if (data.getModule() == Engine.module()) {
                Engine.settings().remove(data.getKey());
            }
        }
    }
}
