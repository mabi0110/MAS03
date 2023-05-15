package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserBook {
    private LocalDate startDate;

    private User user;

    private Book book;
    private static List<UserBook> extent = new ArrayList<>();

    public UserBook(LocalDate startDate, User user, Book book) {
        this.startDate = startDate;
        this.user = user;
        this.book = book;
        addUserBook(this);
        user.getUserBooks().add(this);
        book.getUserBooks().add(this);
    }



    public static void printHistory(){
        for (UserBook userBook : extent) {
            System.out.println(userBook);
        }
    }


    private static void addUserBook(UserBook userBook){
        extent.add(userBook);
    }

    @Override
    public String toString() {
        return "UserBook{" +
                "startDate=" + startDate +
                ", user=" + user +
                ", book=" + book +
                '}';
    }
}
