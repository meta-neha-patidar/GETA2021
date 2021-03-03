
import java.util.*;
public class StringOperations {
	
	int compareString(String string1,String string2){
		if (string1.length() != string2.length()) return 0;
		for(int i = 0; i < string1.length(); i++){
			if(string1.charAt(i) != string2.charAt(i)) return 0;
		}
		return 1;
		
	}
	
	String reverseString(String string){
		try{
			String result = "";
			for(int i = string.length() - 1; i >= 0; i--){
				result += string.charAt(i);
			}
			return result;
		}catch(Exception e){
			return "Invalid";
		}
	}
	
	String swapCases(StringBuilder string){
		for(int i = 0; i < string.length(); i++){
			try{
				if(string.charAt(i) >= 65 && string.charAt(i) <= 90){
					char temp = (char) (string.charAt(i) + 32);					//swapping the case of letter
					string.replace(i, i+1,  temp  + "");					// replacing the letter with swapped case letter
				}else if (string.charAt(i) >= 97 && string.charAt(i) <= 122){
					char temp = (char) (string.charAt(i) - 32);					//swapping the case of letter
					string.replace(i, i+1, temp +"");							//replacing the letter with swapped case letter
				}
			}catch (Exception e){
				return "Invalid";
			}
		}
		return string.toString();
	}
	
	String largestString(String [] string){
		String result = "";
		for(int i = 0; i < string.length; i++){
			if(result.length() <= string[i].length()){		//check if ith word is greater than previous large word
				result = string[i];							// assign larger word to result
			}
		}
		return result;
	}

}
