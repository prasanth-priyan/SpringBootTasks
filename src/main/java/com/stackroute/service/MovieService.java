package com.stackroute.service;

import com.stackroute.domain.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    public Movie saveMovie(Movie movie);

    public List<Movie> getAllMovies();

    public Movie getMovieById(int id);

    public void deleteMovie(int id);

    public Movie updateMovieComments(int id, String comments);
}
