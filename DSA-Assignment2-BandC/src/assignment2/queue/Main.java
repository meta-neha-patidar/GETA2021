package assignment2.queue;


import java.util.*;
/*
 * @author neha patidar
 * 
 */
public class Main {
	public static void main(String [] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the capacity of queue");
		int capacity = scanner.nextInt();
		QueueOperation queue = new QueueOperation(capacity);
		System.out.println("Enter 0 to stop perform any operation");
		System.out.println("Enter 1 to insert element in the queue");
		System.out.println("Enter 2 to remove element from queue");
		System.out.println("Enter 3 to check if the queue is empty");
		System.out.println("Enter 4 to check if the queue if full");
		int operationCase = scanner.nextInt();
		while(operationCase != 0){
			if(operationCase == 1){
				System.out.println("Enter element to insert in queue");
				queue.enqueue(scanner.next());
			}else if(operationCase == 2){
				System.out.println("removed element is : " + queue.dequeue());
			}else if(operationCase == 3){
				System.out.println("queue is empty : " + queue.isEmpty());
			}else if (operationCase == 4){
				System.out.println("queue is full : " + queue.isFull());
			}else{
				System.out.println("Enter correct case");
			}
			System.out.println("Enter operation case from 0 to 4");
			operationCase = scanner.nextInt();
		}
	}
}

