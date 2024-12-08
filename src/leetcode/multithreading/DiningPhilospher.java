package leetcode.multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilospher {

    Lock leftForkLock;
    Lock rightForkLock;
    Condition rightForkCondition;

    public  DiningPhilospher(){
        leftForkLock = new ReentrantLock();
        rightForkLock = new ReentrantLock();
    }


    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        if(leftForkLock.tryLock(100, TimeUnit.MILLISECONDS)){
            try{
                pickLeftFork.run();

                if(rightForkLock.tryLock(100,TimeUnit.MILLISECONDS)){
                    try{
                        pickRightFork.run();
                        System.out.println("Philosper:"+ philosopher+" is eating");
                        eat.run();
                        putRightFork.run();
                        putLeftFork.run();
                    }finally {
                        rightForkLock.unlock();
                    }
                }


            }finally {
                leftForkLock.unlock();
            }


        }

    }

    public static void main(String[] args) {

        DiningPhilospher diningPhilosophers = new DiningPhilospher();

        Runnable pickLeftFork = () -> System.out.println("Picked left fork");
        Runnable pickRightFork = () -> System.out.println("Picked right fork");
        Runnable eat = () -> System.out.println("Eating");
        Runnable putLeftFork = () -> System.out.println("Put down left fork");
        Runnable putRightFork = () -> System.out.println("Put down right fork");

        for (int i = 0; i < 5; i++) {
            int philosopher = i;
            new Thread(() -> {
                try {
                    diningPhilosophers.wantsToEat(philosopher, pickLeftFork, pickRightFork, eat, putLeftFork, putRightFork);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }).start();
        }
    }
}
