package lowleveldesign.logger;

import java.io.File;

public class LogManager {

    protected static AbstractLogger buildChainOfLogger(){

        AbstractLogger infoLogger = new InfoLogger(LogLevel.INFO.ordinal());
        AbstractLogger errorLogger = new ErrorLogger(LogLevel.ERROR.ordinal());
        AbstractLogger debugLogger = new DebugLogger(LogLevel.DEBUG.ordinal());

        infoLogger.setNextLevel(errorLogger);
        errorLogger.setNextLevel(debugLogger);


        return infoLogger;


    }

    protected static LogSubject buildLogSubject(){
        LogSubject logSubject = new LogSubject();
        ConsoleLogger consoleLogger = new ConsoleLogger();
        FileLogger fileLogger = new FileLogger();

        logSubject.addObservers(LogLevel.INFO.ordinal(), consoleLogger);
        logSubject.addObservers(LogLevel.ERROR.ordinal(), consoleLogger);
        logSubject.addObservers(LogLevel.ERROR.ordinal(), fileLogger);

        return logSubject;
    }
}
