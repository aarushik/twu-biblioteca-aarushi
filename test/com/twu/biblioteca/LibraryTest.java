package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by Aarushi on 3/08/2016.
 */
public class LibraryTest {

    Library library;
    Book book1;
    Book book2;

    Movie movie1;
    Movie movie2;
    User user;

    private PrintStream console;
    private ByteArrayOutputStream outputStream;

    @Before
    public void setUp() {

        book1 = mock(Book.class);
        user = mock(User.class);

        //Mock book details
        when(book1.getTitle()).thenReturn("Intro to Java");

        //Mock user credentials
        when(user.getLibraryNumber()).thenReturn("111-1111");
        when(user.getPassword()).thenReturn("password");

        library = new Library();

        console = System.out;
        outputStream = new ByteArrayOutputStream();



    }

    @Test
    public void testBookCheckout() {
        System.setOut(new PrintStream(outputStream));
        library.checkoutArticle("Intro to Java"); //removing book 1
        assertEquals(true,outputStream.toString().contains("Enjoy the article"));
    }

    @Test
    public void testBookReturn() {
        System.setOut(new PrintStream(outputStream));
        library.returnArticle("Intro to Java");
        assertEquals(true,outputStream.toString().contains("returning that article"));
    }

    @Test
    public void testMovieCheckout() {
        System.setOut(new PrintStream(outputStream));
        library.checkoutArticle("Harry Potter");
        assertEquals(true,outputStream.toString().contains("Enjoy the article"));

    }

    @Test
    public void testMovieReturn() {
        System.setOut(new PrintStream(outputStream));
        library.returnArticle("Suicide Squad");
        assertEquals(true,outputStream.toString().contains("returning that article"));
    }

    @Test
    public void testInvalidArticleReturn() {
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        library.returnArticle("Invalid title");
        assertEquals("That is not a valid article to return\n", output.toString());
    }

    @Test
    public void testInvalidArticleCheckout() {
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        library.checkoutArticle("Invalid title");
        assertEquals("That article is not available\n", output.toString());
    }

}
