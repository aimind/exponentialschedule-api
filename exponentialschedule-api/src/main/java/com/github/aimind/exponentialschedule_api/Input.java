package com.github.aimind.exponentialschedule_api;

import com.github.aimind.exponentialschedule_api.core.*;
import java.util.List;

public class Input {

	//Attributes
	private String url;
	private String user;
	private String password;
	private String iv;
	private int maxConstraintPriorityValue;
	private int numberOfSolutions;
	private List<Integer> hoursDistribution;
	private List<HourElement> hourElements; 
	
	
	//Properties
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIv() {
		return iv;
	}
	public void setIv(String iv) {
		this.iv = iv;
	}
	public int getMaxConstraintPriorityValue() {
		return maxConstraintPriorityValue;
	}
	public void setMaxConstraintPriorityValue(int maxConstraintPriorityValue) {
		this.maxConstraintPriorityValue = maxConstraintPriorityValue;
	}
	public int getNumberOfSolutions() {
		return numberOfSolutions;
	}
	public void setNumberOfSolutions(int numberOfSolutions) {
		this.numberOfSolutions = numberOfSolutions;
	}
	public List<Integer> getHoursDistribution() {
		return hoursDistribution;
	}
	public void setHoursDistribution(List<Integer> hoursDistribution) {
		this.hoursDistribution = hoursDistribution;
	}
	public List<HourElement> getHourElements(){
		return hourElements;
	}
	public void setHourElements(List<HourElement> hourElements){
		this.hourElements = hourElements;
	}
	
	
	
	/**
	 * Function to calculate the total number of hours in base of the distribution
	 * @return total number of hours
	 */
	private int NumberOfHoursCalculation(){
		
		int numberOfHours = 0;
		
		for(int hours : this.hoursDistribution){
			numberOfHours += hours;
		}
		
		return numberOfHours;
	}
	
	
	
	
}
