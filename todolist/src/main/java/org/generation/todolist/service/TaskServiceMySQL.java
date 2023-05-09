
package org.generation.todolist.service;

import org.generation.todolist.repository.entity.Task;
import org.generation.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceMySQL implements TaskService {


    private final TaskRepository taskRepository;

    public TaskServiceMySQL(@Autowired TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public Task save(Task task){return taskRepository.save(task);}

    @Override
    public void delete(int id) {taskRepository.deleteById(id);}

    @Override
    public List<Task> all() {
        List<Task> result = new ArrayList<>();
        taskRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public Task findById(int id){
        Optional<Task> task= taskRepository.findById(id);
        Task taskResponse = task.get();
        return taskResponse;
    }

}//end of class
