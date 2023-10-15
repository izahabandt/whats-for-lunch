package com.izahabandt;

public class Meal {
    public Meal(String name, String description) {
        this.name = name;
        this.description = description;
    }

    private int _id;
    private String name;
    private String description;


    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
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
