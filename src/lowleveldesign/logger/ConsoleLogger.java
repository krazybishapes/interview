package lowleveldesign.logger;

public class ConsoleLogger implements LogObserver{
    @Override
    public void log(String message) {
        System.out.println("Writing message to console");
    }
}
