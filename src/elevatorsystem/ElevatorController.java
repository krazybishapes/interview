package elevatorsystem;

import java.util.ArrayList;
import java.util.List;

public class ElevatorController {

    List<Elevator> elevators;

    public ElevatorController(int numberOfElevators, int capacity){
        elevators = new ArrayList<>(numberOfElevators);
        for(int i=0;i<numberOfElevators;i++){
            Elevator elevator = new Elevator(i, capacity);
            elevators.add(elevator);
            Thread elevatorThread = new Thread(elevator); // Correct way
            elevatorThread.start();
        }
    }

    public void addRequest(ElevateRequest request){
        //find the best elevator
        int direction = request.getDestFloor()> request.getSrcFloor()?1:-1;
        Elevator elevator = findBestElevator(request.getSrcFloor(), direction);
        //assign request to elevator
        elevator.addRequest(request);
    }

    private Elevator findBestElevator(int sourceFloor, int direction) {
        Elevator bestElevator = null;
        int bestScore = Integer.MAX_VALUE;

        for (Elevator elevator : elevators) {
            int distance = Math.abs(sourceFloor - elevator.getCurrentFloor());
            int score;

            if (elevator.getStatus() == ElevatorStatus.IDLE) {
                score = distance; // idle elevators are prioritized
            } else if ((elevator.getStatus() == ElevatorStatus.MOVING_UP && direction > 0 && elevator.getCurrentFloor() <= sourceFloor) ||
                    (elevator.getStatus() == ElevatorStatus.MOVING_DOWN && direction < 0 && elevator.getCurrentFloor() >= sourceFloor)) {
                score = distance + 1; // moving toward the user; good candidate
            } else {
                score = distance + 1000; // moving away or busy; penalize heavily
            }

            score += elevator.getPendingRequestCount() * 10;

            if (score < bestScore) {
                bestScore = score;
                bestElevator = elevator;
            }
        }

        return bestElevator;
    }

}
