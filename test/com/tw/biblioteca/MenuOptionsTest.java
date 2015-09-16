package com.tw.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuOptionsTest {

    @Test
    public void shouldListOutMenuForUser() {
        MenuOptions menuOptions = new MenuOptions();
        menuOptions.toString();
        assertEquals("1:List Books\n", menuOptions.toString());
    }
}