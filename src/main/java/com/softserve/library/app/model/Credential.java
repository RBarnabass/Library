package com.softserve.library.app.model;

import java.util.Objects;

/**
 *
 *
 * @author Roman Berezhnov
 */
public class Credential {

    private int id;
    private String login;
    private String password;

    public Credential() { }
    public Credential(String login, String password) {
        this.login = login;
        this.password = password;
    }
    public Credential(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Credential that = (Credential) o;
        return id == that.id &&
                Objects.equals(login, that.login) &&
                Objects.equals(password, that.password);
    }
    @Override public int hashCode() {
        return Objects.hash(id, login, password);
    }
    @Override public String toString() {
        return "Credential{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
