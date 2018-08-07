package com.patrinav.viewit.services;

import com.patrinav.viewit.dao.MovieDao;
import com.patrinav.viewit.entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dbMoviesService")
public class DbMoviesService implements MoviesService{

    @Autowired
    private MovieDao movieDao;

    @Override
    public List<Movie> getAll() {
        return movieDao.getAll();
    }

    @Override
    public Movie get(Long id) {
        return movieDao.get(id);
    }

    @Override
    public Movie update(Movie movie) {
        return null;
    }

    @Override
    public Movie create(Movie movie) {
        return movieDao.create(movie);
    }

    @Override
    public Movie delete(Movie movie) {
        return null;
    }
}
