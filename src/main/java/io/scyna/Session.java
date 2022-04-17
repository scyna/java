package io.scyna;

import java.util.Timer;
import java.util.TimerTask;

public class Session {
    private final long id;
    private long sequence;

    public Session(long id) {
        this.id = id;

        TimerTask task = new TimerTask() {
            public void run() {
                /* TODO: send update session here */
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, 1000L * 60 * 10); /* 10 minutes, FIXME: move to config */
    }

    public long ID() {
        return id;
    }

    public synchronized long nextSequence() {
        sequence++;
        return sequence;
    }
}
