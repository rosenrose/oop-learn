package s04_logger;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.List;

public class SingletonLogger {
    private static final String CONFIG_FILENAME = "singleton.config";
    private static SingletonLogger instance = null;

    private final LogLevel logLevel;
    private final BufferedWriter bufferOut;

    private SingletonLogger(LogLevel logLevel, String outputPath) {
        this.logLevel = logLevel;

        try {
            this.bufferOut = new BufferedWriter(new FileWriter(outputPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static SingletonLogger getInstance() {
        if (instance != null) {
            return instance;
        }

        try {
            String classPath = getClassPath();
            Path loggerConfigPath = Paths.get(classPath, CONFIG_FILENAME);
            File configFile = new File(loggerConfigPath.toString());

            LogLevel logLevel = LogLevel.WARNING;
            String outputFilename = "log_singleton.txt";

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
            instance = new SingletonLogger(logLevel, outputPath);

            return instance;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteInstance() {
        try {
            this.bufferOut.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        instance = null;
    }

    public void logDebug(String msg, Object... args) {
        writeToFile(LogLevel.DEBUG, msg, args);
    }

    public void logInfo(String msg, Object... args) {
        writeToFile(LogLevel.INFO, msg, args);
    }

    public void logWarning(String msg, Object... args) {
        writeToFile(LogLevel.WARNING, msg, args);
    }

    public void logError(String msg, Object... args) {
        writeToFile(LogLevel.ERROR, msg, args);
    }

    public void logCritical(String msg, Object... args) {
        writeToFile(LogLevel.CRITICAL, msg, args);
    }

    private void writeToFile(LogLevel logLevel, String msg, Object... args) {
        if (logLevel.getLogLevel() < this.logLevel.getLogLevel()) {
            return;
        }

        try {
            String log = String.format("[%s] %s: %s", Instant.now(), logLevel, String.format(msg, args));

            this.bufferOut.write(log);
            this.bufferOut.newLine();
            this.bufferOut.flush();
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
