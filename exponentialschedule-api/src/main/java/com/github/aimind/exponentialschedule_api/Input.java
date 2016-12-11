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
	private int numberOfHours;
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
	 * Adds a number of hours in the distribution
	 * @param hours to add in the distribution
	 */
	public void addHourDistribution(int hours){
		this.hoursDistribution.add(hours);
	}
	
	/**
	 * Adds an hour element in the list of elements
	 * @param hourElement
	 */
	public void addHourElement(HourElement hourElement){
		this.hourElements.add(hourElement);
	}
	
	/**
	 * Constructor
	 * @param url of the web service
	 * @param user of the web service
	 * @param password of the web service
	 * @param iv of the user
	 * @param maxPriorityValue the maximum priority value of the constraints
	 * @param numberOfSolutions number of solutions to be returned
	 */
	public Input(String url, String user, String password, String iv, int maxPriorityValue, int numberOfSolutions){
		
		//Setting the attributes
		this.url = url;
		this.user = user;
		this.password = password;
		this.iv = iv;
		this.maxConstraintPriorityValue = maxPriorityValue;
		this.numberOfSolutions = numberOfSolutions;
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
	
	
	/**
	 * Function to generate the schedule via the web service
	 * @return the web service output
	 * @throws Exception 
	 */
	public Output GenerateSchedule() throws Exception{
		
		//Creates a new output
		Output output = new Output();
		
		//Calculates the number of hours
		this.numberOfHours = this.NumberOfHoursCalculation();
		
		//Checking the mandatory elements
		if(this.numberOfHours < 1 || this.hourElements.size() < 1){
			throw new Exception("The hours distribution and the hour elements are mandatory");
		}
		
		//Checking the mandatory values
		if(this.maxConstraintPriorityValue < 1 || this.numberOfSolutions < 1){
			throw new Exception("The maxConstraintPriorityValue and the numberOfSolutions must be greater than 0");
		}
		
		
		return output;
	}
	
	
}
