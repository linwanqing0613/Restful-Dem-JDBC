package com.example.Restful_Demo.Service.Action;

import com.example.Restful_Demo.Dao.MovieRepository;
import com.example.Restful_Demo.Modul.Movie;
import com.example.Restful_Demo.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Iterator;


@Service
public class MovieServiceImplements implements MovieService {

    @Autowired
    private MovieRepository movieRepository;
    //目前時間
    private final LocalDateTime nowDate = LocalDateTime.now();

    public Movie getMovie(Integer movie_id){
        return movieRepository.findById(movie_id).orElse(null);
    }
    public Iterator<Movie> getMovies(){
        return movieRepository.findAll().iterator();
    }
    public Movie postMovies(Movie movie){
        movie.setCreated_date(nowDate);
        movie.setLast_modified_date(nowDate);
        return movieRepository.save(movie);
    }
    public void updateMovies(Integer movie_id, Movie movie){
        movie.setId(movie_id);
        movie.setLast_modified_date(nowDate);
        movieRepository.save(movie);
    }

    public Movie deleteMovies(Integer movie_id){
        Movie movie = getMovie(movie_id);
        if(movie != null) {
            movieRepository.deleteById(movie_id);
            return movie;
        }else
            return null;
    }
}
