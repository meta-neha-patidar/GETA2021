package employee;
/*
 * @author Neha Patidar
 * @since 12-03-2021
 * @version 0.1
 */
public class Employee {
	String empName;
	int empId;
	String empAddress;
	
	/*
	 * Parameterized constructor
	 * @param empId, empName, empAddress
	 */
	Employee(int empId, String empName, String empAddress){
		this.empId = empId;
		this.empName = empName;
		this.empAddress = empAddress;
	}
	
	/*
	 * set id of Employee
	 * @param empId
	 */
	void setId(int empId){
		this.empId = empId;
	}
	
	/*
	 * set name of employee
	 * 
	 * @param empName
	 */
	void setName(String empName){
		this.empName = empName;
	}
	
	/*
	 * set address of employee
	 * @param empAddress
	 */
	void setAddress(String empAddress){
		this.empAddress = empAddress;
	}
	
	/*
	 * @return this.empId
	 */
	int getEmpId(){
		return this.empId;
	}
	/*
	 * @return this.empName
	 */
	String getEmpName(){
		return this.empName;
	}
	/*
	 * return this.empAddress
	 */
	String getEmpAddress(){
		return this.empAddress;
	}
}
