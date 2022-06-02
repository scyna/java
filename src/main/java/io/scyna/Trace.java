package io.scyna;

import java.time.LocalDateTime;

public class Trace {

    public final static int SERVICE = 1;
    public final static int EVENT = 2;
    public final static int SIGNAL = 3;

    public long ParentID;
    public long ID;
    public int Type;
    public LocalDateTime Time;
    public long Duration;
    public String Path;
    public String Source;
    public long SessionID;
    public int Status;

    public void record() {
        /* TODO */
    }
}
