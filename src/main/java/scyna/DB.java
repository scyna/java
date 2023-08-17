package scyna;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class DB {
    private Cluster cluster = null;
    private Session session = null;

    public void assureExists(String query, Object... args) throws Error {
        try {
            var result = session.execute(query, args);
            if (!result.isExhausted()) {
                throw Error.OBJECT_NOT_FOUND;
            }
        } catch (scyna.Error e) {
            throw e;
        } catch (Exception e) {
            throw scyna.Error.SERVER_ERROR;
        }
    }

    public void assureNotExists(String query, Object... args) throws Error {
        try {
            var result = session.execute(query, args);
            if (result.isExhausted()) {
                throw Error.OBJECT_EXISTS;
            }
        } catch (scyna.Error e) {
            throw e;
        } catch (Exception e) {
            throw scyna.Error.SERVER_ERROR;
        }
    }

    public Row queryOne(String query, Object... args) throws Error {
        try {
            var result = session.execute(query, args);
            if (!result.isExhausted()) {
                throw Error.OBJECT_NOT_FOUND;
            }
            return result.one();
        } catch (scyna.Error e) {
            throw e;
        } catch (Exception e) {
            throw scyna.Error.SERVER_ERROR;
        }
    }

    public void execute(String query, Object... args) throws Error {
        try {
            session.execute(query, args);
        } catch (Exception e) {
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

    static DB init(String[] hosts, String username, String password, String location) {
        return new DB(hosts, username, password);
    }

    public Session session() {
        return session;
    }

    public void close() {
        session.close();
        cluster.close();
    }
}
