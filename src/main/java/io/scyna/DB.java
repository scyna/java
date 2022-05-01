package io.scyna;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.MappingManager;

public class DB {
    private Cluster cluster = null;
    private Session session = null;
    private MappingManager mapping;

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
        mapping = new MappingManager(session);
    }

    static DB init(String[] hosts, String username, String password, String location) {
        return new DB(hosts, username, password);
    }

    public Session session() {
        return session;
    }

    public MappingManager mapping() {
        return mapping;
    }

    public void close() {
        cluster.close();
    }
}
