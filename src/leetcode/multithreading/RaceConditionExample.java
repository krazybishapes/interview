package leetcode.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class RaceConditionExample {

    public static void main(String[] args) throws InterruptedException {

        AtomicInteger atomicInteger = new AtomicInteger(0);

        Runnable task = ()->{

            for(int i=0;i<10000;i++){
                int counter = atomicInteger.get();
                atomicInteger.set(counter+1);
            }

        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(atomicInteger.get());
    }
}
