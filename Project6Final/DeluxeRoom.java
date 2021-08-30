/**
 * 
 * @author Mika Wong, Nicolas Guardado, Gem Balagtas, Michael Ching
 * Due Date: December 7, 2020
 * Purpose: This class demonstrates our knowledge of the Factory Pattern where the rooms are the specific types of rooms being created.
 * Each room will have a description and a base cost. This is a deluxe room.
 *
 */
public class DeluxeRoom extends MotelRoom implements Visitable {

	/**
	 * Default DeluxeRoom constructor
	 * */
	public DeluxeRoom() 
	{
		description = "Deluxe Room";
	}
	
	/**
	 * This method returns the description of a deluxe room in String format.
	 * @return String Deluxe Room description
	 * @Override MotelRoom's getDescription
	 * */
	public String getDescription() 
	{
		return this.description;
	}

	/**
	 * This method returns the cost of a deluxe room in Double format.
	 * @return Double Deluxe Room cost
	 * @Override MotelRoom's cost
	 * */
	public double cost() 
	{
		return this.cost = 75;
	}

	/**
	 * This void methods accepts the cleaning visitor if the room accepts to
	 * be disturbed.
	 * @param visitor the Cleaning Visitor
	 * @Override Visitable's accept
	 * */
	public void accept(CleaningVisitor visitor) 
	{
		try 
		{
			visitor.visit(this);
		} 
		catch (NullPointerException e) 
		{
			System.out.println(e.toString());
		}
	}
	
	/**
	 * Method that sets the Do Not Disturb sign on
	 * @Override MotelRoom's setDoNotDisturb
	 * @return Boolean disturb status
	 * */
	public Boolean setDoNotDisturb() 
	{
		return this.doNotDisturbStatus = true;
	}

	/**This overrides the object's tostring method
	 * @Override Object's tostring method
	 * @return String Displays Deluxe Room characteristics
	 */
	public String toString() 
	{
		return this.description + " " + String.format("$%.2f", this.cost);
	}
}