package s04_logger;

public class Program {
    public static void main(String[] args) {
        try {
            StaticLogger.loadConfig();

            StaticLogger.logDebug("Log debug");
            StaticLogger.logInfo("Log info: %d", 123);
            StaticLogger.logWarning("Log Warn: %s", "hello");
            StaticLogger.logError("Log Err: %s-%s", "foo", "bar");
            StaticLogger.logCritical("CRITICAL!!");

            StaticLogger.close();

            SingletonLogger logger = SingletonLogger.getInstance();

            logger.logDebug("Debug");
            logger.logInfo("Info: %d", 9987);
            logger.logWarning("Warn: %s", "world");
            logger.logError("Err: %s-%s", "baz", "bas");
            logger.logCritical("critical");

            logger.deleteInstance();
        } catch (Exception _) {
        }
    }
}
