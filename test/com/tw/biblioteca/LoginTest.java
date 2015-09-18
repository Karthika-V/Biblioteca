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
        User user = new User("111-1111","abcd", "Abc", "Def@xyz.com", "100", User.Role.USER);
        Session session = new Session(user);
        Login login = new Login(authenticator, consoleView, user, session);
        authenticator.checkCredentials(input1, input2);

        assertEquals("Login Successful\n", outContent.toString());
    }
}