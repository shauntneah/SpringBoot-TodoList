package org.generation.todolist.repository.entity;

//Repository package is part of the Model Component (MVC)
//Item is the entity class to use to map against the table from the database
// model is the object used to map to the database table & fields

import org.generation.todolist.controller.dto.TaskDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.sql.Date;


@Entity
public class Task {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private Date target;

    public Task() {}
    public Task(TaskDTO taskDto) {
        this.title = taskDto.getTitle();
        this.description = taskDto.getDescription();
        this.target = taskDto.getTargetDeadline();
    }

    public Integer getId() {return id;}
    public String getTitle() {return title;}
    public String getDescription() {return description;}
    public Date getTarget() {return target;}

    public void setId(Integer id) {this.id = id;}
    public void setTitle(String title) {this.title = title;}
    public void setDescription(String description) {this.description = description;}
    public void setTarget(Date target) {this.target = target;}

    @Override
    public String toString() {
        return String.format("Task{id=%d, title='%s', description='%s', target='%s'}",id,title,description,target);
    }

}//end of class
