package com.softserve.library.app.model;

import java.util.Objects;

/**
 *
 *
 * @author Roman Berezhnov
 */
public class Author {

    private int id;
    private String name;
    private boolean isPrimary;

    public Author() { }
    public Author(String name) {
        this.name = name;
    }
    public Author(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
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
    public boolean isPrimary() {
        return isPrimary;
    }
    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id &&
                Objects.equals(name, author.name);
    }
    @Override public int hashCode() {
        return Objects.hash(id, name);
    }
    @Override public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isPrimary=" + isPrimary +
                '}';
    }
}
