package com.tw.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

//ConsoleView manages the console output and input
public class ConsoleView {

    private Scanner in = new Scanner(System.in);

    public void display(String message) {
        System.out.println(message);
    }

    public String inputFromUser() {
        return in.nextLine();
    }

    private void list(String[] columns) {
        String divider = "\n--------------------------------------------------------------------------------\n";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(divider);
        for (int i = 0; i < columns.length; i++)
            stringBuilder.append(String.format("%-23s", columns[i]));
        stringBuilder.append(divider);
        System.out.println(stringBuilder.toString());
    }

    public void menu(ArrayList menuOptions) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hi User!!!\nYou have the following Options:\nChoose One\n");
        for (int i = 0; i < menuOptions.size(); i++) {
            stringBuilder.append(menuOptions.get(i) + "\n");
        }
        System.out.println(stringBuilder.toString());
    }

    public void bookList(ArrayList<Book> books) {
        display("List Of Books:");
        String[] columns = new String[]{"Title", "Author", "Published year"};
        list(columns);
        StringBuilder stringBuilder = new StringBuilder();
        for (Book book : books) {
            stringBuilder.append(book.toString());
            stringBuilder.append("\n");
        }
        display(stringBuilder.toString());
    }

    public void moviesList(ArrayList<Movie> movies) {
        display("List of Movies:");
        String[] columns = new String[]{"Name", "Year of Release", "Director", "Rating"};
        list(columns);
        StringBuilder stringBuilder = new StringBuilder();
        for (Movie movie : movies) {
            stringBuilder.append(movie.toString());
            stringBuilder.append("\n");
        }
        display(stringBuilder.toString());
    }
}
