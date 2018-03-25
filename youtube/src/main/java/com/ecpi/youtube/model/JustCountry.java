package com.ecpi.youtube.model;

import java.util.Objects;

public class JustCountry {
    private String name;

    public JustCountry(String name) {
        this.name = name;
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
        JustCountry that = (JustCountry) o;
        return Objects.equals(name.toLowerCase(), that.name.toLowerCase());
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "JustCountry{" +
                "name='" + name + '\'' +
                '}';
    }
}
