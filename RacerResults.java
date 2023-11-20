/**
 * Date: 9/19/22
 * Class IT 168
 */
package edu.ilstu;

import java.util.Random;
import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Race program to calculate payout for racers and is determined by total laps. 
 * @author Bradley Prokop 
 */
public class RacerResults {
	
		//Create race entry fee (not used)
		static final double ENTRY_FEE = 100.00;
		
		//Create constant for amount won per lap 
		static final double WINNINGS_PER_LAP = 22.00;
		
		//Create 50 mile bonus constant
		static final double BONUS_PER_MILE = 12.00;
		
		//Create constant for miles per lap
		static final double MILES_PER_LAP = 8.50;

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
	
	//create an instance for Scanner
	Scanner scan = new Scanner(System.in);
	
	//create an instance for Random
	Random rand = new Random();
	
	//Create an instance for number format 
	NumberFormat numForm = NumberFormat.getCurrencyInstance(Locale.US);
	//To get commas every 3 digits 
	numForm.setGroupingUsed(true);
	//To get no more than 2 decimal places
	numForm.setMaximumFractionDigits(2);
	//To get no less than 2 decimal places
	numForm.setMinimumFractionDigits(2);
	
	//create 3 random number variables for each racer
	int randNum1 = rand.nextInt(5000) + 1;
	int randNum2 = rand.nextInt(5000) + 1;
	int randNum3 = rand.nextInt(5000) + 1;
	
	//
		
	//Welcome user to the race
	System.out.println("Welcome to the Lone Survivor Endurance Race!");
	
	//
	
	//Prompt and get input for user first name 
	System.out.print("\nPlease enter the racer's first name: ");
	String fNRacer1 = scan.next();
	
	//Prompt and get input for user last name 
	System.out.print("Please enter the racer's last name: ");
	String lNRacer1 = scan.next();
	
	//Prompt and get input for user number of laps completed
	System.out.print("Please enter the number of laps completed: ");
	int numOfLapsRacer1 = scan.nextInt();
	
	//Get racers 1 full name into a single variable 
	String racer1FullName = fNRacer1 + " " + lNRacer1;
	
	//Prompt and get input for user first name 
	System.out.print("\nPlease enter the racer's first name: ");
	String fNRacer2 = scan.next();
		
	//Prompt and get input for user last name 
	System.out.print("Please enter the racer's last name: ");
	String lNRacer2 = scan.next();
		
	//Prompt and get input for user number of laps completed
	System.out.print("Please enter the number of laps completed: ");
	int numOfLapsRacer2 = scan.nextInt();
	
	//Get racers 2 full name into a single variable 
	String racer2FullName = fNRacer2 + " " + lNRacer2;
	
	//Prompt and get input for user first name 
	System.out.print("\nPlease enter the racer's first name: ");
	String fNRacer3 = scan.next();
			
	//Prompt and get input for user last name 
	System.out.print("Please enter the racer's last name: ");
	String lNRacer3 = scan.next();
			
	//Prompt and get input for user number of laps completed
	System.out.print("Please enter the number of laps completed: ");
	int numOfLapsRacer3 = scan.nextInt();
	
	//Get racers 3 full name into a single variable 
	String racer3FullName = fNRacer3 + " " + lNRacer3;
	
	//Create the calculation for miles for each racer 
	double miles1 = numOfLapsRacer1 * MILES_PER_LAP;
	double miles2 = numOfLapsRacer2 * MILES_PER_LAP;
	double miles3 = numOfLapsRacer3 * MILES_PER_LAP;
	
	//Create base winnings for each racer
	double baseWinningsR1 = numOfLapsRacer1 * WINNINGS_PER_LAP;
	double baseWinningsR2 = numOfLapsRacer2 * WINNINGS_PER_LAP;
	double baseWinningsR3 = numOfLapsRacer3 * WINNINGS_PER_LAP;
	
	//Create the total for miles and base winnings
	double totalMiles = miles1 + miles2 + miles3;
	double totalBaseWinnings = baseWinningsR1 + baseWinningsR2 + baseWinningsR3;
	
	//Prints out the label 
	System.out.println("\nLone Survivor Endurance Race Results\n");
	System.out.println("bib#  \tName\t\tLaps\tMiles\tBase Winnings\tBonus\t\tNet winnings ");
	System.out.println("------------------------------------------------------------------------------------");
	
