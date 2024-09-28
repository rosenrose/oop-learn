package s04_logger;

public enum LogLevel {
    DEBUG(0),
    INFO(1),
    WARNING(2),
    ERROR(3),
    CRITICAL(4);

    private final int level;

    LogLevel(int level) {
        this.level = level;
    }

    public int getLogLevel() {
        return this.level;
    }
}
