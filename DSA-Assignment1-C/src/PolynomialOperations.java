
public class PolynomialOperations {
	String variables;
	PolyNode head, tail;
	/*
	 * @param- variables- polynomial variables
	 * 
	 */
	PolynomialOperations (String variables){
		this.variables = variables;
	}
	/*
	 * add term in polynomial
	 * @param cooficientInput- cooficientInput of term, PowerArray- array containing power of variables of term
	 * 
	 */
	void addTerm(int cooficientInput, int []PowerArray){
		if(cooficientInput == 0){
			return;
		}
		
		Poly powerOfVariables = sublistCreation(PowerArray);		//poly list contain power of variables
		
		PolyNode PolynomialNode = new PolyNode(cooficientInput, powerOfVariables);
		if (head == null){
			head = PolynomialNode;
			tail = PolynomialNode;
			return ;
		}
		tail.next = PolynomialNode;
		tail = tail.next;
	}
	/*
	 * @param PowerArray- power of variables
	 * @return returnPoly- sublist which contain power of variables
	 */
	Poly sublistCreation(int [] PowerArray){
		Poly powerOfVariables = new Poly(PowerArray[0]);
		Poly returnPoly = powerOfVariables;
		for(int i = 1; i < PowerArray.length; i++){
			Poly polyNode = new Poly(PowerArray[i]);
			powerOfVariables.next = polyNode;
			powerOfVariables = powerOfVariables.next;
		}
		return returnPoly;
	}
	
	/*
	 * print polynomial
	 */
	void printPolynomial(){
		PolyNode currentNode = head;
		while (currentNode != null){
			if(currentNode.cooficient > 0){
				System.out.print("+" + currentNode.cooficient);
			}
			else{
				System.out.print(currentNode.cooficient);
			}
			
			Poly temp = currentNode.varPowerList;
			int i = 0;
			while(temp != null){
				if(temp.powerOfVar != 0){
					System.out.print(variables.charAt(i) + "" + temp.powerOfVar);
				}
				i++;
				temp = temp.next;
			}
			currentNode = currentNode.next;
		}
		System.out.println();
	}
	
	/*
	 * calculate degree of polynomial 
	 * @return degree- maximum sum of variables of terms in polynomial
	 */
	int degreeOfPolynomial(){
		int degree = 0;
		PolyNode currentNode = head;
		while (currentNode != null){
			Poly temp = currentNode.varPowerList;
			int powerSum = 0;
			while(temp != null){
				powerSum += temp.powerOfVar;			//sum of power of variables
				temp = temp.next;
			}
			degree = Math.max(degree, powerSum);			//assign maximum sum of power of term variables to degree
			currentNode = currentNode.next;
		}
		return degree;						//return degree that is maximum sum of variables of terms in polynomial
	}
}
