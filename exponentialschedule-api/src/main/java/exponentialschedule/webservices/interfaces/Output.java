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
	@XmlElement(name="transactionId")
	private int transactionId;
	@XmlElement(name="bestIndividuals")
	private List<Schedule> bestSchedules;
	@XmlElement(name="individualRun")
	private List<Integer> executionNumber;
	@XmlElement(name="runTime")
	private List<Integer> executionTime;
	@XmlElement(name="exceptions")
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
	
	
	public Output(){}
	
}
