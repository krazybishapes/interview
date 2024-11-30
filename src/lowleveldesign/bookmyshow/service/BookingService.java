package lowleveldesign.bookmyshow.service;

import lowleveldesign.bookmyshow.Booking;

import java.util.List;

public interface BookingService {

    public void bookTicket(Booking booking);
    public Booking getBookingDetails(String userId, String bookingId);
    public List<Booking> getUserBooking(String userId);

}
