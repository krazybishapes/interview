package lowleveldesign.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotService {

    ParkingLot parkingLot;

    public ParkingLotService(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }

    public void addLevel(ParkingFloor parkingFloor){
        this.parkingLot.getFloors().add(parkingFloor);
    }
    public void addParkingSport(int level, ParkingSpot parkingSpot) throws Exception {
        ParkingFloor parkingFloor = this.parkingLot.getFloors().get(level);
        if(parkingFloor == null){
            throw new Exception("");
        }
        parkingFloor.getParkingSpots().add(parkingSpot);
    }

    public List<ParkingSpot> getAvailability(VehicleType vehicleType) throws Exception {
        List<ParkingFloor> parkingFloors = this.parkingLot.getFloors();
        List<ParkingSpot> availableParkingSpots= new ArrayList<>();
        for(ParkingFloor parkingFloor : parkingFloors){
            List<ParkingSpot> parkingSpots = parkingFloor.getParkingSpots();
            for(ParkingSpot parkingSpot: parkingSpots){
                if(BookingStatus.AVAILABLE.equals(parkingSpot.getBookingStatus())){
                    availableParkingSpots.add(parkingSpot);
                }
            }
        }
        return availableParkingSpots;
    }
}
