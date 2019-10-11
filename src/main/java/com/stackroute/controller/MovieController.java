package com.stackroute.controller;

import com.stackroute.domain.Movie;
import com.stackroute.exceptions.MovieAlreadyExistsException;
import com.stackroute.exceptions.MovieNotFoundException;
import com.stackroute.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "api/v1")
public class MovieController {

    private MovieService movieService;

    private ResponseEntity responseEntity;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("movie")
    public ResponseEntity saveMovie(@RequestBody Movie movie) throws MovieAlreadyExistsException, Exception {
        Movie savedMovie = movieService.saveMovie(movie);
        responseEntity = new ResponseEntity<Movie>(savedMovie, HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("movies")
    public ResponseEntity getAllMovies() throws Exception {
        List<Movie> movieList = movieService.getAllMovies();
        responseEntity = new ResponseEntity<List<Movie>>(movieList, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("movie/{id}")
    public ResponseEntity getMovieById(@PathVariable int id) throws MovieNotFoundException, Exception {
        Movie retrievedMovie = movieService.getMovieById(id);
        responseEntity = new ResponseEntity<Movie>(retrievedMovie, HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("movie/{id}")
    public ResponseEntity deleteMovie(@PathVariable int id) throws MovieNotFoundException, Exception {
        responseEntity = new ResponseEntity<Movie>(movieService.deleteMovie(id), HttpStatus.OK);
        return responseEntity;
    }

    @PutMapping("movie")
    public ResponseEntity updateMovie(@RequestBody Movie movie) throws MovieNotFoundException, Exception {
        responseEntity = new ResponseEntity<Movie>(movieService.updateMovie(movie), HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("movie/byName/{name}")
    public ResponseEntity getMoviesByName(@PathVariable String name) throws MovieNotFoundException, Exception {
        responseEntity = new ResponseEntity<List<Movie>>(movieService.getMoviesByName(name), HttpStatus.OK);
        return responseEntity;
    }
}
