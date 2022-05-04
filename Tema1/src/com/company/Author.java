package com.company;

import java.util.ArrayList;
import java.io.File;

public class Author {
    private int ID;
    private String firstName;
    private String lastName;
    private static ArrayList<Author> allAuthors;

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getID() {
        return this.ID;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void initAuthors(File authorsFile) {
        FileToList ftl = new FileToList();
        allAuthors = ftl.readAuthorFromFile(authorsFile);
    }

    public ArrayList<Author> getAllAuthors() {
        return allAuthors;
    }
}
