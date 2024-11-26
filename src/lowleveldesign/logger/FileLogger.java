package lowleveldesign.logger;

public class FileLogger implements LogObserver{
    @Override
    public void log(String message) {
        System.out.println("Writing message to file");
    }
}
