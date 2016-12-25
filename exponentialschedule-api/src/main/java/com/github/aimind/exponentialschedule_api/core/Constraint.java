package com.github.aimind.exponentialschedule_api.core;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.github.aimind.exponentialschedule_api.enums.ConstraintTypeEnum;

@XmlType(name="Constraint")
public class Constraint {
	
	//Attributes
	private int priority;
	private int value;
	private ConstraintTypeEnum type;
	
	//Properties
	public int getPriority() {
		return priority;
	}
	@XmlElement(name="constraintPriority")
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public int getValue() {
		return value;
	}
	@XmlElement(name="value")
	public void setValue(int value) {
		this.value = value;
	}
	public ConstraintTypeEnum getType() {
		return type;
	}
	@XmlElement(name="constraintType")
	public void setType(ConstraintTypeEnum type) {
		this.type = type;
	}
	
	/**
	 * Constructor
	 * @param priority of the constraint
	 * @param value of the constraint (the number of hours, etc.)
	 * @param type of the constraint (max number of hours, min number of hours, etc.)
	 */
	public Constraint(int priority, int value, ConstraintTypeEnum type){
		this.priority = priority;
		this.value = value;
		this.type = type;
	}

	public Constraint(){}
	
}
