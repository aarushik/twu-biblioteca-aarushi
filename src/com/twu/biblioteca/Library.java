package com.twu.biblioteca;



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


    public Library(ArrayList<Article> articles, ArrayList<User> users) {
        this.articles = articles;
        this.users = users;
        //populateLibrary();
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
            throw new RuntimeException("You must be logged in to do this");
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
            throw new RuntimeException("You must be logged in to do this");
        }

    }

    public void printUserDetails() {
        if(loggedIn) {
            for (User user: users) {
                if(user.getLoggedIn() && user.getLibraryNumber().equals(currentUserId) && user.getPassword().equals(currentUserPassword)) {
                    System.out.println(user.printDetails());
                }
            }
        } else {
            throw new RuntimeException("You must be logged in to do this");
        }
    }

    public Boolean getLoggedIn() {
        return loggedIn;
    }

    public User getUser(String libraryId) {
        for (User user : users) {
            if (user.getLibraryNumber().equals(libraryId)) {
                return user;
            }
        }
        return null;
    }

    public void setLoggedIn(Boolean loggedIn) {
        this.loggedIn = loggedIn;
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


}
