package com.stackroute.startup;

import com.stackroute.domain.Movie;
import com.stackroute.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:values.properties")
@ConfigurationProperties(prefix = "movie")
public class StartupDatabaseSeederApproachB implements CommandLineRunner {

    private MovieRepository movieRepository;
    private Movie movie;

    private int id2;
    private String name2;
    private String watch;

    @Autowired
    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Movie movie = new Movie();
        movie.setMovieId(id2);
        movie.setMovieName(name2);
        movie.setMovieComments(watch);
        movieRepository.save(movie);
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public void setWatch(String watch) {
        this.watch = watch;
    }
}
