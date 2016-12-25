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
	public int getId() {
		return id;
	}
	@XmlElement(name="templateId")
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
	public List<ElementComponent> getComponents() {
		return components;
	}
	@XmlElement(name="components")
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
	
	public HourElement(){}
	
}
