package com.example.dropwizard.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: sully.rafiq
 * Date: 31/07/2014
 * Time: 21:34
 * To change this template use File | Settings | File Templates.
 */
public class TodoItem {

    @JsonProperty
    private String description;

    @JsonProperty
    private Date createdDate;

    public TodoItem() {
        createdDate = new Date();
    }

    public TodoItem(String description) {
        this();
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TodoItem todoItem = (TodoItem) o;

        if (createdDate != null ? !createdDate.equals(todoItem.createdDate) : todoItem.createdDate != null)
            return false;
        if (description != null ? !description.equals(todoItem.description) : todoItem.description != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = description != null ? description.hashCode() : 0;
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "description='" + description + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
