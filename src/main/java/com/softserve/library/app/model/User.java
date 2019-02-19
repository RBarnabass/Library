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
    private Date regDate;
    private String login;
    private String password;
    private int role_id;

    public User() { }

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

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
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

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        User user = (User) o;
//        return id == user.id &&
//                Objects.equals(fullName, user.fullName) &&
//                Objects.equals(birthDate, user.birthDate) &&
//                Objects.equals(registrationDate, user.registrationDate);
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(id, fullName, birthDate, registrationDate);
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", fullName='" + fullName + '\'' +
//                ", birthDate=" + birthDate +
//                ", registrationDate=" + registrationDate +
//                '}';
    }
}
