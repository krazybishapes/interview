package leetcode.multithreading.threadpoolsample;

public class WorkerThread implements Runnable{


    public void execute(){
        if (MyThreadPool.currentCapacity
                < MyThreadPool.maxThread) {
            MyThreadPool.currentCapacity++;

            // Creating object of Thread class
            Thread t = new Thread(new WorkerThread());

            // Starting the thread
            t.start();
        }
    }

    @Override
    public void run() {

        while(!MyThreadPool.queue.isEmpty()){
            MyThreadPool.queue.poll().run();
        }
    }
}
