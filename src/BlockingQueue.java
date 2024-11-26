import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<T> {


    int size;
    int capacity;
    Queue<T> queue;
    ReentrantLock lock = new ReentrantLock();
    Condition notFull = lock.newCondition();
    Condition notEmpty = lock.newCondition();

    public BlockingQueue(int capacity){
        this.queue = new LinkedList<>();
        this.size = 0;
        this.capacity = capacity;
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public int size(){
        return queue.size();
    }



    public void put(T item){
        lock.lock();
        try{
            if(queue.size() == capacity){
                notFull.await();
            }
            queue.add(item);
            notEmpty.signal();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }


    }

    public T take(){
        lock.lock();
        try{
            if(queue.isEmpty()){
                notEmpty.await();
            }
            T item = queue.poll();
            notFull.signal();
            return item;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
        return null;
    }
}
