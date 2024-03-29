package scyna.db;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.BatchStatement.Type;

import scyna.Engine;
import scyna.Error;

public class DB {
    private Cluster cluster = null;
    private Session session = null;

    public Batch newLoggedBatch() {
        return new Batch(session, Type.LOGGED);
    }

    public Batch newUnloggedBatch() {
        return new Batch(session, Type.UNLOGGED);
    }

    public Batch newCounterBatch() {
        return new Batch(session, Type.COUNTER);
    }

    public void assureExists(String query, Object... args) throws Error {
        try {
            var result = session.execute(addLimitOne(query), args);
            if (result.isExhausted()) {
                throw Error.OBJECT_NOT_FOUND;
            }
        } catch (scyna.Error e) {
            throw e;
        } catch (Exception e) {
            Engine.LOG().error(e.toString());
            throw scyna.Error.SERVER_ERROR;
        }
    }

    public void assureNotExists(String query, Object... args) throws Error {
        try {
            var result = session.execute(addLimitOne(query), args);
            if (!result.isExhausted()) {
                throw Error.OBJECT_EXISTS;
            }
        } catch (scyna.Error e) {
            throw e;
        } catch (Exception e) {
            Engine.LOG().error(e.toString());
            throw scyna.Error.SERVER_ERROR;
        }
    }

    public Row queryOne(String query, Object... args) throws Error {
        try {
            var result = session.execute(addLimitOne(query), args);
            if (!result.isExhausted()) {
                throw Error.OBJECT_NOT_FOUND;
            }
            return result.one();
        } catch (scyna.Error e) {
            throw e;
        } catch (Exception e) {
            Engine.LOG().error(e.toString());
            throw scyna.Error.SERVER_ERROR;
        }
    }

    public ResultSet queryMany(String query, Object... args) throws Error {
        try {
            return session.execute(query, args);
        } catch (Exception e) {
            throw scyna.Error.SERVER_ERROR;
        }
    }

    public void execute(String query, Object... args) throws Error {
        try {
            session.execute(query, args);
        } catch (Exception e) {
            Engine.LOG().error(e.toString());
            throw scyna.Error.SERVER_ERROR;
        }
    }

    private DB(String[] hosts, String username, String password) {
        Cluster.Builder builder = Cluster.builder();
        for (String host : hosts) {
            builder.addContactPoint(host);
        }
        if (!username.isEmpty()) {
            builder.withCredentials(username, password);
        }
        cluster = builder.build();
        session = cluster.connect();
    }

    static public DB Init(String[] hosts, String username, String password, String location) {
        return new DB(hosts, username, password);
    }

    public Session getSession() {
        return session;
    }

    public void close() {
        session.close();
        cluster.close();
    }

    private String addLimitOne(String query) {
        if (query.contains("LIMIT")) {
            return query;
        }
        return query + " LIMIT 1";
    }
}
