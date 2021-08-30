/**
 * 
 * @author Mika Wong, Nicolas Guardado, Gem Balagtas, Michael Ching
 * Due Date: December 7, 2020
 * Purpose: This class demonstrates our knowledge of the Observer Pattern where the RoachColony will be placed on a waitlist if the hotel is full.
 * Each colony will be notified when a room opens up.
 *
 */
import java.util.*;
public class WaitListRC implements WaitList {
	
	private ArrayList<RoachColony> list;
	
	/**
	 * WaitListRC constructor
	 */
	public WaitListRC()
	{
		list = new ArrayList<RoachColony>();
	}
	
	/**
	 * Method that adds a RoachColony to the waitlist
	 */
	public void addToWL(RoachColony rc)
	{
		list.add(rc);
	}
	
	/**
	 * Method that clears the waitlist when a room opens up
	 */
	public void clearWL()
	{
		list.clear();
	}
	
	/**
	 * Method that notifies all the RoachColonies on the waitlist that  a room just opened up and then clears the list
	 * @param motelname String name of the motel sending notification
	 */
	public void notifyRoaches(String motelName)
	{
		for (RoachColony rc:list)
		{
			System.out.println(rc.update() + motelName );
		}
		list.clear();
	}
	
	/**
	 * Method that says if the waitlist is empty or not
	 * @return Boolean type if the waitlist is empty or not
	 */
	public Boolean isEmpty()
	{
		if (list.isEmpty())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**This overrides the object's tostring method
	 * @Override Object's tostring method
	 * @return String Displays Deluxe Room characteristics
	 */
	public String toString()
	{
		return "Current Waistlist: " + list;
	}

}
