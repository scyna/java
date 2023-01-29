package io.scyna.ex.basic.service;

import io.scyna.Endpoint;
import io.scyna.ex.basic.proto.EchoRequest;
import io.scyna.ex.basic.proto.EchoResponse;

public class EchoService extends Endpoint.Handler<EchoRequest> {
    @Override
    public void execute() throws io.scyna.Error {
        context.info("Receive EchoRequest");
        response(EchoResponse.newBuilder().setText(request.getText()).build());
    }
}