package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Ignore;
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

        populateLibrary();


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
        library.checkoutArticle("Intro to Java");
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
        library.checkoutArticle("Harry Potter");
        library.returnArticle("Harry Potter");
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

    @Test
    public void itShouldReturnUserIfExists() {
        User retrivedUser = library.getUser("111-1111");
        assertEquals("111-1111", retrivedUser.getLibraryNumber());
        assertEquals("Aarushi Kansal", retrivedUser.getName());

    }

    @Test
    public void itShouldReturnNullIfUserDoesNotExist() {
        assertEquals(null, library.getUser("invalidID"));
    }

    private void populateLibrary() {
        ArrayList<Article> articles = new ArrayList<Article>();
        ArrayList<User> users = new ArrayList<User>();

        Book javaBook = new Book("Aarushi", 2016, "Intro to Java", true);

        Movie movie1 = new Movie("Harry Potter", "David Yates", 2009, 10, true);

        User user = new User("111-1111", "password", "Aarushi Kansal", false, "user@email.com", "0430512710");
        users.add(user);

        articles.add(javaBook);
        articles.add(movie1);

        library = new Library(articles, users);


    }

}
