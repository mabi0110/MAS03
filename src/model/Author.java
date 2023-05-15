package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Author implements Serializable {
    private String firstName;
    private String lastName;
    private static List<Author> extent = new ArrayList<>();
    private List<Book> books;

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.books = new ArrayList<>();
        addAuthor(this);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public static List<Author> getExtent() {
        return extent;
    }

    public static void setExtent(List<Author> extent) {
        Author.extent = extent;
    }

    private static void addAuthor(Author author){
        extent.add(author);
    }

    public void addBook(Book newBook){
        if (!books.contains(newBook)){
            books.add(newBook);
            newBook.addAuthor(this);
        }
    }

    public static boolean checkIfExtentContainsAuthor(String authorName, String authorSurname){
        for (Author author : extent) {
            if (authorName.equals(author.firstName) && (authorSurname.equals(author.lastName))){
                return true;
            }
        }
        return false;
    }

    public static Author getAuthorFromExtent(String authorName, String authorSurname) {
        for (Author author : extent) {
            if (authorName.equals(author.firstName) && (authorSurname.equals(author.lastName))){
                return author;
            }
        }
        return null;
    }

    public static void showAuthors(){
        System.out.println("Lista wszystkich autorów");
        for (Author a : extent) {
            System.out.println(a);
        }
    }
    @Override
    public String toString() {
        String info = "Autor: " + firstName + " " + lastName;
        for (Book b: books){
            info += " " + b.getTitle();
        }
        return info;
    }


}
