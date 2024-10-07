package com.library.model;

import java.util.Date;

public class Report {
    private String title;        // Title of the book
    private String author;       // Author of the book
    private String member;       // Member's name who issued or returned the book
    private Date date;           // Date of the transaction

    // Constructor
    public Report(String title, String author, String member, Date date) {
        this.title = title;
        this.author = author;
        this.member = member;
        this.date = date;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getMember() {
        return member;
    }

    public Date getDate() {
        return date;
    }

    // Optionally, you can override toString() for easier debugging
    @Override
    public String toString() {
        return "Report{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", member='" + member + '\'' +
                ", date=" + date +
                '}';
    }
}
