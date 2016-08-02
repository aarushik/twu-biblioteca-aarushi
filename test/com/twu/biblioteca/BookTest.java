package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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

    @Test
    public void testSetAuthor() {
        book.setAuthor("Jessica");
        assertEquals("Jessica", book.getAuthor());
    }

    @Test
    public void testSetYear() {
        book.setYear(2015);
        assertEquals(2015, book.getYear());
    }

    @Test
    public void testSetNegativeYear() {
        try {
            book.setYear(-2);
            fail("Should throw exception");
        } catch(IllegalArgumentException) {

        }
    }
}
