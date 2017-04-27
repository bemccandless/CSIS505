package edu.liberty.bemccandless.csis505.hw6.exercise2;

/**
 *
 * @author bemccandless
 */
public class Book {

    private String title;
    private String isbn;
    private int editionNumber;
    private String copyright;

    public Book() {
    }

    public Book(String title, String isbn, int edition, String copyright) {
        this.title = title;
        this.isbn = isbn;
        this.editionNumber = edition;
        this.copyright = copyright;
    }

    @Override
    public String toString() {
        return "Book{" + "title=" + title + ", isbn=" + isbn + ", edition=" + editionNumber + ", copyright=" + copyright + '}';
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getEditionNumber() {
        return editionNumber;
    }

    public void setEditionNumber(int editionNumber) {
        this.editionNumber = editionNumber;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }
    
}
