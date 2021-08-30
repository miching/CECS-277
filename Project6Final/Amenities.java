import java.util.ArrayList;

/**
 * 
 * @author Mika Wong, Nicolas Guardado, Gem Balagtas, Michael Ching
 * Due Date: December 7, 2020
 * Purpose: This class demonstrates our knowledge of the Decorator Pattern where the amenities are the decorators to the amenities abstract class.
 * Each decorator will add on an extra cost and the description to the specific type of room.
 *
 */
public abstract class Amenities extends MotelRoom {
	
	/**
	 * Default Amenities constructor
	 */
	public Amenities()
	{
		super.amenities = new ArrayList<Amenities>();
		super.description = "";
		super.cost = 0;
	}
	/**
	 * An abstract method that all the amenity subclasses will have to implement
	 * It will return a String that describes the room and it's amenities
	 */
	public abstract String getDescription();
	
	/**
	 * Method that will allow an amenity to be created when a RoachColony checks in so that
	 * the cost of the amenities will be added to the room
	 * @param s String s is the amenity that the RoachColony would like to add to their room
	 * @param r MotelRoom r is the room, along with any amenities already added on, that is 
	 * having amenities being added on to it
	 * @return the MotelRoom with the amenities that were added on
	 */
	public static MotelRoom createAmenity(String s, MotelRoom r)
	{
		if (s.equalsIgnoreCase("foodbar"))
		{
			r = new FoodBar(r);
			return r;
		}
		else if (s.equalsIgnoreCase("refillbar"))
		{
			r = new RefillBar(r);
			return r;
		}
		else if (s.equalsIgnoreCase("shower"))
		{
			r = new Shower(r);
			return r;
		}
		else
		{
			r = new Spa(r);
			return r;
		}
	}
	
	/**This overrides the object's tostring method
	 * @Override Object's tostring method
	 * @return String Displays Suite Room characteristics
	 */
	public String toString()
	{
		return "Amenities: " + super.amenities;
	}

}
