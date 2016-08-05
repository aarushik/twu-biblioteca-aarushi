package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by Aarushi on 2/08/2016.
 */
public class Library {

    private ArrayList<Article> articles = new ArrayList<Article>();

    public Library(ArrayList<Article> articles) {
        this.articles = articles;

    }

    public void listBooks() {
        String titleTemp = "%-10s %12s %9s%n";
        String contentTemp = "%-10s %10s %9s%n";

        System.out.printf(titleTemp, "Title", "Author",  "Year");
        for (Article article : articles) {
            if (article.getAvailability() && (article instanceof Book)) { //print only available books
                System.out.printf(contentTemp, article.getTitle(),  article.getCreator(),  article.getYear());
            }
        }
    }

    public void listMovies() {
        String titleTemp = "%-10s %12s %6s %9s%n";
        String contentTemp = "%-10s %10s %4s %9s%n";

        System.out.printf(titleTemp, "Title", "Director",  "Year", "Rating");
        for (Article article : articles) {
            if (article.getAvailability() && (article instanceof Movie)) { //print only available movies
                System.out.printf(contentTemp, article.getTitle(),  article.getCreator(),  article.getYear(), ((Movie)article).getRating());
            }
        }
    }

    public void checkoutArticle(String bookName) {
        boolean articleFound = false;
        for (Article article : articles) {
            if (article.getTitle().matches(bookName) && article.getAvailability()) {
                article.setAvailability(false);
                articleFound = true;
                System.out.println("Thank you! Enjoy the article");
            }
        }

        if(!articleFound) {
            System.out.println("That article is not available");
        }
    }

    public void returnArticle(String bookName) {
        boolean articleFound = false;
        for (Article article : articles) {
            if (article.getTitle().matches(bookName) && !article.getAvailability()) {
                article.setAvailability(true);
                articleFound = true;
                System.out.println("Thank you for returning the article");
            }
        }

        if (!articleFound) {
            System.out.println("That is not a valid article to return");
        }
    }




}
