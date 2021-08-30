/**
 * A concrete sub class "Cookies" that extends from the super class "DessertItem".
 * Provides methods to get and set the number of cookies and price per dozen.
 * Also implements code to define the abstract method getCost from the super class.
 * @author Amir Hammoud
 * @author Katrina Orevillo
 * @author Michael Ching
 * Date: 9-23-2020
 */

public class Cookies extends DessertItem{

    private int numberOfCookies;
    private double pricePerDozen;

    // Default Cookies constructor, takes no parameters.
    public Cookies(){
        super();
        numberOfCookies = 0;
        pricePerDozen = 0;
    }

    /**
     * Cookies constructor that takes 4 parameters.
     * @param name
     * @param calories
     * @param numberOfCookies
     * @param pricePerDozen
     */
    public Cookies(String name, int calories, int numberOfCookies, double pricePerDozen){
        super(name, calories);
        this.numberOfCookies = numberOfCookies;
        this.pricePerDozen = pricePerDozen;
    }

    /**
     * Gets the numberOfCookies. 
     * @return numberOfCookies
     */
    public double getNumberOfCookies(){
        return numberOfCookies;
    }

    /**
     * Gets the pricePerDozen. 
     * @return pricePerDozen
     */
    public double getPricePerDozen(){
        return pricePerDozen;
    }

    /**
     * Sets the numberOfCookies. 
     * @param numberOfCookes
     */
    public void setWeightInPounds(int numberOfCookies){
        this.numberOfCookies = numberOfCookies;
    }

    /**
     * Sets the pricePerDozen. 
     * @param pricePerDozen
     */
    public void setPriceInPennies(double pricePerDozen){
        this.pricePerDozen = pricePerDozen;
    }

    @Override
    /**
     * Overridden getCalories method.
     * @return calories of the cookies
     */
    public int getCalories(){
        double temp = calories * numberOfCookies;
        double newCalories = (int)Math.round(temp);
        return (int)newCalories;
    }
      
    /**
     * Calculates the cost of cookies in dollars. 
     * @return cost
     */
    public double getCost(){
        return (double)numberOfCookies / 12 * pricePerDozen;
    }
    
    @Override
    /**
     * Overriden toString method.
     * @return The string representation of a Cookies object.
     */
    public String toString(){
        return numberOfCookies + " @ " + pricePerDozen + " /dz.\n" + String.format("%-20s\t%8.2f\n", getName(), getCost());
    }
}

