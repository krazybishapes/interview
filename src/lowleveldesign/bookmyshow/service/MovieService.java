package lowleveldesign.bookmyshow.service;

import lowleveldesign.bookmyshow.Movie;

public interface MovieService {

    public void addMovie(Movie movie);
    public Movie getMovieDetails(String movieId);
    public void updateMovieDetails(Movie movie);
}
