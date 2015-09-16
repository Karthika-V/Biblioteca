package com.tw.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class UsersTest {

    @Test
    public void shouldHaveUserDetails() {
        Users user = new Users("Abc", "Def@xyz.com", "100");

        assertEquals(true, !(user.toString().isEmpty()));
    }

    @Test
    public void shouldNotBeNull() {
        Users user = new Users("Abc", "Def@xyz.com", "100");

        assertNotEquals(user, null);
    }

    @Test
    public void shouldBeEqualToItself() {
        Users user = new Users("Abc", "Def@xyz.com", "100");

        assertEquals(user, user);
    }

    @Test
    public void shouldBeEqualToOtherInstanceOfSameClass() {
        Users user1 = new Users("Abc", "Def@xyz.com", "100");
        Users user2 = new Users("Abc", "Def@xyz.com", "100");

        assertEquals(user1, user2);
    }

    @Test
    public void shouldNotBeEqualToAnotherType() {
        Users user = new Users("Abc", "Def@xyz.com", "100");

        assertNotEquals(user, "some string");
    }

    @Test
    public void shouldHaveSameHashCodeForSameUserName() {
        Users user1 = new Users("Abc", "Def@xyz.com", "100");
        Users user2 = new Users("Abc", "xyz@xyz.com", "000");

        assertEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    public void shouldHaveDifferentHashCodeForDifferentUserName() {
        Users user1 = new Users("Abc", "Def@xyz.com", "100");
        Users user2 = new Users("def", "xyz@xyz.com", "000");

        assertNotEquals(user1.hashCode(), user2.hashCode());
    }

}