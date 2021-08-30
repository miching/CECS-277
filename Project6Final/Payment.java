/**
 * 
 * @author Mika Wong, Nicolas Guardado, Gem Balagtas, Michael Ching
 * Due Date: December 7, 2020
 * Purpose: This class demonstrates our knowledge of the Strategy Pattern to implement different types of payments.
 * This is the general Payment.
 *
 */
public abstract class Payment {
	
	PaymentBehavior paymentBehavior;
	double price;
	
	/**
	 * Default Payment constructor
	 */
	public Payment()
	{
		paymentBehavior = null;
		price = 0;
	}
	/**
	 * Method that sets what type of card the stay will be paid with
	 * @param paymentBehavior type PaymentBehavior; is the way the type of payment the colony is going to use to pay will behave
	 */
	public void setPaymentMethod(PaymentBehavior paymentBehavior) 
	{
		this.paymentBehavior = paymentBehavior;
	}
	
	/**
	 * Method that sets the price of the stay
	 * @param price double; price is the price of the stay
	 */
	public abstract void setPrice(double price);
	
	/**
	 * Method that describes the payment
	 * @return String description of the payment
	 */
	public String performPayment() 
	{
		return paymentBehavior.pay();
	}
		
	/**This overrides the object's tostring method
	 * @Override Object's tostring method
	 * @return String Displays Deluxe Room characteristics
	 */
	public String toString() 
	{
		return price + " paid by " + paymentBehavior.pay();
	}

}
