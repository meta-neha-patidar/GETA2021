package string;
import java.util.*;
/*
 * @author Neha Patidar
 * @since 11-03-2021
 * @version 0.1
 */
public class UniqueCharacter {
	static HashMap<String, Integer> container = new HashMap<>();
	/*
	 * @objective count the unique characters in a given string
	 * @param inputString
	 * @return uniqueChar
	 */
	static int uniqueCharacterCount(String inputString){
		if(container.containsKey(inputString))
			return container.get(inputString);
		HashSet <Character> distChar = new HashSet<>();
		for(int index = 0; index < inputString.length(); index++){
			if(!distChar.contains(inputString.charAt(index))){
				distChar.add(inputString.charAt(index));
			}
		}
		container.put(inputString,distChar.size());
		return distChar.size();
	}
	
	/*
	 * main() method
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter 0 to stop performance");
		System.out.println("Enter any integer to count unique character in string ");
		int operation = scanner.nextInt();
		while(operation != 0){
			System.out.println("Enter a string to count the unique character");
			String inputString = scanner.next();
			System.out.println("Number of unique character in given string = " + uniqueCharacterCount(inputString));
			
			System.out.println("Enter 0 to stop performance");
			System.out.println("Enter any integer to count unique character in string ");
			operation = scanner.nextInt();
		}
	}

}
