import static org.junit.Assert.*;

import org.junit.Test;
/*
 * @author -  Neha Patidar
 */

public class JUnitTest {
	SparseMatrix object;
	
	@Test
	public void getTransposeTest() {
		int array[][] = {
                {1, 2, 3, 5, 4},
                {0, 0, 5, 7, 0},
                {0, 1, 0, 0, 0},
                {0, 2, 6, 0, 0},
                {0, 8, 0, 9, 0}
            };
		int nonZeroCount = 12;
		int result[][] ={
				{0, 0, 1 }, 
				{1, 0, 2 },
				{2, 0, 3 }, 
				{3, 0, 5 },
				{4, 0, 4 },
				{2, 1, 5 },
				{3, 1, 7 },
				{1, 2, 1 },
				{1, 3, 2 },
				{2, 3, 6 },
				{1, 4, 8 },
				{3, 4, 9 }
				};
		object = new SparseMatrix(nonZeroCount,array);
		int[][] transpose = object.getTranspose();
		assertArrayEquals(result, transpose);
	}
	
	@Test
	public void isSymmetricalMatrixTestPositive(){
		int array[][] = {
                {1, 0, 5, 0, 4},
                {0, 4, 0, 3, 8},
                {5, 0, 0, 0, 0},
                {0, 3, 0, 0, 2},
                {4, 8, 0, 2, 0}
            };
		
		assertEquals(true,object.isSymmetricalMatrix(array));
		
	}
	@Test
	public void isSymmetricalMatrixTestNegative(){
		int array[][] = {
                {1, 0, 5, 0, 4},
                {0, 4, 0, 3, 8},
                {5, 0, 0, 0, 0},
                {0, 3, 0, 0, 2},
            };
		
		assertEquals(false,object.isSymmetricalMatrix(array));
		
	}
	@Test
	public void addMatricesTest() {
		int array1[][] = {
				{1, 0, 5, 0, 4},
                {0, 4, 0, 3, 0},
                {0, 0, 0, 0, 0},
                {0, 2, 0, 0, 2},
                {0, 8, 0, 9, 0}
            };
		int array2[][] = {
				{2, 3, 5, 0, 4},
                {0, 4, 0, 3, 0},
                {0, 0, 4, 0, 0},
                {0, 2, 0, 0, 2},
                {0, 8, 0, 9, 6}
            };
		int result[][] = {
				{3, 3, 10, 0, 8},
				{0, 8, 0, 6, 0 },
				{0, 0, 4, 0, 0 },
				{0, 4, 0, 0, 4 },
				{0, 16, 0, 18, 6 }
		};
		
		int addedArray[][] = SparseMatrix.addMatrices(array1, array2);
		for(int i = 0 ; i < addedArray.length;i++);
		assertArrayEquals(result,addedArray);
	}
	
	@Test
	public void multiplyMatricesTest(){
		int array1[][] = {
				{1, 0, 5, 0, 4},
                {0, 4, 0, 3, 0},
                {0, 0, 0, 0, 0},
                {0, 2, 0, 0, 2},
                {0, 8, 0, 9, 0}
            };
		int array2[][] = {
				{2, 3, 5, 0, 4},
                {0, 4, 0, 3, 0},
                {0, 0, 4, 0, 0},
                {0, 2, 0, 0, 2},
                {0, 8, 0, 9, 6}
            };
		int result[][] = {
				{2, 35, 25, 36, 28},
				{0, 22, 0, 12, 6 },
				{0, 0, 0, 0, 0 },
				{0, 24, 0, 24, 12 },
				{0, 50, 0, 24, 18 }
		};
		int outputArray[][] = SparseMatrix.multiplyMatrices(array1, array2);
		assertArrayEquals(result,outputArray);
		
	}
	

}
