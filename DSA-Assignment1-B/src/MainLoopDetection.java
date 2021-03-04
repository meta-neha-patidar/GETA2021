import java.util.*;
public class MainLoopDetection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter length of list");
		// take length of list as an input
		int sizeOfList = scanner.nextInt();
		//object initialization of LoopOperation class
		LoopOperation  llist = new LoopOperation();
		while(sizeOfList-- > 0){
			// take node value as input
			llist.insert(scanner.nextInt());
		}
		
		System.out.println("Enter the node number to create loop otherwise enter -1 : ");
		// take node no which is to be connected with last node otherwise take -1
		llist.createLoop(scanner.nextInt());
		//calling loopDetect() method to check if loop present or not
		System.out.println("Found loop in Linked List : " + llist.loopDetect());	
	}

}
