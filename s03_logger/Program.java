package s03_logger;

public class Program {
    public static void main(String[] args) {
        try {
            Logger.loadConfig();

            Logger.logDebug("Log debug");
            Logger.logInfo("Log info: %d", 123);
            Logger.logWarning("Log Warn: %s", "hello");
            Logger.logError("Log Err: %s-%s", "foo", "bar");
            Logger.logCritical("CRITICAL!!");

            Logger.close();
        } catch (Exception _) {
        }
    }
}
