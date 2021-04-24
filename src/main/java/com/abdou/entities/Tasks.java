package com.abdou.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class Tasks {

	@Id
	@GeneratedValue
	private Long id;
	private String taskName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String gettaskName() {
		return taskName;
	}

	public void settaskName(String taskName) {
		this.taskName = taskName;
	}

	public Tasks(String taskName) {
		super();
		this.taskName = taskName;
	}

	public Tasks() {
		super();
		// TODO Auto-generated constructor stub
	}

}
