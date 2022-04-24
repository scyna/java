package io.scyna.ex.echo;

import io.scyna.ServiceHandler;
import io.scyna.ex.echo.proto.EchoRequest;
import io.scyna.ex.echo.proto.EchoResponse;

public class EchoService extends ServiceHandler<EchoRequest> {
    @Override
    public void execute(EchoRequest request) {
        System.out.println("Receive EchoRequest");
        LOG.info("Test Log from echo [JAVA]");
        done(EchoResponse.newBuilder().setText(request.getText()).build());
    }
}