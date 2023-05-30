package model.dynamiczne;

import java.time.Year;

public class LibrarianDyn extends PersonDyn{

    Double salary;
    public LibrarianDyn(PersonDyn personDyn, Double salary) {
        super(personDyn.getFirstName(), personDyn.getLastName(), personDyn.getBirthYear());
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() + "LibrarianDyn{" +
                "salary=" + salary +
                '}';
    }
}
