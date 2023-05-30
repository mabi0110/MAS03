package model.klasaAbstrakcyjnaPolimor;

import java.time.Year;

public class Book extends Publication {
    private String author;
    private String isbn;

    public Book(String title, Year year, String author, String isbn) {
        super(title, year);
        this.author = author;
        this.isbn = isbn;
    }

    @Override
    public String getData() {
        return "Book: " + getTitle() + " " + author + " " + Publication.PUBLISHER + " " + getYear() + " " + isbn;
    }
}
