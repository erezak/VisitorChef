interface Logger {
    public void log(String message);
}

// A class that simulates an old logging system
class FileLogger implements Logger {
    private final String filename;

    public FileLogger(String filename) {
        this.filename = filename;
    }

    // Write a message to a file
    public void log(String message) {
        // Simulate some logic to open the file and append the message
        System.out.println("Appending to file: " + message);
    }
}

// A class that simulates a new logging system
class DatabaseLogger implements Logger {
    private final String connectionString;

    public DatabaseLogger(String connectionString) {
        this.connectionString = connectionString;
    }

    // Write a message to a database
    public void log(String message) {
        // Simulate some logic to connect to the database and insert the message
        System.out.println("Logging to database: " + message);
    }
}

// A class that implements the façade for logging systems
class LoggerFacade implements Logger {
    private final FileLogger fileLogger;
    private final DatabaseLogger databaseLogger;

    public LoggerFacade(FileLogger fileLogger, DatabaseLogger databaseLogger) {
        this.fileLogger = fileLogger;
        this.databaseLogger = databaseLogger;
    }

    // Write a message using the appropriate logging system
    public void log(String message) {
        // Decide which logging system to use based on some criteria
        // For example, use the new system for error messages
        if (message.startsWith("ERROR")) {
            databaseLogger.log(message);
        } else {
            fileLogger.log(message);
        }
    }
}

// A test class to demonstrate the usage of logger façade
public class LoggerStrangler {
    public static void main(String[] args) {
        // Create an instance of the façade with the old and new logging systems
        Logger logger = new LoggerFacade(new FileLogger("log.txt"),
                new DatabaseLogger("jdbc:mysql://localhost:3306/test"));

        // Write some sample messages using the façade
        logger.log("INFO: Starting application");
        logger.log("ERROR: Invalid input");
        logger.log("INFO: Ending application");
    }
}
