package com.softserve.library.app.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

/**
 *
 *
 * @author Roman Berezhnov
 */
public class User {

    private int id;
    private String fullName;
    private Date birthDate;
    private transient Timestamp registrationDate;

    public User() { }

    public User(String fullName, Date birthDate) {
        this.fullName = fullName;
        this.birthDate = birthDate;
    }

    public User(int id, String fullName, Date birthDate, Timestamp registrationDate) {
        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.registrationDate = registrationDate;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Timestamp getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Timestamp registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(fullName, user.fullName) &&
                Objects.equals(birthDate, user.birthDate) &&
                Objects.equals(registrationDate, user.registrationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, birthDate, registrationDate);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", birthDate=" + birthDate +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
