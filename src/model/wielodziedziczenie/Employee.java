package model.wielodziedziczenie;

import java.time.Year;

public abstract class Employee extends Person {

    protected static final Double SALARY = 2000.00;
    private String employeeId;
    private Double salary;
    public Employee(String firstName, String lastName, Year birthYear, String employeeId) {
        super(firstName, lastName, birthYear);
        this.salary = SALARY;
        this.employeeId = employeeId;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public abstract void addUser(User user);

    public abstract void removeUser(User user);
}
