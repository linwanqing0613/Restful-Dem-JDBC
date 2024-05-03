package com.example.Restful_Demo.Service.Action;

import com.example.Restful_Demo.Dao.MovieRepository;
import com.example.Restful_Demo.Modul.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class MovieServiceImplementsTest {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    void getMovie() {
        Movie movie =  movieRepository.findById(1).orElse(null);
        assertNotNull(movie, "FindById() 成功");
    }

    @Test
    void getMovies() {
        List<Movie> movies = (List<Movie>) movieRepository.findAll();
        assertFalse(movies.isEmpty(),"FindAll() 失敗");
    }

    @Test
    void postMovies() {
        Movie movie = new Movie();
        movie.setTitle("TEST");
        movie.setDirector("JPA_TEST");
        movie.setYear(2024);
        movie.setCreated_date(LocalDateTime.now());
        movie.setLast_modified_date(LocalDateTime.now());
        movie = movieRepository.save(movie);
        assertNotNull(movie.getId(), "postMovies 失敗");
    }

    @Test
    void updateMovies() {
        Movie movie =  movieRepository.findById(3).orElse(null);
        movie.setDirector("JPA_TEST");
        movieRepository.save(movie);
        movie =  movieRepository.findById(3).orElse(null);
        assertEquals("JPA_TEST", movie.getDirector(),"updateMovies 失敗");
    }

    @Test
    void deleteMovies() {
        movieRepository.deleteById(2);
        Movie movie =  movieRepository.findById(2).orElse(null);
        assertNull(movie, "DeleteById() 失敗");
    }
}