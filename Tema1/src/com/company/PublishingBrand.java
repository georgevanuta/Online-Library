package com.company;

import java.io.File;
import java.util.ArrayList;

public class PublishingBrand implements IPublishingArtifact {
    private int ID;
    private String name;
    private ArrayList<Book> books = new ArrayList<Book>();
    private ArrayList<PublishingBrand> allPublishingBrands;

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return this.ID;
    }

    public ArrayList<Book> getBooks() {
        return this.books;
    }

    public void addBook(Book book){
        this.books.add(book);
    }

    public String publish() {
        String IDLine = "\t\t" + "<ID>" + this.ID + "</ID>" + "\n";
        String nameLine = "\t\t" + "<Name>" + this.name + "</Name>" + "\n";
        String booksLine = new String();
        Helpers h = new Helpers();
        int n = this.books.size();
        for (int i = 0; i < n; i++) {
            booksLine = booksLine + h.publishBookWithoutXml(this.books.get(i), 3, 1);
        }
        String s = "<xml>\n\t<publishingBrand>\n" + IDLine + nameLine + "\t</publishingBrand>\n\t<books>\n" +
                booksLine + "</books>\n</xml>\n";

        return s;
    }

    public void initPublishingBrands(File publishingBrandsFile, File publishingBrandsBooksFile) {
        FileToList ftl = new FileToList();
        Book book = new Book();

        allPublishingBrands = ftl.readPublishingBrandsFromFile(publishingBrandsFile);
        ftl.assignBooksToPublishingBrands(allPublishingBrands, book.getAllBooks(), publishingBrandsBooksFile);
    }

    public ArrayList<PublishingBrand> getAllPublishingBrands() {
        return allPublishingBrands;
    }

}
