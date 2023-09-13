package scyna;

import scyna.proto.TraceCreatedSignal;

public class Trace {

    public final static int ENDPOINT = 1;
    public final static int EVENT = 2;
    public final static int SYNC = 4;
    public final static int TASK = 5;
    public final static int DOMAIN_EVENT = 6;

    private long parentID;
    private long id;
    private int type;
    private String path;
    private long sessionID;
    private int status;
    private String source;

    private long t1;
    public long time;

    public long ID() {
        return id;
    }

    public static Trace Event(String channel) {
        var ret = new Trace();
        ret.type = EVENT;
        ret.path = channel;
        ret.sessionID = Engine.Session().ID();
        ret.t1 = System.nanoTime();
        ret.source = Engine.Module();
        return ret;
    }

    public static Trace Task(String channel) {
        var ret = new Trace();
        ret.type = TASK;
        ret.path = channel;
        ret.sessionID = Engine.Session().ID();
        ret.t1 = System.nanoTime();
        ret.source = Engine.Module();
        return ret;
    }

    public static Trace Endpoint(String url, long trace) {
        var ret = new Trace();
        ret.type = ENDPOINT;
        ret.path = url;
        ret.id = Engine.ID().next();
        ret.parentID = trace;
        ret.t1 = System.nanoTime();
        ret.time = Utils.currentMicroSeconds();
        ret.source = Engine.Module();
        return ret;
    }

    public static Trace DomainEvent(String name, long parentTrace) {
        var ret = new Trace();
        ret.type = ENDPOINT;
        ret.path = name;
        ret.id = Engine.ID().next();
        ret.parentID = parentTrace;
        ret.t1 = System.nanoTime();
        ret.time = Utils.currentMicroSeconds();
        ret.source = Engine.Module();
        return ret;
    }

    public void reset(long parent) {
        this.parentID = parent;
        this.id = Engine.ID().next();
        t1 = System.nanoTime();
        time = Utils.currentMicroSeconds();
    }

    public void start() {
        t1 = System.nanoTime();
        time = Utils.currentMicroSeconds();
    }

    public void record() {
        var signal = TraceCreatedSignal.newBuilder()
                .setDuration(System.nanoTime() - t1)
                .setTime(time)
                .setID(id)
                .setParentID(parentID)
                .setType(type)
                .setPath(path)
                .setSessionID(sessionID)
                .setSource(source)
                .setStatus(status).build();
        Signal.emit(Path.TRACE_CREATED_CHANNEL, signal);
    }
}
