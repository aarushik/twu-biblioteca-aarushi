package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by akansal on 16/08/2016.
 */
public class CredentialTest {

    Credential creds;
    Library library;

    @Before
    public void setUp() {
        library = TestHelper.populateLibrary();
        creds = new Credential(library);
    }

    @Test
    public void itShouldReturnFalseWhenInvalidCredentials() {
        assertEquals(false,creds.authenticate("111-1113", "password"));
    }

    @Test
    public void itShouldReturnTrueWhenValidCredentials() {
        assertEquals(true, creds.authenticate("111-1111", "password"));
    }


}
