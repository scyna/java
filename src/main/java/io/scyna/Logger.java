package io.scyna;

import io.scyna.proto.WriteLogSignal;

public class Logger {
    final int LOG_INFO = 1;
    final int LOG_ERROR = 2;
    final int LOG_WARNING = 3;
    final int LOG_DEBUG = 4;
    final int LOG_FATAL = 5;
    private long id;
    private final boolean session;
    private boolean enable = true;

    Logger(long id, boolean session) {
        this.id = id;
        this.session = session;
    }

    public void reset(long id, boolean enable) {
        this.id = id;
    }

    private void add(int level, String messgage) {
        messgage = convertLog(messgage);
        System.out.println(messgage);
        if (enable) {
            var event = WriteLogSignal.newBuilder()
                    .setId(id)
                    .setTime(System.nanoTime() / 1000)
                    .setLevel(level)
                    .setText(messgage)
                    .setSession(session)
                    .build();
            Signal.emit(Path.LOG_WRITE_CHANNEL, event);
        }
    }

    public void info(String message) {
        add(LOG_INFO, message);
    }

    public void warning(String message) {
        add(LOG_WARNING, message);
    }

    public void error(String message) {
        add(LOG_ERROR, message);
    }

    public void debug(String message) {
        add(LOG_DEBUG, message);
    }

    public void fatal(String message) {
        add(LOG_FATAL, message);
    }

    private String convertLog(String log) {
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        String newLog = "[" + elements[4].getFileName() + ":" + elements[4].getLineNumber() + " - "
                + elements[4].getMethodName() + "] " + log;
        return newLog;
    }
}
