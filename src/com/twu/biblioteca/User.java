package com.twu.biblioteca;

/**
 * Created by akansal on 12/08/2016.
 */
public class User {

    private String libraryNumber;
    private String password;
    private String name;
    private Boolean loggedIn;
    private String email;
    private String phoneNum;


    public User(String libraryNumber, String password, String name, Boolean loggedIn, String email, String phoneNum) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.name = name;
        this.loggedIn = loggedIn;
        this.email = email;
        this.phoneNum = phoneNum;
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

    public Boolean getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(Boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public String printDetails() {
        return this.name + "\n" + this.email + "\n" + this.phoneNum;
    }
}
