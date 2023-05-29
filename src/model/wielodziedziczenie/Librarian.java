package model.wielodziedziczenie;

import java.time.Year;

public class Librarian extends Employee {

    public Librarian(String firstName, String lastName, Year birthYear, String employeeId) {
        super(firstName, lastName, birthYear, employeeId);
    }

    @Override
    public void addUser(User user) {
        System.out.println("Z klasy Librarian");
    }


    @Override
    public void removeUser(User user) {
        System.out.println("Z klasy Librarian");
    }


}



