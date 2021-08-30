/**
 * 
 * @author Mika Wong, Nicolas Guardado, Gem Balagtas, Michael Ching
 * Due Date: December 7, 2020
 * Purpose: This class describes a roach colony and a few methods associated with the roach colonies
 *
 */
public class RoachColony implements RoachColonyInterface {
	
	private String roachName;
	private int roachPop;
	private double growthRate;
	
	/**Default RoachColony constructor*/
	public RoachColony() {
		roachName = "";
		roachPop = 0;
		growthRate = 0;
	}
	
	/**
	 * RoachColony constructor
	 * @param type String n is the name of the colony
	 * @param type int p is the colony's population
	 * @param type double g is the colony's growth rate
	 */
	public RoachColony(String n, int p, double g)
	{
		roachName = n;
		roachPop = p;
		growthRate = g;
	}
	
	/**
	 * Method that gets the Roach Colony's name
	 * @return the Roach Colony's name
	 */
	public String getName()
	{
		return roachName;
	}
	
	/**
	 * Method that gets the Roach Colony's population
	 * @return the Roach Colony's population
	 */
	public int getPop()
	{
		return roachPop;
	}
	
	/**
	 * Method that gets the Roach Colony's growth rate
	 * @return the Roach Colony's growth rate
	 */
	public double getRate()
	{
		return growthRate;
	}
	
	/**
	 * Method that gets the Roach Colony's name and population
	 * @return the Roach Colony's name and population
	 */
	public String getColony() { 
		return roachName + " " + roachPop;
	}
	
	/**
	 * Method that updates the RoachColonies on the waitlist when a room opens up
	 */
	public String update()
	{
		return (this.roachName + " has recieved the notification from ");
	}
	
	/**
	 * Method that grows the colony's population by it's growth rate, then reduces the colony's population
	 * depending on if they have the shower amenity or not
	 * @return a confirmation that there was a party
	 */
	public String party()
	{
		roachPop = (int) Math.round(roachPop * (1 + growthRate));
		if (RoachMotel.getRoachColony(this).toLowerCase().contains("shower"))
		{
			roachPop = (int) Math.round(roachPop * 0.75);
		}
		else
		{
			roachPop = (int) Math.round(roachPop * 0.5);
		}
		return "Time to party!";
	}
	
	/**This overrides the object's tostring method
	 * @Override Object's tostring method
	 * @return String Displays Deluxe Room characteristics
	 */
	public String toString()
	{
		return "Colony Name: " + roachName + "; Population: " + roachPop;
	}
	

}
