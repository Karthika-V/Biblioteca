package com.tw.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

public class LoginTest {

    @Test
    public void shouldHaveInputForALibraryNumberAndPasswordFromUser() {
        String input1 = "111-1111";
        ByteArrayInputStream inContent1 = new ByteArrayInputStream(input1.getBytes());
        System.setIn(inContent1);
        String input2 = "abcd";
        ByteArrayInputStream inContent2 = new ByteArrayInputStream(input2.getBytes());
        System.setIn(inContent2);

        Authenticator authenticator = mock(Authenticator.class);
        authenticator.checkCredentials(input1, input2);

        Mockito.verify(authenticator, times(1)).checkCredentials(input1, input2);
    }

    @Test
    public void shouldCheckForTheValidityForAProperlyFormattedLibraryNumber() {
        ConsoleView consoleView = new ConsoleView();
        Authenticator authenticator = new Authenticator();
        Login login = new Login(authenticator, consoleView);

        assertEquals(true, login.isValidLibraryNumber("131-1441"));
    }

    @Test
    public void shouldCheckForTheValidityForAImproperlyFormattedLibraryNumber() {
        ConsoleView consoleView = new ConsoleView();
        Authenticator authenticator = new Authenticator();
        Login login = new Login(authenticator, consoleView);

        assertEquals(false, login.isValidLibraryNumber("1311-441"));
    }

    @Test
    public void shouldCallAuthenticatorWhenALibraryNumberIsValid() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String input1 = "111-1111";
        ByteArrayInputStream inContent1 = new ByteArrayInputStream(input1.getBytes());
        System.setIn(inContent1);
        String input2 = "abcd";
        ByteArrayInputStream inContent2 = new ByteArrayInputStream(input2.getBytes());
        System.setIn(inContent2);

        ConsoleView consoleView = new ConsoleView();
        Authenticator authenticator = new Authenticator();
        Login login = new Login(authenticator, consoleView);
        login.isValidLibraryNumber(input1);
        authenticator.checkCredentials(input1, input2);

        assertEquals("Login Successful\n", outContent.toString());
    }
}