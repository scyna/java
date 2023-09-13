package ex.registering.services;

import scyna.Endpoint;
import scyna.Error;
import ex.registering.proto.*;

public class CreateRegistrationHandler extends Endpoint.Handler<CreateRegistrationRequest> {

    @Override
    protected void execute() throws Error {
        context.info("Receive CreateRegistrationRequest: " + request.toString());

        /* TODO */

        context.raiseDomainEvent(RegistrationCreated.newBuilder()
                .setEmail(request.getEmail())
                .setName(request.getName())
                .setPassword(request.getPassword())
                .build());
        context.raiseDomainEvent(RegistrationCreated.newBuilder()
                .setEmail(request.getEmail())
                .setName(request.getName())
                .setPassword(request.getPassword())
                .build());
    }
}
