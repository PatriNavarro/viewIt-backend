package com.patrinav.viewit.entities.embeddables;

import main.resources.enumerations.Genre;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class MovieDetails {
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private Integer duration;
    private String sinopsis;

    public MovieDetails() {
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
}
