package scyna.ex.hello.services;

import scyna.Endpoint;
import scyna.ex.hello.proto.AddRequest;
import scyna.ex.hello.proto.AddResponse;

public class AddService extends Endpoint.Handler<AddRequest> {
    @Override
    public void execute() throws scyna.Error {
        context.info("Receive AddRequest");

        var sum = request.getA() + request.getB();
        if (sum > 100) {
            throw scyna.Error.REQUEST_INVALID;
        }

        response(AddResponse.newBuilder().setSum(sum).build());
    }
}