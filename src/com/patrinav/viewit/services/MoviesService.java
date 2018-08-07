package com.patrinav.viewit.services;

import com.patrinav.viewit.entities.Movie;

import java.util.List;

public interface MoviesService {
    List<Movie> getAll();
    Movie get(Long id);
    Movie update(Movie movie);
    Movie create(Movie movie);
    Movie delete(Movie movie);

}
