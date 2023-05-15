
import exception.DataExportException;
import exception.DataImportException;
import exception.NoSuchOptionException;
import model.*;

import java.time.LocalDate;
import java.util.*;

public class LibraryControl {

    private final Library library;
    private final Scanner scanner = new Scanner(System.in);
    private BookFileManager fileManager;

    LibraryControl(Library library){
        this.library = library;
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
                case ADD_EMPLOYEE -> addEmployee();
                case PRINT_EMPLOYEES -> printEmployees();
                case FIND_EMPLOYEE_BY_ID -> findEmployeeByID();
            }
        } while (option != Option.EXIT);
    }

    private void findEmployeeByID() {
        Employee employee;
        System.out.print("Podaj id pracownika: ");
        int id = readInt();
        try {
            employee = library.findEmployeeByID(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(employee);
    }

    private void printEmployees() {
        Map<Integer, Employee> employees = library.getEmployees();
        Set<Map.Entry<Integer, Employee>> entries = employees.entrySet();
        for (Map.Entry<Integer, Employee> entry : entries) {
            System.out.println(entry.getValue());
        }
    }

    private void addEmployee() {
        library.addEmployee(createEmployee());
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
            List<String> nameAndSurname = readNameAndSurname();
            firstName = nameAndSurname.get(0);
            lastName = nameAndSurname.get(1);
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
            List<String> nameAndSurname = readNameAndSurname();
            firstName = nameAndSurname.get(0);
            lastName = nameAndSurname.get(1);
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
        new UserBook(LocalDate.now(),user, book);
    }

    private Author createAuthor() {
        String answer;
        Author author;
        List<String> nameAndSurname = readNameAndSurname();
        String authorName = nameAndSurname.get(0);
        String authorSurname = nameAndSurname.get(1);
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

    private void printAuthors() {
        Author.showAuthors();
    }

    private void printBooks() {
        Book.showBooks();
    }

    private void addUser() { createUser();}

    private void addBook() {
        createBook();
    }

    private void addAuthor() { createAuthor(); }

    private void createUser() {
        List<String> nameAndSurname = readNameAndSurname();
        new User(nameAndSurname.get(0), nameAndSurname.get(1));
    }

    private Employee createEmployee() {
        List<String> nameAndSurname = readNameAndSurname();
        return new Employee(nameAndSurname.get(0), nameAndSurname.get(1));
    }

    private List<String> readNameAndSurname(){
        List<String> nameAndSurname = new ArrayList<>();
        System.out.print("Podaj imię: ");
        nameAndSurname.add(scanner.nextLine());
        System.out.print("Podaj nazwisko: ");
        nameAndSurname.add(scanner.nextLine());
        return nameAndSurname;
    }

    private int readInt(){
        int id = scanner.nextInt();
        scanner.nextLine();
        return id;
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
