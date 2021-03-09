import static org.junit.Assert.*;

import org.junit.Test;

/*
 * juit test for linear search and binary search
 */
public class SearchTest {

	@Test
	public void linearSearchTest() {
		int array[] = {4,3,22,4,1,5,7}, element1 = 5, res1= 5;
		int array2[] = {2,3,6,1,5,7}, element2 = 6, res2 = 2;
		int array3[] = {2,3,6,1,5,7}, element3 = 9, res3 = -1;
		
		assertEquals(res1, Search.linearSearch(array, element1, 0));
		assertEquals(res2, Search.linearSearch(array2, element2, 0));
		assertEquals(res3, Search.linearSearch(array3, element3, 0));
	}
	@Test
	public void binarySearchTest(){
		int array[] = {1,2,3,5,6,7,8}, element1 = 4, res1= -1, element2 = 3, res2 = 2, element3 = 8 ,res3= 6;
		assertEquals(res1, Search.binarySearch(array, element1, 0, array.length));
		assertEquals(res2, Search.binarySearch(array, element2, 0, array.length));
		assertEquals(res3, Search.binarySearch(array, element3, 0, array.length));
	}

}
