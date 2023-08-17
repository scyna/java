package ex.hello.services;

import ex.hello.proto.AddRequest;
import ex.hello.proto.AddResponse;
import scyna.Endpoint;

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