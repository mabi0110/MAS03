package model;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private static int employeeTempNo = 0;
    private int employeeNo;
    private String firstName;
    private String lastName;
    private Library library;

    private static List<Employee> extent = new ArrayList<>();

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeNo = employeeTempNo + 1;
        employeeTempNo += 1;
        addEmployee(this);
    }

    public int getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(int employeeNo) {
        this.employeeNo = employeeNo;
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


    public static List<Employee> getExtent() {
        return extent;
    }

    public static void setExtent(List<Employee> extent) {
        Employee.extent = extent;
    }

    private static void addEmployee(Employee employee){
        extent.add(employee);
    }

    public static void showEmployee(){
        System.out.println("Lista pracowników");
        for (Employee employee : extent) {
            System.out.println(employee);
        }
    }

    public void addLibrary(Library library) {
        this.library = library;
    }

    @Override
    public String toString() {
        return employeeNo + " " + firstName + " " + lastName + " pracuje w " + library.getName();
    }
}
