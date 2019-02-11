package com.softserve.library.app.entity;

import java.util.Objects;

public class Copy {
    private static int id;
    private int bookId=Book.getId();
    private boolean is_available;

    public Copy() {
    }

    public Copy(int bookId, boolean is_available) {
        this.bookId = bookId;
        this.is_available = is_available;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Copy.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public boolean isIs_available() {
        return is_available;
    }

    public void setIs_available(boolean is_available) {
        this.is_available = is_available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Copy copy = (Copy) o;
        return bookId == copy.bookId &&
                is_available == copy.is_available;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, is_available);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("id ").append(id)
                .append(", book ").append(bookId)
                .append(", is_available ").append(is_available).toString();
    }
}
