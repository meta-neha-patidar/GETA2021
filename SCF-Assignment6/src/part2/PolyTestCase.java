package part2;

import static org.junit.Assert.*;

import org.junit.Test;

public class PolyTestCase {

	@Test
	public void degreeTestPositive() {
		int arr[][] = {{2,1},{3,5},{4,2},{2,8}};
		Polynomial poly = new Polynomial(arr);
		assertEquals(8,poly.degree());
	}
	@Test
	public void degreeTestNegative() {
		int arr[][] = {{2,1},{3,5},{4,2},{2,8}};
		Polynomial poly = new Polynomial(arr);
		assertNotEquals(6,poly.degree());
	}
	
	@Test
	public void addPolyTest(){
		int arr1[][] = {{1,2},{2,3},{4,4}};
		int arr2[][] = {{4,2},{5,4}};
		int result[][] = {{9,4},{2,3},{5,2}};
		Polynomial poly1 = new Polynomial(arr1);
		Polynomial poly2 = new Polynomial(arr2);
		assertArrayEquals(result,Polynomial.addPolynomials(poly1, poly2));
	}
	
	@Test
	public void productPolyTest(){
		int arr1[][] = {{1,2},{2,3},{4,4}};
		int arr2[][] = {{4,2},{5,4}};
		int result[][] = {{8,5},{16,6},{10,7},{20,8}};
		Polynomial poly1 = new Polynomial(arr1);
		Polynomial poly2 = new Polynomial(arr2);
		assertArrayEquals(result,Polynomial.multiplyPolynomials(poly1, poly2));
	}

}
