package com.tw.biblioteca;

import java.util.ArrayList;

//Menu gives a list of options to the user and handles the option
public class MenuOptions {

    private ArrayList<String> optionsList;

    public MenuOptions() {
        optionsList = new ArrayList<String>();
        optionsList.add("1:List Books");
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < optionsList.size(); i++) {
            stringBuilder.append(optionsList.get(i) + "\n");
        }
        return stringBuilder.toString();
    }
}
