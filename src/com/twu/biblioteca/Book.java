package com.twu.biblioteca;

/**
 * Created by Aarushi on 2/08/2016.
 */
public class Book {

    private String author;
    private int year;

    public Book(String author, int year) {
        this.author = author;
        this.year = year;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

}
