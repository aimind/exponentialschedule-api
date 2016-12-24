package com.github.aimind.exponentialschedule_api.core;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="GeneComponent")
public class ElementComponent {
	
	//Attributes
	private int id;
	private String name;
	private List<Constraint> constraints;
	
	//Properties
	@XmlElement(name="id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@XmlElement(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement(name="constraints")
	public List<Constraint> getConstraints() {
		return constraints;
	}
	public void setConstraints(List<Constraint> constraints) {
		this.constraints = constraints;
	}
	
	/**
	 * Adds a constraint to the list
	 * @param constraint
	 */
	public void addConstraint(Constraint constraint){
		this.constraints.add(constraint);
	}
	
	
	/**
	 * Constructor
	 * @param id of the element
	 * @param name of the element
	 */
	public ElementComponent(int id, String name){
		this.id = id;
		this.name = name;
		this.constraints = new ArrayList<Constraint>();
	}

}
