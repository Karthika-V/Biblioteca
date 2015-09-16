package com.tw.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class MenuOptionsTest {

    @Test
    public void shouldListOutMenuForUser() {
        MenuOptions menuOptions = new MenuOptions();
        menuOptions.toString();
        assertEquals("1:List Books\n2:Checkout Book\n3:Return Book\nq:QUIT\n", menuOptions.toString());
    }

}