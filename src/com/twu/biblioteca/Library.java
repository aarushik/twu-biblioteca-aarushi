package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by Aarushi on 2/08/2016.
 */
public class Library {

    private ArrayList<Book> books = new ArrayList<Book>();

    public Library(ArrayList<Book> books) {
        this.books = books;
    }

    public void listBooks() {
        String titleTemp = "%-10s %6s %6s%n";

        System.out.printf(titleTemp, "Title", "Author",  "Year");
        for (Book book : books) {
            if (book.getAvailability()) { //print only available books
                System.out.println(book.getTitle() + " " + book.getAuthor() + " " + book.getYear());
            }
        }
    }

    public void checkout(String bookName) {
        boolean bookFound = false;
        for (Book book : books) {
            if (book.getTitle().matches(bookName) && book.getAvailability()) {
                book.setAvailability(false);
                bookFound = true;
                System.out.println("Thank you! Enjoy the book");
            }
        }

        if(!bookFound) {
            System.out.println("That book is not available");
        }
    }

    public void returnBook(String bookName) {
        boolean bookFound = false;
        for (Book book : books) {
            if (book.getTitle().matches(bookName) && !book.getAvailability()) { //print only available books
                book.setAvailability(true);
                bookFound = true;
                System.out.println("Thank you for returning the book");
            }
        }

        if (!bookFound) {
            System.out.println("That is not a valid book to return");
        }
    }




}
