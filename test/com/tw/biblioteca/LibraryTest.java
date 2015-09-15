package com.tw.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryTest {

    @Test
    public void shouldHaveAListOfBooks() {
        Library library = new Library();

        assertEquals(true, !library.books.isEmpty());
    }

}