		//If statement to first calculate the bonus, net winnings, and grand totals
		if ((miles1 > 50) && (miles2 > 50) && (miles3 > 50))
		{
			//Racer 1 
			double milesOver1 = miles1 - 50.00;
			double bonus = milesOver1 * BONUS_PER_MILE;
			double netWinningsR1 = baseWinningsR1 + bonus;
			//Print statement for bonus
			System.out.println(randNum1 + "\t" + racer1FullName.toLowerCase() + "\t" + numOfLapsRacer1 + "\t" + miles1 + "\t" + numForm.format(baseWinningsR1) + "\t" + "\t" + numForm.format(bonus) + "\t\t" + numForm.format(netWinningsR1) + "\n");	
			//Racer 2
			double milesOver2 = miles2 - 50.00;
			double bonus2 = milesOver2 * BONUS_PER_MILE;
			double netWinningsR2 = baseWinningsR2 + bonus2;	
			System.out.println(randNum2 + "\t" + racer2FullName.toLowerCase() + "\t" + numOfLapsRacer2 + "\t" + miles2 + "\t" + numForm.format(baseWinningsR2) + "\t" + "\t" + numForm.format(bonus2) + "\t\t" + numForm.format(netWinningsR2) + "\n");    
			//Racer3
			double milesOver3 = miles3 - 50.00;
			double bonus3 = milesOver3 * BONUS_PER_MILE;
			double netWinningsR3 = baseWinningsR3 + bonus3;
			System.out.println(randNum3 + "\t" + racer3FullName.toLowerCase() + "\t" + numOfLapsRacer3 + "\t" + miles3 + "\t" + numForm.format(baseWinningsR3) + "\t" + "\t" + numForm.format(bonus3) + "\t\t" + numForm.format(netWinningsR3) + "\n");    
			//Grand totals
			double totalBonusWinnings = bonus + bonus2 + bonus3;
			double totalNetWinnings = netWinningsR1 + netWinningsR2 + netWinningsR3;
			System.out.println("Total Miles Covered: " + "\t" + totalMiles);
			System.out.println("Total Base Winnings: " + "\t" + numForm.format(totalBaseWinnings));
			System.out.println("Total Bonus Winnings: " + "\t" + numForm.format(totalBonusWinnings));
			System.out.println("Total Net Winnings: " + "\t" + numForm.format(totalNetWinnings));
		}
		else if ((miles1 < 50) && (miles2 > 50) && (miles3 > 50))
		{
			//Racer 1
			double bonus = 0.00;
			double netWinningsR1 = baseWinningsR1;
			//Print statement for no bonus
			System.out.println(randNum1 + "\t" + racer1FullName.toLowerCase() + "\t" + numOfLapsRacer1 + "\t" + miles1 + "\t" + numForm.format(baseWinningsR1) + "\t" + "\t" + numForm.format(bonus) + "\t\t" + numForm.format(netWinningsR1) + "\n");   
			//Racer 2
			double milesOver2 = miles2 - 50.00;
			double bonus2 = milesOver2 * BONUS_PER_MILE;
			double netWinningsR2 = baseWinningsR2 + bonus2;	
			System.out.println(randNum2 + "\t" + racer2FullName.toLowerCase() + "\t" + numOfLapsRacer2 + "\t" + miles2 + "\t" + numForm.format(baseWinningsR2) + "\t" + "\t" + numForm.format(bonus2) + "\t\t" + numForm.format(netWinningsR2) + "\n");    
			//Racer 3    
			double milesOver3 = miles3 - 50.00;
			double bonus3 = milesOver3 * BONUS_PER_MILE;
			double netWinningsR3 = baseWinningsR3 + bonus3;
			System.out.println(randNum3 + "\t" + racer3FullName.toLowerCase() + "\t" + numOfLapsRacer3 + "\t" + miles3 + "\t" + numForm.format(baseWinningsR3) + "\t" + "\t" + numForm.format(bonus3) + "\t\t" + numForm.format(netWinningsR3) + "\n");    
			//Grand totals
			double totalBonusWinnings = bonus + bonus2 + bonus3;
			double totalNetWinnings = netWinningsR1 + netWinningsR2 + netWinningsR3;
			System.out.println("Total Miles Covered: " + "\t" + totalMiles);
			System.out.println("Total Base Winnings: " + "\t" + numForm.format(totalBaseWinnings));
			System.out.println("Total Bonus Winnings: " + "\t" + numForm.format(totalBonusWinnings));
			System.out.println("Total Net Winnings: " + "\t" + numForm.format(totalNetWinnings));
		}
		else if ((miles1 < 50) && (miles2 < 50) && (miles3 > 50))
		{
			//Racer 1
			double bonus = 0.00;
			double netWinningsR1 = baseWinningsR1;
			System.out.println(randNum1 + "\t" + racer1FullName.toLowerCase() + "\t" + numOfLapsRacer1 + "\t" + miles1 + "\t" + numForm.format(baseWinningsR1) + "\t" + "\t" + numForm.format(bonus) + "\t\t" + numForm.format(netWinningsR1) + "\n");
			//Racer 2
			double bonus2 = 0.00;
			double netWinningsR2 = baseWinningsR2;	
			System.out.println(randNum2 + "\t" + racer2FullName.toLowerCase() + "\t" + numOfLapsRacer2 + "\t" + miles2 + "\t" + numForm.format(baseWinningsR2) + "\t" + "\t" + numForm.format(bonus2) + "\t\t" + numForm.format(netWinningsR2) + "\n");   
			//Racer 3
			double milesOver3 = miles3 - 50.00;
			double bonus3 = milesOver3 * BONUS_PER_MILE;
			double netWinningsR3 = baseWinningsR3 + bonus3;
			System.out.println(randNum3 + "\t" + racer3FullName.toLowerCase() + "\t" + numOfLapsRacer3 + "\t" + miles3 + "\t" + numForm.format(baseWinningsR3) + "\t" + "\t" + numForm.format(bonus3) + "\t\t" + numForm.format(netWinningsR3) + "\n");
			//Grand totals
			double totalBonusWinnings = bonus + bonus2 + bonus3;
			double totalNetWinnings = netWinningsR1 + netWinningsR2 + netWinningsR3;
			System.out.println("Total Miles Covered: " + "\t" + totalMiles);
			System.out.println("Total Base Winnings: " + "\t" + numForm.format(totalBaseWinnings));
			System.out.println("Total Bonus Winnings: " + "\t" + numForm.format(totalBonusWinnings));
			System.out.println("Total Net Winnings: " + "\t" + numForm.format(totalNetWinnings));
		}
		else if ((miles1 > 50) && (miles2 < 50) && (miles3 < 50))
		{
			//Racer 1
			double milesOver1 = miles1 - 50.00;
			double bonus = milesOver1 * BONUS_PER_MILE;
			double netWinningsR1 = baseWinningsR1 + bonus;
			System.out.println(randNum1 + "\t" + racer1FullName.toLowerCase() + "\t" + numOfLapsRacer1 + "\t" + miles1 + "\t" + numForm.format(baseWinningsR1) + "\t" + "\t" + numForm.format(bonus) + "\t\t" + numForm.format(netWinningsR1) + "\n");
			//Racer 2
		    double bonus2 = 0.00;
			double netWinningsR2 = baseWinningsR2;	
			System.out.println(randNum2 + "\t" + racer2FullName.toLowerCase() + "\t" + numOfLapsRacer2 + "\t" + miles2 + "\t" + numForm.format(baseWinningsR2) + "\t" + "\t" + numForm.format(bonus2) + "\t\t" + numForm.format(netWinningsR2) + "\n");
		    //Racer 3
		    double bonus3 = 0.00;
			double netWinningsR3 = baseWinningsR3;
			System.out.println(randNum3 + "\t" + racer3FullName.toLowerCase() + "\t" + numOfLapsRacer3 + "\t" + miles3 + "\t" + numForm.format(baseWinningsR3) + "\t" + "\t" + numForm.format(bonus3) + "\t\t" + numForm.format(netWinningsR3) + "\n");
			//Grand totals
			double totalBonusWinnings = bonus + bonus2 + bonus3;
			double totalNetWinnings = netWinningsR1 + netWinningsR2 + netWinningsR3;
			System.out.println("Total Miles Covered: " + "\t" + totalMiles);
			System.out.println("Total Base Winnings: " + "\t" + numForm.format(totalBaseWinnings));
			System.out.println("Total Bonus Winnings: " + "\t" + numForm.format(totalBonusWinnings));
			System.out.println("Total Net Winnings: " + "\t" + numForm.format(totalNetWinnings));
		}
		else if ((miles1 < 50) && (miles2 > 50) && (miles3 < 50))
		{
			//Racer 1
			double bonus = 0.00;
			double netWinningsR1 = baseWinningsR1;
			System.out.println(randNum1 + "\t" + racer1FullName.toLowerCase() + "\t" + numOfLapsRacer1 + "\t" + miles1 + "\t" + numForm.format(baseWinningsR1) + "\t" + "\t" + numForm.format(bonus) + "\t\t" + numForm.format(netWinningsR1) + "\n");
			//Racer 2
			double milesOver2 = miles2 - 50.00;
			double bonus2 = milesOver2 * BONUS_PER_MILE;
			double netWinningsR2 = baseWinningsR2 + bonus2;	
			System.out.println(randNum2 + "\t" + racer2FullName.toLowerCase() + "\t" + numOfLapsRacer2 + "\t" + miles2 + "\t" + numForm.format(baseWinningsR2) + "\t" + "\t" + numForm.format(bonus2) + "\t\t" + numForm.format(netWinningsR2) + "\n");
			//Racer 3
			double bonus3 = 0.00;
			double netWinningsR3 = baseWinningsR3;
			System.out.println(randNum3 + "\t" + racer3FullName.toLowerCase() + "\t" + numOfLapsRacer3 + "\t" + miles3 + "\t" + numForm.format(baseWinningsR3) + "\t" + "\t" + numForm.format(bonus3) + "\t\t" + numForm.format(netWinningsR3) + "\n");
			//Grand totals
			double totalBonusWinnings = bonus + bonus2 + bonus3;
			double totalNetWinnings = netWinningsR1 + netWinningsR2 + netWinningsR3;
			System.out.println("Total Miles Covered: " + "\t" + totalMiles);
			System.out.println("Total Base Winnings: " + "\t" + numForm.format(totalBaseWinnings));
			System.out.println("Total Bonus Winnings: " + "\t" + numForm.format(totalBonusWinnings));
			System.out.println("Total Net Winnings: " + "\t" + numForm.format(totalNetWinnings));
		}
		else if ((miles1 > 50) && (miles2 > 50) && (miles3 < 50))
		{
			//Racer 1 
			double milesOver1 = miles1 - 50.00;
			double bonus = milesOver1 * BONUS_PER_MILE;
			double netWinningsR1 = baseWinningsR1 + bonus;
			System.out.println(randNum1 + "\t" + racer1FullName.toLowerCase() + "\t" + numOfLapsRacer1 + "\t" + miles1 + "\t" + numForm.format(baseWinningsR1) + "\t" + "\t" + numForm.format(bonus) + "\t\t" + numForm.format(netWinningsR1) + "\n");
		    //Racer 2
		    double milesOver2 = miles2 - 50.00;
			double bonus2 = milesOver2 * BONUS_PER_MILE;
			double netWinningsR2 = baseWinningsR2 + bonus2;	
			System.out.println(randNum2 + "\t" + racer2FullName.toLowerCase() + "\t" + numOfLapsRacer2 + "\t" + miles2 + "\t" + numForm.format(baseWinningsR2) + "\t" + "\t" + numForm.format(bonus2) + "\t\t" + numForm.format(netWinningsR2) + "\n");
		    //Racer 3 
		    double bonus3 = 0.00;
			double netWinningsR3 = baseWinningsR3;
			System.out.println(randNum3 + "\t" + racer3FullName.toLowerCase() + "\t" + numOfLapsRacer3 + "\t" + miles3 + "\t" + numForm.format(baseWinningsR3) + "\t" + "\t" + numForm.format(bonus3) + "\t\t" + numForm.format(netWinningsR3) + "\n");
			//Grand totals 
			double totalBonusWinnings = bonus + bonus2 + bonus3;
			double totalNetWinnings = netWinningsR1 + netWinningsR2 + netWinningsR3;
			System.out.println("Total Miles Covered: " + "\t" + totalMiles);
			System.out.println("Total Base Winnings: " + "\t" + numForm.format(totalBaseWinnings));
			System.out.println("Total Bonus Winnings: " + "\t" + numForm.format(totalBonusWinnings));
			System.out.println("Total Net Winnings: " + "\t" + numForm.format(totalNetWinnings));
		}
		else if ((miles1 > 50) && (miles2 < 50) && (miles3 > 50))
		{
			//Racer 1  
			double milesOver1 = miles1 - 50.00;
			double bonus = milesOver1 * BONUS_PER_MILE;
			double netWinningsR1 = baseWinningsR1 + bonus;
			System.out.println(randNum1 + "\t" + racer1FullName.toLowerCase() + "\t" + numOfLapsRacer1 + "\t" + miles1 + "\t" + numForm.format(baseWinningsR1) + "\t" + "\t" + numForm.format(bonus) + "\t\t" + numForm.format(netWinningsR1) + "\n");
		    //Racer 2
		    double bonus2 = 0.00;
			double netWinningsR2 = baseWinningsR2;	
			System.out.println(randNum2 + "\t" + racer2FullName.toLowerCase() + "\t" + numOfLapsRacer2 + "\t" + miles2 + "\t" + numForm.format(baseWinningsR2) + "\t" + "\t" + numForm.format(bonus2) + "\t\t" + numForm.format(netWinningsR2) + "\n");
		    //Racer 3 
		    double milesOver3 = miles3 - 50.00;
			double bonus3 = milesOver3 * BONUS_PER_MILE;
			double netWinningsR3 = baseWinningsR3 + bonus3;
			System.out.println(randNum3 + "\t" + racer3FullName.toLowerCase() + "\t" + numOfLapsRacer3 + "\t" + miles3 + "\t" + numForm.format(baseWinningsR3) + "\t" + "\t" + numForm.format(bonus3) + "\t\t" + numForm.format(netWinningsR3) + "\n");
			//Grand totals
			double totalBonusWinnings = bonus + bonus2 + bonus3;
			double totalNetWinnings = netWinningsR1 + netWinningsR2 + netWinningsR3;
			System.out.println("Total Miles Covered: " + "\t" + totalMiles);
			System.out.println("Total Base Winnings: " + "\t" + numForm.format(totalBaseWinnings));
			System.out.println("Total Bonus Winnings: " + "\t" + numForm.format(totalBonusWinnings));
			System.out.println("Total Net Winnings: " + "\t" + numForm.format(totalNetWinnings));
		}
		else 
		{
			//Racer 1
			double bonus = 0.00;
			double netWinningsR1 = baseWinningsR1;
			//Print statement for no bonus
			System.out.println(randNum1 + "\t" + racer1FullName.toLowerCase() + "\t" + numOfLapsRacer1 + "\t" + miles1 + "\t" + numForm.format(baseWinningsR1) + "\t" + "\t" + numForm.format(bonus) + "\t\t" + numForm.format(netWinningsR1) + "\n");
			//Racer 2
			double bonus2 = 0.00;
			double netWinningsR2 = baseWinningsR2;	
			System.out.println(randNum2 + "\t" + racer2FullName.toLowerCase() + "\t" + numOfLapsRacer2 + "\t" + miles2 + "\t" + numForm.format(baseWinningsR2) + "\t" + "\t" + numForm.format(bonus2) + "\t\t" + numForm.format(netWinningsR2) + "\n");
			//Racer 3 
			double bonus3 = 0.00;
			double netWinningsR3 = baseWinningsR3;
			System.out.println(randNum3 + "\t" + racer3FullName.toLowerCase() + "\t" + numOfLapsRacer3 + "\t" + miles3 + "\t" + numForm.format(baseWinningsR3) + "\t" + "\t" + numForm.format(bonus3) + "\t\t" + numForm.format(netWinningsR3) + "\n");
			double totalBonusWinnings = bonus + bonus2 + bonus3;
			double totalNetWinnings = netWinningsR1 + netWinningsR2 + netWinningsR3;
			System.out.println("Total Miles Covered: " + "\t" + totalMiles);
			System.out.println("Total Base Winnings: " + "\t" + numForm.format(totalBaseWinnings));
			System.out.println("Total Bonus Winnings: " + "\t" + numForm.format(totalBonusWinnings));
			System.out.println("Total Net Winnings: " + "\t" + numForm.format(totalNetWinnings));
		}
	
	//Close the scanner
	scan.close();
	
	}
}
