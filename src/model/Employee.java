package model;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private String firstName;
    private String lastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        addEmployee(this);
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



    @Override
    public String toString() {
        return firstName + " " + lastName;
    }



    private static List<Employee> extent = new ArrayList<>();

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
        System.out.println("Lista wszystkich pracowników");
        for (Employee employee : extent) {
            System.out.println(employee);
        }
    }
}
