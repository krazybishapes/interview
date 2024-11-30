package lowleveldesign.bookmyshow.service;

import lowleveldesign.bookmyshow.Seat;
import lowleveldesign.bookmyshow.Show;
import lowleveldesign.bookmyshow.Theater;
import java.util.Date;
import java.util.List;

public interface TheaterService {

    public void addTheater(Theater theater);
    public Theater getTheaterDetails(String theaterId);
    public void updateTheaterDetails(Theater theater);

    public void addShow(String theaterId, Show show);
    public void addSeat(String showId, Seat seat);

    public List<Show> getAvailableShows(String longitude, String lattitude, String movieId, Date bookingDate);

    public List<Seat> getAvailableSeats(String showId);
}
