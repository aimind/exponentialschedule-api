package com.github.aimind.exponentialschedule_api.core;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlType(name="Gene")
public class HourElement {

	//Attributes
	private int id;
	private String name;
	private List<ElementComponent> components;
	
	//Properties
	@XmlElement(name="templateId")
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
	
	@XmlElement(name="components")
	public List<ElementComponent> getComponents() {
		return components;
	}
	public void setComponents(List<ElementComponent> components) {
		this.components = components;
	}
	
	/**
	 * Adds a component to the element component list
	 * @param component
	 */
	public void addComponent(ElementComponent component){
		this.components.add(component);
	}
	
	/**
	 * Constructor
	 * @param id of the component
	 * @param name of the component
	 */
	public HourElement(int id, String name){
		this.id = id;
		this.name = name;
		this.components = new ArrayList<ElementComponent>();
	}
	
}
