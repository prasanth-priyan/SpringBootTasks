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
@RequestMapping(value = "stackroute/")
public class MovieController {

    @Autowired
    private MovieService movieService;

    private ResponseEntity responseEntity;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("movie")
    public ResponseEntity saveMovie(@RequestBody Movie movie) throws MovieAlreadyExistsException {
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
    public ResponseEntity getMovieById(@PathVariable int id) throws MovieNotFoundException {
        Movie retrievedMovie = movieService.getMovieById(id);
        responseEntity = new ResponseEntity<Movie>(retrievedMovie, HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("movie/{id}")
    public ResponseEntity deleteMovie(@PathVariable int id) throws MovieNotFoundException {
        responseEntity = new ResponseEntity<Movie>(movieService.deleteMovie(id), HttpStatus.OK);
        return responseEntity;
    }

    @PutMapping("movie/{id}")
    public ResponseEntity updateComments(@PathVariable int id, @RequestBody String comments) throws MovieNotFoundException {
        responseEntity = new ResponseEntity<Movie>(movieService.updateMovieComments(id, comments), HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("movie/byName/{name}")
    public ResponseEntity getMoviesByName(@PathVariable String name) throws MovieNotFoundException {
        responseEntity = new ResponseEntity<List<Movie>>(movieService.getMoviesByName(name), HttpStatus.OK);
        return responseEntity;
    }
}
