package com.softserve.library.app.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class TimePeriod {
    private static int id;
    private int copyId=Book.getId();
    private LocalDateTime bookTakingDate;
    private LocalDateTime bookReturningDate;
    private int userId=User.getId();

    public TimePeriod() {
    }

    public TimePeriod(int copyId, LocalDateTime bookTakingDate, LocalDateTime bookReturningDate, int userId) {
        this.copyId = copyId;
        this.bookTakingDate = bookTakingDate;
        this.bookReturningDate = bookReturningDate;
        this.userId = userId;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        TimePeriod.id = id;
    }

    public int getCopyId() {
        return copyId;
    }

    public void setCopyId(int copyId) {
        this.copyId = copyId;
    }

    public LocalDateTime getBookTakingDate() {
        return bookTakingDate;
    }

    public void setBookTakingDate(LocalDateTime bookTakingDate) {
        this.bookTakingDate = bookTakingDate;
    }

    public LocalDateTime getBookReturningDate() {
        return bookReturningDate;
    }

    public void setBookReturningDate(LocalDateTime bookReturningDate) {
        this.bookReturningDate = bookReturningDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimePeriod that = (TimePeriod) o;
        return copyId == that.copyId &&
                userId == that.userId &&
                Objects.equals(bookTakingDate, that.bookTakingDate) &&
                Objects.equals(bookReturningDate, that.bookReturningDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(copyId, bookTakingDate, bookReturningDate, userId);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("id ").append(id)
                .append(", book ").append(copyId)
                .append(", was taken ").append(bookTakingDate)
                .append(", returned ").append(bookReturningDate)
                .append(" , by ").append(userId).toString();
    }
}
