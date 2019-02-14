package com.softserve.library.app.dto;

public class BookDto {

    private int id;
    private String bookName;
    private int publishYear;
    private String publisherName;
    private String primaryAuthor;
    private String coAuthor;
    private boolean isPrimary;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public int getPublishYear() {
        return publishYear;
    }
    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }
    public String getPublisherName() {
        return publisherName;
    }
    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }
    public String getPrimaryAuthor() {
        return primaryAuthor;
    }
    public void setPrimaryAuthor(String primaryAuthor) {
        this.primaryAuthor = primaryAuthor;
    }
    public String getCoAuthor() {
        return coAuthor;
    }
    public void setCoAuthor(String coAuthor) {
        this.coAuthor = coAuthor;
    }
    public boolean isPrimary() {
        return isPrimary;
    }
    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", publishYear=" + publishYear +
                ", publisherName='" + publisherName + '\'' +
                ", primaryAuthor='" + primaryAuthor + '\'' +
                ", coAuthor='" + coAuthor + '\'' +
                ", isPrimary=" + isPrimary +
                '}';
    }
}
