package leetcode.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class EvenOdd {

    static boolean isEven = true;
    static Lock lock = new ReentrantLock();
    static Condition evenCondition = lock.newCondition();
    static Condition oddCondition = lock.newCondition();
    public static void printEven(int even)  {
        lock.lock();

        try{
            while(!isEven){
                evenCondition.await();
            }
            System.out.println(even);
            isEven = false;
            Thread.sleep(500);
            oddCondition.signal();
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            lock.unlock();
        }
    }

    private static void printOdd(int odd){
        lock.lock();
        try{
            while(isEven){
                oddCondition.await();
            }
            System.out.println(odd);
            isEven = true;
            Thread.sleep(500);
            evenCondition.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // Even number thread
        executorService.execute(() -> {
            for (int i = 2; i < 100; i += 2) {
                printEven(i);
            }
        });

        // Odd number thread
        executorService.execute(() -> {
            for (int i = 1; i < 100; i += 2) {
                printOdd(i);
            }
        });

        executorService.shutdown();

    }
}
