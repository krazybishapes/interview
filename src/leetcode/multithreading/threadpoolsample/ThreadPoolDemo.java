package leetcode.multithreading.threadpoolsample;

import java.util.concurrent.ScheduledExecutorService;

public class ThreadPoolDemo {

    public static void main(String[] args) {

        MyExecutorService executorService = MyExecutors.newFixedThreadPool(10);


        for(int i=0;i<100;i++){
            int counter = i;
            executorService.execute(()->{
                System.out.println("Thread:"+ Thread.currentThread().getName() + " "+ counter);
            });
        }

    }
}
