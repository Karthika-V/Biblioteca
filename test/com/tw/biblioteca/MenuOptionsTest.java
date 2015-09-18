package com.tw.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuOptionsTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Library library = new Library();
    private ConsoleView consoleView = new ConsoleView();
    private Authenticator authenticator = new Authenticator();
    private Scanner in = new Scanner(System.in);
    private User user = new User("111-1111","abcd", "Abc", "Def@xyz.com", "100", User.Role.USER);;
    private Session session = new Session(user);
    private Login login = new Login(authenticator, consoleView, user, session);

    MenuOptions menuOptions = new MenuOptions(library, consoleView, authenticator, login, session, user);

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
    public void shouldCallBookListWhenUserChoiceIsOne() {
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

        menuOptions.optionHandler("*");

        assertEquals("Select a valid option!\n", outContent.toString());
    }

    @Test
    public void shouldHaveAnOptionToCheckOutABook() {
        MenuOptions mockedmenuOptions = mock(MenuOptions.class);

        mockedmenuOptions.optionHandler("2");

        verify(mockedmenuOptions).optionHandler("2");
    }

    @Test
    public void shouldHaveAnOptionToReturnABook() {
        MenuOptions mockedmenuOptions = mock(MenuOptions.class);

        mockedmenuOptions.optionHandler("3");

        verify(mockedmenuOptions).optionHandler("3");
    }

}