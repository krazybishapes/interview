package lowleveldesign.logger;

import java.io.Serializable;

import static lowleveldesign.logger.LogManager.buildChainOfLogger;
import static lowleveldesign.logger.LogManager.buildLogSubject;

public class Logger implements Cloneable, Serializable {

    private volatile static Logger logger = null;
    private volatile static AbstractLogger chainOfLogger = null;
    private volatile static LogSubject logSubject = null;

    private Logger() {
        if(logger != null){
            throw new IllegalStateException("Logger object already created");
        }
    }

    public static Logger getInstance() {
        if(logger == null){
            synchronized (Logger.class){
                if(logger == null){
                    logger = new Logger();
                    chainOfLogger = buildChainOfLogger();
                    logSubject = buildLogSubject();
                }

            }
        }

        return logger;
    }

    public Object doResolve(){
        return logger;
    }

    private void log(int level, String message){
        chainOfLogger.log(level,message, logSubject);
    }

    public void info(String message){
        log(LogLevel.INFO.ordinal(), message);
    }

    public void error(String message){
        log(LogLevel.ERROR.ordinal(), message);
    }

    public void debug(String message){
        log(LogLevel.DEBUG.ordinal(), message);
    }


}
