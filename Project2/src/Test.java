import java.util.*;

/**
 * A concrete class "Test" that tests various aspects of the program.
 * @author Amir Hammoud
 * @author Katrina Orevillo
 * @author Michael Ching
 * Date: 9-23-2020
 */

public class Test {

	/**
     * Extensively tests the following:
	 * 1) Using polymorphism to test every subclasses toString() method.
	 * 2) If the Checkout object prints out a receipt by taking advantage of polymorphism 
	 * by using the toString method of every subclass under the DessertItem super class.
	 * 3) Tests if the Max method properly displays the larger calorie amount between two DessertItems of the same type.
	 * 4) Tests if the Max method properly displays the larger calorie amount between two DessertItems of different types.
	 * 5) Shows that all DessertItems added to an ArrayList are sorted it.
     * @param args
     */
	public static void main(String[] args) {
	  DessertItem c1 = new Candy();
	  DessertItem c2 = new Candy("Corn(Candy)", 333, 1.5, 7.25);
	  DessertItem c3 = new Candy("Lolipop(Candy)", 256, 2.5, 8.25);
  
	  System.out.println("\n-----------------------------------\nCANDY TEST:");
	  System.out.println(c1);
	  System.out.println(c2);
  
	  System.out.println(c2.getName() + " calories: " + c2.getCalories() + "\n");
	  System.out.println(c3);
  
	  System.out.println(c3.getName() + " calories: " + c3.getCalories());
  
	  DessertItem co1 = new Cookies();
	  DessertItem co2 = new Cookies("ChocChip(Cookie)", 16, 17, 4.99);
	  DessertItem co3 = new Cookies("Oatmeal(Cookie)", 16, 15, 3.99);
  
	  System.out.println("\n-----------------------------------\nCOOKIE TEST:");
  
	  System.out.println(co1);
	  System.out.println(co2);
  
	  System.out.println(co2.getName() + " calories: " + co2.getCalories() + "\n");
  
	  System.out.println(co3);
  
	  System.out.println(co3.getName() + " calories: " + co3.getCalories());
  
	  DessertItem i1 = new IceCream();
	  DessertItem i2 = new IceCream("Vanilla(IceCream)", 500, 10.05);
	  DessertItem i3 = new IceCream("Chocolate(IceCream)", 500, 9.99);
  
	  System.out.println("\n-----------------------------------\nICE CREAM TEST:");
  
	  System.out.println(i1);
	  System.out.println(i2);
  
	  System.out.println(i2.getName() + " calories: " + i2.getCalories() + "\n");
  
	  System.out.println(i3);
  
	  System.out.println(i3.getName() + " calories: " + i3.getCalories());
  
	  DessertItem s1 = new Sundae();
	  DessertItem s2 = new Sundae("Caramel(Sundae)", 600, 6.00, "HotFudge(Topping)", 1.70);
	  DessertItem s3 = new Sundae("BananaSplit(Sundae)", 560, 6.00, "Strawberries(Topping)", .90);
	  System.out.println("\n-----------------------------------\nSUNDAE TEST:");
  
	  System.out.println(s1);
	  System.out.println(s2);
  
	  System.out.println(s2.getName() + " calories: " + s2.getCalories() + "\n");
  
	  System.out.println(s3);
  
	  System.out.println(s3.getName() + " calories: " + s3.getCalories());
  
	  System.out.println("-----------------------------------");

      //Tests constructor, setTaxRate, getTaxRate
      Checkout receipt = new Checkout();
      receipt.setTaxRate(8.5);
      System.out.println("Output Receipt: \n");

      //Tests enterItem, numberOfItems, toString, totalCost, totalTax
      receipt.enterItem(c2);
      receipt.enterItem(co2);
      receipt.enterItem(i2);
      receipt.enterItem(s2);
	  
	  System.out.println("Number of Items: " + receipt.numberOfItems());
	  System.out.println("Total cost: " + receipt.totalCost());
	  System.out.println("Total tax: " + receipt.totalTax());
	  System.out.println("Cost + Tax: " + (receipt.totalCost() + receipt.totalTax()));
      System.out.println();
      System.out.println(receipt.toString());

      //Tests clear
      receipt.clear();
      System.out.println("List cleared. Number of Items: " + receipt.numberOfItems() + "\n");
	  
  
	  //Arraylist to make it easier to print
	  ArrayList < DessertItem > dessert = new ArrayList < DessertItem > ();
  
	  dessert.add(c2);
	  dessert.add(c3);
  
	  dessert.add(co2);
	  dessert.add(co3);
  
	  dessert.add(i2);
	  dessert.add(i3);
  
	  dessert.add(s2);
	  dessert.add(s3);

	  System.out.println("-----------------------------------");
  
	  System.out.println("Max Test With Same DessertItem Types: ");
  
	  for (int i = 0; i < dessert.size() - 1; i++) {
  
		if ((dessert.get(i) instanceof Candy) && (dessert.get(i + 1) instanceof Candy) || (dessert.get(i) instanceof Cookies) && (dessert.get(i + 1) instanceof Cookies) || (dessert.get(i) instanceof IceCream) && (dessert.get(i + 1) instanceof IceCream) && !(dessert.get(i) instanceof Sundae) && !(dessert.get(i+1) instanceof Sundae)  || (dessert.get(i) instanceof Sundae) && (dessert.get(i + 1) instanceof Sundae) ) {
  
		  if (dessert.get(i).getCalories() == dessert.get(i + 1).getCalories() ) {
  
			System.out.println(dessert.get(i).name + " with " + dessert.get(i).getCalories() + " calories is equal to " + dessert.get(i + 1).name + " with " + dessert.get(i + 1).getCalories() + " calories.");
  
		  }
  
		  else {
  
			DessertItem greater = DessertItem.Max(dessert.get(i), dessert.get(i + 1));
			DessertItem lesser;
  
			if (greater.equals(dessert.get(i))) {
  
			  lesser = dessert.get(i + 1);
  
			}
  
			else {
  
			  lesser = dessert.get(i);
  
			}
  
			System.out.println(greater.name + " with " + greater.getCalories() + " calories is bigger than " + lesser.name + " with " + lesser.getCalories() + " calories.");
  
		  }
  
		}
  
	  }
  
	  System.out.println("-----------------------------------");
	  
	  System.out.println("Max Test With Different DessertItem Types: ");
  
	  //made an ArrayList to make it easier to print
	  ArrayList < DessertItem > test = new ArrayList < DessertItem > ();
  
	  DessertItem t1 = DessertItem.Max(c2, co2);
	  DessertItem l1;
  
	  if (t1 instanceof Candy) {
  
		l1 = co2;
  
	  }
  
	  else {
  
		l1 = c2;
  
	  }
  
	  DessertItem t2 = DessertItem.Max(c3, co3);
	  DessertItem l2;
	  if (t2 instanceof Candy) {
  
		l2 = co3;
  
	  }
  
	  else {
  
		l2 = c3;
  
	  }
  
	  DessertItem t3 = DessertItem.Max(s2, co2);
	  DessertItem l3;
	  if (t3 instanceof Sundae) {
  
		l3 = co2;
  
	  }
  
	  else {
  
		l3 = s2;
  
	  }
  
	  DessertItem t4 = DessertItem.Max(s3, c3);
	  DessertItem l4;
	  if (t4 instanceof Sundae) {
  
		l4 = c3;
  
	  }
  
	  else {
  
		l4 = s3;
  
	  }
  
	  DessertItem t5 = DessertItem.Max(c2, i3);
	  DessertItem l5;
	  if (t5 instanceof Candy) {
  
		l5 = i3;
  
	  }
  
	  else {
  
		l5 = c2;
  
	  }
  
	  test.add(t1);
	  test.add(l1);
  
	  test.add(t2);
	  test.add(l2);
  
	  test.add(t3);
	  test.add(l3);
  
	  test.add(t4);
	  test.add(l4);
  
	  test.add(t5);
	  test.add(l5);
  
	  for (int i = 0; i < test.size() - 1; i += 2) {
  
		if (test.get(i).getCalories() == test.get(i + 1).getCalories()) {
  
		  System.out.println(test.get(i).name + " with " + test.get(i).getCalories() + " calories is equal to " + test.get(i + 1).name + " with " + test.get(i + 1).getCalories() + " calories.");
  
		}
  
		else {
  
		  System.out.println(test.get(i).name + " with " + test.get(i).getCalories() + " calories is bigger than " + test.get(i + 1).name + " with " + test.get(i + 1).getCalories() + " calories.");
  
		}
  
	  }
  
	  System.out.println("-----------------------------------");
	  
	  System.out.println("The unsorted DessertList is: ");
	  for (int i = 0; i < dessert.size(); i++) {
  
		System.out.println(dessert.get(i).name + " has " + dessert.get(i).getCalories() + " calories.");
  
	  }
  
	  System.out.println("-----------------------------------");
	  
	  System.out.println("The sorted DessertList is: ");
  
	  Collections.sort(dessert);
	  for (int i = 0; i < dessert.size(); i++) {
  
		System.out.println(dessert.get(i).name + " has " + dessert.get(i).getCalories() + " calories.");
  
	  }
	}
  }
