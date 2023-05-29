package model;

import java.io.Serializable;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
