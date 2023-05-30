package model.overlapping;

import java.time.Year;
import java.util.EnumSet;

public abstract class PersonOver {

    private String firstName;
    private String lastName;
    private Year birthYear;
    private String identifier;
    private String phoneNumber;
    private EnumSet<PersonType> personType = EnumSet.of(PersonType.PersonOver);

    public PersonOver(String firstName, String lastName, Year birthYear) {
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

    public EnumSet<PersonType> getPersonType() {
        return personType;
    }

    public void setPersonType(EnumSet<PersonType> personType) {
        this.personType = personType;
    }

    public void makeAdmin(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.personType.add(PersonType.AdminOver);
    }

    public void makeUser(String identifier) {
        this.identifier = identifier;
        this.personType.add(PersonType.UserOver);
    }

    public void removeAdmin() {
        this.phoneNumber = null;
        this.personType.remove(PersonType.AdminOver);
    }

    public void removeUser() {
        this.identifier = null;
        this.personType.remove(PersonType.UserOver);
    }

    public String getIdentifier() throws Exception {
        if (!this.personType.contains(PersonType.UserOver)) {
            throw new Exception("Person is not a User");
        }
        return identifier;
    }

    public void setIdentifier(String identifier)  throws Exception {
        if (!this.personType.contains(PersonType.UserOver)) {
            throw new Exception("Person is not a User");
        }
        this.identifier = identifier;
    }

    public String getPhoneNumber() throws Exception {
        if (!this.personType.contains(PersonType.AdminOver)) {
            throw new Exception("Person is not a Admin");
        }
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) throws Exception {
        if (!this.personType.contains(PersonType.AdminOver)) {
            throw new Exception("Person is not a Admin");
        }
        this.phoneNumber = phoneNumber;
    }


}
