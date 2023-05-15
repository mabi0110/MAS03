package model;

import java.util.Map;
import java.util.TreeMap;

public class Library {

    private String name;

    private Map<Integer, Employee> employees;

    public Library(String name) {
        this.name = name;
        this.employees = new TreeMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Integer, Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Map<Integer, Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee newEmployee){
        if (!employees.containsKey(newEmployee.getEmployeeNo())){
            employees.put(newEmployee.getEmployeeNo(), newEmployee);
            newEmployee.addLibrary(this);
        }
    }

    public Employee findEmployeeByID(int id) throws Exception {
        if (!employees.containsKey(id)){
            throw new Exception("Nie odnaleziono pracownika o id: " + id);
        }
        return employees.get(id);
    }
}
