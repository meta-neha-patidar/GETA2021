import static org.junit.Assert.*;

import org.junit.Test;


public class LCMHCFTest {

	@Test
	
	public void LCMTest(){
		int testCaseNum1 = 4, testCaseNum2 = 10, result1 = 20;
		System.out.println(LCMAndHCF.LCM(testCaseNum1, testCaseNum2));
		assertEquals(result1, LCMAndHCF.LCM(testCaseNum1, testCaseNum2));
	}
	@Test
	public void HCFTest() {
		int testCaseNum1 = 20, testCaseNum2 = 4, result1 = 4;
		System.out.println(LCMAndHCF.HCF(testCaseNum1, testCaseNum2));
		assertEquals(result1, LCMAndHCF.HCF(testCaseNum1, testCaseNum2));
	}

}
