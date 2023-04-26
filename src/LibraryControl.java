
import exception.DataExportException;
import exception.DataImportException;
import exception.NoSuchOptionException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryControl {

    private Scanner scanner = new Scanner(System.in);
    private BookFileManager fileManager;

    LibraryControl(){
        try {
            fileManager = new SerializableBookFileManager();
            Book.setExtent(fileManager.importBooks());
            System.out.println("Zaimportowano dane z pliku");
        } catch (DataImportException e){
            System.out.println("w pliku nie ma zapisanych danych");
        }
    }
    public void controlLoop() {
        Option option;
        do {
            printOptions();
            option = getOption();
            switch (option){
                case EXIT -> exit();
                case ADD_BOOK -> addBook();
                case PRINT_BOOKS -> printBooks();
                case PRINT_BOOKS_AMOUNT -> printBooksAmount();
                case ADD_USER -> addUser();
                case PRINT_USERS -> printUsers();
            }

        } while (option != Option.EXIT);
    }

    private void printBooksAmount() {
        int booksAmount = Book.booksAmount();
        if (booksAmount == 0){
            System.out.println("W bibliotece nie ma dostepnych ksiazek");
        } else {
            System.out.println("Ilosc dostepnych ksazek: " + Book.booksAmount());
        }
    }

    private void printBooks() {
        Book.showBooks();
    }

    private void addBook() {
        Book book = createBook();
    }

    private Book createBook() {
        System.out.println("Dodaj książkę");
        System.out.print("Tytuł: ");
        String title = scanner.nextLine();
        System.out.print("Autor: ");
        String author = scanner.nextLine();
        System.out.print("Rok wydania: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        Book book = new Book(title, author, year);
        System.out.print("Czy chcesz dodać opis książki? (t/n): ");
        String answer = scanner.nextLine();
        if (answer.equals("t")) {
            System.out.print("Opis książki: ");
            String description = scanner.nextLine();
            book.setDescription(description);
        }

        System.out.print("Czy chcesz dodać kategorię? (t/n): ");
        answer = scanner.nextLine();
        while (answer.equals("t")) {
            System.out.print("Nazwa kategorii: ");
            String categories = scanner.nextLine();
            book.addCategory(categories);
            System.out.print("Czy chcesz dodać kolejną kategorię? (t/n): ");
            answer = scanner.nextLine();
        }
        return book;
    }

    private void printUsers() {
        User.showUsers();
    }

    private void addUser() {
        User user = createUser();
    }

    private User createUser() {
        System.out.println("Podaj dane użytkownika");
        System.out.print("Imię: ");
        String firstName = scanner.nextLine();
        System.out.print("Nazwisko:");
        String lastName = scanner.nextLine();
        System.out.print("Rok urodzenia:");
        int birthYear = scanner.nextInt();
        scanner.nextLine();
        Address address = createAddress();
        User user = new User(firstName, lastName, address, birthYear);
        System.out.println("Dodano użytkownika: ");
        System.out.println(user);
        return user;
    }

    private Address createAddress() {
        System.out.println("Podaj adres do korespondencji");
        System.out.print("Nazwa ulicy: ");
        String streetName = scanner.nextLine();
        System.out.print("Numer budynku: ");
        String streetNumber = scanner.nextLine();
        System.out.print("Numer mieszkania: ");
        int flatNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Miejscowość: ");
        String city = scanner.nextLine();
        return new Address(streetName, streetNumber, flatNumber, city);
    }

    private void exit(){
        try {
            fileManager.exportBooks(Book.getExtent());
            System.out.println("Wyeksportowano dane do pliku");
        } catch (DataExportException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Koniec programu");
    }

    private void printOptions() {
        System.out.println("Wybierz opcję: ");
        Option[] options = Option.values();
        for (Option option : options) {
            System.out.println(option.toString());
        }
    }

    private Option getOption() {
        boolean optionOk = false;
        Option option = null;
        while (!optionOk) {
            try {
                option = Option.createFromInt(scanner.nextInt());
                optionOk = true;
            } catch (NoSuchOptionException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Wprowadzona wartość nie jest liczbą.");
            } finally {
                scanner.nextLine();
            }
        }
        return option;
    }
}
