import exception.NoSuchOptionException;

public enum Option {
    EXIT(0, "wyjscie"),

    ADD_USER(1, "dodaj uzytkownika"),

    PRINT_USERS(2, "wyswietl uzytkownikow"),

    ADD_BOOK(3, "dodaj ksiazke"),
    PRINT_BOOKS(4, "wyswietl ksiazki"),

    ADD_AUTHOR(5, "dodaj autora"),

    PRINT_AUTHORS(6, "wyświetl autorów"),

    BORROW_BOOK(7, "wypożycz książke"),

    PRINT_BORROWED_BOOKS(8, "wyswielt historie wypozyczen"),
    PRINT_BORROWED_BOOKS_FOR_USER(9, "wyswielt historie wypozyczen dla uzytkownika"),
    PRINT_HISTORY_FOR_BOOK(10, "wyswielt historie wypozyczen dla ksiazki"),

    ADD_EMPLOYEE(11, "dodaj pracownika"),
    PRINT_EMPLOYEES(12, "wyświetl pracownikow"),
    FIND_EMPLOYEE_BY_ID(13, "znajdz pracownika po numerze id"),

    ADD_CONTACT(14, "dodaj kontakt do ksiązki kontaktów"),
    PRINT_CONTACTS(15, "wyświetl kontakty");



    private final int value;
    private final String description;


    Option(int value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public String toString() {
        return  value + " - " + description;
    }

    public static Option createFromInt(int option) throws NoSuchOptionException {
        try {
            return Option.values()[option];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new NoSuchOptionException("Brak opcji o id: " + option);
        }
    }
}
