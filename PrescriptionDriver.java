/*
 * Created on 10/26/22
 * Class IT 168
 */
package edu.ilstu;
import java.util.Scanner;

/**
 * Class to allow users to list all available prescription orders, refill a prescription, transfer a prescription to another CVS
 * and a option to quit when done. 
 * 
 * @author Bradley Prokop
 */
public class PrescriptionDriver 
{
	static Scanner sc = new Scanner(System.in);
	static PrescriptionOrder p1;
	static PrescriptionOrder p2;
	static PrescriptionOrder p3; 
	
	/**
	 * Main method to allow user to run the applications and complete refills, transfer to another branch, 
	 * list the inventory, or quit the program
	 * @param args
	 */
	public static void main(String[] args) 
	{
		//Welcome user
		System.out.println("Welcome to CVS!");
		
		//Calls the createPrescriptions method to populate the inventory 
		createPrescriptions(); 
		
		//Displays menu and prompts the user for input 
		displayMenu();  
		
		//Read in user input
		String choice = sc.next();
		
		//Validates user input
		while (!(choice.equalsIgnoreCase("q")||choice.equalsIgnoreCase("l")||choice.equalsIgnoreCase("t")||choice.equalsIgnoreCase("r"))){
			System.out.println("Invalid choice, please try again");
			System.out.print("Enter your choice: ");
			choice = sc.next();
		}
		
		//While loop to keep running until sentinel value Q or q is entered.
		while (!(choice.equalsIgnoreCase("q")))
		{
			switch(choice){
			case "l":
			case "L":
				listInventory();
				break;
			case "r":
			case "R":
				refill();
				break;
			default:
				transfer();
				break;
			}
			
			//Spacing to make output easier to read
			System.out.println("\n");
			
			//Reprints menu
			displayMenu();
			//Reads in next choice
			choice = sc.next();
			
			//Validates user input
			while (!(choice.equalsIgnoreCase("q")||choice.equalsIgnoreCase("l")||choice.equalsIgnoreCase("t")||choice.equalsIgnoreCase("r"))){
				System.out.println("\nInvalid choice, please try again");
				System.out.print("Enter your choice: ");
				choice = sc.next();
			}
		}
		//Lists amount of refills and tells user goodbye
		System.out.println("\nYou have completed " + PrescriptionOrder.refillCount + " refills" + "\nGoodbye");
		
		//close Scanner
		sc.close();
	}
	
	/**
	 * Displays the menu of options for the user and prompts user
	 */
	public static void displayMenu(){
		System.out.println("Please choose one of the following: ");
		System.out.println("L - List all available prescriptions");
		System.out.println("R - Refill a prescription");
		System.out.println("T - Transfer a prescription");
		System.out.println("Q - Quit");
		System.out.print("Enter your choice: ");
	}
	
	/**
	 * Populates the inventory with 3 prescriptions
	 */
	public static void createPrescriptions(){
		p1 = new PrescriptionOrder("1320335", "CVS-Peoria", "AMOXICILLIN 500MG CAPSULE", "Antibiotic");
		p2 = new PrescriptionOrder("5304689", "CVS-Bloomington", "VITAMIN D2 1.25MG CAPSULE", "X");
		p3 = new PrescriptionOrder("4692854", "CVS-Normal", "ATORVASTATIN 20 MG CAPSULE", "Maintenance");
	}
	
	/**
	 * Prints out the Inventory
	 */
	public static void listInventory(){
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
	}
	
	/**
	 * Asks user for the rx number then finds the matching prescription and calculates if a refill is possible, if refill request is valid
	 * it will notify user that refill is successful otherwise a max refills message is displayed
	 * 
	 */
	public static void refill(){
		System.out.print("Enter a prescription number: ");
		String rxNumber = sc.next();
		
		while(!(findPrescription(rxNumber)==p1||findPrescription(rxNumber)==p2||findPrescription(rxNumber)==p3)){
		System.out.println("Sorry this is an invalid prescription number.");
		System.out.print("Enter a prescription number: ");
		rxNumber = sc.next();
		}
		
		if(findPrescription(rxNumber).equals(p1)){
			if(p1.refill()==true)
				System.out.println("Refill successful");
			else
				System.out.println("You have reached the maximum number of refills for this order");
		}
		else if (findPrescription(rxNumber).equals(p2)){
			if(p2.refill()==true)
				System.out.println("Refill successful");
			else
				System.out.println("You have reached the maximum number of refills for this order");
		}
		else if(findPrescription(rxNumber).equals(p3)){
			if(p3.refill()==true)
				System.out.println("Refill successful");
			else
				System.out.println("You have reached the maximum number of refills for this order");
		}
		else 
			System.out.println("Error, prescription does not exist!");
	}
	
	/**
	 * Method to transfer a prescription to a different branch
	 */
	public static void transfer(){
		System.out.print("Enter a prescription number: ");
		String rxNumber = sc.next();
		
		while(!(findPrescription(rxNumber)==p1||findPrescription(rxNumber)==p2||findPrescription(rxNumber)==p3)){
		System.out.println("Sorry this is an invalid prescription number.");
		System.out.print("Enter a prescription number: ");
		rxNumber = sc.next();
		}
		
		System.out.println("Choose the branch you are transferring to: ");
		System.out.println("1 - CVS-Peoria");
		System.out.println("2 - CVS-Bloomington");
		System.out.println("3 - CVS-Normal");
		System.out.print("Enter your choice:");
		String newBranch = sc.next();
		
		while (!(newBranch.equalsIgnoreCase("1")||newBranch.equalsIgnoreCase("2")||newBranch.equalsIgnoreCase("3"))){
			System.out.println("Invalid choice! Please choose a number between 1 and 3!");
			System.out.print("Enter your choice:");
			newBranch = sc.next();
		}
		
		if (findPrescription(rxNumber).equals(p1)){
			if(newBranch.equalsIgnoreCase("1")){
				p1.transfer("CVS-Peoria");
				System.out.println("transfer successful");
			}
			else if (newBranch.equalsIgnoreCase("2")){
				p1.transfer("CVS-Bloomington");
				System.out.println("transfer successful");
			}
			else{
				p1.transfer("CVS-Normal");
				System.out.println("transfer successful");
			}
		}
		else if (findPrescription(rxNumber).equals(p2)){
			if(newBranch.equalsIgnoreCase("1")){
				p2.transfer("CVS-Peoria");
				System.out.println("transfer successful");
			}
			else if (newBranch.equalsIgnoreCase("2")){
				p2.transfer("CVS-Bloomington");
				System.out.println("transfer successful");
			}
			else {
				p2.transfer("CVS-Normal");
				System.out.println("transfer successful");
			}
		}
		else {
			if(newBranch.equalsIgnoreCase("1")){
				p3.transfer("CVS-Peoria");
				System.out.println("transfer successful");
			}
			else if (newBranch.equalsIgnoreCase("2")){
				p3.transfer("CVS-Bloomington");
				System.out.println("transfer successful");
			}
			else{
				p3.transfer("CVS-Normal");
				System.out.println("transfer successful");
			}
		}
	}
	
	/**
	 * Compares prescription number to test for equality and if true it returns
	 * the prescription with the same rx number otherwise error message is displayed
	 * 
	 * @param rxNumber
	 */
	public static PrescriptionOrder findPrescription(String rxNumber){
		if(p1.equals(rxNumber))
			return p1;
		else if (p2.equals(rxNumber))
			return p2;
		else if (p3.equals(rxNumber))
			return p3;
		else 
			return null;
	}

}
