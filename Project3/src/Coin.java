/**
 * A concrete class that constructs a Coin object with a name and monetary value for the coin.
 * Implements accessors, mutators and an overriden toString() method.
 * @author Amir Hammoud
 * @author Katrina Orevillo
 * @author Michael Ching
 * Date: 10-05-2020
 */

public class Coin {

	private String name;
	private double value;

	// Default Coin constructor, takes no parameters.
	public Coin() {}

	/**
     * Coin constructor that takes 2 parameters.
     * @param name
     * @param value
     */
	public Coin(String name, double value) {
		this.name = name;
		this.value = value;
	}

	/**
     * Gets the name. 
     * @return name
     */
	public String getName() {
		return name;
	}

	/**
     * Gets the value. 
     * @return value
     */
	public double getValue() {
		return value;
	}

	/**
     * Sets the name. 
     * @param name
     */
	public void setName(String name) {
		this.name = name;
	}

	/**
     * Sets the value. 
     * @param value
     */
	public void setValue(double value) {
		this.value = value;
	}

	@Override
	/**
     * Overriden toString method.
     * @return The string representation of a Coin object.
     */
	public String toString() {
		return name + " @ $" + String.format("%.2f", value);
	}
}