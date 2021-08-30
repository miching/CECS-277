/**
 * A concrete class that constructs a Product object with a description, price and quantity for the product.
 * Implements accessors, mutators and an overriden toString() method.
 * @author Amir Hammoud
 * @author Katrina Orevillo
 * @author Michael Ching
 * Date: 10-05-2020
 */

public class Product {
	
	private String description;
	private double price;
	private int quantity;

	// Default Product constructor, takes no parameters.
	public Product() {}

	/**
     * Product constructor that takes 3 parameters.
     * @param description
     * @param price
     * @param quantity
     */
	public Product(String description, double price, int quantity) {
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

	/**
     * Gets the description. 
     * @return description
     */
	public String getDescription() {
		return description;
	}

	/**
     * Gets the price. 
     * @return price
     */
	public double getPrice() {
		return price;
	}
	
	/**
     * Gets the quantity. 
     * @return quantity
     */
	public double getQuantity() {
		return quantity;
	}
	
	/**
     * Sets the description. 
     * @param description
     */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
     * Sets the price. 
     * @param price
     */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
     * Sets the quantity. 
     * @param quantity
     */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	/**
     * Overriden toString method.
     * @return The string representation of a Product object.
     */
	public String toString() {
        return description + " @ $" + String.format("%.2f", price);
    }
}