/*
 * You can use the following import statements
 * 
 * import javax.persistence.*;
 * 
 */

// Write your code here
package com.example.movie.model;

import javax.persistence.*;

@Entity
@Table(name = "movielist")
public class Movie {

    @Id
    @Column(name = "movieid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;

    @Column(name = "moviename")
    private String movieName;

    @Column(name = "leadactor")
    private String leadActor;

    public Movie() {
    }

    public Movie(int movieID, String movieName, String leadActor) {
        this.movieId = movieID;
        this.movieName = movieName;
        this.leadActor = leadActor;
    }

    public int getMovieID() {
        return movieId;
    }

    public void setMovieID(int movieID) {
        this.movieId = movieID;
    }

    public String getLeadActor() {
        return leadActor;
    }

    public void setLeadActor(String leadActor) {
        this.leadActor = leadActor;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

}
