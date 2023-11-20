/*
* Created on: 10/17/22
* Class: IT 168
*/
package edu.ilstu;

import java.util.Random;
import java.util.Scanner;

/**
 * Program to help the user to find their way home from the bar. It will start by prompting the user for the 
 * coordinates of their house. It will then first randomly choose a direction (to simulate a drunk person just
 * walking in a random direction of north, east, south, and west), then it will update the current coordinates 
 * until the person either gets home, which will print out a "Welcome home" message, or after 100 intersections
 * if not home, it will print out "I'm lost, call me a cab. my coordinates are... (current coordinates)".
 *
 *  @author Bradley Prokop 
 */
public class FindYourWayHome {
	
	static final int INTERSECTION_LIMIT = 100;

	public static void main(String[] args) {
		
		//Create an object for Scanner and Random class 
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		
		//Initialize start coordinates (bar)
		int currentXCoordinate = 5;
		int currentYCoordinate = 7;
		
		//Initialize count 
		int count=0;
						
		//Label for user 
		System.out.println("Find your way home!");
		
		//Prompt user to enter x and y coordinates 
		System.out.println("\nPlease enter the x and y coordinates of your apartment: ");
		
		//Prompt the user for x coordinate of their house and read in x coordinate
		System.out.print("\nEnter the x coordinate of your destination: ");
		int xCoordinateHome = sc.nextInt();
		
		//Prompt the user for y coordinate of their house and read in y coordinate
		System.out.print("\nEnter they y coordinate of your destination: ");
		int yCoordinateHome = sc.nextInt();
		
		//While statement to run while count (intersections) is less than 100 
		while (count<INTERSECTION_LIMIT){
			
			//If statement to pick a random direction if one of the current coordinates are not equal to home coordinates
			if (currentXCoordinate!=xCoordinateHome||currentYCoordinate!=yCoordinateHome){
				
				//If statement to keep coordinates above negative x & y values
				if (currentXCoordinate>0&&currentYCoordinate>0){			
					
					//If statement to keep x or y that matches home coordinate and increment or decrement the one that not equal 
					if (currentXCoordinate==xCoordinateHome){
						
						//Generates random number for random choice
						int randomChoice = rand.nextInt(2)+1;
					
						//Switch statement to apply the random direction chosen only to the current y coordinate
						switch(randomChoice) {
						case 1:
							currentYCoordinate++;
							break;
						default:
							currentYCoordinate--;
							break;
						}
						
						System.out.println("("+currentXCoordinate+","+currentYCoordinate+")");
					}
					else if (currentYCoordinate==yCoordinateHome){
						//Generates random number 
						int randomChoice2 = rand.nextInt(2)+1;
					
						//Switch statement to apply the random direction chosen only to the current x coordinate
						switch(randomChoice2){
						case 1:
							currentXCoordinate++;
							break;
						default:
							currentXCoordinate--;
							break;
						}
						System.out.println("("+currentXCoordinate+","+currentYCoordinate+")");
					}
					else {
						//Generates random number 
						int randomChoice3 = rand.nextInt(4)+1;
					
						//if statement to apply the direction chosen to the current x or y coordinate
						if (randomChoice3==1) 
							currentYCoordinate++;
						else if (randomChoice3==2)
							currentXCoordinate++;
						else if (randomChoice3==3)
							currentYCoordinate--;
						else
							currentXCoordinate--;
						
						System.out.println("("+currentXCoordinate+","+currentYCoordinate+")");
					}
				}
				else{
					
					//If statement to keep x & y from going negative
					if(currentXCoordinate<=0){
						currentXCoordinate++;
						System.out.println("("+currentXCoordinate+","+currentYCoordinate+")");
					}
					else{
						currentYCoordinate++;
						System.out.println("("+currentXCoordinate+","+currentYCoordinate+")");
					}
				}
			}
			else
				count = 99;
			count++;	
		} 
		
			//If statement to decide if you made it home before 100 intersections or if you need a cab after 100 intersections
			if(currentXCoordinate==xCoordinateHome&&currentYCoordinate==yCoordinateHome)
				System.out.println("Welcome home!");
			else 
				System.out.println("I’m lost. Call me a cab. I’m currently at " + "("+currentXCoordinate+","+currentYCoordinate+")");
	//Close Scanner
	sc.close();
	}
}

