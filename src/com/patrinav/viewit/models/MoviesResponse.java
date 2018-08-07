package com.patrinav.viewit.models;

import com.patrinav.viewit.entities.Movie;

import java.io.Serializable;
import java.util.List;

public class MoviesResponse implements Serializable{
    private List<Movie> movies;

    public MoviesResponse() {
    }

    public List<Movie> getMovies() {
        return this.movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
