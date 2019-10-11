package com.stackroute.repository;

import com.stackroute.domain.Movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    @Query(value = "SELECT m FROM Movie m WHERE m.movieName = :name")
    public List<Movie> findByName(String name);
}
