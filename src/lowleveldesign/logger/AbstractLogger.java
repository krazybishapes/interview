package lowleveldesign.logger;

public abstract class AbstractLogger {

    int level;

    AbstractLogger nextLoggingLevel;

    public abstract void display(String message, LogSubject logSubject);

    public void log(int level, String message, LogSubject logSubject){
        if(this.level <= level){
            display(message, logSubject);
        }
        if(nextLoggingLevel != null){
            nextLoggingLevel.log(level, message, logSubject);
        }
    }

    public void setNextLevel(AbstractLogger nextLoggingLevel) {

        this.nextLoggingLevel = nextLoggingLevel;

    }
}
