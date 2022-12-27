package com.example.demoneo4j.service;

import com.example.demoneo4j.dao.MovieDao;
import com.example.demoneo4j.modal.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    private MovieDao movieDao;

    public void save(Movie movie) {
        movieDao.save(movie);
    }
}
