package leetcode.multithreading.customscheduler;

public class MyExecutors {


    static CustomScheduledExecutorService newScheduledThreadPool(int maxThread){
        return new ScheduledThreadPool(maxThread);
    }
}
