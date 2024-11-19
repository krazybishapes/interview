package ThreadPool;

import java.util.LinkedList;
import java.util.Queue;

class MyBlockingQueue<T> {
    private Queue<T> queue = new LinkedList<>();
    private int capacity;

    public MyBlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void enqueue(T task) throws InterruptedException {
        while (queue.size() == capacity) {
            wait(); // Wait until space is available
        }
        queue.add(task);
        notifyAll(); // Notify threads waiting to dequeue
    }

    public synchronized T dequeue() throws InterruptedException {
        while (queue.isEmpty()) {
            wait(); // Wait until a task is available
        }
        T task = queue.poll();
        notifyAll(); // Notify threads waiting to enqueue
        return task;
    }

    public synchronized boolean isEmpty() {
        return queue.isEmpty();
    }
}
