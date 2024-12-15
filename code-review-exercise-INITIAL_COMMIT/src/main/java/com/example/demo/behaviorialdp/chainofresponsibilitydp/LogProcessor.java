package src.main.java.com.example.demo.behaviorialdp.chainofresponsibilitydp;

public abstract class LogProcessor {
    public static int INFO = 1;
    public static int DEBUG = 1;
    public static int ERROR = 1;

    LogProcessor nextLogProcessor;

    LogProcessor(LogProcessor logProcessor) {
        this.nextLogProcessor = logProcessor;
    }

    public void log(int logLevel, String message) {
        if (nextLogProcessor != null) {
            nextLogProcessor.log(logLevel, message);
        }
    }


}
