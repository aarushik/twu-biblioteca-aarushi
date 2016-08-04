package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Aarushi on 4/08/2016.
 */
public class MovieTest {
    Movie movie;
    private static final String NAME = "Harry potter";
    private static final String DIRECTOR = "David Yates";
    private static final int YEAR = 2009;
    private static final int RATING = 10;

    @Before
    public void setUp() {
        movie = new Movie(NAME, DIRECTOR, YEAR, RATING);
    }

    @Test
    public void getNameTest() {
        assertEquals(NAME, movie.getName());
    }

    @Test
    public void setNameTest() {
        movie.setName("Deathly Hallows");
        assertEquals("Deathly Hallows", movie.getName());
    }

    @Test
    public void getDirectorTest() {
        assertEquals(DIRECTOR, movie.getDirector());
    }

    @Test
    public void setDirectorTest() {
        movie.setDirector("Chris Columbus");
        assertEquals("Chris Columbus", movie.getDirector());
    }

    @Test
    public void getYearTest() {
        assertEquals(YEAR, movie.getYear());
    }

    @Test
    public void setYearTest() {
        movie.setYear(2000);
        assertEquals(2000, movie.getYear());
    }

    @Test
    public void getRatingTest() {
        assertEquals(RATING,movie.getRating());
    }

    @Test
    public void setRatingTest() {
        movie.setRating(2);
        assertEquals(2, movie.getRating());
    }


}
