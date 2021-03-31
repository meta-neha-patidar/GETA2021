package employee;
/**
 * 
 * @author neha.patidar_metacub
 *
 */
public class Node {
	int empId;
	double salary;
	int age;
	Node next;
	public Node(int empId, double salary, int age) {
		this.empId = empId;
		this.salary = salary;
		this.age = age;
	}
}
