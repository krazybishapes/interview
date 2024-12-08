package leetcode.multithreading.customscheduler;


import java.util.concurrent.TimeUnit;

public class ScheduledTask {

    Runnable command;
    Long executionTime;


    public ScheduledTask(Runnable command, Long executionTime){
        this.command = command;
        this.executionTime = executionTime;
    }



    public Long getExecutionTime() {
        return executionTime;
    }
}
