package scyna.ex.hello.service;

import scyna.Endpoint;
import scyna.ex.hello.proto.EchoRequest;
import scyna.ex.hello.proto.EchoResponse;

public class EchoService extends Endpoint.Handler<EchoRequest> {
    @Override
    public void execute() throws scyna.Error {
        context.info("Receive EchoRequest");
        response(EchoResponse.newBuilder().setText(request.getText()).build());
    }
}