package scyna.ex.hello.service;

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
        } else {
            response(AddResponse.newBuilder().setSum(sum).build());
        }
    }
}