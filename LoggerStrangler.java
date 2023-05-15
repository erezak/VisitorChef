// A class that simulates an old logging system
class FileLogger {
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

// A test class to demonstrate the usage of logger façade
public class LoggerStrangler {
    public static void main(String[] args) {
        // Create an instance of the façade with the old and new logging systems
        FileLogger logger = new FileLogger("log.txt");

        // Write some sample messages using the façade
        logger.log("INFO: Starting application");
        logger.log("ERROR: Invalid input");
        logger.log("INFO: Ending application");
    }
}
