package lowleveldesign.logger;

public class InfoLogger extends AbstractLogger {

   public InfoLogger(int level){
       this.level = level;
   }

    @Override
    public void display(String message, LogSubject logSubject) {
        //System.out.println("INFO:"+ message);
        logSubject.notifyObserver(LogLevel.INFO.ordinal(), message);
    }
}
