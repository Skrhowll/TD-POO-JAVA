package com.dov.database;

public class Subject {
    private String id;
    private String name;
    private int factor; // Assuming factor is an integer

    // Constructor
    public Subject(String id, String name, int factor) {
        this.id = id;
        this.name = name;
        this.factor = factor;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFactor() {
        return factor;
    }

    public void setFactor(int factor) {
        this.factor = factor;
    }

    // toString method for displaying subject information
    @Override
    public String toString() {
        return "Subject{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", factor=" + factor +
                '}';
    }
}
