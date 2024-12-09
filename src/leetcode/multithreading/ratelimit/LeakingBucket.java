package leetcode.multithreading.ratelimit;

import java.util.Currency;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LeakingBucket {


    private int capacity;
    private int current;
    private int leakingRate;
    private long lastLeaked;

    Lock lock;

    public LeakingBucket(int capacity, int leakingRate){

        this.capacity = capacity;
        this.current = 0;
        this.leakingRate = leakingRate;
        this.lastLeaked = System.currentTimeMillis();
        lock = new ReentrantLock();
    }

    public boolean allowRequest(){
        lock.lock();

        try{

            long currentTime = System.currentTimeMillis();
            long timeElapsed = currentTime - lastLeaked;

            //request leaked from last time to current time
            int leaked = (int)(timeElapsed* (leakingRate/1000));

            //preventing current level to go to negative
            current = Math.max(0, current - leaked);

            lastLeaked = currentTime;

            if(current< capacity){
                current++;
                return true;
            }else{
                return false;
            }

        }finally {
            lock.unlock();
        }
    }




}
