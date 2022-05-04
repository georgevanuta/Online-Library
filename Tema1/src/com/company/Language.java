package com.company;

import java.util.ArrayList;
import java.io.File;

public class Language {
    private int ID;
    private String code;
    private String name;
    private static ArrayList<Language> allLanguages;

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return this.ID;
    }

    public String getName() {
        return this.name;
    }

    public void initLanguages(File languagesFile) {
        FileToList ftl = new FileToList();
        allLanguages = ftl.readLanguagesFromFile(languagesFile);
    }

    public ArrayList<Language> getAllLanguages() {
        return allLanguages;
    }
}
