package com.stackroute.service;

import com.stackroute.domain.Movie;
import com.stackroute.exceptions.MovieAlreadyExistsException;
import com.stackroute.exceptions.MovieNotFoundException;

import java.util.List;


public interface MovieService {

    public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException, Exception;

    public List<Movie> getAllMovies() throws Exception;

    public Movie getMovieById(int id) throws MovieNotFoundException, Exception;

    public Movie deleteMovie(int id) throws MovieNotFoundException, Exception;

    public Movie updateMovie(Movie movie) throws MovieNotFoundException, Exception;

    public List<Movie> getMoviesByName(String name) throws MovieNotFoundException, Exception;
}
