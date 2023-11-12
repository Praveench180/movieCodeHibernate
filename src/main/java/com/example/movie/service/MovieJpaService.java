/*
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 *
 */

// Write your code here
package com.example.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import com.example.movie.model.Movie;
import com.example.movie.repository.*;

@Service
public class MovieJpaService implements MovieRepository {
    @Autowired
    private MovieJpaRepository moviejparepository;

    @Override
    public ArrayList<Movie> getMovies() {
        List<Movie> movies = moviejparepository.findAll();
        ArrayList<Movie> allMovies = new ArrayList<>(movies);
        return allMovies;
    }

    @Override
    public Movie getMovieById(int movieid) {
        try {
            Movie getMovie = moviejparepository.findById(movieid).get();
            return getMovie;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public Movie addMovie(Movie movie) {
        moviejparepository.save(movie);
        return movie;
    }

    @Override
    public Movie updateMovie(int movieID, Movie movie) {
        try {
            Movie newMovie = moviejparepository.findById(movieID).get();
            if (movie.getMovieName() != null) {
                newMovie.setMovieName(movie.getMovieName());
            }
            if (movie.getLeadActor() != null) {
                newMovie.setLeadActor(movie.getLeadActor());
            }
            moviejparepository.save(newMovie);
            return newMovie;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteMovie(int movieID) {
        try {
            moviejparepository.deleteById(movieID);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

}