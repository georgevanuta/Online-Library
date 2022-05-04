package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class FileToList {
    public ArrayList<Book> readBooksFromFile(File file) {
        ArrayList<Book> booksList = new ArrayList<Book>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("###");
                Book bookAux = new Book();
                Language languageAux = new Language();

                bookAux.setID(Integer.parseInt(tokens[0]));
                bookAux.setName(tokens[1]);
                bookAux.setSubtitle(tokens[2]);
                bookAux.setISBN(tokens[3]);
                bookAux.setPageCount(Integer.parseInt(tokens[4]));
                bookAux.setKeywords(tokens[5]);
                languageAux.setID(Integer.parseInt(tokens[6]));
                bookAux.setLanguageID(languageAux);
                bookAux.setCreatedOn(tokens[7]);

                booksList.add(bookAux);
            }
        }
        catch(Exception e){
            System.out.println("Couldn't read from " + file.getName());
        }
        return booksList;
    }

    public ArrayList<Language> readLanguagesFromFile(File file) {
        ArrayList<Language> languagesList = new ArrayList<Language>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("###");
                Language languageAux = new Language();

                languageAux.setID(Integer.parseInt(tokens[0]));
                languageAux.setCode(tokens[1]);
                languageAux.setName(tokens[2]);

                languagesList.add(languageAux);
            }
        }
        catch(Exception e){
            System.out.println("Couldn't read from " + file.getName());
        }
        return languagesList;
    }

    public ArrayList<Author> readAuthorFromFile(File file) {
        ArrayList<Author> authorsList = new ArrayList<Author>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("###");
                Author authorAux = new Author();

                authorAux.setID(Integer.parseInt(tokens[0]));
                authorAux.setFirstName(tokens[1]);
                authorAux.setLastName(tokens[2]);

                authorsList.add(authorAux);
            }
        }
        catch (Exception e) {
            System.out.println("Couldn't read from " + file);
        }
        return authorsList;
    }

    public void assignAuthorsToBooks(ArrayList<Book> books,
                                     ArrayList<Author> authors, File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            Helpers h = new Helpers();
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("###");

                int bookID = Integer.parseInt(tokens[0]);
                int authorID = Integer.parseInt(tokens[1]);

                books.get(h.IDToIndexBook(books,
                        bookID)).addAuthor(h.IDToAuthor(authors, authorID));
            }
        }
        catch (Exception e) {
            System.out.println("Couldn't read from " + file);
        }
    }

    public ArrayList<EditorialGroup> readEditorialGroupsFromFile(File file) {
        ArrayList<EditorialGroup> editorialGroupsList= new ArrayList<EditorialGroup>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("###");
                EditorialGroup editorialGroupAux = new EditorialGroup();

                editorialGroupAux.setID(Integer.parseInt(tokens[0]));
                editorialGroupAux.setName(tokens[1]);

                editorialGroupsList.add(editorialGroupAux);
            }
        }
        catch(Exception e){
            System.out.println("Couldn't read from " + file.getName());
        }
        return editorialGroupsList;
    }

    public ArrayList<PublishingBrand> readPublishingBrandsFromFile(File file) {
        ArrayList<PublishingBrand> publishingBrandsList = new ArrayList<PublishingBrand>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("###");
                PublishingBrand publishingBrandAux = new PublishingBrand();

                publishingBrandAux.setID(Integer.parseInt(tokens[0]));
                publishingBrandAux.setName(tokens[1]);

                publishingBrandsList.add(publishingBrandAux);
            }
        }
        catch(Exception e){
            System.out.println("Couldn't read from " + file.getName());
        }
        return publishingBrandsList;
    }

    public void assignBooksToEditorialGroups(ArrayList<EditorialGroup> editorialGroups,
                                             ArrayList<Book> books, File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            Helpers h = new Helpers();
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("###");

                int editorialGroupID = Integer.parseInt(tokens[0]);
                int bookID = Integer.parseInt(tokens[1]);

                editorialGroups.get(h.IDToIndexEditorialGroup(editorialGroups,
                        editorialGroupID)).addBook(h.IDToBook(books, bookID));
            }
        }
        catch (Exception e) {
            System.out.println("Couldn't read from " + file);
        }
    }

    public void assignBooksToPublishingBrands(ArrayList<PublishingBrand> publishingBrands,
                                              ArrayList<Book> books, File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            Helpers h = new Helpers();
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("###");

                int publishingBrandID = Integer.parseInt(tokens[0]);
                int bookID = Integer.parseInt(tokens[1]);

                publishingBrands.get(h.IDToIndexPublishingBrand(publishingBrands,
                        publishingBrandID)).addBook(h.IDToBook(books, bookID));
            }
        }
        catch (Exception e) {
            System.out.println("Couldn't read from " + file);
        }
    }

    public ArrayList<PublishingRetailer> readPublishingRetailersFromFile(File file) {
        ArrayList<PublishingRetailer> publishingRetailersList = new ArrayList<PublishingRetailer>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("###");
                PublishingRetailer publishingRetailerAux = new PublishingRetailer();

                publishingRetailerAux.setID(Integer.parseInt(tokens[0]));
                publishingRetailerAux.setName(tokens[1]);

                publishingRetailersList.add(publishingRetailerAux);
            }
        }
        catch(Exception e){
            System.out.println("Couldn't read from " + file.getName());
        }
        return publishingRetailersList;
    }

    public ArrayList<Country> readCountriesFromFile(File file) {
        ArrayList<Country> countriesList = new ArrayList<Country>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("###");
                Country countryAux = new Country();

                countryAux.setID(Integer.parseInt(tokens[0]));
                countryAux.setCountryCode(tokens[1]);

                countriesList.add(countryAux);
            }
        }
        catch(Exception e){
            System.out.println("Couldn't read from " + file.getName());
        }
        return countriesList;
    }

    public void assignCountriesToPublishingRetailers(ArrayList<PublishingRetailer> publishingRetailers,
                                                     ArrayList<Country> countries, File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            Helpers h = new Helpers();
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("###");

                int publishingRetailerID = Integer.parseInt(tokens[0]);
                int countryID = Integer.parseInt(tokens[1]);

                publishingRetailers.get(h.IDToIndexPublishingRetailer(publishingRetailers,
                        publishingRetailerID)).addCountry(h.IDToCountry(countries, countryID));
            }
        }
        catch (Exception e) {
            System.out.println("Couldn't read from " + file);
        }
    }

    public void assignBooksToPublishingRetailers(ArrayList<PublishingRetailer> publishingRetailers,
                                                 ArrayList<Book> books, File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            Helpers h = new Helpers();
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("###");

                int publishingRetailerID = Integer.parseInt(tokens[0]);
                int bookID = Integer.parseInt(tokens[1]);

                publishingRetailers.get(h.IDToIndexPublishingRetailer(publishingRetailers,
                        publishingRetailerID)).addPublishingArtifact(h.IDToBook(books, bookID));
            }
        }
        catch (Exception e) {
            System.out.println("Couldn't read from " + file);
        }
    }
    
    public void assignEditorialGroupsToPublishingRetailers(ArrayList<PublishingRetailer> publishingRetailers,
                                                           ArrayList<EditorialGroup> editorialGroups, File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            Helpers h = new Helpers();
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("###");

                int publishingRetailerID = Integer.parseInt(tokens[0]);
                int editorialGroupID = Integer.parseInt(tokens[1]);

                publishingRetailers.get(h.IDToIndexPublishingRetailer(publishingRetailers,
                        publishingRetailerID)).addPublishingArtifact(h.IDToEditorialGroup(editorialGroups, editorialGroupID));
            }
        }
        catch (Exception e) {
            System.out.println("Couldn't read from " + file);
        }
    }

    public void assignPublishingBrandsToPublishingRetailers(ArrayList<PublishingRetailer> publishingRetailers,
                                                            ArrayList<PublishingBrand> publishingBrands, File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            Helpers h = new Helpers();
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("###");

                int publishingRetailerID = Integer.parseInt(tokens[0]);
                int publishingBrandID = Integer.parseInt(tokens[1]);

                publishingRetailers.get(h.IDToIndexPublishingRetailer(publishingRetailers,
                        publishingRetailerID)).addPublishingArtifact(h.IDToPublishingBrand(publishingBrands, publishingBrandID));
            }
        }
        catch (Exception e) {
            System.out.println("Couldn't read from " + file);
        }
    }

    public void assignLanguagesToBooks(ArrayList<Book> books, ArrayList<Language> languages) {
        Helpers h = new Helpers();
        for (int i = 0; i < books.size(); i++) {
            books.get(i).setLanguageID(h.IDToLanguage(languages, books.get(i).getLanguageID().getID()));
        }
    }
}
