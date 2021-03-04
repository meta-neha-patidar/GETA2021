/*
 * insert() - method to add node to linked list
 * rotateSubList() - method to rotate sublist
 * rotate() - helper method to rotate sublist
 * printLinkedList() - method to print list
 * 
 */
public class OperationsClass {
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
	 * rotate the given sublist of linked list
	 * @param left- starting of sublist, right- ending of sublist, noOfRotation- rotate sublist noOfRotation times
	 */
	void rotateSubList(int left, int right, int noOfRotation){
		noOfRotation = noOfRotation % (right - left + 1); 			// if number of rotation are greater than length of sublist
		Node cur = head,previous = head;
		int i = 1;
		while(i < left){
			previous = cur; 
			cur = cur.next;
			i++;
		}
//		System.out.println("value of i " + i);
//		System.out.println("Previous of sublist "+previous.data);
		
		Node subListHead = cur , end = cur;
//		System.out.println("start of sublist "+subListHead.data);
		while(i < right){
			end = end.next;
			cur = cur.next;
			i++;
			//left++;
		}
		cur = cur.next;
		end.next = null;
//		System.out.println("cur of list "+cur.data);
//		System.out.println("end of sublist "+end.data);
		subListHead = rotate(subListHead, noOfRotation);
		if (left == 1){
			previous = subListHead;
			head = previous;
		}else{
			previous.next = subListHead;
		}

		while(previous.next != null){
			previous = previous.next;
		}
		previous.next = cur;	
	}
	/*
	 * rotate sublist N times
	 * @param subListRoot- first node of sublist, N - no of rotations
	 * @return head of rotated sublist
	 */
	
	Node rotate(Node subListRoot, int N){
		if (N == 0) return subListRoot;			//if no of rotation is 0 return actual head
		Node headToReturn = subListRoot, temphead = subListRoot;
		while (N > 1){
			headToReturn = headToReturn.next;
			N--;
		}
		Node endOfTemphead = headToReturn;		//endOfTemphead is at the Nth position from head	
		headToReturn = headToReturn.next;		//headToReturn is now head which is to be return
		endOfTemphead.next = null;				//breaking the list into 2 parts
		
		Node current = headToReturn;
		while(current.next != null){
			current = current.next;
		}
		current.next = temphead;				//link the last node of input list to the first node 
		return headToReturn;					//returning rotated sublist
	}
	
	/*
	 * print nodes value of linked list
	 */
	void printLinkedList(){
		Node curr = head;		// address of head node assign to curr node
		System.out.println("Value of nodes of Linked List");
		while(curr != null){
			System.out.print(curr.data + "\t");		//printing value of node
			curr = curr.next;
		}
		System.out.println();
	}
}

