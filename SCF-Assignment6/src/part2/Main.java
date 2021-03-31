package part2;
import java.util.*;
/*
 * @author - Neha Patidar
 */
public class Main {
	static void printPoly(int [][] poly){
		for(int index = 0; index < poly.length; index++){
			System.out.print(poly[index][0] + "x^" + poly[index][1]+ "\t");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter no of terrms of polynomial");
			int length = scanner.nextInt();
			int polyArr[][] = new int[length][2];
			for(int index = 0; index < length; index++){
				System.out.println("Enter coofficient and power of term in polynomial");
				polyArr[index][0] = scanner.nextInt();
				polyArr[index][1] = scanner.nextInt();
			}
			Polynomial poly = new Polynomial(polyArr);
			System.out.println("Enter 0 to stop performing operations");
			System.out.println("Enter 1 to evaluate polynomial");
			System.out.println("Enter 2 to get degree of polynomial");
			System.out.println("Enter 3 to add two polynomials");
			System.out.println("Enter 4 to multiply two polynomial");
			
			int operationCase = scanner.nextInt();
			while(operationCase != 0){
				if(operationCase == 1){
					//evaluatePolynomail
					System.out.println("Enter a value to evaluate polynomial");
					float value = scanner.nextFloat();
					System.out.println("Result of evaluation = " + poly.evaluatePolynomial(value));
				}else if(operationCase == 2){
					//degree
					System.out.println("Degree of polynomial = " + poly.degree());
				}else if(operationCase == 3){
					//addPolynomials
					System.out.println("Enter no term of second Polynomial ");
					
					int length2 = scanner.nextInt();
					int polyArr2[][] = new int[length2][2];
					for(int index = 0; index < length2; index++){
						System.out.println("Enter coofficient and power of term in polynomial");
						polyArr2[index][0] = scanner.nextInt();
						polyArr2[index][1] = scanner.nextInt();
					}
					Polynomial poly2 = new Polynomial(polyArr2);
					
					int addedPoly[][] = Polynomial.addPolynomials(poly, poly2);
					System.out.println("Added polynomial ");
					printPoly(addedPoly);
					System.out.println("\n========");
					
				}else if(operationCase == 4){
					//multiplyPolynomials
					System.out.println("Enter no of terms of second Polynomial ");
					
					int length2 = scanner.nextInt();
					int polyArr2[][] = new int[length2][2];
					for(int index = 0; index < length2; index++){
						System.out.println("Enter coofficient and power of term in polynomial");
						polyArr2[index][0] = scanner.nextInt();
						polyArr2[index][1] = scanner.nextInt();
					}
					Polynomial poly2 = new Polynomial(polyArr2);
					int multipliedPoly[][] = Polynomial.multiplyPolynomials(poly, poly2);
					System.out.println("Multiplied polynomial");
					printPoly(multipliedPoly);
					
				}else{
					System.out.println("Choose a valid operation case");
				}
				System.out.println("Enter opperation case from 0 to 4");
				operationCase = scanner.nextInt();
			}
			
		}catch (Exception e){
			System.out.println(e);
		}
		
	}

}
