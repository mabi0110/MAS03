package model.wielodziedziczenie;

import java.time.Year;

public class Admin extends Employee implements IAdmin {
    private String phoneNumber;
    public Admin(String firstName, String lastName, Year birthYear, String employeeId, String phoneNumber) {
        super(firstName, lastName, birthYear, employeeId);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void addPerson(Person person) {
        System.out.println("Z klasy Admina");
    }

    @Override
    public void removePerson(Person person) {
        System.out.println("Z klasy Admina");

    }

    @Override
    public void addUser(User user) {
        System.out.println("Z klasy Admina");
        addPerson(user);
    }
    @Override
    public void removeUser(User user) {
        System.out.println("Z klasy Admina");
        removePerson(user);
    }


}
