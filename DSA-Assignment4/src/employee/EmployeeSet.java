package employee;

import java.util.*;

/*
 * @author Neha Patidar
 * @since 12-03-2021
 * @version 0.1
 */
public class EmployeeSet {
	Set<Employee> employeeSet = new HashSet<>();
	boolean addEmployee(Employee employee){
		if(employee == null){
			 System.out.println("NullPointerException");
			 return false;
		 }
		for(Employee emp : employeeSet){
			if(emp.empId == employee.empId){
				return false;
			}
		}
		employeeSet.add(employee);
		return true;
	}
	
}
