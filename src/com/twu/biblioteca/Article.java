package com.twu.biblioteca;

/**
 * Created by Aarushi on 5/08/2016.
 */
public class Article {

    private String title;
    private String creator;
    private Boolean availabilty;
    private int year;

    public Article(String title, String creator, Boolean availabilty, int year) {
        this.title = title;
        this.creator = creator;
        this.availabilty = availabilty;
        this.year = year;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreator() {
        return creator;
    }

    public void setAvailability(Boolean availabilty) {
        this.availabilty = availabilty;
    }

    public Boolean getAvailability() {
        return availabilty;
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


}
