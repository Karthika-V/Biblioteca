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

}
