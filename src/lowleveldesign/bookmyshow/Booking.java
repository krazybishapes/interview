package lowleveldesign.bookmyshow;

import java.util.Date;
import java.util.List;

public class Booking {

    private int id;
    private List<Seat> seats;
    private double BookingStatus;
    private User user;
    private Date bookingDate;
    private BookingStatus status;
    private double totalPrice;
    private String paymentReferenceId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public double getBookingStatus() {
        return BookingStatus;
    }

    public void setBookingStatus(double bookingStatus) {
        BookingStatus = bookingStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public lowleveldesign.bookmyshow.BookingStatus getStatus() {
        return status;
    }

    public void setStatus(lowleveldesign.bookmyshow.BookingStatus status) {
        this.status = status;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPaymentReferenceId() {
        return paymentReferenceId;
    }

    public void setPaymentReferenceId(String paymentReferenceId) {
        this.paymentReferenceId = paymentReferenceId;
    }
}
