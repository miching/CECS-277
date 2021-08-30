/**
 * 
 * @author Mika Wong, Nicolas Guardado, Gem Balagtas, Michael Ching
 * Due Date: December 7, 2020
 * Purpose: This class demonstrates our knowledge of the Observer Pattern where the RoachColony will be placed on a waitlist if the hotel is full.
 * Each colony will be notified when a room opens up.
 *
 */
public interface RoachColonyInterface {
	
	/**
	 * Method that updates the RoachColonies on the waitlist when a room opens up
	 */
	public String update();

}
