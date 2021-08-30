import java.util.ArrayList;

/**
 * A concrete class "Checkout" that provides methods to enter dessert items into the 
 * cash register, clear the cash register, get the number of items, get the total cost of the items (before tax),
 * get the total tax for the items and get a String representing a receipt for the dessert items.
 * @author Amir Hammoud
 * @author Katrina Orevillo
 * @author Michael Ching
 * Date: 9-23-2020
 */


public class Checkout {
    
  private ArrayList<DessertItem> itemList;
  private double taxRate;

  /**
   * Creates a Checkout instance with an empty list of DessertItem's
   */
  Checkout() {
     itemList = new ArrayList<DessertItem>();
   }

  /**
   * Clears the Checkout to begin checking out a new set of items
   */
  public void clear() {
    itemList.clear();
  }

  /**
   * A DessertItem is added to the end of the list of items
   @param item - DessertItem to add to list of items
   */
   public void enterItem(DessertItem item) {
     itemList.add(item);
   }
  
  /**
   * Returns the number of DessertItem's in the list
   * @return number of DessertItem's in the list
   */
  public int numberOfItems() {
    return itemList.size();
  }

  /**
   * Returns total cost of items
   * @return total cost of items in cents (without tax)
   */
  public int totalCost() {
    double totalCost = 0;

    for (int i = 0; i < numberOfItems(); i++) {
      totalCost += Math.round((itemList.get(i).getCost()) * 100);
    }

    return (int)totalCost;
  }

  /**
   * Returns total tax on items
   * @return total tax on items in cents
   */
  public int totalTax() {
    double totalTax = (totalCost() * getTaxRate()) / 100;
    return (int)totalTax;
  }

  /**
   * Returns tax rate for this purchase
   * @return tax rate
   */
  public double getTaxRate() {
    return taxRate;
  }

  /**
   * Changes tax rate for this purchase
   * @return tax rate
   */
  public void setTaxRate(double tRate) {
    taxRate = tRate;
  }
  
  @Override
    /**
     * Overriden toString method.
     * @return a String representing a receipt for the current list of DessertItem's 
     * with the name of the Dessert store, the items purchased, the tax, and the total cost
     */
  public String toString() {
    String nameOfStore = "A&S Dessert Shop";
    String divider = "----------------";
    String currentReceipt = String.format("%24s\n%24s\n", nameOfStore, divider);

    for (int i = 0; i < numberOfItems(); i++) {
      currentReceipt += itemList.get(i).toString();
    }

    currentReceipt += String.format("\n%-20s\t%8.2f\n", "Tax:", (totalTax() / 100.00));
    currentReceipt += String.format("%-20s\t%8.2f\n", "Total Cost:", ((totalCost() / 100.00) + (totalTax() / 100.00)));
    
    return currentReceipt;
  }
}
