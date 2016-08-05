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
            if (article.getAvailability()) { //print only available articles
                System.out.printf(contentTemp, article.getTitle(),  article.getCreator(),  article.getYear());
            }
        }
    }

    public void checkoutArticle(String bookName) {
        boolean bookFound = false;
        for (Article article : articles) {
            if (article.getTitle().matches(bookName) && article.getAvailability()) {
                article.setAvailability(false);
                bookFound = true;
                System.out.println("Thank you! Enjoy the article");
            }
        }

        if(!bookFound) {
            System.out.println("That book is not available");
        }
    }

    public void returnArticle(String bookName) {
        boolean bookFound = false;
        for (Article article : articles) {
            if (article.getTitle().matches(bookName) && !article.getAvailability()) {
                article.setAvailability(true);
                bookFound = true;
                System.out.println("Thank you for returning the article");
            }
        }

        if (!bookFound) {
            System.out.println("That is not a valid book to return");
        }
    }




}
