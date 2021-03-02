import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Scanner scanner=new Scanner(System.in);
			System.out.println("Enter 0 to exit : ");
			System.out.println("Enter 1 to compare two strings : ");
			System.out.println("Enter 2 to reverse string : ");
			System.out.println("Enter 3 to swap cases of string : ");
			System.out.println("Enter 4 to get largest word from string : ");
			
			//input for selecting which operation to be perform
			int operationCase = scanner.nextInt();
			
			//object creation for StringOperation class
			StringOperations object=new StringOperations();
			while (operationCase !=0){
				if(operationCase ==1){
					// compare strings
					try{
						System.out.println("Enter two strings : ");
						String string1=scanner.next();
						String string2 = scanner.next();
						System.out.println("Result of comparision : " + object.compareString(string1, string2));
					}catch (Exception e){
					}
				}
				else if(operationCase == 2){
					// reverse a string
					try{
						System.out.println("Enter a string : ");
						String string=scanner.next();
						System.out.println("Result : " + object.reverseString(string));
					}catch (Exception e){
						System.out.println("Invalid Input");
					}
				}
				else if(operationCase == 3){
					// swap case of letters of string
					try{
						System.out.println("Enter a string : ");
						StringBuilder string=new StringBuilder(scanner.next());
						System.out.println("Result : " + object.swapCases(string));
					}
					catch (Exception e){
						System.out.println("Invalid Input");
					}
				}
				else if(operationCase == 4){
					// largest word from string
					try{
						System.out.println("Enter a string having word separated by @ : ");
//					StringBuffer inputString = new StringBuffer(scanner.next());
						String inputString=scanner.next();
						String [] string = inputString.toString().split("@");
						System.out.println("Result : " + object.largestString(string));
					}catch (Exception e){
						System.out.println("Invalid input");
					}
				}
				else{
					System.out.println("Enter a valid input ");
				}
				
				System.out.println("Enter a num from 0-4 to perform any operation : ");
				operationCase = scanner.nextInt();
			}
			
		}
		catch (Exception e){
			System.out.println(e);
		}

	}

}
