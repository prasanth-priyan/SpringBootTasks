package com.stackroute.service;

import com.stackroute.domain.Movie;
import com.stackroute.exceptions.MovieAlreadyExistsException;
import com.stackroute.exceptions.MovieNotFoundException;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException;

    public List<Movie> getAllMovies();

    public Movie getMovieById(int id) throws MovieNotFoundException;

    public void deleteMovie(int id) throws MovieNotFoundException;

    public Movie updateMovieComments(int id, String comments) throws MovieNotFoundException;

    public List<Movie> getMoviesByName(String name) throws MovieNotFoundException;
}
