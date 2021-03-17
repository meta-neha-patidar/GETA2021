package part2;

import static org.junit.Assert.*;

import org.junit.Test;

public class PolyTestCase {

	@Test
	public void degreeTestPositive() {
		int arr[] = {1,2,3,0,5};
		Polynomial poly = new Polynomial(arr);
		assertEquals(4,poly.degree());
	}
	@Test
	public void degreeTestNegative() {
		int arr[] = {1,2,3,0,5};
		Polynomial poly = new Polynomial(arr);
		assertNotEquals(6,poly.degree());
	}
	
	@Test
	public void addPolyTest(){
		int arr1[] = {1,2,3,4};
		int arr2[] = {6,5,4};
		int result[] = {1,8,8,8};
		Polynomial poly1 = new Polynomial(arr1);
		Polynomial poly2 = new Polynomial(arr2);
		assertArrayEquals(result,Polynomial.addPolynomials(poly1, poly2));
	}
	
	@Test
	public void productPolyTest(){
		int arr1[] = {1,2,3,4};
		int arr2[] = {5,6,7};
		int result[] = {5, 16, 27, 18, 0, 0};
		Polynomial poly1 = new Polynomial(arr1);
		Polynomial poly2 = new Polynomial(arr2);
		assertArrayEquals(result,Polynomial.multiplyPolynomials(poly1, poly2));
	}

}
