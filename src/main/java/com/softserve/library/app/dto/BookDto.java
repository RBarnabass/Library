package com.softserve.library.app.dto;

import java.util.Objects;

/**
 *
 *
 * @author Roman Berezhnov
 */
public class BookDto {

    private int bookId;
    private String bookName;
    private int publishYear;
    private String publisherName;
    private String primaryAuthor;
    private String coAuthor;
    private boolean isPrimary;
    private int copies;

    public int getBookId() {
        return bookId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
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
    public int getCopies() {
        return copies;
    }
    public void setCopies(int copies) {
        this.copies = copies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDto bookDto = (BookDto) o;
        return bookId == bookDto.bookId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId);
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' + "\n" +
                ", publishYear=" + publishYear +
                ", publisherName='" + publisherName + '\'' + "\n" +
                ", primaryAuthor='" + primaryAuthor + '\'' +
                ", coAuthor='" + coAuthor + '\'' + "\n" +
                ", isPrimary=" + isPrimary +
                ", copies=" + copies +
                '}';
    }
}
