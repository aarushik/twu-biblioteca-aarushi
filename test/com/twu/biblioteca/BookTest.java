package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Aarushi on 2/08/2016.
 */
public class BookTest {

    Book book;

    @Before
    public void setUp() {
        book = new Book("Aarushi", 2016);
    }

    @Test
    public void testGetAuthor() {
        assertEquals("Aarushi", book.getAuthor());
    }

    @Test
    public void testGetYear() {
        assertEquals(2016, book.getYear());
    }
}
