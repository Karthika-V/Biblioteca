package com.tw.biblioteca;

//A Movie should have a name, year, director and rating.
public class Movie {

    private String name;
    private int releaseYear;
    private String director;
    private String rating;

    public Movie(String name, int releaseYear, String director, String rating) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.director = director;
        this.rating = rating;
    }
}
