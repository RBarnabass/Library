package com.softserve.library.app.dto;

import java.util.ArrayList;
import java.util.List;

public class DebtorDto {

    private int userId;
    private String userFullName;
    private String userBirthDate;
    private String userRegistrationDate;
    private List<DebtCopyDto> debtCopies = new ArrayList<>();

    public List<DebtCopyDto> getDebtCopies() {
        return debtCopies;
    }

    public void setDebtCopies(List<DebtCopyDto> debtCopies) {
        this.debtCopies = debtCopies;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserBirthDate() {
        return userBirthDate;
    }

    public void setUserBirthDate(String userBirthDate) {
        this.userBirthDate = userBirthDate;
    }

    public String getUserRegistrationDate() {
        return userRegistrationDate;
    }

    public void setUserRegistrationDate(String userRegistrationDate) {
        this.userRegistrationDate = userRegistrationDate;
    }

}
