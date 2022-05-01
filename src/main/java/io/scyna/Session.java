package io.scyna;

import java.util.Timer;
import java.util.TimerTask;

import io.scyna.proto.UpdateSessionSignal;

public class Session {
    private final long id;
    private long sequence;

    public Session(long id) {
        this.id = id;

        TimerTask task = new TimerTask() {
            public void run() {
                var sig = UpdateSessionSignal.newBuilder().setID(id).build();
                Signal.sendCommand(Path.SESSION_UPDATE_CHANNEL, sig);
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
