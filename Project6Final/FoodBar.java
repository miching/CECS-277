/**
 * 
 * @author Mika Wong, Nicolas Guardado, Gem Balagtas, Michael Ching
 * Due Date: December 7, 2020
 * Purpose: This class demonstrates our knowledge of the Decorator Pattern where the amenities are the decorators to the amenities abstract class.
 * Each decorator will add on an extra cost and the description to the specific type of room.
 *
 */
public class FoodBar extends Amenities {

	MotelRoom room;
	
	/**
	 * FoodBar constructor that instantiates a FoodBar in the specific room
	 * @param room type MotelRoom room is the room where the FoodBar will be included in
	 */
	public FoodBar(MotelRoom room)
	{
		this.room = room;
	}
	
	/**
	 * Method to get the description of the room and the amenity included
	 * @return the string description of the room and the amenity included
	 */
	public String getDescription()
	{
		return room.getDescription() + ", Food Bar";
	}
	
	/**
	 * Method that adds on the additional cost of the FoodBar to the room's cost
	 * @return the room's cost with the additional cost for the FoodBar
	 */
	public double cost()
	{
		return room.cost() + 10;
	}
	
	/**This overrides the object's tostring method
	 * @Override Object's tostring method
	 * @return String Displays Deluxe Room characteristics
	 */
	public String toString()
	{
		return "Foodbar";
	}

}