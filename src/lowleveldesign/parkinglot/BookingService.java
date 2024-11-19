package lowleveldesign.parkinglot;

public interface BookingService {

    public BookingDetails createBooking(BookingRequest bookingRequest);

    public BookingDetails getBookingDetails(int bookingId);

    public void cancelBooking(int bookingId);
}
