package com.softserve.library.app.dto;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 *
 * @author Roman Berezhnov
 */
public class UserStatisticDto {

    private String userName;
    private Timestamp usingTime;
    private String bookName;
    private int publishYear;
    private Date startDate;
    private Date endDate;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Timestamp getUsingTime() {
        return usingTime;
    }

    public void setUsingTime(Timestamp usingTime) {
        this.usingTime = usingTime;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "UserStatisticDto{" +
                "userName='" + userName + '\'' +
                ", usingTime=" + usingTime +
                ", bookName='" + bookName + '\'' +
                ", publishYear=" + publishYear +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
