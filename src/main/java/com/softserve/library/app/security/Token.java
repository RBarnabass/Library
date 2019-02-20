package com.softserve.library.app.security;

import java.util.Objects;

/**
 *
 *
 * @author Roman Berezhnov
 */
public class Token {

    private long lastTouch;
    private String role;
    private int userId;

    Token() { }
    Token(long lastTouch, String role, int userId) {

        this.lastTouch = lastTouch;
        this.role = role;
        this.userId = userId;
    }

    long getLastTouch() {
        return lastTouch;
    }
    void setLastTouch(long lastTouch) {
        this.lastTouch = lastTouch;
    }
    String getRole() {
        return role;
    }
    void setRole(String role) {
        this.role = role;
    }
    int getUserId() {
        return userId;
    }
    void setUserId(int userId) {
        this.userId = userId;
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return lastTouch == token.lastTouch &&
                userId == token.userId &&
                Objects.equals(role, token.role);
    }
    @Override public int hashCode() {
        return Objects.hash(lastTouch, role, userId);
    }
    @Override public String toString() {
        return "Token{" +
                "lastTouch=" + lastTouch +
                ", role='" + role + '\'' +
                ", userId=" + userId +
                '}';
    }
}
