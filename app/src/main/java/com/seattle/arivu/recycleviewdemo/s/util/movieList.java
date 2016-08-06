package com.seattle.arivu.recycleviewdemo.s.util;

/**
 * Created by v-arambi on 8/5/2016.
 */
public class movieList {
    private String title;
    private String genre;
    public movieList(String title, String genre, String year) {
        this.title = title;
        this.genre = genre;
        this.year = year;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    private String year;

}
