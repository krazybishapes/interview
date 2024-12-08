package leetcode.multithreading;


import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class VotingAgencyBathroom {

    int max_capacity = 3;
    Semaphore bathroom = new Semaphore(max_capacity,true);
    Lock lock = new ReentrantLock();
    Condition diplomats = lock.newCondition();
    Condition republican = lock.newCondition();

    int diplomatsInBathroom = 0;
    int republicanInBathroom = 0;
    String currentParty = null;


    public void moveIn(String party, String name, int fN) throws InterruptedException {
        lock.lock();
        try{
            if(party.equals("D")){
                if(!canUseBathroom(party)){
                    diplomats.await();
                }
                diplomatsInBathroom++;
                currentParty = "D";
                republican.signal();

            }else{
                if(!canUseBathroom(party)){
                    republican.await();
                }
                republicanInBathroom++;
                currentParty = "R";
                diplomats.signal();

            }
            bathroom.acquire();
            System.out.println(name + " (" + party + ") entered the bathroom.");
            Thread.sleep(fN*10);
            moveOut(party,name);
        }finally {
            lock.unlock();
        }

    }

    public void moveOut(String party, String name) throws InterruptedException {
        lock.lock();
        try{
            if(party.equals("D")){
                diplomatsInBathroom--;
                if(diplomatsInBathroom == 0){
                    currentParty = null;
                    republican.signalAll();
                }


            }else{
                republicanInBathroom--;
                if(republicanInBathroom == 0){
                    currentParty = null;
                    diplomats.signalAll();
                }


            }
            System.out.println(name + " (" + party + ") left the bathroom.");
            bathroom.release();
        }finally {
            lock.unlock();
        }

    }

    private boolean canUseBathroom(String party) {
        if (currentParty == null || currentParty.equals(party)) {
            // Bathroom is empty or occupied by the same party
            return diplomatsInBathroom + republicanInBathroom < max_capacity;
        }
        return false;
    }

    public static void main(String[] args) {
        VotingAgencyBathroom bathroom = new VotingAgencyBathroom();

        Runnable democratTask = () -> {
            String name = Thread.currentThread().getName();
            try {
                int fN = (int) (Math.random() * 5 + 1); // Random f(N) value
                bathroom.moveIn("D", name, fN);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        Runnable republicanTask = () -> {
            String name = Thread.currentThread().getName();
            try {
                int fN = (int) (Math.random() * 5 + 1); // Random f(N) value
                bathroom.moveIn("R", name, fN);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };



        // Create threads for Democrats and Republicans
        for (int i = 0; i < 100; i++) {
            new Thread(democratTask, "Democrat-" + i).start();
            new Thread(republicanTask, "Republican-" + i).start();
        }
    }
}
