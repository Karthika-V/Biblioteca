package com.tw.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void shouldHaveUserDetails() {
        User user = new User("111-1111", "abcd", "Abc", "Def@xyz.com", "100", User.Role.USER);

        assertEquals(true, !(user.toString().isEmpty()));
    }

    @Test
    public void shouldNotBeNull() {
        User user = new User("111-1111", "abcd", "Abc", "Def@xyz.com", "100", User.Role.USER);

        assertNotEquals(user, null);
    }

    @Test
    public void shouldBeEqualToItself() {
        User user = new User("111-1111", "abcd", "Abc", "Def@xyz.com", "100", User.Role.USER);

        assertEquals(user, user);
    }

    @Test
    public void shouldBeEqualToOtherInstanceOfSameClass() {
        User user1 = new User("111-1111", "abcd", "Abc", "Def@xyz.com", "100", User.Role.USER);
        User user2 = new User("111-1111", "abcd", "Abc", "Def@xyz.com", "100", User.Role.USER);
        assertEquals(user1, user2);
    }

    @Test
    public void shouldNotBeEqualToAnotherType() {
        User user = new User("111-1111", "abcd", "Abc", "Def@xyz.com", "100", User.Role.USER);

        assertNotEquals(user, "some string");
    }

    @Test
    public void shouldHaveSameHashCodeForSameUserName() {
        User user1 = new User("111-1111", "abcd", "Abc", "Def@xyz.com", "100", User.Role.USER);
        User user2 = new User("111-1111", "abcd", "Abc", "Def@xyz.com", "100", User.Role.USER);

        assertEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    public void shouldHaveDifferentHashCodeForDifferentUserName() {
        User user1 = new User("111-1111", "abcd", "Abc", "Def@xyz.com", "100", User.Role.USER);
        User user2 = new User("222-2222", "abcd", "Def", "Def@xyz.com", "100", User.Role.USER);

        assertNotEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    public void shouldDisplayUserDetails() {
        User user = new User("111-1111", "abcd", "Abc", "Def@xyz.com", "100", User.Role.USER);

        assertEquals("Library Number:111-1111\n" +
                " User Name:Abc\n" +
                " User Mail:Def@xyz.com\n" +
                " Phone Number:100\n" +
                " Role:USER\n", user.displayUserDetails());
    }

}