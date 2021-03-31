package employee;
/**
 * 
 * @author neha patidar
 *
 */
public class LinkedList {
	Node head;
	/**
	 * 
	 * @param empId
	 * @param salary
	 * @param age
	 */
	public void addNewNode(int eId, double salary, int age) {
		if (head == null) {
			head = new Node(eId, salary, age);
			return;
		} 
		Node cur = head;
		if(cur.empId == eId){
			System.out.println("Duplicate id can not be add");
			return;
		}
		while (cur.next != null) {
			System.out.println(cur.empId);
			if(cur.empId == eId){
				System.out.println("Duplicate id can not be add");
				return;
			}
			cur = cur.next;
		}
		Node newNode = new Node(eId, salary, age);
		cur.next = newNode;
		
	}
	/**
	 * Display the nodes having information of employee
	 */
	public void printLinkedList() {
		if (head == null) {
			System.out.println("===List is empty!====");
		}
		Node temp = head;

		while (temp != null) {
			System.out.println("empId= " + temp.empId + ", empSalary=" + temp.salary + ", empAge=" + temp.age);
			temp = temp.next;
			
		}
	}
	/**
	 * sortEmployeeList
	 */
	public void sortEmployeeList(){
		head = mergeSort(head);
	}
	/**
	 * 
	 * @param tempHead
	 * @return
	 */
	private Node mergeSort(Node tempHead) {
		if (null == tempHead || null == tempHead.next) {
			return tempHead;
		}

		Node middle = getMiddleNode(tempHead);
		Node nextOfMiddle = middle.next;
		middle.next = null;

		Node leftList = mergeSort(tempHead);
		Node rightList = mergeSort(nextOfMiddle);

		Node sortedList = sortedMerge(leftList, rightList);

		return sortedList;
	}
	/**
	 * get middle node using 2 pointer method
	 * @param tempHead
	 * @return
	 */
	 private static Node getMiddleNode(Node tempHead) {
			if (null == tempHead) {
				return tempHead;
			}

			Node slow = tempHead, fast = tempHead;

			while (null != fast.next && null != fast.next.next) {
				slow = slow.next;
				fast = fast.next.next;
			}

			return slow;
		}
	 
	 
	 private static Node sortedMerge(Node leftNode, Node rightNode) {
			Node result = null;

			if (null == leftNode) {
				return rightNode;
			}
			if (null == rightNode) {
				return leftNode;
			}

			if (leftNode.salary > rightNode.salary) {
				result = leftNode;
				result.next = sortedMerge(leftNode.next, rightNode);
			} else if (leftNode.salary < rightNode.salary) {
				result = rightNode;
				result.next = sortedMerge(leftNode, rightNode.next);
			} else {
				if (leftNode.age < rightNode.age) {
					result = leftNode;
					result.next = sortedMerge(leftNode.next, rightNode);
				} else {
					result = rightNode;
					result.next = sortedMerge(leftNode, rightNode.next);
				}
			}

			return result;
		}
}
