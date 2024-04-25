package com.example.Restful_Demo.Controller;

import com.example.Restful_Demo.Modul.Movie;
import com.example.Restful_Demo.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/Movie/{movie_id}")
    public ResponseEntity<Movie> getMovies(@PathVariable Integer movie_id){
        Movie movie = movieService.getMovie(movie_id);
        return movie != null? ResponseEntity.ok(movie): ResponseEntity.notFound().build();
    }
    @PostMapping("/Movie")
    public ResponseEntity<Movie> postMovies(@RequestBody Movie pre_movie){
        Movie movie= movieService.postMovies(pre_movie);

        return movie != null? ResponseEntity.ok(movie): ResponseEntity.notFound().build();
    }
    @PutMapping("/Movie/{movie_id}")
    public ResponseEntity<Movie> updateMovies(@PathVariable Integer movie_id,@RequestBody Movie pre_movie){
        movieService.updateMovies(movie_id, pre_movie);
        Movie movie= movieService.getMovie(movie_id);
        return movie != null? ResponseEntity.ok(movie): ResponseEntity.notFound().build();
    }
    @DeleteMapping("/Movie/{movie_id}")
    public ResponseEntity<Movie> deleteMovies(@PathVariable Integer movie_id){
        Movie movie= movieService.deleteMovies(movie_id);
        return movie != null? ResponseEntity.ok(movie): ResponseEntity.notFound().build();
    }
}
