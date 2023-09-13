package scyna;

import java.util.Timer;
import java.util.TimerTask;

import scyna.proto.UpdateSessionSignal;

public class Session {
    private final long id;
    private long sequence;

    public Session(long id) {
        this.id = id;

        TimerTask task = new TimerTask() {
            public void run() {
                Signal.emit(Path.SESSION_UPDATE_CHANNEL, UpdateSessionSignal.newBuilder().setID(id).build());
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
