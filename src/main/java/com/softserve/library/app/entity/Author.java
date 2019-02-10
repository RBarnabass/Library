package com.softserve.library.app.entity;

import java.util.Objects;

public class Author {
    private static int id;
    private String name;

    public Author() {
    }

    public Author(String name) {
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id &&
                Objects.equals(name, author.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("id ").append(id)
                .append(", name ").append(name).toString();
    }
}
