package com.company;

import java.util.ArrayList;
import java.util.Calendar;

public class Helpers {
    public String authorToString(Author author) {
    return author.getFirstName() + " " + author.getLastName();
}

    public String authorsToString(ArrayList<Author> authors) {
        String s = authorToString(authors.get(0));

        int n = authors.size();
        for (int i = 1; i < n; i++) {
            s = s + "," + authorToString(authors.get(i));
        }

        return s;
    }

    public String calendarToString(Calendar calendar) {
        String s = calendar.get(Calendar.DAY_OF_MONTH) + "." + calendar.get(Calendar.MONTH) + "." +
                calendar.get(Calendar.YEAR)  + " " + calendar.get(Calendar.HOUR) + ":" +
                calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND);

        return s;
    }

    public String publishBookWithoutXml(Book book, int nrTabs, int flag) {
        Helpers help = new Helpers();
        String tabs = new String();
        for (int i = 0; i < nrTabs; i++) {
            tabs = tabs + "\t";
        }
        String nameLine = tabs + "<title>" + book.getName() + "</title>" + "\n";
        if (book.getSubtitle().trim().isEmpty() == false) {
            String subtitleLine = tabs + "<subtitle>" + book.getSubtitle() + "</subtitle>" + "\n";
            nameLine = nameLine + subtitleLine;
        }
        String isbnLine = tabs + "<isbn>" + book.getISBN() + "</isbn>" + "\n";
        String pageCountLine = tabs + "<pageCount>" + book.getPageCount() + "</pageCount>" + "\n";
        String keywordsLine = tabs + "<keywords>" + book.getKeywords() + "</keywords>" + "\n";
        String languageIDLine = tabs + "<languageID>" + book.getLanguageID().getID() + "</languageID>" + "\n";
        String createdOnLine = tabs + "<createdOn>" + help.calendarToString(book.getCreatedOn()) + "</createdOn>" + "\n";
        String authorsLine = tabs + "<authors>" + help.authorsToString(book.getAuthors()) + "</authors>" + "\n";

        String s;
        if (flag == 0){
            s = nameLine + isbnLine + pageCountLine + keywordsLine +
                    languageIDLine + createdOnLine + authorsLine + "\n";
        }
        else {
            String otherTabs = new String();
            for (int i = 0; i < nrTabs - 1; i++) {
                otherTabs = otherTabs + "\t";
            }
            s = otherTabs + "<book>\n" + isbnLine + pageCountLine + keywordsLine +
                    languageIDLine + createdOnLine + authorsLine + otherTabs + "</book>\n";
        }

        return s;
    }

    public Author IDToAuthor(ArrayList<Author> authors, int ID) {
        for (int i = 0; i < authors.size(); i++) {
            if (authors.get(i).getID() == ID) {
                return authors.get(i);
            }
        }
        return null;
    }

    public int IDToIndexBook(ArrayList<Book> books, int ID) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getID() == ID) {
                return i;
            }
        }
        return -1;
    }

    public Book IDToBook(ArrayList<Book> books, int ID) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getID() == ID) {
                return books.get(i);
            }
        }
        return null;
    }

    public int IDToIndexEditorialGroup(ArrayList<EditorialGroup> editorialGroups, int ID) {
        for (int i = 0; i < editorialGroups.size(); i++) {
            if (editorialGroups.get(i).getID() == ID) {
                return i;
            }
        }
        return -1;
    }

    public int IDToIndexPublishingBrand(ArrayList<PublishingBrand> publishingBrands, int ID) {
        for (int i = 0; i < publishingBrands.size(); i++) {
            if (publishingBrands.get(i).getID() == ID) {
                return i;
            }
        }
        return -1;
    }

    public int IDToIndexPublishingRetailer(ArrayList<PublishingRetailer> publishingRetailers, int ID) {
        for (int i = 0; i < publishingRetailers.size(); i++) {
            if (publishingRetailers.get(i).getID() == ID) {
                return i;
            }
        }
        return -1;
    }

    public Country IDToCountry(ArrayList<Country> countries, int ID) {
        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i).getID() == ID) {
                return countries.get(i);
            }
        }
        return null;
    }

    public EditorialGroup IDToEditorialGroup(ArrayList<EditorialGroup> editorialGroups, int ID) {
        for (int i = 0; i < editorialGroups.size(); i++) {
            if(editorialGroups.get(i).getID() == ID) {
                return editorialGroups.get(i);
            }
        }
        return null;
    }

    public PublishingBrand IDToPublishingBrand(ArrayList<PublishingBrand> publishingBrands, int ID) {
        for (int i = 0; i < publishingBrands.size(); i++) {
            if(publishingBrands.get(i).getID() == ID) {
                return publishingBrands.get(i);
            }
        }
        return null;
    }

    public PublishingRetailer IDToPublishingRetailer(ArrayList<PublishingRetailer> publishingRetailers, int ID) {
        for (int i = 0; i < publishingRetailers.size(); i++) {
            if(publishingRetailers.get(i).getID() == ID) {
                return publishingRetailers.get(i);
            }
        }
        return null;
    }

    public Language IDToLanguage(ArrayList<Language> languages, int ID) {
        for (int i = 0; i < languages.size(); i++) {
            if (languages.get(i).getID() == ID) {
                return languages.get(i);
            }
        }
        return null;
    }

    public void PrintBooks(ArrayList<Book> books) {
        if (books.size() < 1) {
            System.out.println("No books!");
            return;
        }
        for (int i = 0; i < books.size(); i++) {
            if (i % 4 == 0) {
                System.out.println();
            }
            System.out.print(books.get(i).getName() + "###");
        }
    }

    public void PrintLanguages(ArrayList<Language> languages) {
        if (languages.size() < 1) {
            System.out.println("No languages!");
            return;
        }
        for (int i = 0; i < languages.size(); i++) {
            if (i % 4 == 0) {
                System.out.println();
            }
            System.out.print(languages.get(i).getName() + "###");

        }
    }

    public void PrintCountries(ArrayList<Country> countries) {
        if (countries.size() < 1) {
            System.out.println("No countries!");
            return;
        }
        for (int i = 0; i < countries.size(); i++) {
            if (i % 4 == 0) {
                System.out.println();
            }
            System.out.print(countries.get(i).getCountryCode() + "###");
        }
    }

    public ArrayList<Integer> PublishingRetailersToIDs(ArrayList<PublishingRetailer> publishingRetailers) {
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        for (int i = 0; i < publishingRetailers.size(); i++) {
            indexes.add(publishingRetailers.get(i).getID());
        }
        return indexes;
    }

}
