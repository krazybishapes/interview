package leetcode.multithreading.customscheduler;


public class ScheduledWorkerThread implements Runnable{

    public void execute(){

        if(ScheduledThreadPool.currentCapacity< ScheduledThreadPool.maxThread){

            ScheduledThreadPool.currentCapacity++;

            Thread t = new Thread(new ScheduledWorkerThread());
            t.start();
        }
    }

    @Override
    public void run() {

        while(!ScheduledThreadPool.queue.isEmpty()){
            ScheduledTask task = ScheduledThreadPool.queue.poll();
            Long currentTime = System.currentTimeMillis();
            if (task.getExecutionTime() > currentTime) {
                try {
                    Thread.sleep(task.getExecutionTime() - currentTime);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }

            if (task != null) {
                System.out.println("Command running");
                task.command.run();
            }
        }

    }
}
