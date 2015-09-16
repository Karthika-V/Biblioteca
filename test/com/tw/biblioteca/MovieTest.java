package com.tw.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {

    @Test
    public void shouldHaveANameAndReleaseYearAndDirectorAndRating() {
        Movie movie = new Movie("Roja", 1995, "ManiRatnam", "9");

        assertEquals(true, !movie.toString().isEmpty());
    }

    @Test
    public void shouldHaveRatingBetween1And10() {
        Movie movie = new Movie("Roja", 1995, "ManiRatnam", "9");

        assertEquals("9", movie.isValidRating("9"));
    }

    @Test
    public void shouldHaveRatingAsUnratedIfRatingIsNotBetween1And10() {
        Movie movie = new Movie("Roja", 1995, "ManiRatnam", "9");

        assertEquals("Unrated", movie.isValidRating("11"));
    }

    @Test
    public void shouldNotBeNull() {
        Movie movie = new Movie("Roja", 1995, "ManiRatnam", "9");

        assertNotEquals(movie, null);
    }

    @Test
    public void shouldBeEqualToItself() {
        Movie movie = new Movie("Roja", 1995, "ManiRatnam", "9");

        assertEquals(movie, movie);
    }

    @Test
    public void shouldBeEqualToOtherInstanceOfSameType() {
        Movie movie1 = new Movie("Roja", 1995, "ManiRatnam", "9");
        Movie movie2 = new Movie("Roja", 1995, "ManiRatnam", "9");

        assertEquals(movie1, movie2);
    }

    @Test
    public void shouldNotBeEqualToAnotherType() {
        Movie movie = new Movie("Roja", 1995, "ManiRatnam", "9");

        assertNotEquals(movie, "some string");
    }

    @Test
    public void shouldHaveSameHashCodeForSameMovieName() {
        Movie movie1 = new Movie("Roja", 1995, "ManiRatnam", "9");
        Movie movie2 = new Movie("Roja", 000, "xyz", "5");

        assertEquals(movie1.hashCode(), movie2.hashCode());
    }

    @Test
    public void shouldHaveDifferentHashCodeForDifferentMovies() {
        Movie movie1 = new Movie("Roja", 1995, "ManiRatnam", "9");
        Movie movie2 = new Movie("ABC", 000, "xyz", "5");

        assertNotEquals(movie1.hashCode(), movie2.hashCode());
    }

}