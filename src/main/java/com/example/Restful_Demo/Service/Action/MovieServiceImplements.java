package com.example.Restful_Demo.Service.Action;

import com.example.Restful_Demo.Dao.MovieRepository;
import com.example.Restful_Demo.Modul.Movie;
import com.example.Restful_Demo.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

@Service
public class MovieServiceImplements implements MovieService {

    @Autowired
    private MovieRepository movieRepository;
    //目前時間
    private final LocalDateTime nowDate = LocalDateTime.now();

    public Movie getMovie(Integer movie_id){
        return movieRepository.findById(movie_id).orElse(null);
    }
    public Iterator<Movie> getMovies(List<Integer> movie_ids){
        return movieRepository.findAllById(movie_ids).iterator();
    }
    public Movie postMovies(Movie movie){
        movie.setCreated_date(nowDate);
        movie.setLast_modified_date(nowDate);
        return movieRepository.save(movie);
    }
    public void updateMovies(Integer movie_id, Movie movie){
        Movie pre_movie = getMovie(movie_id);
        if(pre_movie != null) {
            if(movie.getId() == null)
                movie.setId(movie_id);
            if(movie.getTitle() == null)
                movie.setTitle(pre_movie.getTitle());
            if(movie.getDirector() == null)
                movie.setDirector(pre_movie.getDirector());
            if(movie.getYear() == null)
                movie.setYear(pre_movie.getYear());
            movie.setCreated_date(pre_movie.getCreated_date());
            movie.setLast_modified_date(nowDate);
            movieRepository.save(movie);
        }
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
