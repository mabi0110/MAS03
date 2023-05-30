package model.klasaAbstrakcyjnaPolimor;

import java.time.Year;

public abstract class Publication {

    protected static final String PUBLISHER = "WSIP";
    private String title;
    private Year year;

    public Publication(String title, Year year) {
        this.title = title;
        this.year = year;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public abstract String getData();
}

