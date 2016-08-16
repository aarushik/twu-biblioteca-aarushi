package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BibliotecaApp {


    public static void main(String[] args) {
        int userChoice = -1;

        Library library = populateLibrary();
        welcomeMenu();

        while (userChoice != -2) {
            if(library.getLoggedIn()) {
                printLoggedInMenu();
            }else {
                printMenu();
            }
            userChoice = getInteger();

            if(userChoice == 1) {
                library.listBooks();
            } else if(userChoice == 2) {
                library.listMovies();
            } else if(userChoice == 3) {
                System.out.println("Enter book name");
                library.checkoutArticle(getBookName());
            } else if (userChoice == 4) {
                System.out.println("Enter book name");
                library.returnArticle(getBookName());
            } else if (userChoice == 5 ) {

                if(library.getLoggedIn()) {
                    library.printUserDetails();
                } else {
                  System.exit(0);
                }

            } else if (userChoice == 6) {
                if (library.getLoggedIn()) {
                    System.exit(0);
                } else {
                    System.out.println("Enter a valid option");
                }

            } else {
                System.out.println("Enter a valid option");
            }
        }
    }

    private static Library populateLibrary() {
        ArrayList<Article> articles = new ArrayList<Article>();
        ArrayList<User> users = new ArrayList<User>();

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

        Library library = new Library(articles, users);
        return library;
    }

    private static void populateMovies() {
        Movie movie1 = new Movie("Harry Potter", "David Yates", 2009, 10, true);
        Movie movie2 = new Movie("Suicide Squad", "John", 2016, 10, true);
//
//        movies.add(movie1);
//        movies.add(movie2);
    }

    private static void welcomeMenu() {
        System.out.println("Welcome to Biblioteca!");
    }

    private static void printMenu() {
        System.out.println("Please choose one of the following options: \n 1: List Books \n 2: List Movies" +
                " \n 3: Checkout" +
                "\n 4: Return \n 5: Exit");
    }

    private static void printLoggedInMenu() {
        System.out.println("Please choose one of the following options: \n 1: List Books \n 2: List Movies" +
                " \n 3: Checkout" +
                "\n 4: Return \n 5:User information \n 6:Exit");
    }

    private static int getInteger() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int userInt = 0;
        try {
            userInt =Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userInt;
    }

    private static String getBookName() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String bookName = "";
        try {
            bookName = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bookName;
    }
}
