import static org.junit.Assert.*;

import org.junit.Test;

/*
 * @author Neha Patidar
 */
public class QueenJunitTest {

	@Test
	public void nQueenTest() {
		// when size is 1
		int size1 = 1;
		NQueen nQueen = new NQueen(size1);
		assertTrue(nQueen.solution(nQueen.board, 0));
		
	}

	@Test
	public void nQueenTest1() {
		// when size is 1
		int size1 = 1;
		NQueen nQueen = new NQueen(size1);
		assertTrue(nQueen.solution(nQueen.board, 0));
		
	}
	
	@Test
	public void nQueenTest3(){
		
		int size = 4;
		NQueen nQueen = new NQueen(size);
		int expectedArray[][] = { { 0, 0, 1, 0 }, { 1, 0, 0, 0 },
				{ 0, 0, 0, 1 }, { 0, 1, 0, 0 } };
		nQueen.solution(nQueen.board, 0);
		assertArrayEquals(expectedArray, nQueen.board);
	}
	
}
