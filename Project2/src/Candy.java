/**
 * A concrete sub class "Candy" that extends from the super class "DessertItem".
 * Provides methods to get and set the weight in pounds and the price per pounds.
 * Also implements code to define the abstract method getCost from the super class.
 * @author Amir Hammoud
 * @author Katrina Orevillo
 * @author Michael Ching
 * Date: 9-23-2020
 */

public class Candy extends DessertItem{

    private double weightInPounds, pricePerPound;

    // Default Candy constructor, takes no parameters.
    public Candy(){
        super();
        weightInPounds = 0;
        pricePerPound = 0;
    }

    /**
     * Candy constructor that takes 4 parameters.
     * @param name
     * @param calories
     * @param weightInPounds
     * @param pricePerPound
     */
    public Candy(String name, int calories, double weightInPounds, double pricePerPound){
        super(name, calories);
        this.weightInPounds = weightInPounds;
        this.pricePerPound = pricePerPound;
    }

    /**
     * Gets the weightInPounds. 
     * @return weightInPounds
     */
    public double getWeightInPounds(){
        return weightInPounds;
    }

    /**
     * Gets the pricePerPound. 
     * @return pricePerPound
     */
    public double getPricePerPound(){
        return pricePerPound;
    }

     /**
     * Sets the weightInPounds. 
     * @param weightInPounds
     */
    public void setWeightInPounds(double weightInPounds){
        this.weightInPounds = weightInPounds;
    }

    /**
     * Sets the pricePerPound. 
     * @param pricePerPound
     */
    public void setPriceInPennies(double pricePerPound){
        this.pricePerPound = pricePerPound;
    }

    @Override
    /**
     * Overridden getCalories method.
     * @return calories of the candy
     */
    public int getCalories(){
        double temp = calories * weightInPounds;
        double newCalories = (int)Math.round(temp);
        return (int)newCalories;
    }

     /**
     * Calculates the cost of candy in dollars. 
     * @return cost
     */
    public double getCost(){
        return weightInPounds * pricePerPound;
    }

    @Override
    /**
     * Overriden toString method.
     * @return The string representation of a Candy object.
     */
    public String toString(){
        return weightInPounds + " lbs. @ " + pricePerPound + " /lb.\n" + String.format("%-20s\t%8.2f\n", getName(), getCost());
    }
}

