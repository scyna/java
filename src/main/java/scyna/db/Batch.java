package scyna.db;

import com.datastax.driver.core.BatchStatement;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.BatchStatement.Type;

public class Batch {
    private Session session;
    private BatchStatement batch;

    Batch(Session session, Type type) {
        this.session = session;
        this.batch = new BatchStatement(type);
    }

    public Batch add(String query, Object... args) {
        batch.add(session.prepare(query).bind(args));
        return this;
    }

    public void execute() {
        session.execute(batch);
    }
}
