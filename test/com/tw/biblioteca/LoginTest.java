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
    public void shouldCallAuthenticatorWhenALibraryNumberIsInvalid() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String input1 = "111-1111";
        ByteArrayInputStream inContent1 = new ByteArrayInputStream(input1.getBytes());
        System.setIn(inContent1);
        String input2 = "abcd";
        ByteArrayInputStream inContent2 = new ByteArrayInputStream(input2.getBytes());
        System.setIn(inContent2);

        Authenticator authenticator = new Authenticator();
        authenticator.checkCredentials(input1, input2);

        assertEquals("Logging Attempt failed\n", outContent.toString());
    }
}