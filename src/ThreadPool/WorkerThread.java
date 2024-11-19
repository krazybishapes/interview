package ThreadPool;


public class WorkerThread extends Thread{

    MyBlockingQueue<Runnable> taskQueue;

    boolean stopped = false;

    public WorkerThread(MyBlockingQueue<Runnable> task){
        this.taskQueue = task;
        stopped = false;
    }

    @Override
    public void run(){
        while(!stopped){
            Runnable task = null;
            try {
                task = taskQueue.dequeue();
                task.run();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }

        }
    }

    public void stopThread(){
        stopped = true;
        this.interrupt();
    }

}
