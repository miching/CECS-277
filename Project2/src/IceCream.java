/**
 * A concrete sub class "IceCream" that extends from the super class "DessertItem".
 * Provides a method to set the cost of the ice cream.
 * Also implements code to define the abstract method getCost from the super class.
 * @author Amir Hammoud
 * @author Katrina Orevillo
 * @author Michael Ching
 * Date: 9-23-2020
 */

public class IceCream extends DessertItem{

    private double cost;

    // Default IceCream constructor, takes no parameters.
    public IceCream(){
        super();
        cost = 0;
    }

    /**
     * Ice Cream constructor that takes 3 parameters.
     * @param name
     * @param calories
     * @param cost
     */
    public IceCream(String name, int calories, double cost){
        super(name, calories);
        this.cost = cost;
    }
    
    /**
     * Gets the cost of IceCream. 
     * @return cost
     */
    public double getCost(){
        return cost;
    }

     /**
     * Sets the cost. 
     * @param cost
     */
    public void setCost(double cost){
        this.cost = cost;
    }

    @Override
    /**
     * Overriden toString method.
     * @return The string representation of an IceCream object.
     */
    public String toString(){
        return String.format("%-20s\t%8.2f\n", getName(), getCost());
    }
}