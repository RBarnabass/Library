package com.softserve.library.app.model;

import java.util.Objects;

public class Copy {

    private int id;
    private int bookId;

    public Copy() { }
    public Copy(int id, int bookId) {
        this.id = id;
        this.bookId = bookId;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getBookId() {
        return bookId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Copy copy = (Copy) o;
        return id == copy.id &&
                bookId == copy.bookId;
    }
    @Override public int hashCode() {
        return Objects.hash(id, bookId);
    }
    @Override public String toString() {
        return "Copy{" +
                "id=" + id +
                ", bookId=" + bookId +
                '}';
    }
}
