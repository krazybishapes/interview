package elevatorsystem;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Elevator implements Runnable {

    private int id;
    private int capacity;
    private ElevatorStatus status;
    private Queue<ElevateRequest> requests;
    private int currentFloor;

    public Elevator(int id, int capacity){
        this.id = id;
        this.capacity = capacity;
        this.status = ElevatorStatus.IDLE;
        this.requests = new LinkedList<>();
        this.currentFloor = 0;
    }

    public synchronized void addRequest(ElevateRequest request){
        if(requests.size() < capacity){
            requests.add(request);
            notifyAll();
        }
    }

    public synchronized ElevateRequest getNextRequest() {
        while (requests.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return null;
            }
        }
        return requests.poll();
    }

    private void processRequest(ElevateRequest request){
        int startFloor = currentFloor;
        int endFloor = request.getDestFloor();

        if(startFloor < endFloor){
            status = ElevatorStatus.MOVING_UP;
            for(int i = startFloor; i <= endFloor; i++){
                currentFloor = i;
                System.out.println("Elevator id: " + id + " is at floor: " + currentFloor);
                sleep();
            }
        } else {
            status = ElevatorStatus.MOVING_DOWN;
            for(int i = startFloor; i >= endFloor; i--){
                currentFloor = i;
                System.out.println("Elevator id: " + id + " is at floor: " + currentFloor);
                sleep();
            }
        }

        status = ElevatorStatus.IDLE;
    }

    private void sleep(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void run(){
        while (true) {
            ElevateRequest request = getNextRequest();
            if (request != null) {
                processRequest(request);
            }
        }
    }

    public int getCurrentFloor(){
        return currentFloor;
    }

    public ElevatorStatus getStatus(){
        return status;
    }

    public int getId() {
        return id;
    }

    public synchronized int getPendingRequestCount() {
        return requests.size();
    }

}
