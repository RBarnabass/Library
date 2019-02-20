package com.softserve.library.app.dto;

public class BookParametersDto {

    private String name;
    private String author;
    private String publisher;
    private int yearPublishedFrom;
    private int yearPublishedTo;
    private boolean available;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYearPublishedFrom() {
        return yearPublishedFrom;
    }

    public void setYearPublishedFrom(int yearPublishedFrom) {
        this.yearPublishedFrom = yearPublishedFrom;
    }

    public int getYearPublishedTo() {
        return yearPublishedTo;
    }

    public void setYearPublishedTo(int yearPublishedTo) {
        this.yearPublishedTo = yearPublishedTo;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
