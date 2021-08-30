/**
 * 
 * @author Mika Wong, Nicolas Guardado, Gem Balagtas, Michael Ching
 * Due Date: December 7, 2020
 * Purpose: This class demonstrates our knowledge of the Strategy Pattern to implement different types of payments.
 * This is the RoachPalBehavior.
 *
 */
public class RoachPalBehavior implements PaymentBehavior {
	
	String email;
	String name;
	
	/**
	 * Default RoachPalBehavior constructor
	 */
	public RoachPalBehavior() 
	{
		email = null;
		name = null;
	}
	
	/**
	 * RoachPalBehavior constructor
	 * @param email type String; email is the email being used to pay
	 * @param name type String; name the name of the payer
	 */
	public RoachPalBehavior(String email, String name) 
	{
		this.email = email;
		this.name = name;
	}

	/**
	 * Method that describes how the RoachColony will be paying
	 * @return String format of email associated with payment
	 */
	public String pay() 
	{
		return name + " using email " + email;
	}
	
	/**This overrides the object's tostring method
	 * @Override Object's tostring method
	 * @return String Displays Deluxe Room characteristics
	 */
	public String toString()
	{
		return "Payment is with RoachPal";
	}

}
