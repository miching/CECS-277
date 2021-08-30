import java.util.ArrayList;
import java.util.Scanner;

/**
 * A concrete class "Tester" that tests various aspects of the program.
 * @author Amir Hammoud
 * @author Katrina Orevillo
 * @author Michael Ching
 * Date: 10-05-2020
 */

public class Tester {

	public static void main(String[] args) {
		Scanner input = new Scanner(System. in );

		final Coin NICKEL = new Coin("nickel", 0.05);
		final Coin DIME = new Coin("dime", 0.10);
		final Coin QUARTER = new Coin("quarter", 0.25);
		final Coin DOLLAR = new Coin("dollar", 1.00);

		ArrayList <Coin> coins = new ArrayList <Coin>();

		coins.add(NICKEL);
		coins.add(DIME);
		coins.add(QUARTER);
		coins.add(DOLLAR);
		
		ArrayList <Product> products = new ArrayList <Product>();
		
		VendingMachine vend = new VendingMachine(products);
		

		boolean stillChoosing = true;

		do {
			System.out.println("S)how products  I)nsert coin  B)uy  A)dd product  R)emove coins  Q)uit");

			String choice = input.nextLine().toUpperCase();

			switch (choice) {
			case "S":
				for (int i = 0; i < products.size(); i++) {
					System.out.println(products.get(i));
				}
				break;
			case "I":
				boolean tryAgain = true;
				
				while(tryAgain) {
				char alphabet = 'A';
				for (int i = 0; i < coins.size(); i++) {
					System.out.println(alphabet + ") " + coins.get(i));
					alphabet++;
				}
				
				String choiceToInsertCoin = input.nextLine().toUpperCase();
				
				if(choiceToInsertCoin.equals("A")) {
					vend.coinsInsert(0.05);
					tryAgain = false;
				}
				else if(choiceToInsertCoin.equals("B")) {
					vend.coinsInsert(0.1);
					tryAgain = false;
				}
				else if(choiceToInsertCoin.equals("C")) {
					vend.coinsInsert(0.25);
					tryAgain = false;
				}
				else if(choiceToInsertCoin.equals("D")) {
					vend.coinsInsert(1.00);
					tryAgain = false;
				}
				else
					System.out.println("Invalid input, please try again.");
				}
				
				break;
				
			case "B":
				
				char alphabet = 'A';
				int itemChoice = 0;
				
				for(int i = 0; i < products.size(); i++)
				{
					
					System.out.println(alphabet + ") " + products.get(i));
					alphabet++;
					
				}
				
				char choiceOfProduct = input.nextLine().toUpperCase().charAt(0);
				char compareChoice = 'A';
				
				for(int i = 0; i < products.size(); i++) 
				{

					if(choiceOfProduct == (compareChoice) )
					{
						
						itemChoice = i;
						
					}
					compareChoice++;
					
					
				}
				
				if (products.get(itemChoice).getQuantity() <= 0){
					System.out.println("Product is sold out.");
					System.out.println("Returned: $" + vend.removeAllCoins());
                  }
				else if (products.get(itemChoice).getPrice() > vend.getMoneyEntered()) {
					System.out.println("Insufficient money.");
					System.out.println("Returned: $" + vend.removeAllCoins());
				}
              else
                  System.out.println(vend.buyProduct(itemChoice));
				
				break;
				
			case "A":
				System.out.println("Description: ");
				String description = input.next();
				
				System.out.println("Price: ");
				double price = input.nextDouble();
				
				System.out.println("Quantity: ");
				int quantity = input.nextInt();
				
				input.nextLine();
				
				products.add(new Product(description, price, quantity));
				
				break;
				
			case "R":
				System.out.println("Removed: $" + vend.removeAllCoins() );
				break;
				
			case "Q":
				stillChoosing = false;
				break;
				
			default:
				System.out.println("Invalid choice, please try again.");
				break;
			}

		} while ( stillChoosing == true );
		
		input.close();
	}
}
