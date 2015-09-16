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

}