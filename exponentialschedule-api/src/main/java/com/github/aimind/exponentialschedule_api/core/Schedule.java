package com.github.aimind.exponentialschedule_api.core;

import java.util.List;

public class Schedule {

	//Attributes
	private List<HourElement> hours;
	private double rate;
	
	//Properties
	public List<HourElement> getHours() {
		return hours;
	}
	public void setHours(List<HourElement> hours) {
		this.hours = hours;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	
	
	
}
