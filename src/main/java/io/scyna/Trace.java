package io.scyna;

import java.time.Instant;
import io.scyna.proto.TraceCreatedSignal;

public class Trace {

    public final static int SERVICE = 1;
    public final static int EVENT = 2;
    public final static int SIGNAL = 3;

    private long parentID;
    private long id;
    private int type;
    private String path;
    private String source;
    private long sessionID;
    private int status;

    private long t1;
    public long time;

    public long ID() {
        return id;
    }

    public static Trace newSignalTrace(String channel) {
        var ret = new Trace();
        ret.type = SIGNAL;
        ret.path = channel;
        ret.sessionID = Engine.session().ID();
        return ret;
    }

    public static Trace newEventTrace(String channel) {
        var ret = new Trace();
        ret.type = EVENT;
        ret.path = channel;
        ret.sessionID = Engine.session().ID();
        return ret;
    }

    public static Trace newServiceTrace(String url, long trace) {
        var ret = new Trace();
        ret.type = SERVICE;
        ret.path = url;
        ret.id = Engine.ID().next();
        ret.parentID = trace;
        ret.t1 = System.nanoTime();
        var instant = Instant.now();
        ret.time = instant.getEpochSecond() * 1000_000 + instant.getNano() / 1000;
        ret.source = Engine.module();
        return ret;
    }

    public void update(long parent) {
        this.parentID = parent;
        this.id = Engine.ID().next();
        t1 = System.nanoTime();
        var instant = Instant.now();
        time = instant.getEpochSecond() * 1000_000 + instant.getNano() / 1000;
    }

    public void updateService(long session, int status) {
        this.sessionID = session;
        this.status = status;
    }

    public void start() {
        t1 = System.nanoTime();
        var instant = Instant.now();
        time = instant.getEpochSecond() * 1000_000 + instant.getNano() / 1000;
    }

    public void record() {
        var signal = TraceCreatedSignal.newBuilder()
                .setDuration(System.nanoTime() - t1)
                .setTime(time)
                .setID(id)
                .setParentID(parentID)
                .setType(type)
                .setPath(path)
                .setSource(source)
                .setSessionID(sessionID)
                .setStatus(status).build();
        SignalLite.emit(Path.TRACE_CREATED_CHANNEL, signal);
    }
}
