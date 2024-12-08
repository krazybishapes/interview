package leetcode.multithreading.customscheduler;

import java.util.concurrent.TimeUnit;

public interface CustomScheduledExecutorService {

    void schedule(Runnable command, long delay, TimeUnit unit);
    void scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit);
    void scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit);
}
