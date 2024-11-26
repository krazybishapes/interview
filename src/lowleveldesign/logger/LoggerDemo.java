package lowleveldesign.logger;

public class LoggerDemo {

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        //logger.info("Log message");
        logger.error("Error message");
    }
}
