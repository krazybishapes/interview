package leetcode.multithreading;

public class EvenOddWait {

    static boolean isEvenTurn = true;
    static Object lock = new Object();
    public static void main(String[] args) {


        Thread evenThread = new Thread(()->{

            for(int i=2;i<100;i+=2){
                synchronized (lock){
                    while(!isEvenTurn){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println(i);
                    isEvenTurn = false;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    lock.notify();
                }
            }


        });


        Thread oddThread = new Thread(()->{

            for(int i=1;i<100;i+=2){
                synchronized (lock){
                    while(isEvenTurn){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println(i);
                    isEvenTurn = true;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    lock.notify();
                }
            }


        });

        evenThread.start();
        oddThread.start();
    }



}
