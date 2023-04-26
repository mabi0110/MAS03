import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Book implements Serializable {
    private String title;
    private String author;
    private int year;
    private String description;
    private List<String> categories = new ArrayList<>();
    private static String publisher = "WSIP";

    public static int booksAmount() {
        return extent.size();
    }
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        addBook(this);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public static String getPublisher() {
        return publisher;
    }

    public static void setPublisher(String publisher) {
        Book.publisher = publisher;
    }

    @Override
    public String toString() {
        String bookBasicDesc = title + " " + author + " " + year + " " + publisher + " ";
        if (description == null && categories.isEmpty()) {
            return bookBasicDesc;
        }
        if (categories.isEmpty()){
            return bookBasicDesc + description;
        }
        if (description == null){
            return bookBasicDesc + categories;
        } else {
            return bookBasicDesc + categories + " " + description;
        }
    }

    public void addCategory(String category) {
        this.categories.add(category);
    }

    private static List<Book> extent = new ArrayList<>();

    public static List<Book> getExtent() {
        return extent;
    }

    public static void setExtent(List<Book> extent) {
        Book.extent = extent;
    }

    private static void addBook(Book book){
        extent.add(book);
    }

    public static void showBooks(){
        System.out.println("Dostępne książki:");
        for (Book book : extent) {
            System.out.println(book);
        }
    }
}
