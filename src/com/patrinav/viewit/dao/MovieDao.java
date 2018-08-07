package com.patrinav.viewit.dao;

import com.patrinav.viewit.entities.Movie;

import java.util.List;

public interface MovieDao {
    List<Movie> getAll();
    Movie get(Long id);
    Movie update(Movie movie);
    Movie create(Movie movie);
    Movie delete(Movie movie);
}
