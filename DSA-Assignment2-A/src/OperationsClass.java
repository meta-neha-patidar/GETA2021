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
	 * @return prefix- prefix expression
	 */
	String prefixExpression(String [] infix){
		StackImplement operator = new StackImplement(infix.length);
		StackImplement operand = new StackImplement(infix.length);
		
		for(int i = 0; i < infix.length; i++){
			//if element is an opening bracket then push into operator stack
			if ("(".equals(infix[i])){
				
				operator.push(infix[i]);
			}
			
			//if element is closing bracket then pop from both stack and push in operand  till opening bracket is not found
			else if (")".equals(infix[i])){
	
				while(!operator.isEmpty() && operator.peek() != "("){

					String op1 = operand.pop(); 
					
	                String op2 = "";
	                if(!operand.isEmpty())
	                	op2 = operand.pop();
	                
	                String op ="";
		            if(operator.peek() != "(")
		            	 op = operator.pop();
		            else break;
	    
	                String temp = op + op2 + op1;
	                
	                operand.push(temp);
				}
				operator.pop();
				//if (operator.isEmpty()) return "invalid";
				
			}
			else if(! isOperator(infix[i])){
				
				operand.push(infix[i]);
			}
			else {
				while ( !operator.isEmpty() && getPriority(infix[i]) <= getPriority(operator.peek()))  
		                { 
							String op1 = "";
				            if(!operand.isEmpty())
				            	op1 = operand.pop();
					
							String op2 = "";
							if(!operand.isEmpty())
								op2 = operand.pop();
	                
							String op ="";
				            if(operator.peek() != "(")
				            	 op = operator.pop();
				            else
				            	operator.pop();
							String temp = op + op2 + op1;
							operand.push(temp);
		            } 
		          operator.push(infix[i]); 
			}	
		}
		while (!operator.isEmpty() && operator.peek()!= "("){
			
			String op1 =operand.pop(); 
			
            String op2 = "";
            if(!operand.isEmpty())
            	op2 = operand.pop();
            
            String op ="";
            if(operator.peek() != "(")
            	 op = operator.pop(); 
            else operator.pop();
            String temp = op + op2 + op1;
            operand.push(temp);
		}
		return operand.peek();
	}
	/*
	 * @param infix- infix expression
	 * @return postfix
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
