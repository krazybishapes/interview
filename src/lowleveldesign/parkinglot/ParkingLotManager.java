package lowleveldesign.parkinglot;


public class ParkingLotManager {

    static ParkingLot parkingLot = ParkingLot.getInstance();

    static ParkingLotService parkingLotService = new ParkingLotService(parkingLot);

    static BookingService bookingService = new BookingServiceImpl();

    public static void main(String[] args) {


        //add level into parking lot


        //add parking spot

        //get available parking spots

        //create Booking





    }


}
