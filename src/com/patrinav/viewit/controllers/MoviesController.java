package com.patrinav.viewit.controllers;

import com.patrinav.viewit.entities.Movie;
import com.patrinav.viewit.models.MoviesResponse;
import com.patrinav.viewit.services.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/movies")
public class MoviesController {

    @Autowired
    @Qualifier("dbMoviesService")
    private MoviesService moviesService;

    @GetMapping
    public ResponseEntity<MoviesResponse> getAll() {
        List<Movie> movies = this.moviesService.getAll();

        MoviesResponse moviesResponse = new MoviesResponse();
        moviesResponse.setMovies(movies);
        return new ResponseEntity<MoviesResponse>(moviesResponse,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getSingle(@PathVariable Long id){
        Movie movie = this.moviesService.get(id);
        return new ResponseEntity<Movie>(movie,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Movie> delete(@PathVariable Long id){
        Movie deletedMovie = this.moviesService.delete(this.moviesService.get(id));
        return new ResponseEntity<Movie>(deletedMovie,HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<Movie> update(@PathVariable Long id, @RequestBody Movie movie){
        Movie updatedMovie = this.moviesService.update(movie);
        return new ResponseEntity<Movie>(updatedMovie,HttpStatus.OK);
    }

    @PostMapping(value = "/insert",consumes = "application/json")
    public ResponseEntity<Movie> insert(@RequestBody Movie movie){
        Movie createdMovie = this.moviesService.create(movie);
        return new ResponseEntity<Movie>(createdMovie,HttpStatus.OK);
//        return new ResponseEntity<Movie>(movie,HttpStatus.OK);
    }
}
