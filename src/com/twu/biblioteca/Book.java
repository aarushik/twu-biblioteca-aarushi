package com.twu.biblioteca;

/**
 * Created by Aarushi on 2/08/2016.
 */
public class Book {

    private String author;
    private int year;
    private String title;

    public Book(String author, int year, String title) {
        this.author = author;
        this.year = year;
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setYear(int year) {
        if (year <= 0) {
            throw new IllegalArgumentException("Year has to be bigger than 0");
        } else {
            this.year = year;
        }
    }

    public int getYear() {
        return year;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
