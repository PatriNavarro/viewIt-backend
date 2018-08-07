package com.patrinav.viewit.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.patrinav.viewit.entities.embeddables.MovieDetails;
import main.resources.enumerations.Genre;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="movie")
public class Movie implements Serializable {
//    public enum Genre{Action,Animated,Musical}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movies_id")
    private Long movieId;
    private String title;
    @Embedded
    MovieDetails movieDetails;

    private String image;
    private String trailer;

    @OneToMany(mappedBy = "movie")
    @JsonIgnore
    private Set<Screening> screenings;

    public Movie() {
    }

    public Movie(Long movieId, String title, Genre genre, Integer duration, String sinopsis, String image, String trailer) {
        this.movieId = movieId;
        this.title = title;
//        this.genre = genre;
//        this.duration = duration;
//        this.sinopsis = sinopsis;
        this.image = image;
        this.trailer = trailer;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//
//    public Genre getGenre() {
//        return genre;
//    }
//    public void setGenre(Genre genre) {
//        this.genre = genre;
//    }
//
//    public Integer getDuration() {
//        return duration;
//    }
//
//    public void setDuration(Integer duration) {
//        this.duration = duration;
//    }
//
//    public String getSinopsis() {
//        return sinopsis;
//    }
//
//    public void setSinopsis(String sinopsis) {
//        this.sinopsis = sinopsis;
//    }

    public MovieDetails getMovieDetails() {
        return movieDetails;
    }

    public void setMovieDetails(MovieDetails movieDetails) {
        this.movieDetails = movieDetails;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public Set<Screening> getScreenings() {
        return screenings;
    }

    public void setScreenings(Set<Screening> screenings) {
        this.screenings = screenings;
    }
}
