package part2;
import java.util.*;
/*
 * @author - Neha Patidar
 */
public class Polynomial {
	private final ArrayList<Integer> polynomial = new ArrayList<>();
	/*
	 * Parameterized constructor
	 * @param polyArray
	 */
	Polynomial(int [] polyArray){
		for(int i = 0; i <polyArray.length; i++){
			polynomial.add(polyArray[i]);
		}
	}
	
	/*
	 * @return this.polynomial
	 */
	ArrayList<Integer> getPoly(){
		return this.polynomial;
	}
	
	/*
	 * @return this.polynomial.size()-1
	 */
	int degree(){
		return this.polynomial.size()-1;
	}
	/*
	 * @param value
	 * @return evaluate
	 */
	float evaluatePolynomial(float value){
		float evaluate= 0;
		int tempDegree = this.degree();
		for(int element : polynomial){
			evaluate += element * Math.pow(value, tempDegree--);
		}
		return evaluate;
	}
	
	/*
	 * @param poly1, poly2
	 * @return addedPoly
	 */
	static int[] addPolynomials(Polynomial poly1, Polynomial poly2){
		
		ArrayList<Integer> polynomial1 = poly1.getPoly();
		ArrayList<Integer> polynomial2 = poly2.getPoly();
		int limit = Math.max(poly1.degree(), poly2.degree());
		int[] addedPoly = new int[ limit + 1];
		int degree1 = poly1.degree(),degree2= poly2.degree();
		while(degree1 >= 0 && degree2 >= 0){
			addedPoly[limit--] = polynomial1.get(degree1--) + polynomial2.get(degree2--);
		}
		while( degree1 >= 0){
			addedPoly[limit--] = polynomial1.get(degree1--);
		}
		while( degree2 >= 0){
			addedPoly[limit--] = polynomial2.get(degree2--);
		}
		
		return addedPoly;
	}
	
	/*
	 * @param poly1,poly2
	 * @return multipliedPoly 
	 */
	
	static int[] multiplyPolynomials(Polynomial poly1, Polynomial poly2){
		ArrayList<Integer> polynomial1 = poly1.getPoly();
		ArrayList<Integer> polynomial2 = poly2.getPoly(); 
		int degree1 = poly1.degree(),degree2= poly2.degree();
		int []multipliedPoly = new int[degree1 + degree2 + 1];
		for(int indexOne = 0;indexOne < degree1; indexOne++){
			for(int indexTwo = 0;indexTwo < degree2; indexTwo++){
				multipliedPoly[indexOne + indexTwo] += polynomial1.get(indexOne) * polynomial2.get(indexTwo);
			}
		}
		
		return multipliedPoly;
	}
	
}
