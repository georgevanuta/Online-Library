package com.company;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        /* Pentru folosirea functiilor */
        Administration admin = new Administration();

        /* Numele fisierelor */
        File booksFile = new File("init\\books.in");
        File languagesFile = new File("init\\languages.in");
        File authorsFile = new File("init\\authors.in");
        File booksAuthorsFile = new File("init\\books-authors.in");
        File editorialGroupsFile = new File("init\\editorial-groups.in");
        File publishingBrandsFile = new File("init\\publishing-brands.in");
        File editorialGroupsBooksFile = new File("init\\editorial-groups-books.in");
        File publishingBrandsBooksFile = new File("init\\publishing-brands-books.in");
        File publishingRetailersFile = new File("init\\publishing-retailers.in");
        File countriesFile = new File("init\\countries.in");
        File publishingRetailersCountriesFile = new File("init\\publishing-retailers-countries.in");
        File publishingRetailersBooksFile = new File("init\\publishing-retailers-books.in");
        File publishingRetailersEditorialGroupsFile = new File("init\\publishing-retailers-editorial-groups.in");
        File publishingRetailersPublishingBrandsFile = new File("init\\publishing-retailers-publishing-brands.in");

        /* ArrayList-urile pentru toate tipurile */
        Book book = new Book();
        Language language = new Language();
        Author author = new Author();
        EditorialGroup editorialGroup = new EditorialGroup();
        PublishingBrand publishingBrand = new PublishingBrand();
        PublishingRetailer publishingRetailer = new PublishingRetailer();
        Country country = new Country();

        /* Initializarea ArrayList-urilor din fisiere.in */
        author.initAuthors(authorsFile);
        language.initLanguages(languagesFile);
        book.initBooks(booksFile, booksAuthorsFile);
        country.initCountries(countriesFile);
        editorialGroup.initEditorialGroups(editorialGroupsFile, editorialGroupsBooksFile);
        publishingBrand.initPublishingBrands(publishingBrandsFile, publishingBrandsBooksFile);
        publishingRetailer.initPublishingRetailers(publishingRetailersFile, publishingRetailersCountriesFile,
                publishingRetailersBooksFile, publishingRetailersEditorialGroupsFile);
        FileToList ftl = new FileToList();
        ftl.assignPublishingBrandsToPublishingRetailers(publishingRetailer.getAllPublishingRetailers(),
                publishingBrand.getAllPublishingBrands(), publishingRetailersPublishingBrandsFile);
        /* ---Exemple pentru functii--- */

        /* getBooksForPublishingRetailerID */
        if (false) {
            admin.getBooksForPublishingRetailerID(21, true);
            admin.getBooksForPublishingRetailerID(2, true);
            admin.getBooksForPublishingRetailerID(11, true);
            admin.getBooksForPublishingRetailerID(7, true);
            admin.getBooksForPublishingRetailerID(33, true);
        }

        /* getLanguagesForPublishingRetailerID */
        if (false) {
            admin.getLanguagesForPublishingRetailerID(1, true);
            admin.getLanguagesForPublishingRetailerID(10, true);
            admin.getLanguagesForPublishingRetailerID(31, true);
            admin.getLanguagesForPublishingRetailerID(13, true);
            admin.getLanguagesForPublishingRetailerID(23, true);
        }

        /* getCountriesForBookID() */
        if (false) {
            admin.getCountriesForBookID(9372, true);
            admin.getCountriesForBookID(11000, true);
            admin.getCountriesForBookID(12806, true);
            admin.getCountriesForBookID(730, true);
            admin.getCountriesForBookID(5227, true);
        }

        /* getCommonBooksForRetailerIDs */
        if (false) {
            admin.getCommonBooksForRetailerIDs(21, 11, true);
            admin.getCommonBooksForRetailerIDs(13, 1, true);
            admin.getCommonBooksForRetailerIDs(21, 13, true);
            admin.getCommonBooksForRetailerIDs(7, 5, true);
            admin.getCommonBooksForRetailerIDs(4, 12, true);
        }

        /* getAllBooksForRetailerIDs */
        if (false) {
            admin.getAllBooksForRetailerIDs(21, 11, true);
            admin.getAllBooksForRetailerIDs(13, 1, true);
            admin.getAllBooksForRetailerIDs(21, 13, true);
            admin.getAllBooksForRetailerIDs(22, 2, true);
            admin.getAllBooksForRetailerIDs(4, 8, true);
        }

    }

}
