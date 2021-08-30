/**
 * 
 * @author Mika Wong, Nicolas Guardado, Gem Balagtas, Michael Ching
 * Due Date: December 7, 2020
 * Purpose: This class demonstrates our knowledge of the Factory Pattern where the rooms are the specific types of rooms being created.
 * Each room will have a description and a base cost. This is a basic room.
 *
 */
public class BasicRoom extends MotelRoom implements Visitable {
	
	/**
	 * Default Basic Room constructor
	 * */
	public BasicRoom() 
	{
		description = "Basic Room";
	}
	
	/**
	 * This method returns the description of a basic room in String format.
	 * @return String Basic Room description
	 * */
	public String getDescription() 
	{
		return this.description;
	}
	
	/**
	 * This method returns the cost of a basic room in Double format.
	 * @return Double Basic Room base cost
	 * */
	public double cost() 
	{
		return this.cost = 50;
	}
	
	/**
	 * Methods that accepts the cleaning visitor if the room does not have
	 * the Do Not Disturb sign on
	 * @param visitor the Cleaning Visitor
	 * @Override Visitable interface's accept
	 * */
	public void accept(CleaningVisitor visitor) 
	{
		visitor.visit(this);
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
	 * @return String Displays Basic Room characteristics
	 */
	public String toString() 
	{
		return this.description + " " + String.format("$%.2f", this.cost);
	}

}