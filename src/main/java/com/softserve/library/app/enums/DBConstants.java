package com.softserve.library.app.enums;

public enum DBConstants {

    PATH ("jdbc:mysql://"),
    HOST ("localhost"),
    PORT (":3306"),
    BASE ("/library"),
    LOGIN ("root"),
    PASSWORD ("java");

    private String line;

    DBConstants(String line) {

        this.line = line;
    }

    public String getValue() {

        return line;
    }
}
