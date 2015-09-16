package com.tw.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class UsersTest {

    @Test
    public void shouldHaveUserDetails() {
        Users user = new Users("Abc", "Def@xyz.com", "100");

        assertEquals(true, !(user.toString().isEmpty()));
    }

}