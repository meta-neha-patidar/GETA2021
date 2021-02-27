package assignment01;
import java.util.*;

public class ShoppingCart {
	static HashMap<String,ItemDetails> listOfItems = new HashMap<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		//for adding items in item list 
		System.out.println("Enter the no. of items : ");
		int itemsInList = scanner.nextInt();
		while(itemsInList-- > 0){
			System.out.println("Enter the item name, quantity and price: ");
			String itemName = scanner.next();		//name of the item adding in the item list
			int quantityOfItem = scanner.nextInt();		
			float priceOfItem = scanner.nextFloat();
			ItemDetails itemDetails = new ItemDetails(quantityOfItem, priceOfItem);
			listOfItems.put(itemName, itemDetails);
			
		}
		System.out.println("List of items present for shopping");
		for(Map.Entry<String, ItemDetails> list: listOfItems.entrySet()){
			System.out.print(list.getKey() + "\t");
		}
		System.out.println();
		
		//for customer end operations while shopping
		System.out.println("=================================operations on cart for customer ======================");
		
		System.out.println("Enter 0 to stop operations on cart :");
		System.out.println("Enter 1 to add item in cart :");
		System.out.println("Enter 2 to remove one quantity of item from cart :");
		System.out.println("Enter 3 to remove product from cart :");
		System.out.println("Enter 4 to display item in cart :");
		System.out.println("Enter 5 to display bill of cart :");
		
		ShoppingCartOperations shoppingCartOperations = new ShoppingCartOperations();				//object of ShoppingCartOperations class
		
		int operationValue = scanner.nextInt();
		while(operationValue != 0){
			
			if(operationValue == 1){
				System.out.println("Enter item name and quantity : ");
				String itemNameAdd = scanner.next();
				int quantity=scanner.nextInt();
				shoppingCartOperations.addItemToCart(itemNameAdd, quantity);
			}
			else if(operationValue == 2){
				System.out.println("Enter item name : ");
				String itemNameToQuantityReduce = scanner.next();
				shoppingCartOperations.minimizeItemQuantityFromCart(itemNameToQuantityReduce);
			}
			else if(operationValue == 3){
				System.out.println("Enter item name : ");
				String itemToRemove = scanner.next();
				shoppingCartOperations.removeItemFromCart(itemToRemove);
			}
			else if(operationValue == 4){
				shoppingCartOperations.printCartList();
			}else if(operationValue == 5){
				shoppingCartOperations.billOfCartItemts();
			}else{
				System.out.println("Enter a valid input from 0-5");
			}
			shoppingCartOperations.cartPrice();
			System.out.println("Enter a input from 0-5 to perform any task : ");
			operationValue = scanner.nextInt();
		}
		System.out.println("operations done");
	}

}
