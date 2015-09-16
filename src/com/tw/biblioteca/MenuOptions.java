package com.tw.biblioteca;

import java.util.ArrayList;

//Menu gives a list of options to the user and handles the option
public class MenuOptions {

    private ArrayList<String> optionsList;
    private Library library = new Library();
    private ConsoleView consoleView = new ConsoleView();

    public MenuOptions() {
        optionsList = new ArrayList<String>();
        optionsList.add("1:List Books");
    }

    public void optionHandler(String option) {
        if (option.contentEquals("1")) {
            consoleView.bookListView(library.books);
        }
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
