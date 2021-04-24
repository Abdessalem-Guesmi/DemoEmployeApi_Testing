package com.abdou.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Employe {
	@Id
	@GeneratedValue
	private long id;
	private String fName;
	private String lName;
	private double salary;
	@ManyToOne
	private Adress adress;
	@ManyToOne
	private Department department;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Employe(String fName, String lName, double salary, Adress adress, Department department) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.salary = salary;
		this.adress = adress;
		this.department = department;
	}

	public Employe() {
		super();
	}

}
