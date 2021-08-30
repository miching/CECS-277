/**
 * 
 * @author Mika Wong, Nicolas Guardado, Gem Balagtas, Michael Ching
 * Due Date: December 7, 2020
 * Purpose: This class demonstrates our knowledge of the Strategy Pattern to implement different types of payments.
 * This is the RoachPal payment.
 *
 */
public class RoachPal extends Payment {
	
	/**
	 * Default RoachPal constructor
	 */
	public RoachPal() 
	{
		paymentBehavior = new RoachPalBehavior();
	}
	
	/**
	 * RoachPal constructor
	 * @param email type String; email is the email being used to pay
	 * @param name type String; name the name of the payer
	 */
	public RoachPal(String email, String name) 
	{
		paymentBehavior = new RoachPalBehavior(email, name);
	}


	/**
	 * Method that sets the total price of the stay
	 * @param price the price of the stay
	 */
	public void setPrice(double price) 
	{
		this.price = price;
	}
	
	/**This overrides the object's tostring method
	 * @Override Object's tostring method
	 * @return String Displays Deluxe Room characteristics
	 */
	public String toString()
	{
		return "RoachPal";
	}
}
