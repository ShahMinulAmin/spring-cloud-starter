package com.sajib.example.birdservice.model;

/**
 * Created by sajib on 1/22/19.
 */
public class Bird {

    protected String name;
    protected String description;

    public Bird(String name, String description) {
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
