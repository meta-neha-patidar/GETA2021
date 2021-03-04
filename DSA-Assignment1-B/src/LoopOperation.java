/*
 * insert() method to add node in linkedList
 * createLoop() method to create loop in list
 * loopDetect() method to find
 * 
 */
public class LoopOperation {
	Node head, tail;
	/*
	 * add new node at tail in a linked list
	 * @param data
	 */
	void insert(int data){
		Node newNode = new Node(data);
		if(head == null){
			head = newNode;
			tail = newNode;
			return ;
		}
		tail.next = newNode;
		tail = tail.next;
	}
	
	/*
	 * loop creation in Linked List
	 * @param nodeNo- node no with that last node to be connected
	 */
	void createLoop(int nodeNo){
		if(nodeNo == -1){
			return;
		}
		Node cur = head;
		while(nodeNo-- >= 0){
			if(cur.next == null){
				System.out.println("no of node is greater than length of linked list");
				return ;
			}
			cur = cur.next;
		}
		tail.next = cur;
		
	}
	/*
	 * @return boolean value true- if loop found, false- if loop not found
	 * 2 pointer method to check presence of loop
	 */
	boolean loopDetect(){
		Node first = head, second = head.next;
		while(second != null && second.next != null){
			if (first == second) return true;
			first = first.next;
			second = second.next.next;
			
		}
		
		return false;
	}
}
