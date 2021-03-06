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
        return (String.format("\n%-23s %-23s %-23s", this.bookTitle, this.bookAuthor, this.publishedYear));
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;
        Book book = (Book) that;
        return bookTitle.equals(book.bookTitle);
    }

    @Override
    public int hashCode() {
        return bookTitle.hashCode();
    }
}
