package com.tw.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

//ConsoleView manages the console output and input
public class ConsoleView {

    private String message;
    private Scanner in = new Scanner(System.in);

    public void display(String message) {
        System.out.println(message);
    }

    public String inputFromUser() {
        String input = in.nextLine();
        return input;
    }

    private void listView(String[] columns) {
        String divider = "\n--------------------------------------------------------------------------------\n";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(divider);
        for (int i = 0; i < columns.length; i++)
            stringBuilder.append(String.format("%-23s", columns[i]));
        stringBuilder.append(divider);
        System.out.println(stringBuilder.toString());
    }

    public void menuView() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hi User!!!\nYou have the following Options:\nChoose One\n");
        MenuOptions menuOptions = new MenuOptions();
        stringBuilder.append(menuOptions.toString());
        System.out.println(stringBuilder.toString());
    }

    public void bookListView(ArrayList<Book> books) {
        display("List Of Books:");
        String[] columns = new String[]{"Title", "Author", "Published year"};
        listView(columns);
        StringBuilder stringBuilder = new StringBuilder();
        for (Book book : books) {
            stringBuilder.append(book.toString());
            stringBuilder.append("\n");
        }
        display(stringBuilder.toString());
    }
}
