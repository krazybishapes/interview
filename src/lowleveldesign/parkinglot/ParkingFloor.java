package lowleveldesign.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {

    private int level;
    private List<ParkingSpot> parkingSpots;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<ParkingSpot> getParkingSpots() {
        if(parkingSpots == null){
            parkingSpots = new ArrayList<>();
        }
        return parkingSpots;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }
}
