package leetcode.multithreading.threadpoolsample;

public class MyExecutors {


    static MyExecutorService newFixedThreadPool(int maxThreads){
        return new MyThreadPool(maxThreads);
    }
}
