package com.softserve.library.app.entity;

import java.util.Objects;

public class Book{
    private static int id;
    private String title;
    private int authorId=Author.getId();
    private int publisherId =Publisher.getId();
    private int publishYear;

    public Book() {
    }

    public Book(String title, int authorId, int publisherId, int publishYear) {
        this.title = title;
        this.authorId = authorId;
        this.publisherId = publisherId;
        this.publishYear = publishYear;
    }

    public static int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return authorId == book.authorId &&
                publisherId == book.publisherId &&
                publishYear == book.publishYear &&
                title.equals(book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, authorId, publisherId, publishYear);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("id ").append(id)
                .append(", title ").append(title)
                .append(", author ").append(authorId)
                .append(", publisher ").append(publisherId)
                .append(" ,publishYear ").append(publishYear).toString();
    }
}
