package com.example.u4t8database.model;

public class Task {
    private int _id;
    private String todo;
    private String toAccomplish;
    private String description;

    //public Task(){};

    public Task(int _id, String todo, String to_accomplish, String description ) {
        this._id = _id;
        this.todo = todo;
        this.toAccomplish = to_accomplish;
        this.description = description;

    }


    public int get_id() { return _id; }

    public String getTodo() { return todo; }

    public String getToAccomplish() { return toAccomplish; }

    public String getDescription() { return description; }
}
