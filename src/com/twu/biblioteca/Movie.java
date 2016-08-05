package com.twu.biblioteca;

/**
 * Created by Aarushi on 4/08/2016.
 */
public class Movie extends Article {

    private int rating;


    public Movie(String title, String creator, int year, int rating, Boolean availability) {
        super(title,creator,availability,year);
        this.rating = rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }
}
