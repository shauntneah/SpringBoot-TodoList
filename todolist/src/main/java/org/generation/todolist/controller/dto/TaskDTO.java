
//This file is used for adding & updating of task listings


package org.generation.todolist.controller.dto;
import java.sql.Date;



public class TaskDTO {

    private String title;
    private String description;
    private Date target;

    public TaskDTO(String title, String description, Date targetDeadline) {
        this.title = title;
        this.description = description;
        this.target = targetDeadline;
    }

    public String getTitle() {return title;}
    public String getDescription() {return description;}
    public Date getTargetDeadline() {return target;}

    public void setTitle(String title) {this.title = title;}
    public void setDescription(String description) {this.description = description;}
    public void setTargetDeadline(Date targetDeadline) {this.target = targetDeadline;}


}//end of class

