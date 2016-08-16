package com.twu.biblioteca;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Aarushi on 2/08/2016.
 */
public class Library {

    private static ArrayList<Article> articles = new ArrayList<Article>();
    private static ArrayList<User> users = new ArrayList<User>();
    private String currentUserId;
    private String currentUserPassword;
    private Boolean loggedIn = false;
    private User loggedInUser;


    public Library() {
        populateLibrary();
    }

    public void listBooks() {
        String titleTemp = "%-30s %30s %39s%n";
        String contentTemp = "%-30s %30s %39s%n";

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
        if (loggedIn) {
            boolean articleFound = false;
            for (Article article : articles) {
                if (article.getTitle().matches(bookName) && article.getAvailability()) {
                    article.setAvailability(false);
                    articleFound = true;
                    System.out.println("Thank you! Enjoy the article");
                    return;
                }
            }

            if(!articleFound) {
                System.out.println("That article is not available");
            }
        } else {
            authenticate();
            checkoutArticle(bookName);
        }
    }

    public void returnArticle(String bookName) {
        if (loggedIn) {
            boolean articleFound = false;
            for (Article article : articles) {
                if (article.getTitle().matches(bookName) && !article.getAvailability()) {
                    article.setAvailability(true);
                    articleFound = true;
                    System.out.println("Thank you for returning that article");
                    return;
                }
            }

            if (!articleFound) {
                System.out.println("That is not a valid article to return");
            }
        } else {
            authenticate();
            returnArticle(bookName);
        }

    }

    public void printUserDetails() {
        if(loggedIn) {
            for (User user: users) {
                if(user.getLoggedIn() && user.getLibraryNumber().equals(currentUserId) && user.getPassword().equals(currentUserPassword)) {
                    System.out.println(user.printDetails());
                }
            }
        }
    }

    public Boolean getLoggedIn() {
        return loggedIn;
    }

    private void printLoginPrompt() {
        System.out.println("Enter User Id:");
        currentUserId = getString();
        System.out.println("Enter Password");
        currentUserPassword = getString();
    }

    private String getString() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String userInput = "";
        try {
            userInput = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userInput;
    }

    private void authenticate() {

        printLoginPrompt();
        for (User user : users) {
            if ((user.getLibraryNumber().equals(currentUserId)) && (user.getPassword().equals(currentUserPassword))) {
                user.setLoggedIn(true);
                loggedIn = true;
                return;
            } else { //logging out any previous user
                user.setLoggedIn(false);
            }
        }
        if (!loggedIn) { //couldn't find a user
            System.out.println("Error in credentials\n");
        }
    }

    private void populateLibrary() {

        Book javaBook = new Book("Aarushi", 2016, "Intro to Java", true);
        Book rubyBook = new Book("Aarushi", 2015, "Intro to Ruby", true);
        Book rBook = new Book("Aarushi", 2013, "Intro to R", true);
        Book CssBook = new Book("Aarushi",2014, "Intro to CSS", true);
        Movie movie1 = new Movie("Harry Potter", "David Yates", 2009, 10, true);
        Movie movie2 = new Movie("Suicide Squad", "John", 2016, 10, false);
        articles.add(javaBook);
        articles.add(rubyBook);
        articles.add(rBook);
        articles.add(CssBook);
        articles.add(movie1);
        articles.add(movie2);


        User user1 = new User("111-1111", "password", "user1", false, "user1@email.com", "0430512710");
        User user2 = new User("222-2222", "password", "user2", false, "user2@email.com", "0430512711");
        users.add(user1);
        users.add(user2);
    }


}
