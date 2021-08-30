/**
 * A concrete sub class "Sundae" that extends from the super class "IceCream".
 * Provides methods to get and set the topping and price of the topping as well as the cost of the sundae.
 * @author Amir Hammoud
 * @author Katrina Orevillo
 * @author Michael Ching
 * Date: 9-23-2020
 */

public class Sundae extends IceCream{

    private String topping;
    private double priceOfTopping;

    // Default Sundae constructor, takes no parameters.
    public Sundae(){
        super();
        topping = "";
        priceOfTopping = 0;
    }

    /**
     * Sundae constructor that takes 5 parameters.
     * @param name
     * @param calories
     * @param cost
     * @param topping
     * @param priceOfTopping
     */
    public Sundae(String name, int calories, double cost, String topping, double priceOfTopping){
        super(name, calories, cost);
        this.topping = topping;
        this.priceOfTopping = priceOfTopping;
    }

    /**
     * Gets the topping. 
     * @return topping
     */
    public String getTopping(){
        return topping;
    }

    /**
     * Sets the topping. 
     * @param topping
     */
    public void setTopping(String topping){
        this.topping = topping;
    }

    /**
     * Gets the priceOfTopping. 
     * @return priceOfTopping
     */
    public double getPriceOfTopping(){
        return priceOfTopping;
    }

    /**
     * Sets the priceOfTopping. 
     * @param priceOfTopping
     */
    public void setPriceOfTopping(double priceOfTopping){
        this.priceOfTopping = priceOfTopping;
    }
    
    /**
     * Gets the cost of IceCream by adding cost of an ice cream to the price of a topping. 
     * @return cost
     */
    public double getCost(){
        return super.getCost() + priceOfTopping;
    }

    @Override
    /**
     * Overriden toString method.
     * @return The string representation of a Sundae object.
     */
    public String toString(){
        return String.format("%s with\n%-20s\t%8.2f\n", getName(), getTopping(), getCost());
    }
}