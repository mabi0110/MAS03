
import exception.DataExportException;
import exception.DataImportException;
import exception.NoSuchOptionException;
import model.*;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
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
                case ADD_USER -> addUser();
                case PRINT_USERS -> printUsers();
                case ADD_AUTHOR -> addAuthor();
                case PRINT_AUTHORS -> printAuthors();
                case BORROW_BOOK -> borrowBook();
                case PRINT_BORROWED_BOOKS -> printBorrowedBooksHistory();
                case PRINT_BORROWED_BOOKS_FOR_USER -> printBorrowedBooksForUser();
                case PRINT_HISTORY_FOR_BOOK -> printHistoryForBook();
            }
        } while (option != Option.EXIT);
    }

    private void printHistoryForBook() {
        String title;
        int year;
        do {
            System.out.print("Podaj tytuł ksiązki: ");
            title = scanner.nextLine();
            System.out.print("Podaj rok wydania: ");
            year = scanner.nextInt();
            scanner.nextLine();
            if (!Book.checkIfExtentContainsBook(title, year)){
                System.out.println("W bibliotece nie ma takiej ksiązki");
            }
        } while (!Book.checkIfExtentContainsBook(title, year));

        Book book = Book.getBookFromExtent(title, year);
        List<UserBook> userBooks = book.getUserBooks();
        userBooks.forEach(System.out::println);
    }

    private void printBorrowedBooksForUser() {
        String firstName, lastName;
        do {
            System.out.print("Podaj imię użytkownika: ");
            firstName = scanner.nextLine();
            System.out.print("Podaj nazwisko użytkownika:");
            lastName = scanner.nextLine();
            if (!User.checkIfExtentContainsUser(firstName, lastName)){
                System.out.println("W bibliotece nie ma takiego użytkownika");
            }
        } while (!User.checkIfExtentContainsUser(firstName, lastName));
        User user = User.getUserFromExtent(firstName, lastName);
        List<UserBook> userBooks = user.getUserBooks();
        userBooks.forEach(System.out::println);
    }

    private void printBorrowedBooksHistory() {
        UserBook.printHistory();
    }

    private void borrowBook() {
        String firstName, lastName, title;
        int year;
        do {
            System.out.print("Podaj imię użytkownika: ");
            firstName = scanner.nextLine();
            System.out.print("Podaj nazwisko użytkownika:");
            lastName = scanner.nextLine();
            if (!User.checkIfExtentContainsUser(firstName, lastName)){
                System.out.println("W bibliotece nie ma takiego użytkownika");
            }
        } while (!User.checkIfExtentContainsUser(firstName, lastName));

        User user = User.getUserFromExtent(firstName, lastName);

        do {
            System.out.print("Podaj tytuł ksiązki: ");
            title = scanner.nextLine();
            System.out.print("Podaj rok wydania: ");
            year = scanner.nextInt();
            scanner.nextLine();
            if (!Book.checkIfExtentContainsBook(title, year)){
                System.out.println("W bibliotece nie ma takiej ksiązki");
            }
        } while (!Book.checkIfExtentContainsBook(title, year));

        Book book = Book.getBookFromExtent(title, year);
        UserBook userBook = new UserBook(LocalDate.now(),user, book);


    }

    private void addAuthor() {
        Author author = createAuthor();
    }

    private Author createAuthor() {
        String answer;
        Author author;
        System.out.print("Imię autora: ");
        String authorName = scanner.nextLine();
        System.out.print("Nazwisko autora: ");
        String authorSurname = scanner.nextLine();
        if (!Author.checkIfExtentContainsAuthor(authorName, authorSurname)){
            author = new Author(authorName, authorSurname);
        } else {
            author = Author.getAuthorFromExtent(authorName, authorSurname);
        }
        System.out.print("Czy chcesz dodać książkę do autora? (t/n): ");
        answer = scanner.nextLine();
        while (answer.equals("t")) {
            Book book = createBook();
            author.addBook(book);
            System.out.print("Czy chcesz dodać kolejną ksiażkę do autora? (t/n): ");
            answer = scanner.nextLine();
        }
        return author;
    }

    private void printAuthors() {
        Author.showAuthors();
    }


    private void printBooks() {
        Book.showBooks();
    }

    private void addBook() {
        Book book = createBook();
    }

    private Book createBook() {
        String answer;
        Book book;
        System.out.println("Dodaj książkę");
        System.out.print("Tytuł: ");
        String title = scanner.nextLine();
        System.out.print("Rok wydania: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        if (!Book.checkIfExtentContainsBook(title, year)){
            book = new Book(title, year);
        } else {
            book = Book.getBookFromExtent(title, year);
        }
        System.out.print("Czy chcesz dodać autora książki? (t/n): ");
        answer = scanner.nextLine();
        while (answer.equals("t")) {
            Author author = createAuthor();
            book.addAuthor(author);
            System.out.print("Czy chcesz dodać kolejnego autora? (t/n): ");
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
        System.out.print("Imię: ");
        String firstName = scanner.nextLine();
        System.out.print("Nazwisko:");
        String lastName = scanner.nextLine();
        return new User(firstName, lastName);
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
