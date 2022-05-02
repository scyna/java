package io.scyna.ex.basic;

import io.scyna.Error;
import io.scyna.Service;
import io.scyna.ex.basic.proto.AddRequest;
import io.scyna.ex.basic.proto.AddResponse;

public class AddService extends Service.Handler<AddRequest> {
    @Override
    public void execute() {
        LOG.info("Receive AddRequest");
        var sum = request.getA() + request.getB();
        if (sum > 100) {
            error(Error.REQUEST_INVALID);
        } else {
            done(AddResponse.newBuilder().setSum(sum).build());
        }
    }
}