package com.softserve.library.app.tables;

public enum PublisherColumns {
    ID("id"),
    NAME("name");

    private String line;

    PublisherColumns(String line) {
        this.line = line;
    }

    public String getColumn() {
        return line;
    }
}
