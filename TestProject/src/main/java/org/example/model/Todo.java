package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Timestamp;


public class Todo {
    @JsonIgnoreProperties(ignoreUnknown = true)
    private int id;
    private String title;
    private String description;
    @JsonIgnoreProperties(ignoreUnknown = true)
    private String status;

    @JsonIgnoreProperties(ignoreUnknown = true)
    private Timestamp createdAt;


    // Getters and Setters


    public Todo() {
    }

    public  Todo (String title , String description){
        this.title=title;
        this.description=description;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
