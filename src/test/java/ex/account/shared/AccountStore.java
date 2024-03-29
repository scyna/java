package ex.account.shared;

import ex.account.proto.AccountModel;
import scyna.eventstore.EventStore;
import scyna.eventstore.IProjection;
import scyna.eventstore.Model;

public final class AccountStore {
    static EventStore<AccountModel> store = null;

    public static void Init() throws Exception {
        store = scyna.eventstore.EventStore.Create(Table.ACCOUNT_EVENTS, AccountModel.class);
    }

    public static Model<AccountModel> Read(Object id) throws scyna.Error {
        return store.readModel(id);
    }

    public static Model<AccountModel> Create(Object id) throws scyna.Error {
        return store.createModel(id);
    }

    public static void RegisterProjection(IProjection projection) throws Exception {
        store.registerProjection(projection);
    }
}
