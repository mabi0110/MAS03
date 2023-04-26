import java.util.List;

public interface BookFileManager {

    List<Book> importBooks();
    void exportBooks(List<Book> data);


}
