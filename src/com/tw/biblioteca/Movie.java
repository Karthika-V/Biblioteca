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

    public String isValidRating(String rating) {
        int ratingNumber = Integer.parseInt(rating);
        if ( ratingNumber > 0 && ratingNumber < 10) {
            this.rating = rating;
            return this.rating;
        }
        return "Unrated";
    }

    @Override
    public String toString() {
        return (String.format("%-23s %-23s %-23s %-23s", this.name, this.releaseYear, this.director, isValidRating(this.rating)));
    }
}
