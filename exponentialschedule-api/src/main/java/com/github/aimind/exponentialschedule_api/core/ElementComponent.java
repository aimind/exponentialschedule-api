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
	public int getId() {
		return id;
	}
	@XmlElement(name="id")
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	@XmlElement(name="name")
	public void setName(String name) {
		this.name = name;
	}
	public List<Constraint> getConstraints() {
		return constraints;
	}
	@XmlElement(name="constraints")
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
	
	public ElementComponent(){}

}
