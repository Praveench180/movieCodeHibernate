// Write your code here

package com.example.movie.repository;

import java.util.*;

import com.example.movie.model.Movie;

public interface MovieRepository {

    ArrayList<Movie> getMovies();

    Movie getMovieById(int movieid);

    Movie addMovie(Movie movie);

    Movie updateMovie(int movieID, Movie movie);

    void deleteMovie(int movieID);
}
