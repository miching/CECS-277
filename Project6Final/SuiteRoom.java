/**
 * 
 * @author Mika Wong, Nicolas Guardado, Gem Balagtas, Michael Ching
 * Due Date: December 7, 2020
 * Purpose: This class demonstrates our knowledge of the Factory Pattern where the rooms are the specific types of rooms being created.
 * Each room will have a description and a base cost. This is a deluxe room.
 *
 */
public class SuiteRoom extends MotelRoom implements Visitable{

	/**Default SuiteRoom Constructor*/
	public SuiteRoom() {
		description = "Suite";
	}
	
	/**
	 * This method returns the description of a suite room in String format.
	 * @return String Suite Room description
	 * @Override MotelRoom's getDescription method
	 * */
	public String getDescription() {
		return this.description;
	}

	/**
	 * This method returns the cost of a suite room in Double format.
	 * @return Double Suite Room cost
	 * @Override MotelRoom's cost method
	 * */
	public double cost() {
		return this.cost = 100;
	}

	/**
	 * This void methods accepts the cleaning visitor if the room accepts to
	 * be disturbed
	 * @Override Visitor's accept method
	 * @param Visitor Cleaning Visitor
	 * */
	public void accept(CleaningVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (NullPointerException e) {
			System.out.println(e.toString() + "Tell me what is wrong with you.");
		}
	}
	
	/**
	 * Method that sets the Do Not Disturb sign on
	 * @Override MotelRoom's setDoNotDisturb
	 * @return Boolean disturb status
	 * */
	public Boolean setDoNotDisturb() {
		return this.doNotDisturbStatus = true;
	}
	
	/**This overrides the object's tostring method
	 * @Override Object's tostring method
	 * @return String Displays Suite Room characteristics
	 */
	public String toString() {
		return this.description + " " + String.format("$%.2f", this.cost);
	}
}