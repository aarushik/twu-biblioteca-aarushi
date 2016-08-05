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
    Movie movie1;
    Movie movie2;

    @Before
    public void setUp() {
        book1 = new Book("Aarushi", 2016, "Intro to Java", true);
        book2 = new Book("Aarushi", 2014, "Intro to Ruby", true);
        book3 = new Book("Aarushi", 2013, "Intro to R", false);
        movie1 = new Movie("Harry Potter", "David Yates", 2009, 10, true);
        movie2 = new Movie("Suicide Squad", "John", 2016, 10, false);
        ArrayList<Article> articles = new ArrayList<Article>();
        articles.add(book1);
        articles.add(book2);
        articles.add(book3);
        articles.add(movie1);
        articles.add(movie2);

        library = new Library(articles);
    }

    @Test
    public void testBookCheckout() {
        library.checkoutArticle("Intro to Java"); //removing book 1
        assertEquals(false,book1.getAvailability());
    }

    @Test
    public void testBookReturn() {
        library.returnArticle("Intro to R");
        assertEquals(true, book3.getAvailability());
    }

    @Test
    public void testMovieCheckout() {
        library.checkoutArticle("Harry Potter");
        assertEquals(false, movie1.getAvailability());

    }

    @Test
    public void testMovieReturn() {
        library.returnArticle("Suicide Squad");
        assertEquals(true, movie2.getAvailability());
    }


}
