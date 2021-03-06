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
        book = new Book("Aarushi", 2016, "Intro to Java", true);
    }

    @Test
    public void testGetAuthor() {
        assertEquals("Aarushi", book.getCreator());
    }

    @Test
    public void testGetYear() {
        assertEquals(2016, book.getYear());
    }

    @Test
    public void testSetAuthor() {
        book.setCreator("Jessica");
        assertEquals("Jessica", book.getCreator());
    }

    @Test
    public void testSetYear() {
        book.setYear(2015);
        assertEquals(2015, book.getYear());
    }

    @Test
    public void testGetTitle() {
        assertEquals("Intro to Java", book.getTitle());
    }

    @Test
    public void testSetTitle() {
        book.setTitle("Intro to Ruby");
        assertEquals("Intro to Ruby", book.getTitle());
    }

    @Test
    public void testSetNegativeYear() {
        try {
            book.setYear(-2);
            fail("Should throw exception");
        } catch(IllegalArgumentException e) {

        }
    }
}
