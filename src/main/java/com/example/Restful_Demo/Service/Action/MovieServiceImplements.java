package com.example.Restful_Demo.Service.Action;

import com.example.Restful_Demo.Dao.MovieDao;
import com.example.Restful_Demo.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImplements implements MovieService {

    @Autowired
    private MovieDao movieDao;

    public String getMovie(){
        movieDao.getMovie();
        return "獲取一部電影";
    }
    public String getMovies(){
        movieDao.getMovies();
        return "獲取多部電影";
    }
    public String postMovies(){
        movieDao.postMovies();
        return "新增電影";
    }
    public String updateMovies(){
        movieDao.updateMovies();
        return "更新電影";
    }

    public String deleteMovies(){
        movieDao.deleteMovies();
        return "刪除電影";
    }
}
