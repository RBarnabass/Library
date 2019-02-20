package com.softserve.library.app.model;

import java.time.LocalDate;
import java.util.Objects;

public class User {

    private int id;
    private String fullName;
    private LocalDate birthDate;
    private LocalDate registrationDate;
    private String login;
    private String password;
    private Role role;

    public User() { }
    public User(String fullName, LocalDate birthDate, LocalDate registrationDate, String login, String password) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.registrationDate = registrationDate;
        this.login = login;
        this.password = password;
    }
    public User(String fullName, LocalDate birthDate, LocalDate registrationDate, String login, String password, Role role) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.registrationDate = registrationDate;
        this.login = login;
        this.password = password;
        this.role = role;
    }
    public User(int id, String fullName, LocalDate birthDate, LocalDate registrationDate, String login, String password, Role role) {
        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.registrationDate = registrationDate;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public LocalDate getRegistrationDate() {
        return registrationDate;
    }
    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return id == that.id &&
                Objects.equals(fullName, that.fullName) &&
                Objects.equals(birthDate, that.birthDate) &&
                Objects.equals(registrationDate, that.registrationDate) &&
                Objects.equals(login, that.login) &&
                Objects.equals(password, that.password) &&
                Objects.equals(role, that.role);
    }
    @Override public int hashCode() {
        return Objects.hash(id, fullName, birthDate, registrationDate, login, password, role);
    }
    @Override public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", birthDate=" + birthDate +
                ", registrationDate=" + registrationDate +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
