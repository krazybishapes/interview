package leetcode.multithreading.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

    Queue<Integer> queue;
    int size;
    Lock lock;
    Condition producer;
    Condition consumer;

    public SharedResource(int size){
        queue = new LinkedList<>();
        this.size = 10;
        lock = new ReentrantLock();
        producer = lock.newCondition();
        consumer = lock.newCondition();
    }

    public void produce(int item){
        lock.lock();
        try{
            if(queue.size() == size){
                producer.await();
            }
            queue.add(item);
            System.out.println("Produced: "+ item);
            size++;
            consumer.signalAll();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }

    public int consume(){
        lock.lock();
        try{
            if(queue.isEmpty()){
                consumer.await();
            }
            int i = queue.poll();
            System.out.println("Consumed: "+ i);
            size--;
            producer.signalAll();
            Thread.sleep(500);
            return i;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
        return -1;
    }
}
