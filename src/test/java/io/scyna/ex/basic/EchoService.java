package io.scyna.ex.basic;

import io.scyna.Endpoint;
import io.scyna.ex.basic.proto.EchoRequest;
import io.scyna.ex.basic.proto.EchoResponse;

public class EchoService extends Endpoint.Handler<EchoRequest> {
    @Override
    public void execute() {
        context.info("Receive EchoRequest");
        done(EchoResponse.newBuilder().setText(request.getText()).build());
    }
}