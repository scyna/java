package ex.account.features;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;

import ex.account.proto.AccountCreated;
import ex.account.proto.AccountModel;
import ex.account.shared.Table;
import scyna.Engine;
import scyna.eventstore.Projection;

public class ProjectAccountCreated extends Projection<AccountCreated, AccountModel> {
    @Override
    protected void execute(AccountCreated event, AccountModel data) throws scyna.Error {
        Engine.LOG().info("Account created: " + data.getEmail());

        try {
            Engine.DB().newLoggedBatch()
                    .add("INSERT INTO " + Table.ACCOUNT + " (id, email, name, password, data) VALUES (?, ?, ?, ?,?)",
                            Engine.ID().next(),
                            data.getEmail(),
                            data.getName(),
                            data.getPassword(),
                            JsonFormat.printer().print(data))
                    .execute();
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
            throw scyna.Error.BAD_DATA;
        }
    }
}