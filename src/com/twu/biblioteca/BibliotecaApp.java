package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BibliotecaApp {
    static ArrayList<Book> books = new ArrayList<Book>();

    public static void main(String[] args) {
        int userChoice = -1;
        populateBooks();
        Library library = new Library(books);
        welcomeMenu();

        while (userChoice != 0) {
            printMenu();
            userChoice = getInteger();

            if (userChoice == 0) {
                System.exit(0);
            } else if(userChoice == 1) {
                library.listBooks();
            } else if(userChoice == 2) {
                System.out.println("Enter book name");
                library.checkout(getBookName());
            } else if(userChoice == 3) {
                System.out.println("Enter book name");
                library.returnBook(getBookName());
            }
        }






    }

    private static void populateBooks() {
        Book javaBook = new Book("Aarushi", 2016, "Intro to Java", true);
        Book rubyBook = new Book("Aarushi", 2015, "Intro to Ruby", true);
        Book rBook = new Book("Aarushi", 2013, "Intro to R", true);
        Book CssBook = new Book("Aarushi",2014, "Intro to CSS", true);
        books.add(javaBook);
        books.add(rubyBook);
        books.add(rBook);
        books.add(CssBook);
    }

    private static void welcomeMenu() {
        System.out.println("Welcome to Biblioteca!");
    }

    private static void printMenu() {
        System.out.println("Please choose one of the following options: \n 1: List Books \n 2:Checkout book" +
                "\n 3: Return Book");
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
