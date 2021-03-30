package com.example.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entities.Task;
import com.example.services.TaskService;
import com.example.entities.User;
import com.example.repositories.TaskRepository;
import com.example.repositories.UserRepository;
import com.example.services.UserService;


import java.util.List;

@Controller
public class TaskController {
	@Autowired
	private TaskService taskService;
	@Autowired
	private UserService userService;
	@Autowired
	private TaskRepository repository;
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value = "/ViewTask", method = RequestMethod.POST)
	public String viewTask(ModelMap model, @RequestParam String userName,@RequestParam String password) {
		
		User user = userService.GetUserByName(userName);
		if(user == null) {
			return "usernotfound";
		}
		if(!user.getPasscode().equals(password)) {
			return "usernotfound";
		}
		Iterable<Task> tasks = repository.findAll();
		model.addAttribute("users", tasks);    	
	    return "users";
	}
	
	
	
	@RequestMapping(value = "/DeleteTask", method = RequestMethod.POST)
	public String deleteTask(ModelMap model,@RequestParam String name,@RequestParam String userName,@RequestParam String password) {
		
		User user = userService.GetUserByName(userName);
		if(user == null) {
			return "usernotfound";
		}
		if(!user.getPasscode().equals(password)) {
			return "usernotfound";
		}
		
		Task task = taskService.GetTaskByName(name);
		if(task == null) {
			return "usernotfound";
		}
		repository.delete(task);
		return "taskresult";

	}
	
	
	@RequestMapping(value = "/UpdateTask", method = RequestMethod.POST)
	public String updateTask(ModelMap model,@RequestParam String name,@RequestParam String email,@RequestParam String description,@RequestParam String userName,@RequestParam String password,
			@RequestParam String severity, @RequestParam @DateTimeFormat(pattern = "yyyy-mm-dd") String sdate, @RequestParam @DateTimeFormat(pattern = "yyyy-mm-dd") String edate) {
		
		try {	
			User user = userService.GetUserByName(userName);
			if(user == null) {
				return "usernotfound";
			}
			if(!user.getPasscode().equals(password)) {
				return "usernotfound";
			}
				Task t = taskService.GetTaskByName(name);
				if(sdate != "") {
					Date sd =new SimpleDateFormat("yyyy-mm-dd").parse(sdate);
					t.setStart_date(sd);
				}
				if(edate != "") {
					Date ed =new SimpleDateFormat("yyyy-mm-dd").parse(sdate);
					t.setEnd_date(ed);
				}
				if(email != "") {
					t.setEmail(email);
				}
				if(description != "") {
					t.setDescription(description);
				}
				t.setSeverity(severity);
				taskService.UpdateTask(t);
				return "taskresult";
		
		}catch(Exception e) {
			e.printStackTrace();
			return "error";
		}

	}
	
	
	
	@RequestMapping(value = "/AddTask", method = RequestMethod.POST)
	public String addTask(ModelMap model, @RequestParam String name,@RequestParam String email,@RequestParam String description,@RequestParam String userName,@RequestParam String password,
			@RequestParam String severity, @RequestParam @DateTimeFormat(pattern = "yyyy-mm-dd") String sdate, @RequestParam @DateTimeFormat(pattern = "yyyy-mm-dd") String edate) {
		
	try {	
		User user = userService.GetUserByName(userName);
		if(user == null) {
			return "usernotfound";
		}
		if(!user.getPasscode().equals(password)) {
			return "usernotfound";
		}
		String id = user.getName();
		Date sd =new SimpleDateFormat("yyyy-mm-dd").parse(sdate);
		Date ed =new SimpleDateFormat("yyyy-mm-dd").parse(sdate);

		String Sev;
		if(severity.equals("Low")) {
			Sev = "Low";
		} if(severity.equals("Medium")) {
			Sev = "Medium";
		}else {
			Sev = "High";
		}
		if(name != "" || email != "" || description != "" || sdate != null || edate != null) {
				Task u = new Task();
				u.setTaskName(name);
				u.setEmail(email);
				u.setDescription(description);
				u.setSeverity(Sev);
				u.setStart_date(sd);
				u.setEnd_date(ed);
				u.setUserName(userName);
				taskService.UpdateTask(u);
				
				return "taskresult";
		} else {
			return "inputerror";
		}
	}catch(Exception e) {
		e.printStackTrace();
		return "error";
	}

	}
}
