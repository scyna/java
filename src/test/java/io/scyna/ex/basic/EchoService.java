package io.scyna.ex.basic;

import io.scyna.Service;
import io.scyna.ex.basic.proto.EchoRequest;
import io.scyna.ex.basic.proto.EchoResponse;

public class EchoService extends Service.Handler<EchoRequest> {
    @Override
    public void execute() {
        LOG.info("Receive EchoRequest");
        done(EchoResponse.newBuilder().setText(request.getText()).build());
    }
}