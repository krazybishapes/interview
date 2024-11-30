package lowleveldesign.bookmyshow.service;

import lowleveldesign.bookmyshow.Booking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingServiceImpl implements BookingService{

    Map<String, List<Booking>> userBookings;

    public BookingServiceImpl(){
        this.userBookings = new HashMap<>();
    }

    @Override
    public synchronized void bookTicket(Booking booking) {
        String userId = String.valueOf(booking.getUser().getId());
        List<Booking> bookings = userBookings.getOrDefault(userId,new ArrayList<>());
        bookings.add(booking);
        userBookings.put(userId,bookings);
    }

    @Override
    public Booking getBookingDetails(String userId, String bookingId) {
        return null;
    }

    @Override
    public List<Booking> getUserBooking(String userId) {
        return userBookings.get(userId);
    }
}
