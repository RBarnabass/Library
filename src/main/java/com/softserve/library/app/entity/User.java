package com.softserve.library.app.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class User{
    private static int id;
    private String name;
    private LocalDate birthDate;
    private LocalDateTime registrationDate;

    public User() {
    }

    public User(String name, LocalDate birthDate, LocalDateTime registrationDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.registrationDate = registrationDate;
    }

    public static int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                name.equals(user.name) &&
                birthDate.equals(user.birthDate) &&
                registrationDate.equals(user.registrationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthDate, registrationDate);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("id ").append(id)
                .append(", name ").append(name)
                .append(", birthDate ").append(birthDate)
                .append(", registrationDate ").append(registrationDate).toString();
    }
}
