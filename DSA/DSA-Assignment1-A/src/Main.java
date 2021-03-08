import java.util.*;
public class Main {
	/*
	 * main method
	 *  
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter 0 to stop performing any operation");
		System.out.println("Enter 1 for adding node in list");
		System.out.println("Enter 2 for print nodes value of  list");
		System.out.println("Enter 3 for  rotate sublist of linked list");
		int caseOfOperation = scanner.nextInt();
		int sizeOfList = 0;
		//object initialization of OperationsClass class
		OperationsClass  llist = new OperationsClass();
		while(caseOfOperation != 0){
			if (caseOfOperation == 1){
				sizeOfList++;
				System.out.println("Enter node value");
				llist.insert(scanner.nextInt());
			}
			else if(caseOfOperation == 2){
				llist.printLinkedList();
			}
			else if (caseOfOperation == 3){
				System.out.println("Enter left of sublist, right of sublist and no of rotations ");
				int left = scanner.nextInt();
				int right = scanner.nextInt();
				int N = scanner.nextInt();
				if(right <= sizeOfList){
					llist.rotateSubList(left,right,N);
				}else{
					System.out.println("Cant perform this operation please enter the value in range og list size");
				}
				
			}else{
				System.out.print("Enter valid input : ");
			}
			System.out.println("Enter value from 0 to 3 to perform further operations on list");
			caseOfOperation = scanner.nextInt();
		}
		System.out.println("complete");

	}

}
