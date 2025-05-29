package elevatorsystem;

public class ElevatorDemo {

    public static void main(String[] args) {
        ElevatorController elevatorController = new ElevatorController(5, 10);

        elevatorController.addRequest(new ElevateRequest(0,5));
        elevatorController.addRequest(new ElevateRequest(0,10));
        elevatorController.addRequest(new ElevateRequest(2,5));
        elevatorController.addRequest(new ElevateRequest(6,1));
        elevatorController.addRequest(new ElevateRequest(0,2));
    }
}
