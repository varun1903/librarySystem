package com.library.model;

public class Book {
    private String title;
    private String author;
    private String serialNumber;
    private boolean isAvailable;

    public Book(String title, String author, String serialNumber, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.serialNumber = serialNumber;
        this.isAvailable = isAvailable;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
