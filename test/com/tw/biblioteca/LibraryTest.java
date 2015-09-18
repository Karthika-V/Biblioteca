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

        assertEquals(true, !library.books().isEmpty());
    }

    @Test
    public void shouldHaveACheckOutWhenUserChoosesABookAvailableInLibrary() {
        Library library = new Library();
        User user = new User("111-1111", "abcd", "Abc", "Def@xyz.com", "100", User.Role.USER);
        library.checkOutBook("Harry Potter", user);

        assertEquals("Thank You! Enjoy the Book\n", outContent.toString());
    }

    @Test
    public void shouldHaveUnsuccessfulCheckOutWhenUserChoosesAnUnavailableBookInLibrary() {
        Library library = new Library();
        User user = new User("111-1111", "abcd", "Abc", "Def@xyz.com", "100", User.Role.USER);
        library.checkOutBook("Abcd", user);
        assertEquals("That book is not available\n", outContent.toString());
    }

    @Test
    public void shouldHaveAReturnBookOptionWhenUserChoosesReturnFromMenuWhichWasCheckedOutBefore() {
        Library library = new Library();
        User user = new User("111-1111", "abcd", "Abc", "Def@xyz.com", "100", User.Role.USER);
        library.checkOutBook("Harry Potter", user);
        library.checkInBook(library.returnBook("Harry Potter", user));

        assertEquals("Thank You! Enjoy the Book\nThank You for Returning Book\n", outContent.toString());
    }

    @Test
    public void shouldHaveUnsuccessfulReturnWhenUserChoosesABookWhichIsNotCheckedOutFromLibrary() {
        Library library = new Library();
        User user = new User("111-1111", "abcd", "Abc", "Def@xyz.com", "100", User.Role.USER);
        library.returnBook("Abcd", user);

        assertEquals("That is not a Valid Book to Return\n", outContent.toString());
    }

    @Test
    public void shouldHaveACheckOutWhenUserChoosesAMovieAvailableInLibrary() {
        Library library = new Library();
        library.checkOutMovie("Roja");

        assertEquals("Thank You! Enjoy the Movie\n", outContent.toString());
    }

}