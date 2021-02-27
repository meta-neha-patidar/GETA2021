package assignment1feb18;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter 0 to stop performing any operation : ");
		System.out.println("Enter 1 to perform addition of two hex values: ");
		System.out.println("Enter 2 to perform subtraction of one hex value by other hex value ");
		System.out.println("Enter 3 to perform multiplication of two hex values: ");
		System.out.println("Enter 4 to perform division of one hex value by other hex value: ");
		System.out.println("Enter 5 to check weather two hex strings are equal or not : ");
		System.out.println("Enter 6 to check if first hex value is greater than second hex value or not : ");
		System.out.println("Enter 7 to check if first hex value is smaller than second hex value or not : ");
		System.out.println("Enter 8 to convert hex value into integer : ");
		System.out.println("Enter 9 to convert integer value into hex value : ");
		
		// take input for perform hex calculation operations 
		int varToOperation = scanner.nextInt();
		//object initialization of HexCalc class
		HexCalc object = new HexCalc();
		while(varToOperation != 0){
			if(varToOperation >= 1 && varToOperation <= 7){
				String var1 = scanner.next();
				String var2 = scanner.next();
				if(varToOperation == 1){
					System.out.println("Addtion of "+ var1 + " and " + var2 + " = " + object.addHex(var1,var2));
				}
				else if(varToOperation == 2){
					System.out.println("Subtraction of "+ var1 + " with " + var2 + " = " + object.subtractHex(var1,var2));
				}
				else if(varToOperation == 3){
					System.out.println("Multiplication of "+ var1 + " with " + var2 + " = " + object.multiplyHex(var1,var2));
				}
				else if(varToOperation == 4){
					System.out.println("Division of "+ var1 + " by " + var2 + " = " + object.divideHex(var1,var2));
				}
				else if(varToOperation == 5){
					try{
						var1 = Integer.toHexString(Integer.parseInt(var1,16));
						var1 = Integer.toHexString(Integer.parseInt(var2,16));
						System.out.println( var1 + " and " + var2 + " are equal = " + object.isEqualHex(var1,var2));
					}catch (Exception e){
						System.out.println("Invalid Input");
					}
				}
				else if(varToOperation == 6){
					try{
						var1 = Integer.toHexString(Integer.parseInt(var1,16));
						var1 = Integer.toHexString(Integer.parseInt(var2,16));
						System.out.println( var1 + "is greater than  " + var2 + " = " + object.isGreaterHex(var1,var2));
					}catch (Exception e){
						System.out.println("Invalid Input");
					}
				}
				else if(varToOperation == 7){
					try{
						var1 = Integer.toHexString(Integer.parseInt(var1,16));
						var1 = Integer.toHexString(Integer.parseInt(var2,16));
						System.out.println( var1 + "is smaller than " + var2 + " = " + object.isSmallerHex(var1,var2));
					}catch (Exception e){
						System.out.println("Invalid Input");
					}
				}
			}
			else if(varToOperation == 8){
				String var1 = scanner.next();
				System.out.println("decimal representation of hexvalue " + var1 + " is : " + object.decimalRepersentaion(var1));
				
			}
			else if(varToOperation == 9){
				int var1 = scanner.nextInt();
				System.out.println("Hexadecimal representation of hexvalue " + var1 + " is : " + object.hexRepresentation(var1));
			}
			else System.out.println("Enter a valid input from 0 to 9 "); 	//if  input for perform operation is not in range of 0-9(inclusive)
			varToOperation = scanner.nextInt();
		}
		System.out.println("you are exit from operations performing");			//take input to perform further operations
	}

}
