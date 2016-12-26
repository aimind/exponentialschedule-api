package exponentialschedule.webservices.interfaces;

import com.github.aimind.exponentialschedule_api.core.*;
import com.github.aimind.exponentialschedule_api.services.*;

import exponentialschedule.webservices.*;

import java.net.URL;
import javax.xml.ws.Service;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;

@XmlRootElement
@XmlType(name="Input")
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
	@XmlElement(name="user")
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getPassword() {
		return password;
	}
	@XmlElement(name="password")
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getIv() {
		return iv;
	}
	@XmlElement(name="iv")
	public void setIv(String iv) {
		this.iv = iv;
	}
	
	public int getMaxConstraintPriorityValue() {
		return maxConstraintPriorityValue;
	}
	@XmlElement(name="maxPriorityValue")
	public void setMaxConstraintPriorityValue(int maxConstraintPriorityValue) {
		this.maxConstraintPriorityValue = maxConstraintPriorityValue;
	}
	
	public int getNumberOfHours(){
		return numberOfHours;
	}
	@XmlElement(name="numberOfGenes")
	public void setNumberOfHours(int numberOfHours){
		this.numberOfHours = numberOfHours;
	}
	
	public int getNumberOfSolutions() {
		return numberOfSolutions;
	}
	@XmlElement(name="numberOfSolutions")
	public void setNumberOfSolutions(int numberOfSolutions) {
		this.numberOfSolutions = numberOfSolutions;
	}
	
	public List<Integer> getHoursDistribution() {
		return hoursDistribution;
	}
	@XmlElement(name="genesDistribution")
	public void setHoursDistribution(List<Integer> hoursDistribution) {
		this.hoursDistribution = hoursDistribution;
	}
	public List<HourElement> getHourElements(){
		return hourElements;
	}
	@XmlElement(name="templateGenes")
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
	
	public Input(){}
	
	/**
	 * Constructor
	 * @param url of the web service
	 * @param user of the web service
	 * @param password of the web service
	 * @param passphrase of the user
	 * @param maxPriorityValue the maximum priority value of the constraints
	 * @param numberOfSolutions number of solutions to be returned
	 * @throws Exception 
	 */
	public Input(String url, String user, String password, String passphrase, int maxPriorityValue, int numberOfSolutions) throws Exception{
		
		//Initializing the list attributes
		this.hourElements = new ArrayList<HourElement>();
		this.hoursDistribution = new ArrayList<Integer>();
		
		//Setting the attributes
		this.url = url;
		this.user = user;
		this.maxConstraintPriorityValue = maxPriorityValue;
		this.numberOfSolutions = numberOfSolutions;
		
		//Encrypt the password
		List<String> security = new ArrayList<String>();
		try {
			
			security = SecurityService.encryptAESMessage(password, passphrase);
			
			//Sets the password encrypted and the iv
			this.password = security.get(0);
			this.iv = security.get(1);
			
		} catch (Exception e) {
			throw e;
		}
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
		
		//Creating the soap client
		URL url = new URL(this.url + "?wsdl");
		QName qname = new QName("http://webservices.exponentialschedule/", "ExponentialScheduleWSService");
		Service service = Service.create(url, qname);
		ExponentialScheduleWS exponentialScheduleWS = service.getPort(ExponentialScheduleWS.class);
		
		//Calling the service
		output = exponentialScheduleWS.GenerateNewSchedule(this);
		
		return output;
	}
	
	
}
