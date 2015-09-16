package com.tw.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void shouldHaveBookDetails() {
        Book book = new Book("Abc", "Def", 1900);

        assertEquals(true, !(book.toString().isEmpty()));
    }

    @Test
    public void shouldDisplayBookDetails() {
        Book book = new Book("Abc", "Def", 1900);

        assertEquals("Abc                     Def                     1900                   \n", book.toString());
    }

    @Test
    public void shouldNotBeNull() {
        Book book = new Book("Abc", "Def", 1900);

        assertNotEquals(book, null);
    }

    @Test
    public void shouldBeEqualToItself() {
        Book book = new Book("Abc", "Def", 1900);

        assertEquals(book, book);
    }

    @Test
    public void shouldBeEqualToOtherInstanceOfSameClass() {
        Book book1 = new Book("Abc", "Def", 1900);
        Book book2 = new Book("Abc", "Def", 1900);

        assertEquals(book1, book2);
    }

    @Test
    public void shouldNotBeEqualToAnotherType() {
        Book book = new Book("Abc", "Def", 1900);

        assertNotEquals(book, "some string");
    }

    @Test
    public void shouldHaveSameHashCodeForSameBookTitle() {
        Book book1 = new Book("Abc", "Def", 1900);
        Book book2 = new Book("Abc", "Xyz", 2000);

        assertEquals(book1.hashCode(), book2.hashCode());
    }

    @Test
    public void shouldHaveDifferentHashCodeForDifferentBookTitle() {
        Book book1 = new Book("Abc", "Def", 1900);
        Book book2 = new Book("Xyz", "Def", 1900);

        assertNotEquals(book1.hashCode(), book2.hashCode());
    }

}