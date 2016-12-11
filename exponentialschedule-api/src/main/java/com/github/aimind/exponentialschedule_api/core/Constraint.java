package com.github.aimind.exponentialschedule_api.core;

import com.github.aimind.exponentialschedule_api.enums.ConstraintTypeEnum;

public class Constraint {
	
	//Attributes
	private int priority;
	private int value;
	private ConstraintTypeEnum type;
	
	//Properties
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public ConstraintTypeEnum getType() {
		return type;
	}
	public void setType(ConstraintTypeEnum type) {
		this.type = type;
	}

}
