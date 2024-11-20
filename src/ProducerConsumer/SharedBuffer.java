package ProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class SharedBuffer {

    Queue<Integer> queue = new LinkedList<>();
    int capacity;

    ReentrantLock lock = new ReentrantLock();
    Condition notFull = lock.newCondition();
    Condition notEmpty = lock.newCondition();

    public SharedBuffer(int capacity){
        this.capacity = capacity;
    }

    public void produce(int item) throws InterruptedException {
        lock.lock();
        try {
            if (queue.size() == capacity) {
                notFull.await();
            }
            queue.add(item);
            System.out.println("Produced:" + item);
            notEmpty.signal();
        }finally {
            lock.unlock();
        }
    }

    public synchronized int consume() throws InterruptedException {
        lock.lock();
        try {
            if (queue.isEmpty()) {
                notEmpty.await();
            }
            int item = queue.poll();
            System.out.println("Consumed:" + item);
            notFull.signal();
            return item;
        }finally {
            lock.unlock();
        }
    }
}


