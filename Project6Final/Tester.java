/**
 * 
 * @author Mika Wong, Nicolas Guardado, Gem Balagtas, Michael Ching
 * Due Date: December 7, 2020
 * Purpose: This tester combines all of our classes methods into one enabling it to check roach colonies in, 
 * check roach colonies out, add amenities, throw parties, clean, make payments, and add roach colonies 
 * onto the waitlist. The payment files are written on a separate file displaying the colony name, payment 
 * method, and total cost as well. 
 *
 */
import java.util.*;
import java.io.*;
public class Tester {

	public static void main(String[] args) throws FileNotFoundException {
		
		PrintWriter toStayHFile = new PrintWriter("StayHistory.txt");
		
        RoachMotel rm = RoachMotel.getInstance();
        rm.createRooms();
        System.out.println(rm + "\n");
        
        /**Preparing the amenities into arraylists for use later in the code*/
        ArrayList<String> amenities = new ArrayList<>();
        amenities.add("foodbar");
        amenities.add("spa");
        
        ArrayList<String> amenities2 = new ArrayList<>();
        amenities2.add("foodbar");
        amenities2.add("refillbar");
        amenities2.add("spa");
        
        ArrayList<String> amenities3 = new ArrayList<>();
        amenities3.add("shower");
        amenities3.add("spa");
        
        ArrayList<String> amenities4 = new ArrayList<>();
        amenities4.add("foodBar");
        amenities4.add("refillBar");
        amenities4.add("spa");
        amenities4.add("shower");
        
        /**Declaring all roach colonies*/
        RoachColony gem = new RoachColony("Gem's Colony", 155, 0.3);
        RoachColony nick = new RoachColony("Nick's Colony", 400, 0.1);
        RoachColony michael = new RoachColony("Michael's Colony", 790, 0.25);
        RoachColony mika = new RoachColony("Mika's Colony", 640, 0.4);
        RoachColony mimi = new RoachColony("Mimi's Colony", 70, 0.55);
        
        /**Roach colony checking in*/
        System.out.println(gem.getName() + " would like to check in! :D");
        System.out.println(gem);
        MotelRoom r1 = rm.checkIn(gem, "Suite" , amenities);
        System.out.println(rm + "\n");
        
        /**Roach colony having the time of their life*/
        System.out.println(gem.party());
        rm.updateParty();
        System.out.println("The day after...");
        System.out.println(gem + "\n");
        
        /**Roach colony checking in*/
        System.out.println(nick.getName() + " would like to check in! :0");
        System.out.println(nick);
        MotelRoom r2 = rm.checkIn(nick, "Deluxe" , amenities2);
        System.out.println(rm + "\n");
        
        /**Roach colony getting diggy*/
        System.out.println(nick.party());
        rm.updateParty();
        System.out.println("The day after...");
        System.out.println(nick + "\n");
        
        /**Cleaning*/
        System.out.print("Let's clean some roach rooms!\n");
        rm.cleanRooms();
        
        /**Roach colony checking in*/
        System.out.println("\n" + michael.getName() + " would like to check in! :3");
        System.out.println(michael);
        MotelRoom r3 = rm.checkIn(michael, "Suite" , amenities3);
        System.out.println(rm + "\n");
        
        /**Roach colony celebrating because this semester is almost over*/
        System.out.println("Another party?! Whoop whoop!");
        System.out.println(michael.party());
        rm.updateParty();
        System.out.println("The day after...");
        System.out.println(michael + "\n");
        
        /**Roach colony checking in*/
        System.out.println(mika.getName() + " would like to check in! >.<");
        System.out.println(mika + "\n");
        MotelRoom r4 = rm.checkIn(mika, "Basic" , amenities2);
        System.out.println(rm + "\n");
        
        /**Cleaning*/
        r4.setDoNotDisturb();
        System.out.println("Time to clean the rooms again after that crazy party...");
        rm.cleanRooms();
        
        /**Roach colony checking in*/
        System.out.println("\n" + mimi.getName() + " would like to check in! O.o");
        System.out.println(mimi + "\n");
        MotelRoom r5 = rm.checkIn(mimi, "Suite" , amenities4);
        System.out.println(rm + "\n");
        
        /**Testing waitlist*/
        System.out.println("The motel is full so unfortunately " + mimi.getName() + " is on the waitlist :/");
        System.out.println(rm.currentWaitList() + "\n");
        
        System.out.println(nick.getName() + " would like to check out?! D: Okay... Well.. Thanks for your stay!\n");
        Payment p1 = new MasterRoach("298","Nick Jr.","348573933","01/20/2020");
        double cost = rm.checkOut(r2, 14, p1);
        toStayHFile.println("Colony Name: " + nick.getName() + "; Payment Method: " + p1.toString() + "; Cost: $" + cost);

        System.out.println(rm.currentWaitList() + "\n");
        
        /**Testing checkout/waitlist*/
        System.out.println("More colonies are checking out?! But the parties were just getting started! I hope you have a good day at least " + mika.getName() + " :/");
        Payment p2 = new RoachPal("mika.roach.colony@IWasNotPartying.roaches", "Mika's Colony");
        cost = rm.checkOut(r4, 6, p2);
        toStayHFile.println("Colony Name: " + mika.getName() + "; Payment Method: " + p2.toString() + "; Cost: $" + cost);
        
        toStayHFile.close();
	}

}
