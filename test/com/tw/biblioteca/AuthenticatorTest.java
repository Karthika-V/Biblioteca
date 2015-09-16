package com.tw.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class AuthenticatorTest {

    @Test
    public void shouldHaveANonEmptyUserDataForAuthentication() {
        Authenticator authenticator = new Authenticator();
        authenticator.userData();

        assertEquals(true, !authenticator.userData().isEmpty());
    }

    @Test
    public void shouldAuthenticateTheCredentialsFromUser() {
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

        assertEquals("Login Successful\n", outContent.toString());
    }
}