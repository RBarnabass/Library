package com.softserve.library.app.dto;

import java.util.ArrayList;
import java.util.List;

public class DebtorDto {

    private int userId;
    private String userFullName;
    private String userBirthDate;
    private String userRegistrationDate;
    private List<String> debtedBookNames = new ArrayList<>();

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

    public List<String> getDebtedBookNames() {
        return debtedBookNames;
    }

    public void setDebtedBookNames(List<String> debtedBookNames) {
        this.debtedBookNames = debtedBookNames;
    }
}
