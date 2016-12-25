package com.github.aimind.exponentialschedule_api.core;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="Individual")
public class Schedule {

	//Attributes
	private List<HourElement> hours;
	private double rate;
	
	//Properties
	public List<HourElement> getHours() {
		return hours;
	}
	@XmlElement(name="genotype")
	public void setHours(List<HourElement> hours) {
		this.hours = hours;
	}
	
	public double getRate() {
		return rate;
	}
	@XmlElement(name="phenotype")
	public void setRate(double rate) {
		this.rate = rate;
	}
	
	
	public Schedule(){}
	
}
