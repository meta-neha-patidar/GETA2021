import java.util.*;
/*
 * @author neha patidar
 */
public class LCMAndHCF {
	/*
	 * @param num1, num2  
	 * assuming that values are non zero
	 * @return HCF
	 * 
	 */
	static int HCF(int num1, int num2){
		if(num1 == 0)
			return num2;
		return HCF(num2 % num1, num1);
	}
	/*
	 * @param num1, num2
	 * assuming that values are non zero
	 * @return lcm - lcm of num1 and num2
	 */
	static int LCM(int num1, int num2){
		int lcm = (num1 * num2) / HCF(num1, num2);
		return lcm;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter two nonzero values");
		int num1 = scanner.nextInt();
		int num2 = scanner.nextInt();
		System.out.println("HCF = " + HCF(num1, num2));
		System.out.println("LCM = " + LCM(num1, num2));
	}
	

}
