package lowleveldesign.parkinglot;

public class ParkingSpot {

    private int id;
    private VehicleType parkableVehicleType;
    private double costPerHour;
    private BookingStatus bookingStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VehicleType getParkableVehicleType() {
        return parkableVehicleType;
    }

    public void setParkableVehicleType(VehicleType parkableVehicleType) {
        this.parkableVehicleType = parkableVehicleType;
    }

    public double getCostPerHour() {
        return costPerHour;
    }

    public void setCostPerHour(double costPerHour) {
        this.costPerHour = costPerHour;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}
