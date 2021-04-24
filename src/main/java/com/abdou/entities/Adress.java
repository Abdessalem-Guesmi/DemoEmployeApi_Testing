package com.abdou.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Adress {
	@Id
	@GeneratedValue
	private long id;
	private String city;
	private int code;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Adress(String city, int code) {
		super();
		this.city = city;
		this.code = code;
	}

	public Adress() {
		super();
		// TODO Auto-generated constructor stub
	}

}
