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
	@XmlElement(name="genotype")
	public List<HourElement> getHours() {
		return hours;
	}
	public void setHours(List<HourElement> hours) {
		this.hours = hours;
	}
	
	@XmlElement(name="phenotype")
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	
	
	
}
