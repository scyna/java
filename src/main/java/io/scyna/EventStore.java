package io.scyna;

public class EventStore {
    long version;
    String storeQuery;

    private static EventStore instance_ = null;

    public static EventStore instance() {
        if (instance_ == null) {
            Engine.LOG().error("EventStore is not initialized");
            System.exit(1);
        }
        return instance_;
    }

    public static void init(String keyspace) {

    }

    public void Append() {

    }
}
