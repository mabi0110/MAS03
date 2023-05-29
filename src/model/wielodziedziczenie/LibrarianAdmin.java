package model.wielodziedziczenie;

import java.time.Year;

public class LibrarianAdmin extends Librarian implements IAdmin {
    Admin admin;
    public LibrarianAdmin(String firstName, String lastName, Year birthYear, String employeeId, String phoneNumber) {
        super(firstName, lastName, birthYear, employeeId);
        admin = new Admin(null, null, null, null, phoneNumber);  // pass nulls to prevent data redundancy (firstName, etc.)
    }

    @Override
    public void addUser(User user) {
        super.addUser(user);
    }

    @Override
    public void removeUser(User user) {
        super.removeUser(user);
    }

    @Override
    public void addPerson(Person person) {
        admin.addPerson(person);
    }

    @Override
    public void removePerson(Person person) {
        admin.removePerson(person);
    }

    public Double getSalary() {
        return super.getSalary() + admin.getSalary();
    }
}
