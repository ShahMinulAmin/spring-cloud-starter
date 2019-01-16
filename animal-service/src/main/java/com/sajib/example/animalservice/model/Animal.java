package com.sajib.example.animalservice.model;

/**
 * Created by sajib on 1/14/19.
 */
public class Animal {

    protected String name;
    protected String description;

    public Animal(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
