package io.scyna.ex.basic;

import io.scyna.Engine;
import io.scyna.Service;
import io.scyna.ex.basic.proto.EchoRequest;
import io.scyna.ex.basic.proto.EchoResponse;

public class Main {
    public static void main(String[] args) throws Exception {
        Engine.init("http://127.0.0.1:8081", "scyna.test", "123456");
        Service.register("/test/echo", new EchoService());

        var request = EchoRequest.newBuilder().setText("hello").build();
        var r = Service.sendRequest("/test/echo", request);

        if (r != null && r.getCode() == 200) {
            var response = EchoResponse.parseFrom(r.getBody());
            System.out.println("Text=" + response.getText());
        }
    }
}
