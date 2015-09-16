package com.tw.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class MenuOptionsTest {

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
    public void shouldListOutMenuForUser() {
        MenuOptions menuOptions = new MenuOptions();
        menuOptions.toString();

        assertEquals("1:List Books\n", menuOptions.toString());
    }

    @Test
    public void shouldCallBookListWhenUserChoiceIsOne() {
        Library library = new Library();
        MenuOptions menuOptions = new MenuOptions();
        menuOptions.optionHandler("1");

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

}