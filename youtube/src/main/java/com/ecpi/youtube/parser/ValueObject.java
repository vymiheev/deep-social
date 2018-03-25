package com.ecpi.youtube.parser;

import java.io.Serializable;
import java.util.Optional;

public class ValueObject<T> implements Serializable {
    private T value;

    public ValueObject() {
    }

    public ValueObject(T countryVal) {
        this.value = countryVal;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
