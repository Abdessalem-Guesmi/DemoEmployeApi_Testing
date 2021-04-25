package com.abdou.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@GetMapping("/employe/{id}")
	public Optional<Employe> getEmploye(@PathVariable Long id) {
		return employeRepository.findById(id);
	}

	@DeleteMapping("/employe/{idEmploye}")
	public boolean deleteEmploye(@PathVariable("idEmploye") Long id) {
		employeRepository.deleteById(id);
		return true;
	}

	@PutMapping("/employes/{id}")
	public Employe updateEmploye(@RequestBody Employe employe, @PathVariable Long id) {
		employe.setId(id);
		return employeRepository.save(employe);

	}

}
