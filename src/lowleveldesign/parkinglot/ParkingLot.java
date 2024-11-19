package lowleveldesign.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    static ParkingLot parkingLot;
    private ParkingLot(){}

    public static ParkingLot getInstance(){
        if(parkingLot == null){
            parkingLot = new ParkingLot();
            List<ParkingFloor> parkingFloors = new ArrayList<>();
            parkingLot.setFloors(parkingFloors);
        }
        return parkingLot;
    }

    private List<ParkingFloor> floors;

    public List<ParkingFloor> getFloors() {
        return floors;
    }

    public void setFloors(List<ParkingFloor> floors) {
        this.floors = floors;
    }
}
