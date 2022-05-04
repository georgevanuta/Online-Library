package com.company;

import java.io.File;
import java.util.ArrayList;

public class Country {
    private int ID;
    private String countryCode;
    private static ArrayList<Country> allCountries;

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public int getID() {
        return this.ID;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public void initCountries(File countriesFile) {
        FileToList ftl = new FileToList();
        allCountries = ftl.readCountriesFromFile(countriesFile);
    }

    public ArrayList<Country> getAllCountries() {
        return allCountries;
    }
}
