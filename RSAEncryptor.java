/**
 * Created on 9/6/22
 * Class IT 168
 */
package edu.ilstu;

import java.util.Scanner;
import java.util.Random;

/**
 * This program encrypts an integer "message" using RSA encryption.
 * @author Bradley Prokop
 */
public class RSAEncryptor 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		//instance of the scanner
		Scanner input = new Scanner(System.in);
		
		//Instance of the Random 
		Random rand = new Random();     
		
		//Welcome message
		System.out.println("Welcome to the RSA Encryptor!");
		
		//User enters name 
		System.out.print("Enter name: ");
		String name = input.nextLine();
		
		//Gets the first, middle, and last letters
		char firstLetter = name.charAt(0);
		char lastLetter = name.charAt(name.length()-1);
		char middleLetter = name.charAt(name.length()/2);
		
		//Character to a string
		String firstLet = Character.toString(firstLetter);
		String lastLet = Character.toString(lastLetter);
		String middleLet = Character.toString(middleLetter);
	
		//Gets the length of name 
		int nameLength = name.length();
		
		//Puts random number to a variable 
	    int randnum = rand.nextInt(401) + 100;
		
		//Combine the first, middle and last name 
		String queryID = (firstLet + lastLet + randnum + middleLet + nameLength);
		
		//Message to encrypt
		System.out.print("\nHi " + name + ", enter a message to encrypt: ");
		int message = input.nextInt();
		
		//Asks for user input of e and n
		System.out.print("\nProvide a public key (e,n) to encrypt this message");
		
		//Gets user input for e 
		System.out.print("\nEnter e: ");
		int e = input.nextInt();
		
		//Gets user input for n
		System.out.print("Enter n: ");
		int n = input.nextInt();		
		
		//Calculates cipher text
		double messageToThePowE = Math.pow(message, e);
		int ciphertext = (int) messageToThePowE % n;
		
		//Outputs encryption summary
		System.out.println("*********************"
				+ "\n ENCRYPTION SUMMARY\n*********************");
		System.out.println("Query ID: " + queryID);
		System.out.println("Message (M): " + message);
		System.out.println("Public Key (e,n): " + "(" + e + "," + n + ")");
		System.out.println("Ciphertext (C): " + ciphertext);
		
		//Close scanner
		input.close();
	}
}
