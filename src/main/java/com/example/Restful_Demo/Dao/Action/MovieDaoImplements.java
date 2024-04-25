package com.example.Restful_Demo.Dao.Action;

import com.example.Restful_Demo.Dao.MovieDao;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDaoImplements implements MovieDao {
    public String getMovie(){
        return "獲取一部電影";
    }
    public String getMovies(){
        return "獲取多部電影";
    }
    public String postMovies(){
        return "新增電影";
    }
    public String updateMovies(){
        return "更新電影";
    }

    public String deleteMovies(){
        return "刪除電影";
    }
}
