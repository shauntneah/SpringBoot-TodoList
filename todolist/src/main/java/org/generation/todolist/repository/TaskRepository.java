package org.generation.todolist.repository;

import org.generation.todolist.repository.entity.Task;
import org.springframework.data.repository.CrudRepository;


public interface TaskRepository extends CrudRepository<Task, Integer>
{}
