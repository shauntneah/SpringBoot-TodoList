package org.generation.todolist.controller;

import org.generation.todolist.controller.dto.TaskDTO;
import org.generation.todolist.repository.entity.Task;
import org.generation.todolist.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;

@RestController
@RequestMapping("/task")
public class TaskController {

    final TaskService taskService;

    public TaskController(@Autowired TaskService taskService )
    {
        this.taskService = taskService;
    }

    @CrossOrigin
    @GetMapping( "/all" )
    public Iterable<Task> getTasks()
    {
        return taskService.all();
    }

    @CrossOrigin
    @GetMapping( "/{id}" )
    public Task findTaskById( @PathVariable Integer id )
    {
        return taskService.findById( id );
    }

    @CrossOrigin
    @DeleteMapping( "/{id}" )
    public void delete( @PathVariable Integer id )
    {
        taskService.delete( id );
    }

    @CrossOrigin
    @PostMapping("/add")
    public void save(  @RequestParam(name="title", required = true) String title,
                       @RequestParam(name="description", required = true) String description,
                       @RequestParam(name="target", required = true) String target) {

        Date dateVal = null;

        if (description.isEmpty()){
            description = null;
        }
        if (!target.isEmpty()){
            dateVal = Date.valueOf(target);
        }

        TaskDTO taskDto = new TaskDTO(title, description, dateVal);
        taskService.save(new Task(taskDto));
    }




}//end of class
