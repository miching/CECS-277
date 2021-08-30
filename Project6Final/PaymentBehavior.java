/**
 * 
 * @author Mika Wong, Nicolas Guardado, Gem Balagtas, Michael Ching
 * Due Date: December 7, 2020
 * Purpose: This class demonstrates our knowledge of the Strategy Pattern to implement different types of payments.
 * This is the PaymentBehavior.
 *
 */
public interface PaymentBehavior {
	
	/**
	 * Method that describes how the RoachColony will be paying
	 */
	public String pay();
	
}
