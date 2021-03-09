import java.util.*;
/*
 * @author - neha patidar
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		/*StackImplement stack = new StackImplement(5);
		System.out.println(stack.topIndex);
		System.out.println(stack.isEmpty());
		System.out.println(stack.isFull());
		stack.push("metacube");
		System.out.println(stack.topElement());
		System.out.println(stack.topIndex);
		System.out.println(stack.isEmpty());
		System.out.println(stack.isFull());
		System.out.println(stack.pop());
		System.out.println(stack.topIndex);
		System.out.println(stack.isEmpty());
		System.out.println(stack.isFull());
		*/
		
		System.out.println("Enter infix expression");
		String [] infixExpression = scanner.nextLine().split(" ");
		OperationsClass objectOperationsClass = new OperationsClass();
		
		String prefixExp = objectOperationsClass.prefixExpression(infixExpression);
		System.out.println("Prefix Expression : " + prefixExp);
		
		String postfixExp = objectOperationsClass.postfixExpression(infixExpression);
		System.out.println("Post Expression : " + postfixExp);
		
	}

}
