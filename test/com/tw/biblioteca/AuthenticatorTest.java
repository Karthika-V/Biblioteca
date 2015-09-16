package com.tw.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class AuthenticatorTest {

    @Test
    public void shouldHaveANonEmptyUserDataForAuthentication() {
        Authenticator authenticator = new Authenticator();
        authenticator.userData();

        assertEquals(true, !authenticator.userData().isEmpty());
    }

}