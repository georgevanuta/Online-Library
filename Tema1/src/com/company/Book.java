package com.company;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.io.File;

public class Book implements IPublishingArtifact {
    private int ID;
    private String name;
    private String subtitle;
    private String ISBN;
    private int pageCount;
    private String keywords;
    private Language languageID;
    private Calendar createdOn;
    private ArrayList<Author> authors = new ArrayList<Author>();
    private static ArrayList<Book> allBooks;
    
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public void setLanguageID(Language languageID) {
        this.languageID = languageID;
    }

    public void setCreatedOn(String createdOn) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        this.createdOn = Calendar.getInstance();
        try{
            this.createdOn.setTime(sdf.parse(createdOn));
        }
        catch (ParseException p) {
            System.out.println("Calendar couldn't set!");
        }
    }

    public int getID() {
        return this.ID;
    }

    public String getName() {
        return this.name;
    }

    public Language getLanguageID() {
        return this.languageID;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public String getSubtitle() {
        return this.subtitle;
    }

    public String getKeywords() {
        return this.keywords;
    }

    public int getPageCount() {
        return this.pageCount;
    }

    public Calendar getCreatedOn() {
        return this.createdOn;
    }

    public ArrayList<Author> getAuthors() {
        return this.authors;
    }

    public void addAuthor(Author author){
        this.authors.add(author);
    }

    public String publish() {
        Helpers h = new Helpers();
        String s = "<xml>\n" + h.publishBookWithoutXml(this, 1, 0)+ "</xml>\n";

        return s;
    }

    public void initBooks(File booksFile, File booksAuthorsFile) {
        FileToList ftl = new FileToList();
        Author author = new Author();
        Language language = new Language();

        allBooks = ftl.readBooksFromFile(booksFile);
        ftl.assignAuthorsToBooks(allBooks, author.getAllAuthors(), booksAuthorsFile);
        ftl.assignLanguagesToBooks(allBooks, language.getAllLanguages());
    }

    public ArrayList<Book> getAllBooks() {
        return allBooks;
    }
}
