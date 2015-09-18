package com.tw.biblioteca;

import java.util.ArrayList;

//Library has a list of books and does operations:Check out and Returning Book
public class Library {

    private ArrayList<Book> books = new ArrayList<Book>();
    private ArrayList<Book> checkedOutBooks = new ArrayList<Book>();
    private ArrayList<Movie> movies = new ArrayList<Movie>();
    private final String UNKNOWN_AUTHOR = null;
    private final int UNKNOWN_PUBLISHED_YEAR = 0;
    private final int UNKNOWN_YEAR_OF_RELEASE = 0;
    private final String UNKNOWN_DIRECTOR = null;
    private final String UNRATED = null;

    private ConfigMessages configMessages = new ConfigMessages();

    public Library() {
        books.add(new Book("Harry Potter", "J.K.Rowling", 2000));
        books.add(new Book("Diary of a Young Girl", "Anne frank", 1942));

        movies.add(new Movie("Roja", 1995, "ManiRatnam", "9"));
        movies.add(new Movie("ABCD", 2015, "XYZ", "7"));
    }

    public ArrayList books() {
        return books;
    }

    public void checkOutBook(String userChoice, User user) {
        Book userChoiceBook = new Book(userChoice, UNKNOWN_AUTHOR, UNKNOWN_PUBLISHED_YEAR);
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

    public Book returnBook(String bookChoice, User user) {
        Book userChoiceBook = new Book(bookChoice, UNKNOWN_AUTHOR, UNKNOWN_PUBLISHED_YEAR);
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
        }
        return userChoiceBook;
    }

    public void checkInBook(Book book) {
        if (checkedOutBooks.contains(book) && books.contains(book))
            checkedOutBooks.remove(book);
    }

    public ArrayList movies() {
        return movies;
    }

    public void checkOutMovie(String movieChoice) {
        Movie userChoiceMovie = new Movie(movieChoice, UNKNOWN_YEAR_OF_RELEASE, UNKNOWN_DIRECTOR, UNRATED);
        if (movies.contains(userChoiceMovie)) {
            for (Movie movie : movies) {
                if (movie.equals(userChoiceMovie)) {
                    movies.remove(movie);
                    configMessages.displayMessage(configMessages.movieCheckOutMessage);
                }
            }

        }
    }
}
