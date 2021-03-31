package part2;
import java.util.*;
/*
 * @author - Neha Patidar
 */
public class Polynomial {
	private final int [][]polynomial;
	/*
	 * Parameterized constructor
	 * @param polyArray
	 */
	Polynomial(int [][] polyArray){
		this.polynomial = polyArray;
	}
	
	/*
	 * @return this.polynomial
	 */
	public int[][] getPoly(){
		return this.polynomial;
	}
	
	/*
	 * @return this.polynomial.size()-1
	 */
	int degree(){
		return sorting(this.polynomial)[0][1];
	}
	/*
	 * @param value
	 * @return evaluate
	 */
	float evaluatePolynomial(float value){
		float evaluate= 0;
		for(int ind = 0; ind < polynomial.length;ind++){
			evaluate += polynomial[ind][0] * Math.pow(value, polynomial[ind][1]);
		}
		return evaluate;
	}
	
	/*
	 * @param poly1, poly2
	 * @return addedPoly
	 */
	public static int[][] addPolynomials(Polynomial p1,Polynomial p2)
	{
		int firstSorted[][]=sorting(p1.polynomial);
		int secondSorted[][]=sorting(p2.polynomial);
		
		int coeff=0;
		int power=0;
		int resultIndex=0;
		
		int result[][]=new int[firstSorted.length+secondSorted.length][2];
		
		while(coeff <firstSorted.length & power<secondSorted.length)
		{
			if(firstSorted[coeff][1]==secondSorted[power][1])
			{
				result[resultIndex][0]=firstSorted[coeff][0]+secondSorted[power][0];
				result[resultIndex][1]=firstSorted[coeff][1];
				coeff++;
				resultIndex++;
				power++;
			}
			
			else if(firstSorted[coeff][1]>secondSorted[power][1])
			{
				result[resultIndex][0]=firstSorted[coeff][0];
				result[resultIndex][1]=firstSorted[coeff][1];
				coeff++;
				resultIndex++;
				
			}
			else 
			{
				result[resultIndex][0]=secondSorted[power][0];
				result[resultIndex][1]=secondSorted[power][1];
				
				resultIndex++;
				power++;
			}
			
		}
		while(coeff<firstSorted.length)
		{
			result[resultIndex][0]=firstSorted[coeff][0];
			result[resultIndex][1]=firstSorted[coeff][1];
			coeff++;
			resultIndex++;
			
		}
		while(power<secondSorted.length)
		{
			result[resultIndex][0]=secondSorted[power][0];
			result[resultIndex][1]=secondSorted[power][1];
			
			resultIndex++;
			power++;
		}
		return filterPoly(result);
	}
	
	/*
	 * @param poly1,poly2
	 * @return multipliedPoly 
	 */
	
	static int[][] multiplyPolynomials(Polynomial poly1, Polynomial poly2){
		int polynomial1[][]=sorting(poly1.polynomial);
		int polynomial2[][]=sorting(poly2.polynomial);
		int Coeff =  0, Power = 0;
		int size=polynomial1[0][1]+polynomial2[0][1];
		int multipliedPoly[][]=new int[size+1][2];
	    for(int firstIndex=0;firstIndex<polynomial2.length;firstIndex++)
	    {
	    	for(int secondIndex=0;secondIndex<polynomial2.length;secondIndex++)
	    	{
	    		Coeff=polynomial1[firstIndex][0]*polynomial2[secondIndex][0];
	    		Power=polynomial1[firstIndex][1]+polynomial2[secondIndex][1];
	    		multipliedPoly[Power][0]+=Coeff;
	    		multipliedPoly[Power][1]=Power;
	    	}
	    }
		
		return filterPoly(multipliedPoly);
	}
	private static int[][] sorting(int[][] arrayToSort)
	{
		int tempDegree, tempCoeff, length = arrayToSort.length;
		for(int leftIndex  = 0;leftIndex < length -1; leftIndex++)
		{
			for(int rightIndex = 0 ;rightIndex < length -1; rightIndex++)
			{
				if(arrayToSort[rightIndex][1] < arrayToSort[rightIndex+1][1]) {
					tempCoeff = arrayToSort[rightIndex + 1][0];
					arrayToSort[rightIndex + 1][0] = arrayToSort[rightIndex][0];
					arrayToSort[rightIndex][0] = tempCoeff;
					
					tempDegree=arrayToSort[rightIndex+1][1];
					arrayToSort[rightIndex + 1][1] = arrayToSort[rightIndex][1];
					arrayToSort[rightIndex][1] = tempDegree;
				}
			}
		}
	return arrayToSort;
	}
	private static int[][] filterPoly(int [][]poly){
		int nonZero = 0;
		for(int index = 0; index < poly.length;index++){
			if(poly[index][0] != 0){
				nonZero++;
			}
		}
		int result[][] = new int[nonZero][2];
		for(int index = 0, iterate = 0; index < poly.length;index++){
			if(poly[index][0] != 0){
				result[iterate][0] = poly[index][0];
				result[iterate][1] = poly[index][1];
				iterate++;
			}
			
		}
		return result;
	}
	
}
