/**
 * 
 * @author Mika Wong, Nicolas Guardado, Gem Balagtas, Michael Ching
 * Due Date: December 7, 2020
 * Purpose: This class demonstrates our knowledge of the Visitor Pattern where the rooms need to be visited 
 * if the Do Not Disturb sign is not on and each type of room has specific cleaning.
 *
 */
public class CleaningVisitor implements Visitor {
	String name;
	/**
	 * Default CleaningVisitor constructor
	 */
	public CleaningVisitor()
	{
		name = "Angel";
	}
	/**
	 * Method that changes the room's linens
	 * @return String Confirmation that the linens have been changed
	 */
	public String cleanLinens() 
	{
		return "Linens changed. ";
	}
	
	/**
	 * Method that changes the room's towels on the floor
	 * @return String Confirmation that the towles on the floor have been changed
	 */
	public String changeFloorTowels() 
	{
		return "Towels on the floor have been replaced. ";
	}

	/**
	 * Method that changes all the room's towels
	 * @return String Confirmation that all the towels have been changed
	 */
	public String changeAllTowels() 
	{
		return "All towels have been replaced. ";
	}
	
	/**
	 * Method that places a hamburger on each pillow
	 * @return String confirmation that hamburgers have been placed on each pillow
	 */
	public String burgerPillows() 
	{
		return "Hamburger meals have been placed on each pillow. ";
	}
	
	/**
	 * Method so that the room can be visited
	 * @param basic the basic room that needs to be visited
	 */
	public void visit(BasicRoom basic) 
	{
		System.out.println(cleanLinens() + changeFloorTowels());
	}

	/**
	 * Method so that the room can be visited
	 * @param deluxe the deluxe room that needs to be visited
	 */
	public void visit(DeluxeRoom deluxe) 
	{
		System.out.println(cleanLinens() + changeAllTowels());
	}

	/**
	 * Method so that the room can be visited
	 * @param suite the suite room that needs to be visited
	 */
	public void visit(SuiteRoom suite) 
	{
		System.out.println(cleanLinens() + changeAllTowels() + burgerPillows());
	}
	
	/**This overrides the object's tostring method
	 * @Override Object's tostring method
	 * @return String Displays Suite Room characteristics
	 */
	public String toString()
	{
		return name + "is our cleaning visitor :>";
	}

}