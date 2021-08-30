import java.util.ArrayList;

/**
 * A concrete class that constructs a vending machine, holding the products and dealing with transactions
 * @author Amir Hammoud
 * @author Katrina Orevillo
 * @author Michael Ching
 * Date: 10-05-2020
 */
public class VendingMachine 
{

	double moneyEntered;
	ArrayList <Product> products;
	
	/**
	 * Default Constructor
	 */
	public VendingMachine()
	{
		
		moneyEntered = 0;
		products = null;
		
	}
	
	/**
	 * Overload Constructor
	 * @param products ArrayList of the products
	 */
	public VendingMachine(ArrayList<Product> products)
	{
		
		this.products = products;
		moneyEntered = 0;
		
	}
	
	/**
	 * Keep track of the money inserted by the user
	 * @param money the amount the user has entered into the machine
	 */
	public void coinsInsert(double money)
	{
		
		this.moneyEntered += money;
		
	}
	
	/**
     * Returns money entered
     * @return amount of money in the vending machine
     */
    public double getMoneyEntered()
    {

        return moneyEntered;

    }
	
	/**
	 * Returns all the coins that have not been used
	 * @return the change of the money inserted
	 */
	public double removeAllCoins()
	{
		
		double remove = moneyEntered;
		moneyEntered = 0;
		return remove;
		
		
	}
	
	/**
	 * Determines whether an product is buy able or not
	 * @param itemChoice the item desired by user
	 * @return The outcome of whether it was bought or not
	 */
	public String buyProduct(int itemChoice)
	{
		
		//itemChoice = itemChoice - 1;
		
		if(products.get(itemChoice).getQuantity() <= 0)
		{
			
			return "This product is out of stock.";
			
		}
		
		else if (products.get(itemChoice).getPrice() <= moneyEntered)
		{
			
			moneyEntered -= products.get(itemChoice).getPrice();
			int supply = (int)products.get(itemChoice).getQuantity()-1;
			products.get(itemChoice).setQuantity(supply);
			
			return "Purchased: " + products.get(itemChoice);
			
		}
		
		else 
		{
			
			return "Insufficient money";
			
		}
		
			
	}
	
	/**
	 * Prints out the vending machines current products and cost
	 */
	@Override
	public String toString()
	{
		
		String display = null;
		for(int i = 0; i < products.size(); i++)
		{
			
			display += products.get(i).toString();
			
		}
		
		return display;
		
	}
	
	
}