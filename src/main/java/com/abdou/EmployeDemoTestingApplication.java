package com.abdou;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.abdou.dao.AdressRepository;
import com.abdou.dao.DepartmentRepository;
import com.abdou.dao.EmployeRepository;
import com.abdou.dao.TaskRepository;
import com.abdou.entities.Adress;
import com.abdou.entities.AppRole;
import com.abdou.entities.AppUser;
import com.abdou.entities.Department;
import com.abdou.entities.Employe;
import com.abdou.service.AccountService;

@SpringBootApplication
public class EmployeDemoTestingApplication implements CommandLineRunner {
	@Autowired
	private TaskRepository taskRepository;
	@Autowired
	private AccountService accountService;
	@Autowired
	private EmployeRepository employeRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private AdressRepository adressRepository;

	public static void main(String[] args) {
		SpringApplication.run(EmployeDemoTestingApplication.class, args);
		System.out.println("**************test valid*************");
	}

	@Bean
	public BCryptPasswordEncoder getBCr() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {
		accountService.saveUser(new AppUser("admin", "admin", null));
		accountService.saveUser(new AppUser("user", "user", null));
		accountService.saveRole(new AppRole("ADMIN"));
		accountService.saveRole(new AppRole("USER"));
		accountService.addRoleToUser("admin", "ADMIN");
		accountService.addRoleToUser("admin", "USER");
		accountService.addRoleToUser("user", "USER");
		Adress adr1 = adressRepository.save(new Adress("Tunis", 2080));
		Adress adr2 = adressRepository.save(new Adress("Paris", 7070));
		Adress adr3 = adressRepository.save(new Adress("Berlin", 9080));
		Department dep1 = departmentRepository.save(new Department("IT", null));
		Department dep2 = departmentRepository.save(new Department("Dev", null));
		Department dep3 = departmentRepository.save(new Department("QA", null));
		Employe e1 = employeRepository.save(new Employe("Abdou", "Guesmi", 5300, adr1, dep1));
		Employe e2 = employeRepository.save(new Employe("Jack", "Mobila", 3300, adr2, dep2));
		Employe e3 = employeRepository.save(new Employe("Hoffmann", "Gostavo", 2300, adr1, dep3));
		employeRepository.findAll().forEach(e -> {
			System.out.println(e.getfName() + " " + e.getlName());
		});

	}

}
