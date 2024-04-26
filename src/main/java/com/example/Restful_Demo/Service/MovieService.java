package com.example.Restful_Demo.Service;

import com.example.Restful_Demo.Modul.Movie;

import java.util.Iterator;
import java.util.List;

public interface MovieService {
    public Movie getMovie(Integer movie_id);
    public Iterator<Movie> getMovies();
    public Movie postMovies(Movie movie);
    public void updateMovies(Integer movie_id, Movie movie);
    public Movie deleteMovies(Integer movie_id);
}
