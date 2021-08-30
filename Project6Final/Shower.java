/**
 * 
 * @author Mika Wong, Nicolas Guardado, Gem Balagtas, Michael Ching
 * Due Date: December 7, 2020
 * Purpose: This class demonstrates our knowledge of the Decorator Pattern where the amenities are the decorators to the amenities abstract class.
 * Each decorator will add on an extra cost and the description to the specific type of room.
 *
 */
public class Shower extends Amenities {
	
	MotelRoom room;
	
	/**Default Shower constructor*/
	public Shower() {
		
	}
	
	/**
	 * Shower constructor that instantiates a Shower in the specific room
	 * @param room type MotelRoom; room is the room where the Shower will be included in
	 */
	public Shower(MotelRoom room)
	{
		this.room = room;
	}
	
	/**
	 * Method to get the description of the room and the amenity included
	 * @return the description of the room and the amenity included
	 */
	public String getDescription()
	{
		return room.getDescription() + ", Spray Resistance Shower";
	}
	
	/**
	 * Method that adds on the additional cost of the Shower to the room's cost
	 * @return the room's cost with the additional cost for the Shower
	 */
	public double cost()
	{
		return room.cost() + 25;
	}
	
	/**This overrides the object's tostring method
	 * @Override Object's tostring method
	 * @return String Displays Deluxe Room characteristics
	 */
	public String toString()
	{
		return "Shower";
	}

}
