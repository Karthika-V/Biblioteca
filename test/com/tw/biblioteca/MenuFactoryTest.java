package com.tw.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MenuFactoryTest {

    @Test
    public void shouldReturnGuestMenuItemWhenUserIsGuest() {
        MenuFactory menuFactory = new MenuFactory();
        ArrayList<String> optionsList = new ArrayList<String>();
        optionsList.add("1:List Books");
        optionsList.add("4:List Movies");
        optionsList.add("5:Check Out Movie");
        optionsList.add("6:Login");
        optionsList.add("q:QUIT");

        assertEquals(optionsList.toString(), menuFactory.getMenu(User.Role.GUEST).toString());
    }

    @Test
    public void shouldReturnUserMenuWhenUserIsUser() {
        MenuFactory menuFactory = new MenuFactory();
        ArrayList<String> optionsList = new ArrayList<String>();
        optionsList.add("1:List Books");
        optionsList.add("2:Check Out Book");
        optionsList.add("3:Return Book");
        optionsList.add("4:List Movies");
        optionsList.add("5:Check Out Movie");
        optionsList.add("7:User Details");
        optionsList.add("8:Logout");

        assertEquals(optionsList.toString(), menuFactory.getMenu(User.Role.USER).toString());
    }

    @Test
    public void shouldReturnLibrarianMenuWhenUserIsLibrarian() {
        MenuFactory menuFactory = new MenuFactory();
        ArrayList<String> optionsList = new ArrayList<String>();
        optionsList.add("1:List Books");
        optionsList.add("2:Check Out Book");
        optionsList.add("3:Return Book");
        optionsList.add("4:List Movies");
        optionsList.add("5:Check Out Movie");
        optionsList.add("7:User Details");
        optionsList.add("8:Logout");
        optionsList.add("9:Checked Out Book Details");

        assertEquals(optionsList.toString(), menuFactory.getMenu(User.Role.LIBRARIAN).toString());

    }

}