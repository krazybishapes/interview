package leetcode.multithreading;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SchedulerService {


    public void schedule(Runnable command, long delay, TimeUnit unit){

        if(command == null || unit == null){
            throw new NullPointerException();
        }

        Thread scheduledTask = new Thread(()->{

            try {
                Thread.sleep(unit.toMillis(delay));
                command.run();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

        scheduledTask.start();



    }
}
