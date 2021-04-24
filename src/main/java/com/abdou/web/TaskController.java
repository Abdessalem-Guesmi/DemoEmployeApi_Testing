package com.abdou.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abdou.dao.TaskRepository;
import com.abdou.entities.Tasks;

@RestController
public class TaskController {
	@Autowired
	private TaskRepository taskRepository;
	@GetMapping("/tasks")
	public List<Tasks> listTasks(){
		return taskRepository.findAll();
	}
	@PostMapping("/task")
	public Tasks saveTask(@RequestBody Tasks t){
		return taskRepository.save(t);
	}
}
