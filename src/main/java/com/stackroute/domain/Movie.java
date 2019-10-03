package com.stackroute.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie {
    @Id
    private int movieId;
    private String movieName;
    private String movieComments;

    public Movie() {
    }

    public Movie(int movieId, String movieName, String movieComments) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieComments = movieComments;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieComments() {
        return movieComments;
    }

    public void setMovieComments(String movieComments) {
        this.movieComments = movieComments;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", movieComments='" + movieComments + '\'' +
                '}';
    }
}
