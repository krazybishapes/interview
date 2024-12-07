package ProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class SharedBuffer {

    Queue<Integer> queue = new LinkedList<>();
    int capacity;

    ReentrantLock lock = new ReentrantLock();
    Condition producer = lock.newCondition();
    Condition consumer = lock.newCondition();

    public SharedBuffer(int capacity){
        this.capacity = capacity;
    }

    public void produce(int item) throws InterruptedException {
        lock.lock();
        try {
            if (queue.size() == capacity) {
                producer.await();
            }
            queue.add(item);
            System.out.println("Produced:" + item);
            consumer.signal();
        }finally {
            lock.unlock();
        }
    }

    public synchronized int consume() throws InterruptedException {
        lock.lock();
        try {
            if (queue.isEmpty()) {
                consumer.await();
            }
            int item = queue.poll();
            System.out.println("Consumed:" + item);
            producer.signal();
            return item;
        }finally {
            lock.unlock();
        }
    }
}


