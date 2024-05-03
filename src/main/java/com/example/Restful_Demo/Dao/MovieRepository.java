package com.example.Restful_Demo.Dao;

import com.example.Restful_Demo.Modul.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface MovieRepository extends CrudRepository<Movie, Integer> {

}
