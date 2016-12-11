package com.github.aimind.exponentialschedule_api.core;

import java.util.List;

public class HourElement {

	//Attributes
	private int id;
	private String name;
	private List<ElementComponent> components;
	
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
	public List<ElementComponent> getComponents() {
		return components;
	}
	public void setComponents(List<ElementComponent> components) {
		this.components = components;
	}
	
}
