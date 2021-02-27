package assignment1feb18;

public class HexCalc {
	//method-1. addition
	String addHex(String variable1, String variable2){
		return Integer.toHexString(Integer.parseInt(variable1,16) + Integer.parseInt(variable2,16));			//addition of hex values
	}
	//method-2. subtraction
	String subtractHex(String variable1, String variable2){
		return Integer.toHexString(Integer.parseInt(variable1,16) - Integer.parseInt(variable2,16));			//subtraction of first value with second value
	}
	
	//method-3. multiplication
	String multiplyHex(String variable1, String variable2){
		return Integer.toHexString(Integer.parseInt(variable1,16) * Integer.parseInt(variable2,16));			//multiplying hex-values
	}
	
	//method-4. division
	String divideHex(String variable1, String variable2){
		if (Integer.parseInt(variable2,16) == 0) return "Invalid input";											//if second value is 0
		return Integer.toHexString(Integer.parseInt(variable1,16) / Integer.parseInt(variable2,16));				//dividing first hex value by second
	}
	
	//method-5. values are equal or not
	boolean isEqualHex(String variable1, String variable2){
		if(variable1.length() != variable2.length()) return false;								//if string length is not same values also can not be same
		for(int i = 0; i < variable1.length(); i++){
			if(variable1.charAt(i) != variable2.charAt(i)) return false;						// if i-th digit of first and second string are not same
		}
		return true;																			//if both hex-strings are same
	}
	
	// method-6. is first value greater than second or not
	boolean isGreaterHex(String variable1, String variable2){
		if(variable1.length() > variable2.length()) return true;
		for(int i = 0; i < variable1.length(); i++){
			if(variable1.charAt(i) > variable2.charAt(i)) return true;
		}
		return false;
	}
	
	//method-7 is first value smaller than second or not
	boolean isSmallerHex(String variable1, String variable2){
		if(variable1.length() < variable2.length()) return true;				//if first hex string is smaller than second
		for(int i = 0; i < variable1.length(); i++){
			if(variable1.charAt(i) < variable2.charAt(i)) return true;			//if i-th hex-digit of first hex string is smaller than second
		}
		return false;															//if first hex string is greater or equal to second hex string
	}
	
	int decimalRepersentaion(String hexValue){
		return Integer.parseInt(hexValue,16);					// converting hex string into integer 
	}
	
	String hexRepresentation(int decValue){
		return Integer.toHexString(decValue);					//converting decimal value into hex string
	}
	
	
	
}
