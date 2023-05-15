package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Book implements Serializable {
    private String title;
    private int year;
    private static List<Book> extent = new ArrayList<>();
    private List<Author> authors;
    private List<UserBook> userBooks;

    public Book(String title, int year) {
        this.title = title;
        this.year = year;
        this.userBooks = new ArrayList<>();
        this.authors = new ArrayList<>();
        addBook(this);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<UserBook> getUserBooks() {
        return userBooks;
    }

    public void setUserBooks(List<UserBook> userBooks) {
        this.userBooks = userBooks;
    }

    public static List<Book> getExtent() {
        return extent;
    }

    public static void setExtent(List<Book> extent) {
        Book.extent = extent;
    }

    private static void addBook(Book book){
        extent.add(book);
    }
    public static boolean checkIfExtentContainsBook(String title, int year){
        for (Book book : extent) {
            if (title.equals(book.title) && (year == book.year)){
                return true;
            }
        }
        return false;
    }

    public static Book getBookFromExtent(String title, int year) {
        for (Book book : extent) {
            if (title.equals(book.title) && year == book.year){
                return book;
            }
        }
        return null;
    }

    public void addAuthor(Author newAuthor){
        if (!authors.contains(newAuthor)){
            authors.add(newAuthor);
            newAuthor.addBook(this);
        }
    }

    public static void showBooks(){
        System.out.println("Dostępne książki:");
        for (Book book : extent) {
            System.out.println(book);
        }
    }

    @Override
    public String toString() {
        String info = "Książka: " + title + " " + year + " ";
        for (Author author : authors) {
            info += author.getFirstName() + " " + author.getLastName() + " " ;
        }
        return info;
    }

}
