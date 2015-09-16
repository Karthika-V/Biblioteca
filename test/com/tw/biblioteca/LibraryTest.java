package com.tw.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class LibraryTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void shouldHaveAListOfBooks() {
        Library library = new Library();

        assertEquals(true, !library.books.isEmpty());
    }

    @Test
    public void shouldDisplayAListOfBooks() {
        Library library = new Library();
        library.displayLibraryBooks();

        assertEquals("[Harry Potter            J.K.Rowling             2000                   \n" +
                ", Diary of a Young Girl   Anne frank              1942                   \n" +
                "]\n", outContent.toString());
    }

    @Test
    public void shouldHaveACheckOutWhenUserChoosesABookAvailableInLibrary() {
        Library library = new Library();
        library.checkOutBook("Harry Potter");

        assertEquals("Thank You! Enjoy the Book\n", outContent.toString());
    }

    @Test
    public void shouldHaveUnsuccessfulCheckOutWhenUserChoosesAnUnavailableBookInLibrary() {
        Library library = new Library();
        library.checkOutBook("Abcd");
        assertEquals("That book is not available\n", outContent.toString());
    }

}