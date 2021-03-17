package part1;
import java.util.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class IntSetTestCases {

	@Test
	public void isMemeberPositiveTest() {
		int arr[] = {2, 3, 5, 1, 8, 3, 6, 9};
		int element = 8;
		IntSet obj = new IntSet(arr);
		assertTrue(obj.isMember(element));
		
	}
	@Test
	public void isMemeberNegativeTest() {
		int arr[] = {2, 3, 5, 1, 8, 3, 6, 9};
		int element = 4;
		IntSet obj = new IntSet(arr);
		assertFalse(obj.isMember(element));
	}
	
	@Test
	public void sizePositiveTest() {
		int arr[] = {2, 3, 5, 1, 8, 3, 6, 9};
		int element = 7;
		IntSet obj = new IntSet(arr);
		assertEquals(element,obj.size());
		
	}
	@Test
	public void sizeNegativeTest() {
		int arr[] = {2, 3, 5, 1, 8, 3, 6, 9};
		int element = 4;
		IntSet obj = new IntSet(arr);
		assertNotEquals(element,obj.size());
	}
	
	@Test
	public void isSubsetPositiveTest() {
		int arr[] = {2, 3, 5, 1, 8, 3, 6, 9};
		int subArr[] = {3, 2, 1};
		IntSet obj = new IntSet(arr);
		IntSet subSet = new IntSet(subArr);
		assertTrue(obj.isSubSet(subSet));
		
	}
	@Test
	public void isSubsetNegativeTest() {
		int arr[] = {2, 3, 5, 1, 8, 3, 6, 9};
		int subArr[] = {7, 2, 1};
		IntSet obj = new IntSet(arr);
		IntSet subSet = new IntSet(subArr);
		assertFalse(obj.isSubSet(subSet));
	}
	
	@Test
	public void unionTest(){
		int arr[] = {2, 3, 5, 1, 8, 3, 6, 9};
		int arr2[] = {7, 2, 10, 55, 1};
		IntSet set1 = new IntSet(arr);
		IntSet set2 = new IntSet(arr2);
		int res[] = {2, 3, 5, 1, 8, 6, 9, 7, 10, 55};
		ArrayList<Integer> result=new ArrayList<>();
		for(int i = 0; i < res.length;i++){
			result.add(res[i]);
		}
		
		assertEquals(result,IntSet.unionSet(set1, set2));
	}

}
