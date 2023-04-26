import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class User {

    private String firstName;
    private String lastName;
    private int birthYear;
    private Address address;

    public User(String firstName, String lastName, Address address, int birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.birthYear = birthYear;
        addUser(this);
    }

    public User(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        addUser(this);
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getAge() {
        return LocalDate.now().getYear() - birthYear;
    }


    @Override
    public String toString() {
        return firstName + " " + lastName + " wiek: " + getAge() + " " + address;
    }

    private static List<User> extent = new ArrayList<>();

    public static List<User> getExtent() {
        return extent;
    }

    public static void setExtent(List<User> extent) {
        User.extent = extent;
    }

    private static void addUser(User user){
        extent.add(user);
    }

    public static void showUsers(){
        System.out.println("Lista wszystkich użytkowników");
        for (User user : extent) {
            System.out.println(user);
        }
    }
}
