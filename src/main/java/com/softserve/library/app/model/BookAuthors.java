package com.softserve.library.app.model;

import java.util.Objects;

public class BookAuthors {

    private int id;
    private int bookId;
    private int authorId;
    private boolean isPrimary;

    public BookAuthors() { }

    public BookAuthors(int bookId, int authorId, boolean isPrimary) {
        this.bookId = bookId;
        this.authorId = authorId;
        this.isPrimary = isPrimary;
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

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookAuthors that = (BookAuthors) o;
        return id == that.id &&
                bookId == that.bookId &&
                authorId == that.authorId &&
                isPrimary == that.isPrimary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookId, authorId, isPrimary);
    }

    @Override
    public String toString() {
        return "BookAuthors{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", authorId=" + authorId +
                ", isPrimary=" + isPrimary +
                '}';
    }
}
