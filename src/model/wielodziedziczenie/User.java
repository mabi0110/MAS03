package model.wielodziedziczenie;

import java.time.Year;

public class User extends Person {

    private String identifier;
    public User(String firstName, String lastName, Year birthYear, String identifier) {
        super(firstName, lastName, birthYear);
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
