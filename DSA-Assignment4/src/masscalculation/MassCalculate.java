package masscalculation;
import java.util.*;

/*
 * @author Neha Patidar
 * @since 15-03-2021
 * @version 0.1
 */
public class MassCalculate {
	static HashMap<Character, Integer> atomMap = new HashMap<>();
	static{
		atomMap.put('H', 1);
		atomMap.put('C', 12);
		atomMap.put('O', 16);
	}
	/*
	 * main method
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		try{
			System.out.println("Enter a chemical formula");
			String chemicalFormula = scanner.next();
			int mass = massCalculation(chemicalFormula);
			if(mass != -1){
				System.out.println("Total mass of chemical formula  = " + mass);
			}
			else{
				System.out.println("Mass can not calculated");
			}
		}catch (Exception e){
			System.out.println(e);
		}

	}
	
	
	/*
	 * purpose : calculate the mass of complete chemical formula
	 * @param chemicalFormula
         * @return massResult
	 */
	static int massCalculation(String chemicalFormula){
		int massResult = 0;
		Stack<Character> atomStack = new Stack<>();
		int noOfAtom = -1;
		int noOfCombinedAtom = -1;
		boolean openBracketVisit = false;
		
		for(int i = 0; i < chemicalFormula.length();i++){
			atomStack.push(chemicalFormula.charAt(i));
		}
		
		while(!atomStack.isEmpty()){
			char elementPopped = atomStack.pop();
			if(atomMap.containsKey(elementPopped)){
				if(noOfAtom == -1){
					if(!openBracketVisit){
						massResult += atomMap.get(elementPopped);
					}
					else {
						massResult += atomMap.get(elementPopped) * noOfCombinedAtom;
					}
				}else{
					massResult += atomMap.get(elementPopped) * noOfAtom;
					noOfAtom = -1;
				}
			}
			else if(Character.isDigit(elementPopped)){
				int tempVariable = Integer.parseInt(String.valueOf(elementPopped));
				if(noOfAtom == -1){
					noOfAtom = tempVariable;
				}
				else{
					noOfAtom = noOfAtom * 10 + tempVariable;
				}
				if (openBracketVisit && noOfCombinedAtom != -1){
					noOfAtom *= noOfCombinedAtom;
				}
			}
			else if (elementPopped == ')'){
				openBracketVisit = true;
				if(noOfAtom != -1){
					noOfCombinedAtom = noOfAtom;
					noOfAtom = -1;
				}
			}else if(elementPopped =='('){
				if(openBracketVisit){
					openBracketVisit = false;
					noOfCombinedAtom = -1;
				}else{
					System.out.println("Invalid equation");
					return -1;
				}
			}else{
				System.out.println("Character not recognised");
				return -1;
			}
		}
		
		return massResult;
	}

}
