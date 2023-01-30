package io.scyna;

import io.scyna.proto.LogCreatedSignal;

public class Logger {
    final int INFO = 1;
    final int ERROR = 2;
    final int WARNING = 3;
    final int DEBUG = 4;
    final int FATAL = 5;
    protected long id;
    private final boolean session;

    Logger(long id, boolean session) {
        this.id = id;
        this.session = session;
    }

    private void add(int level, String messgage) {
        messgage = format(messgage);
        System.out.println(messgage);
        if (id > 0) {
            var event = LogCreatedSignal.newBuilder()
                    .setID(id)
                    .setTime(System.nanoTime() / 1000)
                    .setLevel(level)
                    .setText(messgage)
                    .setSession(session)
                    .build();
            Signal.emit(Path.LOG_CREATED_CHANNEL, event);
        }
    }

    public void info(String message) {
        add(INFO, message);
    }

    public void warning(String message) {
        add(WARNING, message);
    }

    public void error(String message) {
        add(ERROR, message);
    }

    public void debug(String message) {
        add(DEBUG, message);
    }

    public void fatal(String message) {
        add(FATAL, message);
    }

    private String format(String log) {
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        String newLog = "[" + elements[4].getFileName() + ":" + elements[4].getLineNumber() + " - "
                + elements[4].getMethodName() + "] " + log;
        return newLog;
    }
}
