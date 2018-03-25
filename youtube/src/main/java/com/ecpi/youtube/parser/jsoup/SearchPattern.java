package com.ecpi.youtube.parser.jsoup;

import java.io.Serializable;

public class SearchPattern implements Serializable {
    private String line;
    private String name;

    public SearchPattern() {
    }

    public SearchPattern(String name, String line) {
        this.name = name;
        this.line = line;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
