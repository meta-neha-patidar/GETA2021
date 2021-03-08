import static org.junit.Assert.*;

import org.junit.Test;


public class junitTestCase {
	
	@Test
	public void mirrorTest() {
		ArrOperation obj=new ArrOperation();
		int array1[] = {1,2,3,8,9,3,2,1} , result1 = 3;
		int array2[] = {7,1,4,9,7,4,1}, result2 = 2;
		int array3[] = {1,2,1,4}, result3 = 3;
		int array4[] = {1,4,5,3,5,4,1}, result4 = 7;
		
//		System.out.println(obj.maxMirror(array1));
		assertEquals(result1 ,obj.maxMirror(array1));
		
//		System.out.println(obj.maxMirror(array2));
		assertEquals(result2 ,obj.maxMirror(array2));
		
//		System.out.println(obj.maxMirror(array3));
		assertEquals(result3 ,obj.maxMirror(array3));
		
//		System.out.println(obj.maxMirror(array4));
		assertEquals(result4 ,obj.maxMirror(array4));
	}
	
	@Test
	public void countClumpsTest(){
		ArrOperation obj=new ArrOperation();
		int array1[] = {1,2,2,3,4,4}, result1 = 2;
		int array2[] = {1, 1, 2, 1, 1},result2 = 2;
		int array3[]={1,1,1,1,1}, result3 = 1;
		
		assertEquals(result1 ,obj.countClumps(array1));
		assertEquals(result2 ,obj.countClumps(array2));
		assertEquals(result3 ,obj.countClumps(array3));
		
		System.out.println(obj.countClumps(array1));
		System.out.println(obj.countClumps(array2));
		System.out.println(obj.countClumps(array3));
	
	}
	@Test
	public void fixXYTest(){
		ArrOperation obj=new ArrOperation();
		int x = 4, y = 5;
		int array1[] = {5, 4, 9, 4, 9, 5}, result1[] = {9, 4, 5, 4, 5, 9};
		int array2[] = {1, 4, 1, 5}, result2[] = {1, 4, 5, 1};
		int array3[] = {1, 4, 1, 5, 5, 4, 1}, result3[] = {1, 4, 5, 1, 1, 4, 5};
//		assertEquals(result1 ,obj.fixXY(array1 , x, y));
//		assertEquals(result2 ,obj.fixXY(array2 , x, y));
//		assertEquals(result3 ,obj.fixXY(array3 , x, y));
	}
	@Test
	public void splitArrayTest(){
		ArrOperation obj=new ArrOperation();
		int array1[] = {1, 1, 1, 2, 1}, result1 = 3;
		int array2[] = {2, 1, 1, 2, 1}, result2 = -1;
		int array3[] = {10, 10}, result3 = 1;
		
		assertEquals(result1 ,obj.splitArray(array1));
		assertEquals(result2 ,obj.splitArray(array2));
		assertEquals(result3 ,obj.splitArray(array3));
//		System.out.println(obj.splitArray(array1));
//		System.out.println(obj.splitArray(array2));
//		System.out.println(obj.splitArray(array3));
	}

}
