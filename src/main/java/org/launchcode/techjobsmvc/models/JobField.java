package org.launchcode.techjobsmvc.models;

import java.util.Objects;

public abstract class JobField {
    private int id;
    private static int nextId = 1;
    private String value;

    //  constructor assigns unique ID number to each new object
    public JobField() {
        id = nextId;
        nextId++;
    }

    //  constructor takes string param assigned to 'value' field
//    & calls empty constructor to initialize 'id' field
    public JobField(String value) {
        this();
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    //  equivalent objects have same id fields
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobField)) return false;
        JobField jobField = (JobField) o;
        return id == jobField.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    //  getters & setters
    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}