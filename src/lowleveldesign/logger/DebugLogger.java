package lowleveldesign.logger;

public class DebugLogger extends AbstractLogger {

    public DebugLogger(int level){
        this.level = level;
    }

    @Override
    public void display(String message, LogSubject logSubject) {
        //System.out.println("Debug:"+ message);
        logSubject.notifyObserver(LogLevel.DEBUG.ordinal(), message);
    }
}
