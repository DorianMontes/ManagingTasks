package com.example.services;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Task;
import com.example.repositories.TaskRepository;


@Service
public class TaskService {
	
	@Autowired
	 private TaskRepository taskRepository;
	
	

    public Iterable<Task> GetAllTasks()
    {
        return taskRepository.findAll();
    }


    public Task GetTaskByName(String name) {
        Task foundUser = taskRepository.findByTaskName(name);
        return foundUser;
    }
    
    
    public void UpdateTask(Task tasktoUpdate) {
    	taskRepository.save(tasktoUpdate);
    }


}