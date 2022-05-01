package io.scyna.ex.basic;

import io.scyna.ServiceStatefulHandler;
import io.scyna.ex.basic.proto.EchoRequest;
import io.scyna.ex.basic.proto.EchoResponse;

public class EchoService extends ServiceStatefulHandler<EchoRequest> {
    @Override
    public void execute() {
        LOG.info("Receive EchoRequest");
        done(EchoResponse.newBuilder().setText(request.getText()).build());
    }
}