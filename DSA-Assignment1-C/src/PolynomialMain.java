import java.util.*;
/*
 * PolynomialMain Method
 * 
 */
public class PolynomialMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the variables of polynomial : ");
		String variables = scanner.next();
		PolynomialOperations polynomial = new PolynomialOperations(variables);
		System.out.println("Enter 0 to stop operations : ");
		System.out.println("Enter 1 to add term in polynomial ");
		System.out.println("Enter 2 for print polynomial ");
		System.out.println("Enter 3 to print degree of polynomial ");
		int operation = scanner.nextInt();
		while(operation != 0){
			if (operation == 1){
				System.out.println("Enter cooficient of term and power of all variables " + variables);
				int cooficientInput = scanner.nextInt();
				int varPwrArray [] = new int[variables.length()];
				for(int i = 0; i < variables.length();i++){
					varPwrArray[i] = scanner.nextInt();
				}
				polynomial.addTerm(cooficientInput, varPwrArray);
			}
			else if (operation == 2){
				polynomial.printPolynomial();
			}
			else if (operation == 3){
				System.out.println("Degree of polynomial : " + polynomial.degreeOfPolynomial());
			}else{
				System.out.println("Invalid Input");
			}
			System.out.println("Enter value from 0-3 to perform operation");
			operation = scanner.nextInt();
		}
		System.out.println("operations done");
		
	}

}
