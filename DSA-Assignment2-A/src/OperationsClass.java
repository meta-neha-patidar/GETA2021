import java.util.*;
/*
 * 
 */
public class OperationsClass {
	
	static boolean isOperator(String string) 
	{ 
		char element = string.charAt(0);
	    return (!(element >= 'a' && element <= 'z') &&  
	            !(element >= '0' && element <= '9') &&  
	            !(element >= 'A' && element <= 'Z')); 
	} 
	
	static int getPriority(String element) 
	{ 
	    switch (element) {
		case "!":
			return 7;
		case "*":
			return 6;
		case "/":
			return 6;
		case "+":
			return 5;
		case "-":
			return 5;
		case "<":
			return 4;
		case ">":
			return 4;
		case "<=":
			return 4;
		case ">=":
			return 4;
		case "==":
			return 3;
		case "!=":
			return 3;
		case "&&":
			return 2;
		case "||":
			return 1;
		default:
			return -1;
		}
	} 
	
	/*
	 * @param infix- infix expression
	 * @return prefixString- prefix expression
	 */
	String prefixExpression(String [] infix){
		StackImplement operator = new StackImplement(infix.length);
		StackImplement operand = new StackImplement(infix.length);
		
		for(int i = 0; i < infix.length; i++){
			String element = infix[i];
			//if element is an opening bracket then push into operator stack
			if ("(".equals(element)){
				
				operator.push(element);
			}
			
			//if element is closing bracket then pop from both stack and push in operand  till opening bracket is not found
			else if (")".equals(element)){
	
				while(!operator.isEmpty() && !"(".equals(operator.peek())){

					String operand1 = operand.pop(); 
					
	                String operand2 = "";
	                if(!operand.isEmpty())
	                	operand2 = operand.pop();
	                
	                String op = operator.pop();
	                System.out.println(op);
	                String tempVariable = op + operand2 + operand1;
	                
	                operand.push(tempVariable);
				}
				operator.pop();
				
			}
			else if(! isOperator(element) && ! "(".equals(element)){
				
				operand.push(element);
			}
			else {
				while ( !operator.isEmpty() && getPriority(element) <= getPriority(operator.peek()) && !"(".equals(operator.peek()))  
		                { 
							String operand1 = "";
				            if(!operand.isEmpty())
				            	operand1 = operand.pop();
					
							String operand2 = "";
							if(!operand.isEmpty())
								operand2 = operand.pop();
	                
							String op = operator.pop();
							
							String tempVariable = op + operand2 + operand1;
							operand.push(tempVariable);
		            } 
		          operator.push(element); 
			}	
		}
		while (!operator.isEmpty() && !"(".equals(operator.peek())){
			
			String operand1 =operand.pop(); 
			
            String operand2 = "";
            if(!operand.isEmpty())
            	operand2 = operand.pop();
            
            String op = operator.pop(); 
            
            String temp = op + operand2 + operand1;
            operand.push(temp);
		}
		String prefixString = operand.peek();
		return prefixString;
	}
	/*
	 * @param infixString- infix expression
	 * @return postfixString
	 */
	String postfixExpression(String [] infixString){
		String postfixString = "";
		StackImplement stack = new StackImplement(infixString.length);
		
		for(int i = 0; i < infixString.length; i++){
			String element = infixString[i];
			if("(".equals(element) || "[".equals(element) || "{".equals(element)){
				stack.push(element);
			}
			else if (")".equals(element) || "]".equals(element) || "}".equals(element)){
				if(")".equals(element)){
					while(!"(".equals(stack.peek())){
						postfixString += stack.pop();
					}
				}
				if("]".equals(element)){
					while(!"[".equals(stack.peek())){
						postfixString += stack.pop();
					}
				}
				if("}".equals(element)){
					while(!"{".equals(stack.peek())){
						postfixString += stack.pop();
					}
				}
				stack.pop();
			}
			else if (isOperator(element)){
				if(stack.isEmpty()){
					stack.push(element);
				}else{
					if(getPriority(stack.peek()) >= getPriority(element)){
						postfixString += stack.pop();
						stack.push(element);
					}else{
						stack.push(element);
					}
				}
			}
			else{
				postfixString += element;
			}
		}
		while(!stack.isEmpty()){
			postfixString += stack.pop();
		}
		return postfixString;
	}
}
