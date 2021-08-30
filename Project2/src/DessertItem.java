/**
 * An abstract super class that all sub classes will extend.
 * Provides methods to get the name of the dessert as well as getting and setting the calories (setting the calories can be overriden).
 * Provides an abstract class to implement a unique way for sub classes to get the cost of a particular dessert item.
 * @author Amir Hammoud
 * @author Katrina Orevillo
 * @author Michael Ching
 * @author Mimi Opkins
 * Date: 9-23-2020
 */

public abstract class DessertItem implements Comparable<DessertItem>{

  protected String name;
  protected int calories;

/**
 * Null constructor for DessertItem class
 */
  public DessertItem(){
    this("", 0);
  }

/**
 * Initializes DessertItem data
 */
  public DessertItem(String name, int calories){
      this.name = name;
      this.calories = calories;
  }

/**
 * Returns name of DessertItem
 * @return name of DessertItem
 */
  public final String getName(){
    return name;
  }

/**
 * Returns calories of DessertItem
 * @return calories of DessertItem
 */
  public int getCalories(){
    return calories;
  }
  
/**
 * Sets the calories. 
 * @param calories
 */
  public void setCalories(int calories){
    this.calories = calories;
  }


  /**
   * Compares and differentiates the calories of the objects
   * @param DessertItem
   * @return int difference in calories
   */
  @Override
  public int compareTo(DessertItem d2){
    return (this.getCalories() - d2.getCalories());
  }
		
  
  /**
   * Returns the larger of the 2 DessertItems, but returns the first DessertItem if equal
   * @param ds DessertItem one
   * @param ds2 DessertItem two
   * @return the larger DessertItem
   */
 public static DessertItem Max(DessertItem ds, DessertItem ds2){
	 
	 //return first object if equal
	 if(ds.compareTo(ds2) == 0){
     return ds;
    }
	 else if (ds.compareTo(ds2) > 0){
     return ds;
    }
    else{
      return ds2;
    }
  }
  
/**
 * Returns cost of DessertItem
 * @return cost of DessertItem
 */
  public abstract double getCost();
}