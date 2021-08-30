/**
 * 
 * @author Mika Wong, Nicolas Guardado, Gem Balagtas, Michael Ching
 * Due Date: December 7, 2020
 * Purpose: This class demonstrates our knowledge of the Strategy Pattern to implement different types of payments.
 * This is the MasterRoachBehavior.
 *
 */
public class MasterRoachBehavior implements PaymentBehavior {
	
	String securityCode;
	String id;
	String expirationDate;
	String name;
	
	/**
	 * Default MasterRoachBehavior constructor
	 */
	public MasterRoachBehavior() 
	{
		id = null;
		expirationDate = null;
		securityCode = null;
		name = null;
	}
	
	/**
	 * MasterRoachBehavior constructor
	 * @param securityCode String securityCode is the security code the card needs
	 * @param name String name is the name on the card
	 * @param expirationDate String expirationDate is the date the card expires
	 * @param id String id is the ID on the card
	 */
	public MasterRoachBehavior(String securityCode, String name, String expirationDate, String id) 
	{
		this.id = id;
		this.expirationDate = expirationDate;
		this.securityCode = securityCode;
		this.name = name;
	}

	/**
	 * Method that describes how the RoachColony will be paying
	 * @return String formatting of payment type
	 */
	public String pay() 
	{
		return name + " using card " + id + " expires " + expirationDate + " security code " + securityCode;
	}
	
	/**This overrides the object's tostring method
	 * @Override Object's tostring method
	 * @return String Displays Deluxe Room characteristics
	 */
	public String toString()
	{
		return "Payment is with MasterRoach";
	}

}