package com.abdou.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abdou.dao.EmployeRepository;
import com.abdou.entities.Employe;

@RestController
public class EmployeController {
	@Autowired
	private EmployeRepository employeRepository;

	@GetMapping("/employes")
	public List<Employe> listEmployes() {
		return employeRepository.findAll();
	}

	@PostMapping("/employe")
	public Employe saveEmploye(@RequestBody Employe e) {
		return employeRepository.save(e);
	}

}
