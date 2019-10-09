package com.stackroute.repository;

import com.stackroute.domain.Movie;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;
    private Movie movie;

    @Before
    public void setUp() throws Exception {
        movie = new Movie(101, "Ambili", "Malayalam");
    }

    @After
    public void tearDown() throws Exception {
        movieRepository.deleteAll();
    }

    @Test
    public void testSaveMovie(){
        movieRepository.save(movie);
        Movie savedMovie = movieRepository.findById(movie.getMovieId()).get();
        Assert.assertEquals(101,savedMovie.getMovieId());
    }

    @Test
    public void testSaveMovieFailure(){
        Movie testMovie = new Movie(102, "Pokemon", "Gotta catch'em all!!!");
        movieRepository.save(movie);
        Movie savedMovie = movieRepository.findById(movie.getMovieId()).get();
        Assert.assertNotSame(testMovie, movie);
    }

    @Test
    public void testGetAllMovies() {
        Movie movie1 = new Movie(102, "Batman", "TDK");
        Movie movie2 = new Movie(103, "Joker", "Joaquin");
        movieRepository.save(movie1);
        movieRepository.save(movie2);

        List<Movie> list = movieRepository.findAll();
        Assert.assertEquals("Batman", list.get(1).getMovieName());
    }

    @Test
    public void findByMovieNameIgnoreCase() {
    }
}