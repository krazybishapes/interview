package lowleveldesign.parkinglot;

import java.time.LocalDateTime;

public class BookingServiceImpl implements BookingService{
    @Override
    public BookingDetails createBooking(BookingRequest bookingRequest) {

        ParkingSpot parkingSpot = bookingRequest.getParkingSpot();
        User user = bookingRequest.getUser();

        Booking booking = new Booking();
        booking.setId(1);
        booking.setParkingSpot(parkingSpot);
        booking.setBookingStatus(BookingStatus.BOOKED);
        booking.setBookingTime(LocalDateTime.now());
        booking.setTotalPrice(100);
        booking.setUser(user);

        user.getBookings().add(booking);

        return null;
    }

    @Override
    public BookingDetails getBookingDetails(int bookingId) {
        return null;
    }

    @Override
    public void cancelBooking(int bookingId) {

    }
}
