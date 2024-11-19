package ThreadPool;

import java.util.ArrayList;
import java.util.List;


public class ThreadPool {

    List<WorkerThread> threads;
    MyBlockingQueue<Runnable> tasks;
    boolean stopped;

    public ThreadPool(int numberofThread, int maxtask){

        threads = new ArrayList<>();
        tasks = new MyBlockingQueue(maxtask);
        for(int i=0;i<numberofThread;i++){
            WorkerThread workerThread = new WorkerThread(tasks);
            threads.add(workerThread);
            workerThread.start();
        }
    }

    public void execute(Runnable task) throws IllegalStateException, InterruptedException {

        if(stopped) throw new IllegalStateException("");


        tasks.enqueue(task);


    }

    public void stop(){
        for(WorkerThread workerThread: threads){
            workerThread.stopThread();
        }
    }
}
