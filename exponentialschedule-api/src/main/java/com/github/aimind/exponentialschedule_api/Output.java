package com.github.aimind.exponentialschedule_api;

import java.util.List;

import com.github.aimind.exponentialschedule_api.core.*;

public class Output {

	//Attributes
	private int transactionId;
	private List<Schedule> bestSchedules;
	private List<Integer> executionNumber;
	private List<Integer> executionTime;
	private List<String> exceptions;
	
	//Properties
	public int getTransactionId() {
		return transactionId;
	}
	public List<Schedule> getBestSchedules() {
		return bestSchedules;
	}
	public List<Integer> getExecutionNumber() {
		return executionNumber;
	}
	public List<Integer> getExecutionTime() {
		return executionTime;
	}
	public List<String> getExceptions() {
		return exceptions;
	}	
	
}
