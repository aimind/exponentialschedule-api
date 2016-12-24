package exponentialschedule.webservices.interfaces;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.github.aimind.exponentialschedule_api.core.*;

@XmlRootElement
@XmlType(name="Output")
public class Output {

	//Attributes
	private int transactionId;
	private List<Schedule> bestSchedules;
	private List<Integer> executionNumber;
	private List<Integer> executionTime;
	private List<String> exceptions;
	
	//Properties
	@XmlElement(name="transactionId")
	public int getTransactionId() {
		return transactionId;
	}
	
	@XmlElement(name="bestIndividuals")
	public List<Schedule> getBestSchedules() {
		return bestSchedules;
	}
	
	@XmlElement(name="individualRun")
	public List<Integer> getExecutionNumber() {
		return executionNumber;
	}
	
	@XmlElement(name="runTime")
	public List<Integer> getExecutionTime() {
		return executionTime;
	}
	
	@XmlElement(name="exceptions")
	public List<String> getExceptions() {
		return exceptions;
	}	
	
	
	public Output(){}
	
}
