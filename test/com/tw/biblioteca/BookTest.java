package com.tw.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    @Test
    public void shouldHaveBookDetails() {
        Book book = new Book("Abc", "Def", 1900);

        assertEquals(true, !(book.toString().isEmpty()));
    }

}