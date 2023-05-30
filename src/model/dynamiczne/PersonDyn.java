package model.dynamiczne;

import java.time.Year;


public class PersonDyn {

    private String firstName;
    private String lastName;
    private Year birthYear;

    public PersonDyn(String firstName, String lastName, Year birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
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

    public Year getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Year birthYear) {
        this.birthYear = birthYear;
    }

    @Override
    public String toString() {
        return "PersonDyn{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthYear=" + birthYear +
                '}';
    }
}
