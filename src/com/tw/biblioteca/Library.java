package com.tw.biblioteca;

import java.util.ArrayList;

//Library has a list of books and does operations:Check out and Returning Book
public class Library {

    public ArrayList<Book> books = new ArrayList<Book>();
    private ConsoleView consoleView;

    public Library(ConsoleView consoleView) {
        this.consoleView=consoleView;
        books.add(new Book("Harry Potter", "J.K.Rowling", 2000));
        books.add(new Book("Diary of a Young Girl", "Anne frank", 1942));
    }

    public void displayLibraryBooks() {
        consoleView.display(books.toString());
    }
}
