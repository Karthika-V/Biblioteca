package com.tw.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ConsoleViewTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private ConsoleView consoleView = new ConsoleView();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }


    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void shouldDisplayMessagesOnConsole() {
        consoleView.display("Hello");

        assertEquals("Hello\n", outContent.toString());
    }

    @Test
    public void shouldDisplayAFormattedListOfBooks() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Harry Potter", "J.K.Rowling", 2000));
        books.add(new Book("Diary of a Young Girl", "Anne frank", 1942));

        consoleView.bookListView(books);

        assertEquals("List Of Books:\n" +
                "\n" +
                "--------------------------------------------------------------------------------\n" +
                "Title                  Author                 Published year         \n" +
                "--------------------------------------------------------------------------------\n" +
                "\n" +
                "Harry Potter            J.K.Rowling             2000                   \n" +
                "\n" +
                "Diary of a Young Girl   Anne frank              1942                   \n" +
                "\n\n", outContent.toString());

    }

    @Test
    public void shouldTakeInputFromUser() {
        ByteArrayInputStream inputContent = new ByteArrayInputStream("1".getBytes());
        System.setIn(inputContent);
        assertEquals("1", consoleView.inputFromUser());
    }

}