package com.twu.biblioteca;

/**
 * Created by Aarushi on 2/08/2016.
 */
public class Book extends Article {

    private int year;
    private String title;
    private Boolean available;

    public Book(String creator, int year, String title, Boolean available) {
        super(title, creator, available, year);
    }

}
