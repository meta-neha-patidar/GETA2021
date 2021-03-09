import static org.junit.Assert.*;

import org.junit.Test;


public class LCMHCFTest {

	@Test
	
	public void LCMTest(){
		int testCaseNum1 = 4, testCaseNum2 = 10, result1 = 20;
		assertEquals(result1, LCMAndHCF.LCM(testCaseNum1, testCaseNum2));
		
		int num1 = 20, num2 = 8, result2 = 40;
		assertEquals(result2, LCMAndHCF.LCM(num1, num2));
	}
	@Test
	public void HCFTest() {
		int testCaseNum1 = 20, testCaseNum2 = 4, result1 = 4;
		assertEquals(result1, LCMAndHCF.HCF(testCaseNum1, testCaseNum2));
		
		int num1 = 20, num2 = 8, result2 = 4;
		assertEquals(result2, LCMAndHCF.HCF(num1, num2));
	}

}
