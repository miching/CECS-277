/**
 * 
 * @author Mika Wong, Nicolas Guardado, Gem Balagtas, Michael Ching
 * Due Date: December 7, 2020
 * Purpose: This class demonstrates our knowledge of the Factory Pattern where the rooms are the specific types of rooms being created.
 * Each room will have a description and a base cost.
 *
 */
import java.util.ArrayList;
public abstract class MotelRoom {

	ArrayList<Amenities> amenities = new ArrayList<Amenities>();
	String description = "";
	double cost;
	boolean doNotDisturbStatus = false;
	
	/**
	 * Default MotelRoom constructor
	 */
	public MotelRoom()
	{
		description = "";
		cost = 0;
	}
	/**
	 * Method that will set a room to Do Not Disturb so that it wont be cleaned
	 * @return Boolean true/false status of the room does not want to be disturbed
	 */
	public Boolean setDoNotDisturb() 
	{
		return doNotDisturbStatus = true;
	}
	
	/**
	 * Method that gets the description of the room that needs to be implemented by the subclasses.
	 * @return the description of the room
	 */
	public abstract String getDescription();
	
	/**
	 * Method that gets the cost of the room that needs to be implemented by the subclasses.
	 * @return the cost of the room
	 */
	public abstract double cost();
	
	/**This overrides the object's tostring method
	 * @Override Object's tostring method
	 * @return String Displays Deluxe Room characteristics
	 */
	public String toString()
	{
		return this.description + " " + String.format("$%.2f", this.cost);
	}
}