package com.softserve.library.app.enums;

public enum UserRole {
    USER(1),
    ADMIN(2);

    int roleId;

    UserRole(int roleId) {
        this.roleId = roleId;
    }

    public int getValue() {
        return roleId;
    }
}
