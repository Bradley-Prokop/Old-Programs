/*
 * Created on 10/26/22
 * Class IT 168
 */

package edu.ilstu;

/**
 * Class containing methods for calculating max number of refills based on the drug type, getters for Rx number and CVS branch
 * toString method to print out the information formatted, a refill method to keep track of home many refills have been requested, 
 * a transfer method that sets the new location of the CVS, an equals method to compare the RX numbers for equality, a constructor 
 * with the parameters of Rx number, which branch it is, drug name and drug type.
 * 
 * @author Bradley Prokop
 */
public class PrescriptionOrder 
{
	private String rxNumber;
	private String branch;
	private String drugName;
	private String drugType;
	private int maxRefills;
	private int numRefillAlreadyRequested;
	static int refillCount;
	
	/**
	 * Constructor for prescriptions
	 * @param numberRX
	 * @param branchCVS
	 * @param drugName
	 * @param drugType
	 */
	public PrescriptionOrder(String rxNumber, String branch, String drugName, String drugType){
		
		if (drugType.equalsIgnoreCase("vaccine")||drugType.equalsIgnoreCase("antibiotic")||drugType.equalsIgnoreCase("maintenance")||drugType.equalsIgnoreCase("supplement")){
			
			this.rxNumber=rxNumber;
			this.branch=branch;
			this.drugName=drugName;
			this.drugType=drugType;
			this.numRefillAlreadyRequested=0;
			this.maxRefills=calcMaximumRefills(this.drugType);
		}
		else {
			this.rxNumber=rxNumber;
			this.branch=branch;
			this.drugName=drugName;
			this.drugType=drugType;
			this.numRefillAlreadyRequested=0;
			this.maxRefills=calcMaximumRefills(this.drugType);
		}
	}
	
	/**
	 * Returns the prescription number
	 * 
	 * @return numberRX
	 */
	public String getNumberRX(){
		return this.rxNumber;
	}
	
	/**
	 * Returns the CVS branch
	 * 
	 * @return branchCVS
	 */
	public String getBranchCVS(){
		return this.branch;
	}
	
	/**
	 * Returns a formatted string with all the prescription information
	 * 
	 * @return format
	 */
	public String toString(){
		String format = this.rxNumber + "\t\t" + this.drugName + "\t" + this.branch + "\t" + getRefillsAvaliable();
		return format;
	}
	
	/**
	 * Returns how many refills are available 
	 * 
	 * @return refillsAvaliable
	 */
	public int getRefillsAvaliable(){
		
		int refillsAvaliable;
		return refillsAvaliable = maxRefills - numRefillAlreadyRequested;
	}
	
	/**
	 * If eligible for a refill, refills already requested is incremented
	 * by 1 and returns true, otherwise if not eligible returns false
	 * 
	 * @return true or false
	 */
	public boolean refill(){
		
		if (drugType.equalsIgnoreCase("Vaccine"))
			return false;
		else if(drugType.equalsIgnoreCase("Antibiotic")){
			
			if(getRefillsAvaliable()>0){
				numRefillAlreadyRequested++;
				refillCount++;
				return true;
			}
			else 
				return false;
		}
		else if (drugType.equalsIgnoreCase("Maintenance")){
			if(getRefillsAvaliable()>0){
				numRefillAlreadyRequested++;
				refillCount++;
				return true;
			}
			else 
				return false;
		}
		else if (drugType.equalsIgnoreCase("Supplement")){			
			if(getRefillsAvaliable()>0){
				numRefillAlreadyRequested++;
				refillCount++;
				return true;
			}
			else 
				return false;
		}
		else
			return false;
	}
	
	/**
	 * Changes the location of the CVS
	 * 
	 * @param branchCVS
	 */
	public void transfer(String branch){
		this.branch = branch;
	}
	
	/**
	 * Compares the Rx numbers of each object and determines if they are equal
	 * 
	 * @param rx
	 * @return true or false
	 */
	public boolean equals(String rx){
		return this.rxNumber.equals(rx);
	}
	
	/**
	 * Sets max refills based on the drug type
	 * 
	 * @param drugType
	 */
	private int calcMaximumRefills(String drugType){
		
		if (drugType.equalsIgnoreCase("Vaccine")){
			this.maxRefills=0;
			return 0;
		}
		else if(drugType.equalsIgnoreCase("Antibiotic")){
			this.maxRefills=1;
			return 1;
		}
		else if (drugType.equalsIgnoreCase("Maintenance")){
			this.maxRefills=2;
			return 2;
		}
		else if (drugType.equalsIgnoreCase("Supplement")){
			this.maxRefills=5;
			return 5;
		}
		else{
			this.maxRefills=0;
			return 0;
		}
	}
}
