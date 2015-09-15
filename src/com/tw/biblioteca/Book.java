package com.tw.biblioteca;
//Book has a Title, author name and Published year
public class Book {

    private String bookTitle;
    private String bookAuthor;
    private int publishedYear;

    public Book(String bookTitle, String bookAuthor, int publishedYear) {
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.publishedYear = publishedYear;
    }

    @Override
    public String toString() {
        return (String.format("%-23s %-23s %-23s\n", this.bookTitle, this.bookAuthor, this.publishedYear));
    }
}
