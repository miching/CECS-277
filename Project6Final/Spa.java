/**
 * 
 * @author Mika Wong, Nicolas Guardado, Gem Balagtas, Michael Ching
 * Due Date: December 7, 2020
 * Purpose: This class demonstrates our knowledge of the Decorator Pattern where the amenities are the decorators to the amenities abstract class.
 * Each decorator will add on an extra cost and the description to the specific type of room.
 *
 */
public class Spa extends Amenities {
	
	MotelRoom room;
	
	/**Default Spa constructor*/
	public Spa() {

	}
	
	/**
	 * Spa constructor that instantiates a Spa in the specific room
	 * @param of type MotelRoom room is the room where the Spa will be included in
	 */
	public Spa(MotelRoom room)
	{
		this.room = room;
	}
	
	/**
	 * Method to get the description of the room and the amenity included
	 * @return the description of the room and the amenity included
	 */
	public String getDescription()
	{
		return room.getDescription() + ", Spa";
	}
	
	/**
	 * Method that adds on the additional cost of the Spa to the room's cost
	 * @return the room's cost with the additional cost for the Spa
	 */
	public double cost()
	{
		return room.cost() + 20;
	}
	
	/**This overrides the object's tostring method
	 * @Override Object's tostring method
	 * @return String Displays Deluxe Room characteristics
	 */
	public String toString()
	{
		return "Spa";
	}

}
