package com.softserve.library.app.model;

import java.util.Objects;

public class Publisher {

    private int id;
    private String name;

    public Publisher() { }
    public Publisher(String name) {
        this.name = name;
    }
    public Publisher(int id, String name) {
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

    @Override public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return id == publisher.id &&
                Objects.equals(name, publisher.name);
    }
    @Override public int hashCode() {

        return Objects.hash(id, name);
    }
    @Override public String toString() {

        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
