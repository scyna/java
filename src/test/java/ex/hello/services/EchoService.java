package ex.hello.services;

import ex.hello.proto.EchoRequest;
import ex.hello.proto.EchoResponse;
import scyna.Endpoint;

public class EchoService extends Endpoint.Handler<EchoRequest> {
    @Override
    public void execute() throws scyna.Error {
        context.info("Receive EchoRequest");
        response(EchoResponse.newBuilder().setText(request.getText()).build());
    }
}