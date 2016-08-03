package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by Aarushi on 3/08/2016.
 */
public class LibraryTest {

    Library library;
    Book book1;
    Book book2;
    Book book3;

    @Before
    public void setUp() {
        book1 = new Book("Aarushi", 2016, "Intro to Java", true);
        book2 = new Book("Aarushi", 2014, "Intro to Ruby", true);
        book3 = new Book("Aarushi", 2013, "Intro to R", true);
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        library = new Library(books);
    }

    @Test
    public void testCheckOut() {
        library.checkout("Intro to Java"); //removing book 1
        assertEquals(false,book1.getAvailability());
    }

    @Test
    public void testReturnBook() {
        library.returnBook("Intro to Java"); //returning book 1
        assertEquals(true, book1.getAvailability());
    }


}
