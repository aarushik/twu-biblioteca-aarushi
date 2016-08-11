package com.twu.biblioteca;

/**
 * Created by akansal on 12/08/2016.
 */
public class User {

    private String libraryNumber;
    private String password;
    private String name;


    public User(String libraryNumber, String password, String name) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.name = name;
    }

    public void setLibraryNumber(String libraryNumber) {
        this.libraryNumber = libraryNumber;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
