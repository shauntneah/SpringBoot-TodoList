package org.generation.todolist.service;

import org.generation.todolist.repository.entity.Task;
import java.util.List;


public interface TaskService {

    Task save(Task task);
    void delete(int id);
    List<Task> all();
    Task findById(int id);

}//end of class
