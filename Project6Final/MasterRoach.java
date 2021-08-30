/**
 * 
 * @author Mika Wong, Nicolas Guardado, Gem Balagtas, Michael Ching
 * Due Date: December 7, 2020
 * Purpose: This class demonstrates our knowledge of the Strategy Pattern to implement different types of payments.
 * This is the MasterRoach payment.
 *
 */
public class MasterRoach extends Payment {
	
	/**
	 * Default MasterRoach constructor
	 */
	public MasterRoach() 
	{
		paymentBehavior = new MasterRoachBehavior();
	}
	
	/**
	 * MasterRoach constructor
	 * @param securityCode type String; securityCode is the security code the card needs
	 * @param name String name is the name on the card
	 * @param expirationDate String expirationDate is the date the card expires
	 * @param id String id is the ID on the card
	 */
	public MasterRoach(String securityCode, String name, String expirationDate, String id) 
	{
		paymentBehavior = new MasterRoachBehavior(securityCode, name, expirationDate, id);
	}

	/**
	 * Method that sets the total price of the stay
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**This overrides the object's tostring method
	 * @Override Object's tostring method
	 * @return String Displays Deluxe Room characteristics
	 */
	public String toString()
	{
		return "MasterRoach";
	}

}
