package lowleveldesign.logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogSubject {

    List<LogObserver> logObservers = new ArrayList<>();
    Map<Integer,List<LogObserver>> loglevelObserverMap = new HashMap<>();


    void addObservers(int level, LogObserver logObserver){

       List<LogObserver> logObservers = loglevelObserverMap.getOrDefault(level, new ArrayList<>());
       logObservers.add(logObserver);
       loglevelObserverMap.put(level,logObservers);


    }

    void notifyObserver(int level, String message){
        List<LogObserver> logObservers = loglevelObserverMap.get(level);
        for(LogObserver logObserver: logObservers){
            logObserver.log(message);
        }
    }
}
