package com.softserve.library.app.dto;

public class DebtCopyDto {

    private int copyId;
    private int bookId;
    private int daysInDebt;

    public int getCopyId() {
        return copyId;
    }

    public void setCopyId(int copyId) {
        this.copyId = copyId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getDaysInDebt() {
        return daysInDebt;
    }

    public void setDaysInDebt(int daysInDebt) {
        this.daysInDebt = daysInDebt;
    }
}
