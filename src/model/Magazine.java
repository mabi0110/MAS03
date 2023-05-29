package model;

import java.time.Month;
import java.time.MonthDay;
import java.time.Year;

public class Magazine extends Publication {
    private MonthDay monthDay;
    public Magazine(String title, Year year, int month, int day) {
        super(title, year);
        this.monthDay = MonthDay.of(month, day);

    }

    @Override
    public String getData() {
        return "Magazine: " + getTitle() + " " + Publication.PUBLISHER + " " + getYear() + " " +
                monthDay.getMonthValue() + " " + monthDay.getDayOfMonth();
    }
}
