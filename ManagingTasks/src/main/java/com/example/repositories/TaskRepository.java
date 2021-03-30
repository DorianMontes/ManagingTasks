package com.example.repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.entities.Task;
import com.example.entities.User;

public interface TaskRepository extends CrudRepository<Task, Integer> {

    public Task findByTaskName(String taskName);
    
    Integer deleteByTaskName(String taskName);
    
}