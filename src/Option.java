import exception.NoSuchOptionException;

public enum Option {
    EXIT(0, "wyjscie"),
    ADD_BOOK(1, "dodaj ksiazke"),
    PRINT_BOOKS(2, "wyswietl ksiazki"),

    PRINT_BOOKS_AMOUNT(3, "ilosc ksiazek w bibliotece"),

    ADD_USER(4, "dodaj uzytkownika"),

    PRINT_USERS(5, "wyswietl uzytkownikow");

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
