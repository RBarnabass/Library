package com.softserve.library.app.model;

import java.util.Objects;

public class Book {

    private int id;
    private String name;
    private int publishYear;
    private Publisher publisher;

    public Book() { }
    public Book(String name, int publishYear) {
        this.name = name;
        this.publishYear = publishYear;
    }
    public Book(String name, int publishYear, Publisher publisher) {
        this.name = name;
        this.publishYear = publishYear;
        this.publisher = publisher;
    }
    public Book(int id, String name, int publishYear, Publisher publisher) {
        this.id = id;
        this.name = name;
        this.publishYear = publishYear;
        this.publisher = publisher;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPublishYear() {
        return publishYear;
    }
    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }
    public Publisher getPublisher() {
        return publisher;
    }
    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                publishYear == book.publishYear &&
                Objects.equals(name, book.name) &&
                Objects.equals(publisher, book.publisher);
    }
    @Override public int hashCode() {

        return Objects.hash(id, name, publishYear, publisher);
    }
    @Override public String toString() {

        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publishYear=" + publishYear +
                ", publisher=" + publisher +
                '}';
    }
}
