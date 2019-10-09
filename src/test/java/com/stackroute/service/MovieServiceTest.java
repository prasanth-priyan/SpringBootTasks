package com.stackroute.service;

import com.stackroute.domain.Movie;
import com.stackroute.exceptions.MovieAlreadyExistsException;
import com.stackroute.repository.MovieRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class MovieServiceTest {

    private Movie movie;
    private List<Movie> list = null;

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieServiceImpl movieService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        movie = new Movie(101, "Before Sunrise", "100%");
        list = new ArrayList<>();
        list.add(movie);
    }


    @Test
    public void saveMovie() throws MovieAlreadyExistsException {
        when(movieRepository.save((Movie) any())).thenReturn(movie);
        Movie savedMovie = movieService.saveMovie(movie);
        Assert.assertEquals(movie,savedMovie);

        //verify here verifies that userRepository save method is only called once
        verify(movieRepository,times(1)).save(movie);

    }

    @Test(expected = MovieAlreadyExistsException.class)
    public void saveMovieFailure() throws MovieAlreadyExistsException {
        when(movieRepository.save((Movie) any())).thenReturn(null);
        Movie savedMovie = movieService.saveMovie(movie);
        System.out.println("savedMovie: " + savedMovie);
    }

    @Test
    public void getAllMovies() {
        movieRepository.save(movie);
        //stubbing the mock to return specific data
        when(movieRepository.findAll()).thenReturn(list);
        List<Movie> movielist = movieService.getAllMovies();
        Assert.assertEquals(list, movielist);
    }

    @Test
    public void getMovieById() {
    }

    @Test
    public void deleteMovie() {
    }

    @Test
    public void updateMovieComments() {
    }

    @Test
    public void getMoviesByName() {
    }
}