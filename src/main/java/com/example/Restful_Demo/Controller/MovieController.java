package com.example.Restful_Demo.Controller;

import com.example.Restful_Demo.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Component
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/Movies")
    public ResponseEntity<String> getMovies(){
        String movies = movieService.getMovies();
        return null;
    }
    @PostMapping("/Movies")
    public ResponseEntity<String> postMovies(){
        movieService.postMovies();
        return null;
    }
    @PutMapping("/Movies")
    public ResponseEntity<String> updateMovies(){
        movieService.updateMovies();
        return null;
    }
    @DeleteMapping("/Movie")
    public ResponseEntity<String> deleteMovies(){
        movieService.deleteMovies();
        return null;
    }
}
