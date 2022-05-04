package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class Administration {
    public ArrayList<Book> getBooksForPublishingRetailerID(int publishingRetailerID, boolean printFlag) {
        Helpers h = new Helpers();
        PublishingRetailer publishingRetailer = new PublishingRetailer();
        ArrayList<PublishingRetailer> publishingRetailers = publishingRetailer.getAllPublishingRetailers();

        PublishingRetailer publishingRetailerFound = h.IDToPublishingRetailer(publishingRetailers,
                publishingRetailerID);
        if (publishingRetailerFound == null) {
            if (printFlag) {
                System.out.println("\nINVALID ID\n");
            }
            return null;
        }
        ArrayList<Book> booksOfRetailer = new ArrayList<Book>();
        ArrayList<IPublishingArtifact> artifactsOfRetailer = new ArrayList<IPublishingArtifact>();
        artifactsOfRetailer = publishingRetailerFound.getPublishingArtifacts();

        for (int i = 0; i < artifactsOfRetailer.size(); i++) {
            if (artifactsOfRetailer.get(i).getClass().getSimpleName().equals("Book")) {
               Book bookAux = new Book();
               bookAux = (Book) (artifactsOfRetailer.get(i));
               booksOfRetailer.add(bookAux);
            }
            else if (artifactsOfRetailer.get(i).getClass().getSimpleName().equals("EditorialGroup")) {
                EditorialGroup editorialGroupAux = new EditorialGroup();
                editorialGroupAux = (EditorialGroup) (artifactsOfRetailer.get(i));
                ArrayList<Book> booksOfGroup = new ArrayList<Book>();
                booksOfGroup = editorialGroupAux.getBooks();

                for (int j = 0; j < booksOfGroup.size(); j++) {
                    booksOfRetailer.add(booksOfGroup.get(j));
                }
            }
            else if (artifactsOfRetailer.get(i).getClass().getSimpleName().equals("PublishingBrand")) {
                PublishingBrand publishingBrandAux = new PublishingBrand();
                publishingBrandAux = (PublishingBrand) (artifactsOfRetailer.get(i));
                ArrayList<Book> booksOfBrand = new ArrayList<Book>();
                booksOfBrand = publishingBrandAux.getBooks();

                for (int l = 0; l < booksOfBrand.size(); l++) {
                    booksOfRetailer.add(booksOfBrand.get(l));
                }
            }
        }

        /* Eliminare de duplicate(un set nu poate avea duplicate) */
        booksOfRetailer = new ArrayList<Book>(new LinkedHashSet<Book>(booksOfRetailer));

        /* Printarea numelor cartilor daca printFlag == true */
        if (printFlag) {
            System.out.println("\n---The books of " + publishingRetailerFound.getName() + "---");
            h.PrintBooks(booksOfRetailer);
        }

        return booksOfRetailer;
    }

    public ArrayList<Language> getLanguagesForPublishingRetailerID(int publishingReatilerID, boolean printFlag) {
        Helpers h = new Helpers();
        PublishingRetailer publishingRetailer = new PublishingRetailer();
        ArrayList<PublishingRetailer> publishingRetailers = publishingRetailer.getAllPublishingRetailers();

        ArrayList<Book> booksOfRetailer = getBooksForPublishingRetailerID(publishingReatilerID, false);
        if (booksOfRetailer == null) {
            if (printFlag) {
                System.out.println("\nINVALID ID\n");
            }
            return null;
        }
        ArrayList<Language> languagesOfRetailer = new ArrayList<Language>();

        for (int i = 0; i < booksOfRetailer.size(); i++) {
            languagesOfRetailer.add(booksOfRetailer.get(i).getLanguageID());
        }

        /* Eliminare de duplicate */
        languagesOfRetailer = new ArrayList<Language>(new LinkedHashSet<Language>(languagesOfRetailer));

        /* Printarea numelor limbilor daca printFlag == true */
        if (printFlag) {
            PublishingRetailer publishingRetailerFound = new PublishingRetailer();
            publishingRetailerFound = h.IDToPublishingRetailer(publishingRetailers, publishingReatilerID);
            System.out.println("\n\n---The languages of " + publishingRetailerFound.getName() + "---");
            h.PrintLanguages(languagesOfRetailer);
        }
        return languagesOfRetailer;
    }

    public ArrayList<Country> getCountriesForBookID(int bookID, boolean printFlag) {
        Helpers h = new Helpers();
        PublishingRetailer publishingRetailer = new PublishingRetailer();
        ArrayList<PublishingRetailer> publishingRetailers = publishingRetailer.getAllPublishingRetailers();

        ArrayList<Integer> indexes = new ArrayList<Integer>();
        ArrayList<Country> countries = new ArrayList<Country>();
        indexes = h.PublishingRetailersToIDs(publishingRetailers);
        String nameOfBook = new String();
        for (int i = 0; i < publishingRetailers.size(); i++) {
            ArrayList<Book> booksAux = new ArrayList<Book>();
            booksAux = getBooksForPublishingRetailerID(indexes.get(i), false);
            if (booksAux != null && h.IDToBook(booksAux, bookID) != null) {
                nameOfBook = h.IDToBook(booksAux,bookID).getName();
                PublishingRetailer publishingRetailerAux = new PublishingRetailer();
                publishingRetailerAux = h.IDToPublishingRetailer(publishingRetailers, indexes.get(i));
                for (int j = 0; j < publishingRetailerAux.getCountries().size(); j++) {
                    countries.add(publishingRetailerAux.getCountries().get(j));
                }
            }
        }

        countries = new ArrayList<Country>(new LinkedHashSet<Country>(countries));
        if(printFlag) {
            System.out.println("\n\n---The countries in which " + nameOfBook + " was published---");
            h.PrintCountries(countries);
        }
        return countries;
    }

    public ArrayList<Book> getCommonBooksForRetailerIDs(int retailerID1, int retailerID2, boolean printFlag) {
        ArrayList<Book> books1 = getBooksForPublishingRetailerID(retailerID1, false);
        ArrayList<Book> books2 = getBooksForPublishingRetailerID(retailerID2, false);
        ArrayList<Book> commonBooks = new ArrayList<Book>(books1);
        commonBooks.retainAll(books2);

        if (printFlag) {
            Helpers h = new Helpers();
            System.out.println("\n\n---Common books between the two are:---");
            h.PrintBooks(commonBooks);
        }

        return commonBooks;

    }

    public ArrayList<Book> getAllBooksForRetailerIDs(int retailerID1, int retailerID2, boolean printFlag) {
        HashSet<Book> unionSet = new HashSet<Book>();
        ArrayList<Book> books1 = getBooksForPublishingRetailerID(retailerID1, false);
        ArrayList<Book> books2 = getBooksForPublishingRetailerID(retailerID2, false);
        unionSet.addAll(books1);
        unionSet.addAll(books2);
        ArrayList<Book> unionBooks = new ArrayList<Book>(unionSet);

        if (printFlag) {
            Helpers h = new Helpers();
            System.out.println("\n\n---Union of the books of the two retailers---");
            h.PrintBooks(unionBooks);
        }

        return unionBooks;
    }
}
