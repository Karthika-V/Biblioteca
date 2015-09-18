package com.tw.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class SessionTest {

    @Test
    public void shouldRetrunTheUserObjectWhenGetUserIsCalled() {
        User user = new User("111-1111","abcd", "Abc", "Def@xyz.com", "100", User.Role.USER);
        Session session = new Session(user);

        assertEquals(user, session.getUser());
    }

}