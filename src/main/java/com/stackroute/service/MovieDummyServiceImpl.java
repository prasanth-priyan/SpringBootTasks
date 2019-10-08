package com.stackroute.service;

import com.stackroute.domain.Movie;
import com.stackroute.exceptions.MovieAlreadyExistsException;
import com.stackroute.exceptions.MovieNotFoundException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dummy")
@Profile("test")
public class MovieDummyServiceImpl implements MovieService {

    @Override
    public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException {
        return null;
    }

    @Override
    public List<Movie> getAllMovies() {
        return null;
    }

    @Override
    public Movie getMovieById(int id) throws MovieNotFoundException {
        return null;
    }

    @Override
    public void deleteMovie(int id) throws MovieNotFoundException {

    }

    @Override
    public Movie updateMovieComments(int id, String comments) throws MovieNotFoundException {
        return null;
    }

    @Override
    public List<Movie> getMoviesByName(String name) throws MovieNotFoundException {
        return null;
    }
}
