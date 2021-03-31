package employee;
import java.util.*;
/**
 * 
 * @author neha patidar
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter 0 to stop performing any operation");
			System.out.println("Enter 1 to add employee detail in list ");
			System.out.println("Enter 2 to sort the employee list");
			System.out.println("Enter 3 to print the employee list");
			
			int operationCase = scanner.nextInt();
			LinkedList employees = new LinkedList();
			while(operationCase != 0){
				if(operationCase == 1){
					System.out.println("Enter employee id, employee salary and employee age");
					int empId = scanner.nextInt();
					double salary = scanner.nextDouble();
					int age = scanner.nextInt();
					employees.addNewNode(empId, salary, age);
				}
				else if(operationCase == 2){
					employees.sortEmployeeList();
				}
				else if (operationCase == 3){
					employees.printLinkedList();
				}
				
				System.out.println("Enter operation case from 0 to 3");
				operationCase = scanner.nextInt();
			}
			
			
			
			
		}catch(Exception e){
			System.out.println(e);
		}
	}

}
