package com.tw.biblioteca;

import java.util.ArrayList;

public class MenuFactory {

    public ArrayList getMenu(User.Role role) {
        ArrayList<String> optionsList = new ArrayList<String>();
        if (role.equals(User.Role.USER)) {
            optionsList.add("1:List Books");
            optionsList.add("2:Check Out Book");
            optionsList.add("3:Return Book");
            optionsList.add("4:List Movies");
            optionsList.add("5:Check Out Movie");
            optionsList.add("7:User Details");
            optionsList.add("8:Logout");
            return optionsList;
        } else if (role.equals(User.Role.LIBRARIAN)) {
            optionsList.add("1:List Books");
            optionsList.add("2:Check Out Book");
            optionsList.add("3:Return Book");
            optionsList.add("4:List Movies");
            optionsList.add("5:Check Out Movie");
            optionsList.add("7:User Details");
            optionsList.add("8:Logout");
            optionsList.add("9:Checked Out Book Details");
            return optionsList;
        } else {
            optionsList.add("1:List Books");
            optionsList.add("4:List Movies");
            optionsList.add("5:Check Out Movie");
            optionsList.add("6:Login");
            optionsList.add("q:QUIT");
            return optionsList;
        }
    }
}
