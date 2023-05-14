package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {
    private List<UserBook> userBooks;

    public List<UserBook> getUserBooks() {
        return userBooks;
    }

    public void setUserBooks(List<UserBook> userBooks) {
        this.userBooks = userBooks;
    }

    private String firstName;
    private String lastName;

    public static boolean checkIfExtentContainsUser(String userName, String userSurname){
        for (User user : extent) {
            if (userName.equals(user.firstName) && (userSurname.equals(user.lastName))){
                return true;
            }
        }
        return false;
    }

    public static User getUserFromExtent(String userName, String userSurname) {
        for (User user : extent) {
            if (userName.equals(user.firstName) && (userSurname.equals(user.lastName))){
                return user;
            }
        }
        return null;
    }


    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userBooks = new ArrayList<>();
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



    @Override
    public String toString() {
        return firstName + " " + lastName;
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
