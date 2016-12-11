package com.github.aimind.exponentialschedule_api.core;

import java.util.List;

public class ElementComponent {
	
	//Attributes
	private int id;
	private String name;
	private List<Constraint> constraints;
	
	//Properties
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Constraint> getConstraints() {
		return constraints;
	}
	public void setConstraints(List<Constraint> constraints) {
		this.constraints = constraints;
	}

}
