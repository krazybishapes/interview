package lowleveldesign.parkinglot;

import java.time.LocalDateTime;

public class Booking {

    private int id;
    private User user;
    private ParkingSpot parkingSpot;
    private LocalDateTime bookingTime;
    private LocalDateTime vehicleParkedAt;
    private LocalDateTime vehicleReleasedAt;
    private double totalPrice;
    private BookingStatus bookingStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public LocalDateTime getVehicleParkedAt() {
        return vehicleParkedAt;
    }

    public void setVehicleParkedAt(LocalDateTime vehicleParkedAt) {
        this.vehicleParkedAt = vehicleParkedAt;
    }

    public LocalDateTime getVehicleReleasedAt() {
        return vehicleReleasedAt;
    }

    public void setVehicleReleasedAt(LocalDateTime vehicleReleasedAt) {
        this.vehicleReleasedAt = vehicleReleasedAt;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}
