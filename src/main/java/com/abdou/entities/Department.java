package com.abdou.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Department {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY)

	private Collection<Employe> employes;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	public Collection<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(Collection<Employe> employes) {
		this.employes = employes;
	}

	public Department(String name, Collection<Employe> employes) {
		super();
		this.name = name;
		this.employes = employes;
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

}
