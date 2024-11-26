package lowleveldesign.logger;

public class ErrorLogger extends AbstractLogger{

    public ErrorLogger(int level){
        this.level = level;
    }

    @Override
    public void display(String message, LogSubject logSubject) {
        //System.out.println("ERROR:"+ message);
        logSubject.notifyObserver(LogLevel.ERROR.ordinal(), message);
    }
}
