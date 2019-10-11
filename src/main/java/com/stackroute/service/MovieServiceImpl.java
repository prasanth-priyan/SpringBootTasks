package com.stackroute.service;

import com.stackroute.domain.Movie;
import com.stackroute.exceptions.MovieAlreadyExistsException;
import com.stackroute.exceptions.MovieNotFoundException;
import com.stackroute.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("original")
@Primary
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException, Exception{
        if(movieRepository.existsById(movie.getMovieId())){
            throw new MovieAlreadyExistsException("Movie already exists");
        }
        Movie savedMovie = movieRepository.save(movie);
        if (savedMovie == null){
            throw new MovieAlreadyExistsException("Movie already exists");
        }
        return savedMovie;
    }

    public List<Movie> getAllMovies() throws Exception {
        List<Movie> movieList = new ArrayList<>(movieRepository.findAll());
        return movieList;
    }

    public Movie getMovieById(int id) throws MovieNotFoundException, Exception {
        if(!movieRepository.existsById(id)){
            throw new MovieNotFoundException("Movie not found");
        }
        Movie retrievedMovie = movieRepository.findById(id).get();
        return retrievedMovie;
    }


    public Movie deleteMovie(int id) throws MovieNotFoundException, Exception {
        if(!movieRepository.existsById(id)){
            throw new MovieNotFoundException("Movie does not exist");
        }
        Movie deletedMovie = movieRepository.findById(id).get();
        movieRepository.deleteById(id);
        return deletedMovie;
    }

    public Movie updateMovie(Movie movie) throws MovieNotFoundException, Exception {
        if(!movieRepository.existsById(movie.getMovieId())){
            throw new MovieNotFoundException("Movie not found");
        }
        Movie updatedMovie = movieRepository.save(movie);
        return updatedMovie;
    }

    public List<Movie> getMoviesByName(String name) throws MovieNotFoundException, Exception {
        List<Movie> retrievedMovies = movieRepository.findByName(name);
        if(retrievedMovies.toString().equals("[]")){
            throw new MovieNotFoundException("No movie found with the given name");
        }
        return retrievedMovies;
    }

}
