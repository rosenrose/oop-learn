package s03_logger;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.List;

public class StaticLogger {
    private static final String CONFIG_FILENAME = "static.config";

    private static LogLevel logLevel = LogLevel.WARNING;
    private static boolean isConfigLoaded = false;
    private static BufferedWriter bufferOut = null;

    private StaticLogger() {
    }

    public static void loadConfig() {
        try {
            String classPath = getClassPath();
            Path loggerConfigPath = Paths.get(classPath, CONFIG_FILENAME);

            File configFile = new File(loggerConfigPath.toString());
            String outputFilename = "log.txt";

            if (!configFile.exists()) {
                throw new FileNotFoundException();
            }
            if (!configFile.isFile()) {
                throw new FileNotFoundException();
            }

            List<String> lines = Files.readAllLines(loggerConfigPath, StandardCharsets.UTF_8);

            for (String line : lines) {
                String[] token = line.split("=");
                String key = token[0];
                String val = token[1];

                switch (key) {
                    case "log level" -> logLevel = LogLevel.valueOf(val);
                    case "output" -> outputFilename = val;
                    default -> throw new IllegalArgumentException("Unknown config: " + val);
                }
            }

            String outputPath = Paths.get(classPath, outputFilename).toString();

            bufferOut = new BufferedWriter(new FileWriter(outputPath));
            isConfigLoaded = true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close() {
        if (bufferOut == null) {
            return;
        }

        try {
            bufferOut.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void logDebug(String msg, Object... args) {
        assert (isConfigLoaded) : "Config not loaded";
        writeToFile(LogLevel.DEBUG, msg, args);
    }

    public static void logInfo(String msg, Object... args) {
        assert (isConfigLoaded) : "Config not loaded";
        writeToFile(LogLevel.INFO, msg, args);
    }

    public static void logWarning(String msg, Object... args) {
        assert (isConfigLoaded) : "Config not loaded";
        writeToFile(LogLevel.WARNING, msg, args);
    }

    public static void logError(String msg, Object... args) {
        assert (isConfigLoaded) : "Config not loaded";
        writeToFile(LogLevel.ERROR, msg, args);
    }

    public static void logCritical(String msg, Object... args) {
        assert (isConfigLoaded) : "Config not loaded";
        writeToFile(LogLevel.CRITICAL, msg, args);
    }

    private static void writeToFile(LogLevel logLevel, String msg, Object... args) {
        if (!isConfigLoaded ||
                (logLevel.getLogLevel() < StaticLogger.logLevel.getLogLevel())) {
            return;
        }

        try {
            String log = String.format("[%s] %s: %s", Instant.now(), logLevel, String.format(msg, args));

            bufferOut.write(log);
            bufferOut.newLine();
            bufferOut.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getClassPath() {
        String root = System.getProperty("user.dir");
        String packageName = StaticLogger.class.getPackageName();

        Path classPath = Paths.get(root, packageName.replace('.', '/'));

        return classPath.toAbsolutePath().normalize().toString();
    }
}
