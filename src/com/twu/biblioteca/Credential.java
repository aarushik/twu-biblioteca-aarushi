package com.twu.biblioteca;

import javax.security.auth.login.CredentialNotFoundException;
import java.util.ArrayList;

/**
 * Created by akansal on 16/08/2016.
 */
public class Credential {

    private Library library;


    public Credential(Library library) {
        this.library = library;

    }

    public Boolean authenticate(String libraryId, String password) {
        Boolean authenticated = false;

        User user = library.getUser(libraryId);

        if(user != null && user.getPassword().equals(password)) {
            authenticated = true;
        }

        return authenticated;
    }



}
