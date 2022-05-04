package com.company;

import java.io.File;
import java.util.ArrayList;

public class PublishingRetailer {
    private int ID;
    private String name;
    private ArrayList<IPublishingArtifact> publishingArtifacts = new ArrayList<IPublishingArtifact>();
    private ArrayList<Country> countries = new ArrayList<Country>();
    private static ArrayList<PublishingRetailer> allRetailers;

    public void setID(int ID) {
        this.ID = ID;
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

    public ArrayList<Country> getCountries() {
        return this.countries;
    }

    public ArrayList<IPublishingArtifact> getPublishingArtifacts() {
        return this.publishingArtifacts;
    }

    public void addCountry(Country country) {
        this.countries.add(country);
    }

    public void addPublishingArtifact(IPublishingArtifact publishingArtifact) {
        this.publishingArtifacts.add(publishingArtifact);
    }

    public void initPublishingRetailers(File publishingRetailersFile, File publishingRetailersCountriesFile,
                              File publishingRetailersBooksFile, File publishingRetailersEditorialGroupsFile) {
        FileToList ftl = new FileToList();
        Country country = new Country();
        Book book = new Book();
        EditorialGroup editorialGroup = new EditorialGroup();
        PublishingBrand publishingBrand = new PublishingBrand();

        allRetailers = ftl.readPublishingRetailersFromFile(publishingRetailersFile);
        ftl.assignCountriesToPublishingRetailers(allRetailers, country.getAllCountries(),
                publishingRetailersCountriesFile);
        ftl.assignBooksToPublishingRetailers(allRetailers, book.getAllBooks(),
                publishingRetailersBooksFile);
        ftl.assignEditorialGroupsToPublishingRetailers(allRetailers, editorialGroup.getAllEditorialGroups(),
                publishingRetailersEditorialGroupsFile);
    }

    public ArrayList<PublishingRetailer> getAllPublishingRetailers() {
        return allRetailers;
    }
}
