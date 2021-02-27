
import java.util.*;
public class StringOperations {
	
	int compareString(String string1,String string2){
		if (string1.length() != string2.length()) return 0;
		for(int i = 0; i < string1.length(); i++){
			if(string1.charAt(i) != string2.charAt(i)) return 0;
		}
		return 1;
		
	}
	
	StringBuilder reverseString(StringBuilder string){
		try{
			string.reverse();
			return string;
		}catch(Exception e){
			return new StringBuilder("Invalid");
		}
	}
	
	String swapCases(StringBuilder string){
		for(int i = 0; i < string.length(); i++){
			try{
				if(Character.isLowerCase(string.charAt(i))){
					string.replace(i, i+1, Character.toUpperCase(string.charAt(i))+"");
				}else if (Character.isUpperCase(string.charAt(i))){
					string.replace(i, i+1, Character.toLowerCase(string.charAt(i))+"");
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
			if(result.length() <= string[i].length()){
				result = string[i];
			}
		}
		return result;
	}

}
