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

}