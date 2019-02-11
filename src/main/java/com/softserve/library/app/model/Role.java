package com.softserve.library.app.model;

import java.util.Objects;

/**
 *
 *
 * @author Roman Berezhnov
 */
public class Role {

    private int id;
    private String type;

    public Role() { }
    public Role(String type) {
        this.type = type;
    }
    public Role(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role1 = (Role) o;
        return id == role1.id &&
                Objects.equals(type, role1.type);
    }
    @Override public int hashCode() {
        return Objects.hash(id, type);
    }
    @Override public String toString() {
        return "Role{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
