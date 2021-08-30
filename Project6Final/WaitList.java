/**
 * 
 * @author Mika Wong, Nicolas Guardado, Gem Balagtas, Michael Ching
 * Due Date: December 7, 2020
 * Purpose: This class demonstrates our knowledge of the Observer Pattern where the RoachColony will be placed on a waitlist if the hotel is full.
 * Each colony will be notified when a room opens up.
 *
 */
public interface WaitList {
	
	/**
	 * Method that adds a RoachColony to the waitlist
	 */
	public void addToWL(RoachColony rc);
	
	/**
	 * Method that clears the waitlist when a room opens up
	 */
	public void clearWL();
	
	/**
	 * Method that notifies all the RoachColonies on the waitlist that  a room just opened up and then clears the list
	 * @param String name of the motel sending notification
	 */
	public void notifyRoaches(String motelName);

}
