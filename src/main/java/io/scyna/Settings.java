package io.scyna;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.util.JsonFormat;

import io.scyna.proto.ReadSettingRequest;
import io.scyna.proto.ReadSettingResponse;
import io.scyna.proto.SettingUpdatedSignal;
import io.scyna.proto.SettingRemovedSignal;
import io.scyna.proto.WriteSettingRequest;

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
        var response = Service.sendRequest(Path.SETTING_WRITE_URL, request);
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
        var response = Service.sendRequest(Path.SETTING_READ_URL, request);
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

    public static class UpdateHandler implements Command.Handler {
        @Override
        public void execute(byte[] data) {
            try {
                var s = SettingUpdatedSignal.parseFrom(data);
                if (s.getModule() == Engine.module()) {
                    Engine.settings().update(s.getKey(), s.getValue());
                }
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
        }
    }

    public static class RemoveHandler implements Command.Handler {
        @Override
        public void execute(byte[] data) {
            try {
                var s = SettingRemovedSignal.parseFrom(data);
                if (s.getModule() == Engine.module()) {
                    Engine.settings().remove(s.getKey());
                }
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
        }
    }
}
