package leetcode.multithreading.customscheduler;


import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


public class ScheduledThreadPool implements CustomScheduledExecutorService {

    static int maxThread;
    static PriorityBlockingQueue<ScheduledTask> queue;
    static int currentCapacity;
    ScheduledWorkerThread workerThread;

    static final AtomicInteger sequencer = new AtomicInteger(-1);


    public ScheduledThreadPool(int maxThread){
        this.maxThread = maxThread;
        queue = new PriorityBlockingQueue<>(maxThread, Comparator.comparingLong(ScheduledTask:: getExecutionTime));
        workerThread = new ScheduledWorkerThread();
        this.currentCapacity = 0;
    }

    @Override
    public void schedule(Runnable command, long delay, TimeUnit unit) {
        Long executionTime = System.currentTimeMillis() + unit.toMillis(delay);
        queue.add(new ScheduledTask(()->{
            command.run();
            schedule(command,delay,unit);
        }, executionTime));
        workerThread.execute();
    }

    @Override
    public void scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) {
        long initialExecutionTime = System.currentTimeMillis() +initialDelay+ sequencer.incrementAndGet() * unit.toMillis(period);
        queue.add(new ScheduledTask(() -> {
            command.run();
            scheduleAtFixedRate(command, 0, period, unit);
        }, initialExecutionTime));
    }

    @Override
    public void scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit) {
        long initialExecutionTime = System.currentTimeMillis() + initialDelay+ unit.toMillis(delay);
        queue.add(new ScheduledTask(() -> {
            command.run();
            scheduleWithFixedDelay(command, 0, delay, unit);
        }, initialExecutionTime));
    }
}
