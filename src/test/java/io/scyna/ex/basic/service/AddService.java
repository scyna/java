package io.scyna.ex.basic.service;

import io.scyna.Endpoint;
import io.scyna.ex.basic.proto.AddRequest;
import io.scyna.ex.basic.proto.AddResponse;

public class AddService extends Endpoint.Handler<AddRequest> {
    @Override
    public void execute() throws io.scyna.Error {
        context.info("Receive AddRequest");
        var sum = request.getA() + request.getB();

        if (sum > 100) {
            throw io.scyna.Error.REQUEST_INVALID;
        } else {
            response(AddResponse.newBuilder().setSum(sum).build());
        }
    }
}