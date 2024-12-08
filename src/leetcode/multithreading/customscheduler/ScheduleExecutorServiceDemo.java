package leetcode.multithreading.customscheduler;


import java.util.concurrent.TimeUnit;

public class ScheduleExecutorServiceDemo {

    public static void main(String[] args) {

        CustomScheduledExecutorService customScheduledExecutorService = MyExecutors.newScheduledThreadPool(10);

        customScheduledExecutorService.schedule(()->
            System.out.println("Task 1 executed at " + System.currentTimeMillis())
                    , 5000, TimeUnit.MILLISECONDS );



    }
}
