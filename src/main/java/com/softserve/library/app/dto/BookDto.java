package com.softserve.library.app.dto;

import com.softserve.library.app.model.Book;

public class BookDto {
    private String name;
    private String firstAuthorName;
    private String publisherName;
    private int publishYear;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstAuthorName() {
        return firstAuthorName;
    }

    public void setFirstAuthorName(String firstAuthorName) {
        this.firstAuthorName = firstAuthorName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public void bookEntityToDto(Book book) {

        this.name = book.getName();
        this.firstAuthorName = book.getAuthors().get(0).getName();
        this.publisherName = book.getPublisher().getName();
        this.publishYear = book.getPublishYear();
    }
}
