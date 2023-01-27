package io.scyna;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class DB {
    private Cluster cluster = null;
    private Session session = null;

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
