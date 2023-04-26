import exception.DataExportException;
import exception.DataImportException;

import java.io.*;
import java.util.List;

public class SerializableBookFileManager implements BookFileManager {

    private static final String FILE_NAME = "Books.o";

    @Override
    public List<Book> importBooks() {
        try (
                FileInputStream fis = new FileInputStream(FILE_NAME);
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            return (List<Book>) ois.readObject();
        } catch (FileNotFoundException e) {
            throw new DataImportException("Nie znaleziono pliku " + FILE_NAME);
        } catch (IOException e) {
            throw new DataImportException("Błąd odczytu danych z pliku " + FILE_NAME);
        } catch (ClassNotFoundException e) {
            throw new DataImportException("Niezgodny typ danych w pliku " + FILE_NAME);
        }
    }

    @Override
    public void exportBooks(List<Book> books) {
        try (FileOutputStream fis = new FileOutputStream(FILE_NAME);
             ObjectOutputStream ous = new ObjectOutputStream(fis)) {
            ous.writeObject(books);
        } catch (FileNotFoundException e) {
            throw new DataExportException("Nie znaleziono pliku " + FILE_NAME);
        } catch (IOException e) {
            throw new RuntimeException("Błąd zapisu danych do pliku " + FILE_NAME);
        }
    }
}
