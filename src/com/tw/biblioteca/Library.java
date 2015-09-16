package com.tw.biblioteca;

import java.util.ArrayList;

//Library has a list of books and does operations:Check out and Returning Book
public class Library {

    public ArrayList<Book> books = new ArrayList<Book>();
    public ArrayList<Book> checkedOutBooks = new ArrayList<Book>();
    private ConfigMessages configMessages = new ConfigMessages();

    public Library() {
        books.add(new Book("Harry Potter", "J.K.Rowling", 2000));
        books.add(new Book("Diary of a Young Girl", "Anne frank", 1942));
    }

    public void displayLibraryBooks() {
        System.out.println(books.toString());
    }

    public void checkOutBook(String userChoice) {
        Book userChoiceBook = new Book(userChoice, null, 0);
        if (!books.contains(userChoiceBook)) {
            configMessages.displayMessage(configMessages.bookNonAvailabilityMessage);
        } else {
            for (Book book : books) {
                if (book.equals(userChoiceBook)) {
                    books.remove(book);
                    checkedOutBooks.add(book);
                    configMessages.displayMessage(configMessages.bookCheckOutMessage);
                }
            }
        }
    }

    public Book returnBook(String bookChoice) {
        Book userChoiceBook = new Book(bookChoice, null, 0);
        if (checkedOutBooks.contains(userChoiceBook)) {
            for (Book book : checkedOutBooks) {
                if (book.equals(userChoiceBook)) {
                    books.add(book);
                    configMessages.displayMessage(configMessages.bookReturnMessage);
                    return book;
                }
            }
        } else {
            configMessages.displayMessage(configMessages.invalidBookMessage);
        }return userChoiceBook;
    }

    public void checkInBook(Book book) {
        if (checkedOutBooks.contains(book) && books.contains(book))
            checkedOutBooks.remove(book);
    }
}
