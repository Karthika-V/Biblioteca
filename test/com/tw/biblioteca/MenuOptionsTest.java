package com.tw.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuOptionsTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

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

    @Test
    public void shouldQuitFromApplicationtWhenUserChoiceIsQuit() {
        MenuOptions mockedmenuOptions = mock(MenuOptions.class);

        mockedmenuOptions.optionHandler("q");

        verify(mockedmenuOptions).optionHandler("q");
        exit.expectSystemExitWithStatus(0);
        System.exit(0);
    }

    @Test
    public void shouldShowInvalidOptionsWhenUserEntersSomeInvalidInput() {
        MenuOptions menuOptions = new MenuOptions();

        menuOptions.optionHandler("*");

        assertEquals("Select a valid option!\n", outContent.toString());
    }
}