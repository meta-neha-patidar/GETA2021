package bst;

import java.util.*;

import org.json.JSONException;
public class Main {

	static BST bst;
	
	public static void main(String[] args) throws JSONException {
		// TODO Auto-generated method stub
		String jsonString = "{" + "\"arrive\": \"reach a place at the end of a journey or a stage in a journey\","
				+ "\"organize\": \"arrange systematically\","
				+ "\"eager\": \"strongly wanting to do or have something\","
				+ "\"limit\": \"a point or level beyond which something does not or may not extend or pass\","
				+ "\"tease\": \"make fun of or attempt to provoke in a playful way\","
				+ "\"observe\": \"notice or perceive andd register it as being significa\","
				+ "\"resilience\": \"the capacity to recover quickly from difficulties\"" + "}";
		bst = new BST(jsonString);
		Scanner scanner = new Scanner (System.in);
		System.out.println("Enter 0 to stop perform operations");
		System.out.println("Enter 1 to search element");
		System.out.println("Enter 2 to add key value pair");
		System.out.println("Enter 3 to delete element from dictionary");
		System.out.println("Enter 4 to print sorted list of keys");
		System.out.println("Enter 5 to print sorted list of keys from one key to another key");
		int operationCase = scanner.nextInt();
		
		while(operationCase != 0){
			if(operationCase == 1){
				//search
				System.out.println("Enter a word to search");
				String word = scanner.next();
				String meaning = bst.getValue(word);
				if(meaning ==  null){
					System.out.println("word is not found ");
				}else{
					System.out.println(word + ":\t" + meaning);
				}
			}else if (operationCase == 2){
				//add
				System.out.println("Enter a word");
				String word = scanner.next();
				System.out.println("Enter meaning of word");
				String meaning = scanner.nextLine();
				if(word.length() > 0 && meaning.length() > 0){
					if(bst.add(word, meaning)){
						System.out.println("word and meaning added");
					}else{
						System.out.println("Duplicate element found");
					}
				}else{
					System.out.println("not a valid input");
				}
			}else if (operationCase == 3){
				System.out.println("Enter a word to delete");
				String word = scanner.next();
				if(bst.delete(word)){
					System.out.println("word is deleted");
				}else{
					System.out.println("word not present");
				}
			}else if (operationCase == 4){
				List<Node> sortedList = bst.sorted();
				if(sortedList.size() == 0){
					System.out.println("Empty Dictionary found");
				}else{
					System.out.println("word:\t meaning");
					for(Node node: sortedList){
						System.out.println(node.key+":\t" + node.value);
					}
				}
			}else if(operationCase == 5){
				System.out.println("Enter first word");
				String word1 = scanner.next();
				System.out.println("Enter last word");
				String word2 = scanner.next();
				if(word1.compareToIgnoreCase(word2)>0){
					System.out.println("enter valid input");
				}else{
					List<Node>sortedList = bst.sorteInBetween(word1, word2);
					if(sortedList.size()==0){
						System.out.println("Element not found");
					}else{
						System.out.println("word:\t meaning");
						for(Node node: sortedList){
							System.out.println(node.key+":\t" + node.value);
						}
					}
				}
				
			}else{
				System.out.println("Enter a valid test  case");
			}
			System.out.println("Enter operation case from 0 to 5");
			operationCase = scanner.nextInt();
		}
		
	}
}
