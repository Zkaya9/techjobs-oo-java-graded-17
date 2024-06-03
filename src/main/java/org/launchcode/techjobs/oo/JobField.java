package org.launchcode.techjobs.oo;

import java.util.Objects;

public abstract class JobField {
    private String value;
    private int id;
    private static int nextId = 0;

    public JobField(String value) {
        this.value = value;
        this.id = nextId;
        nextId++;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobField)) return false;
        JobField jobField = (JobField) o;
        return getId() == jobField.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

