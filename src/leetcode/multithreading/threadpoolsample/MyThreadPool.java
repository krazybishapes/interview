package leetcode.multithreading.threadpoolsample;

import java.util.concurrent.LinkedBlockingQueue;

public class MyThreadPool implements MyExecutorService{

    static int maxThread;
    static int currentCapacity;
    static LinkedBlockingQueue<Runnable> queue;
    WorkerThread workerThread;


    public MyThreadPool(int maxThread){
        MyThreadPool.maxThread = maxThread;
        currentCapacity = 0;
        queue = new LinkedBlockingQueue<>();
        workerThread = new WorkerThread();
    }


    @Override
    public void execute(Runnable task) {
        queue.add(task);
        workerThread.execute();
    }
}
