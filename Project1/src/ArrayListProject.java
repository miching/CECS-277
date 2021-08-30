/**
 * 
 */
import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author Michael Ching
 * @author Amir Hammoud
 * @author Katrina Orevillo
 * @date 9/9/2020
 * 
 * CECS 277 Project ArrayList
 * This program takes a user input of the amount of tickets they want to play, 
 * and outputs 6 unique numbers for each individual ticket in the range 1-49.
 */
public class ArrayListProject {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{

		Scanner input = new Scanner(System.in);
		
		//size of a individual lottery ticket
		int lotterySize = 6;
		
		System.out.println("Enter the number of games: ");
		
		//gets a positive int user input
		int numberOfGames = CheckInput.getPositiveInt();
		
		//loop through the requested number of games
		for(int i = 0; i < numberOfGames; i++)
		{
			
			//ArrayList to hold each ticket
			ArrayList <Integer> games = new ArrayList<Integer>();
			
			
			//the size of the ArrayList does not exceed the size of the ticket: 6
			while (games.size() != lotterySize)
			{
			
				//random number between (1-49)
				int randomNumber = (int) (Math.random()*49 + 1);
				
				
				//checks for duplicates
				if(!games.contains(randomNumber))
				{
					
					games.add(randomNumber);
					
				}
				
				
			}
			
			
			//sorts numbers on tickets from least to greatest
			Collections.sort(games);
			
			//print the ticket numbers
			System.out.println(games);
			
		}
		
		System.out.println("Press any key to end the program");
		
		input.next();
		
		System.out.println("Program has ended");
		
		input.close();
		
	}

}
