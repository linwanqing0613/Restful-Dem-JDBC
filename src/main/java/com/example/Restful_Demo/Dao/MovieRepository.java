package com.example.Restful_Demo.Dao;

import com.example.Restful_Demo.Modul.Movie;
import org.springframework.data.repository.CrudRepository;


public interface MovieRepository extends CrudRepository<Movie, Integer> {

}
