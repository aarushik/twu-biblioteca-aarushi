package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by akansal on 16/08/2016.
 */
public class TestHelper {
    static Library library;

    private TestHelper() {

    }

    public static Library populateLibrary() {
        ArrayList<Article> articles = new ArrayList<Article>();
        ArrayList<User> users = new ArrayList<User>();

        Book javaBook = new Book("Aarushi", 2016, "Intro to Java", true);

        Movie movie1 = new Movie("Harry Potter", "David Yates", 2009, 10, true);

        User user = new User("111-1111", "password", "Aarushi Kansal", false, "user@email.com", "0430512710");
        users.add(user);

        articles.add(javaBook);
        articles.add(movie1);


        library = new Library(articles, users);
        library.setLoggedIn(true);

        return library;
    }
}
