package employee;
import java.util.*;
/*
 * @author Neha Patidar
 * @since 12-03-2021
 * @version 0.1
 */
public class SortEmployee {
	List<Employee> naturalOrderSort(List<Employee>employees){
		if(employees == null){
			throw new NullPointerException();
		}else if (employees.size() == 0){
			throw new EmptyStackException();
		}
		Collections.sort(employees, naturalSort);
		return employees;
	}
	
	static Comparator<Employee> naturalSort = new Comparator<Employee>() {
		public int compare(Employee employee1, Employee employee2) {
			if (employee1.empId > employee2.empId) {
				return 1;
			} else if (employee2.empId > employee1.empId) {
				return -1;
			} else {
				return 0;
			}
		}
	};
	List<Employee> sortByName(List<Employee> employees){
		if(employees==null) {
			throw new NullPointerException();
		}else if(employees.size()==0) {
			throw new EmptyStackException();
		}
		List<Employee> empList = new LinkedList<Employee>(employees);
		Collections.sort(empList, sortByName);
		return empList;
	}
	static Comparator<Employee> sortByName = new Comparator<Employee>() {
		public int compare(Employee employee1, Employee employee2) {
			return (employee1.empName.compareTo(employee2.empName));
		}
	};
}
