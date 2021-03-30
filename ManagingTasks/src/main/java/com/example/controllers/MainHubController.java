package com.example.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entities.User;
import com.example.services.UserService;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Controller
public class MainHubController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/choice", method = RequestMethod.POST)
	public String showUsers(ModelMap model,@RequestParam String action) {

		if(action.equals("add")) {
        	return "addtask";
		} if(action.equals("delete")) {
			return "deletetask";
		}if(action.equals("view")) {
			return "viewtask";
		}else {
			return "updatetask";
		}
		
	}
}
