package io.scyna.ex.echo;

import io.scyna.Service;
import io.scyna.ex.echo.proto.EchoRequest;
import io.scyna.ex.echo.proto.EchoResponse;

public class EchoService extends Service.Base<EchoRequest> {
    @Override
    public void execute() {
        System.out.println("Receive EchoRequest");
        var request = (EchoRequest) parse(EchoRequest.parser(), EchoRequest.newBuilder());
        if (request == null)
            return;

        log.info("Test Log from echo [JAVA]");
        done(EchoResponse.newBuilder().setText(request.getText()).build());
    }
}