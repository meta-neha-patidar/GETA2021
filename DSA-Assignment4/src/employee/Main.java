package employee;
import java.util.*;
/*
 * @author Neha Patidar
 * @since 12-03-2021
 * @version 0.1
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Scanner scanner = new Scanner(System.in);
			List<Employee> employeeList = new ArrayList<>();
			System.out.println("Enter 0 to stop performing operations");
			System.out.println("Enter 1 to add employee information to list");
			System.out.println("Enter 2 to sort list in natural order");
			System.out.println("Enter 3 to sort list in order by name");
			int operationCase = scanner.nextInt();
			EmployeeSet employeeSetObject = new EmployeeSet();
			SortEmployee sortEmployeeObject = new SortEmployee();
			while(operationCase != 0){
				if(operationCase == 1){
					// add employee in list without duplicate values
					System.out.println("Enter employee id , employee name and employee address");
					int id = scanner.nextInt();
					String name = scanner.next();
					String address = scanner.next();
					Employee employee = new Employee(id,name,address);
					if(employeeSetObject.addEmployee(employee)){
						employeeList.add(employee);
					}else{
						System.out.println("Enter non duplicate id");
					}
					
				}else if (operationCase ==2){
					// sort list in natural order
					List<Employee> naturalSortedList = sortEmployeeObject.naturalOrderSort(employeeList);
					Iterator<Employee> iterate = naturalSortedList.iterator();
					while(iterate.hasNext()){
						Employee emp = iterate.next();
						System.out.println("Employee id : " + emp.empId + ", Employee Name : " + emp.empName + ", Employee address : " + emp.empAddress);;
					}
				}else if (operationCase == 3){
					//sort employee list by name 
					List<Employee> sortedListByName = sortEmployeeObject.sortByName(employeeList);
					Iterator<Employee> iterate = sortedListByName.iterator();
					while(iterate.hasNext()){
						Employee emp = iterate.next();
						System.out.println("Employee id : " + emp.empId + ", Employee Name : " + emp.empName + ", Employee address : " + emp.empAddress);;
					}
				}else{
					System.out.println("Choose valid operation case");
				}
				System.out.println("Enter operation case from 0 to 3");
				operationCase = scanner.nextInt();
			}
			System.out.println("Done");
		}catch (Exception e){
			System.out.println(e);
		}
	}

}
