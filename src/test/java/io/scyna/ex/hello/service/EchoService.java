package io.scyna.ex.hello.service;

import io.scyna.Endpoint;
import io.scyna.ex.hello.proto.EchoRequest;
import io.scyna.ex.hello.proto.EchoResponse;

public class EchoService extends Endpoint.Handler<EchoRequest> {
    @Override
    public void execute() throws io.scyna.Error {
        context.info("Receive EchoRequest");
        response(EchoResponse.newBuilder().setText(request.getText()).build());
    }
}