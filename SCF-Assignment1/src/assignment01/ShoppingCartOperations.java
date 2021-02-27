package assignment01;
import java.util.*;
public class ShoppingCartOperations {
static HashMap<String,Integer> cartItemList = new HashMap<>();
	
	// printCartList() method print all the item present in the cart with quantity
	void printCartList(){
		System.out.println("===================items and quantity in cart======================");
		System.out.println("item name:\t quantity");
		for(Map.Entry<String, Integer> iterator: cartItemList.entrySet()){
			System.out.println(iterator.getKey() + ":\t\t\t" + iterator.getValue());
		}
	}
	
	// addItemToCart() method adds 1 quantity of any item at a time
	void addItemToCart(String itemToAddInCart, int quantity){
		if(! ShoppingCart.listOfItems.containsKey(itemToAddInCart)){	
			System.out.println("Item is not available ");		//if item is not present in shopping item list that customer want
			return;
		}
		if(!cartItemList.containsKey(itemToAddInCart)){		//if item is not present in cart then add item with 1 quantity
			if(ShoppingCart.listOfItems.get(itemToAddInCart).itemQuantity >= quantity){
				
				cartItemList.put(itemToAddInCart,quantity );
				ItemDetails temp = new ItemDetails(ShoppingCart.listOfItems.get(itemToAddInCart).itemQuantity - quantity,ShoppingCart.listOfItems.get(itemToAddInCart).priceOfItem);
				ShoppingCart.listOfItems.replace(itemToAddInCart, temp);
			}
			else{
				System.out.println("Insufficient quantity ");	
			}
			
		}
		else if(ShoppingCart.listOfItems.get(itemToAddInCart).itemQuantity >= quantity){
			//if item is present in cart then increment quantity of item by 1
			cartItemList.replace(itemToAddInCart, cartItemList.get(itemToAddInCart) + quantity);
			ItemDetails temp = new ItemDetails(ShoppingCart.listOfItems.get(itemToAddInCart).itemQuantity - quantity,ShoppingCart.listOfItems.get(itemToAddInCart).priceOfItem);
			ShoppingCart.listOfItems.replace(itemToAddInCart, temp);
			
		}else
				System.out.println("no more quantity available");		//out of limit
		
			
	}
	
	
	//minimizeItemQuantityFromCart() method reduce one quantity of item from cart
	void minimizeItemQuantityFromCart(String itemToMinimize){
		if(!cartItemList.containsKey(itemToMinimize)){	//if item is not present in the cart	
			System.out.println("Item is not in the cart list");
			return ;
		}
		ItemDetails temp=new ItemDetails(ShoppingCart.listOfItems.get(itemToMinimize).itemQuantity + 1 , ShoppingCart.listOfItems.get(itemToMinimize).priceOfItem);
		ShoppingCart.listOfItems.replace(itemToMinimize, temp);
		if(cartItemList.get(itemToMinimize) == 1)
			cartItemList.remove(itemToMinimize);		//remove item from cart if item quantity is 1
		else 
			cartItemList.replace(itemToMinimize, cartItemList.get(itemToMinimize) - 1);		//decrease the quantity of item from cart when item quantity is more than 1
		
	}
	
	//removeItemFromCart() method remove all quantities of item from cart if it is present
	void removeItemFromCart(String itemToRemove){
		if(cartItemList.containsKey(itemToRemove)){
			
			ItemDetails temp = new ItemDetails(ShoppingCart.listOfItems.get(itemToRemove).itemQuantity +  cartItemList.get(itemToRemove), ShoppingCart.listOfItems.get(itemToRemove).priceOfItem);
			cartItemList.remove(itemToRemove);
			ShoppingCart.listOfItems.put(itemToRemove, temp);
		}else{
			System.out.println("Item is not in the cart list");
		}
	}
	
	//billOfCartItemts() method print the total bill of all items present in cart
	void billOfCartItemts(){
		float totalPrice = 0;
		System.out.println("item name\t quantity \t price per quantity \t price of all quantity");
		
		for(Map.Entry<String, Integer> billIterator: cartItemList.entrySet()){
			System.out.println(billIterator.getKey() + "\t\t\t" + billIterator.getValue() + "\t\t\t"+
					ShoppingCart.listOfItems.get(billIterator.getKey()).priceOfItem + 
					"\t\t\t" + ShoppingCart.listOfItems.get(billIterator.getKey()).priceOfItem * billIterator.getValue());
			totalPrice += ShoppingCart.listOfItems.get(billIterator.getKey()).priceOfItem * billIterator.getValue();
		}
		
		System.out.println("\nTotal bill of cart items :\t\t\t\t\t\t" + totalPrice);
	}
	void cartPrice(){
		float totalPrice = 0;
		for(Map.Entry<String, Integer> billIterator: cartItemList.entrySet()){
			totalPrice += ShoppingCart.listOfItems.get(billIterator.getKey()).priceOfItem * billIterator.getValue();
		}
		
		System.out.println("==================Total price of cart items : " + totalPrice + "========================");
	}
}
