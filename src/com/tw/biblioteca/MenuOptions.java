package com.tw.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

//Menu gives a list of options to the user and handles the option
public class MenuOptions {

    private ArrayList<String> optionsList;
    private Library library = new Library();
    private ConsoleView consoleView = new ConsoleView();
    private Scanner in = new Scanner(System.in);

    public MenuOptions() {
        optionsList = new ArrayList<String>();
        optionsList.add("1:List Books");
        optionsList.add("2:Check Out Book");
        optionsList.add("3:Return Book");
        optionsList.add("4:List Movies");
        optionsList.add("q:QUIT");
    }

    public void optionHandler(String option) {
        if (option.contentEquals("1")) {
            consoleView.bookListView(library.books);
        }else if (option.contentEquals("q")) {
            System.exit(0);
        }else if (option.contentEquals("2")) {
            consoleView.display("Enter the book name:");
            library.checkOutBook(in.nextLine());
        }else if (option.contentEquals("3")) {
            consoleView.display("Enter the book name:");
            library.checkInBook(library.returnBook(in.nextLine()));
        }
        else
            System.out.println("Select a valid option!");

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
