package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BibliotecaApp {
    static ArrayList<Article> articles = new ArrayList<Article>();

    public static void main(String[] args) {
        int userChoice = -1;
        populateLibrary();
        Library library = new Library(articles);
        welcomeMenu();

        while (userChoice != 0) {
            printMenu();
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
            } else if (userChoice == 5) {
                System.exit(0);
            } else {
                System.out.println("Enter a valid option");
            }
        }
    }

    private static void populateLibrary() {
        Book javaBook = new Book("Aarushi", 2016, "Intro to Java", true);
        Book rubyBook = new Book("Aarushi", 2015, "Intro to Ruby", true);
        Book rBook = new Book("Aarushi", 2013, "Intro to R", true);
        Book CssBook = new Book("Aarushi",2014, "Intro to CSS", true);
        Movie movie1 = new Movie("Harry Potter", "David Yates", 2009, 10, true);
        Movie movie2 = new Movie("Suicide Squad", "John", 2016, 10, true);
        articles.add(javaBook);
        articles.add(rubyBook);
        articles.add(rBook);
        articles.add(CssBook);
        articles.add(movie1);
        articles.add(movie2);
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
