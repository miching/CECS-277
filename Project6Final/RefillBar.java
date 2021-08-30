/**
 * 
 * @author Mika Wong, Nicolas Guardado, Gem Balagtas, Michael Ching
 * Due Date: December 7, 2020
 * Purpose: This class demonstrates our knowledge of the Decorator Pattern where the amenities are the decorators to the amenities abstract class.
 * Each decorator will add on an extra cost and the description to the specific type of room.
 *
 */
public class RefillBar extends Amenities {
	
	MotelRoom room;
	
	/**
	 * RefillBar constructor that instantiates a RefillBar in the specific room
	 * @param of type MotelRoom room is the room where the RefillBar will be included in
	 */
	public RefillBar(MotelRoom room)
	{
		this.room = room;
	}
	
	/**
	 * Method to get the description of the room and the amenity included
	 * @return the description of the room and the amenity included
	 */
	public String getDescription()
	{
		return room.getDescription() + ", Food Bar Refill";
	}
	
	/**
	 * Method that adds on the additional cost of the RefillBar to the room's cost
	 * @return the room's cost with the additional cost for the RefillBar
	 */
	public double cost()
	{
		return room.cost() + 5;
	}
	
	/**This overrides the object's tostring method
	 * @Override Object's tostring method
	 * @return String Displays Deluxe Room characteristics
	 */
	public String toString()
	{
		return "Refillbar";
	}

}