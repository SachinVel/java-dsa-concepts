package javaconcepts;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee{
	int empNo;
	String name;
	float salary;
	Employee(int empNo,String name,float salary){
		this.empNo = empNo;
		this.name = name;
		this.salary = salary;
	}
	
	void incrementSalaray(float incVal) {
		this.salary += incVal;
	}
	
	@Override
	public String toString() {
		return "Employee name : "+this.name+" salary : "+this.salary;
	}
	 
	
}
public class Streams {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Employee[] empArr = {
			new Employee(1, "john", 10000),
			new Employee(2, "alice", 20000),
			new Employee(3, "mohhamed", 30000)
		};
		
		int arr[] = {1,2,3};
		
		Stream.of(empArr).forEach((employee)->{
			employee.incrementSalaray(10);
		});
		
		Arrays.stream(arr).forEach((elem)->{
			elem += 10;
		});
		
		//return employee stream from employee id stream
		
		Integer empIds[] = {1, 2, 3, null};
		
		List<Employee>  employeesList = Stream.of(empIds).filter(empId->empId!=null).map((empId)->{
			for( Employee emp : empArr ) {
				if( emp.empNo == empId ) {
				 return emp;
				}
			}
			return null;
		}).collect(Collectors.toList());
		
		
		//find first employee whose salary is greater than 15000
		
		Employee employee = Stream.of(empArr)
				.filter(emp->emp.salary>15000)
				.findFirst()
				.orElse(null);
		
		boolean isAnyEmpSalGreaterThan30K = employeesList.parallelStream().anyMatch(emp->emp.salary>30000);//true
		
		boolean isAllEmpSalGreaterThan30K = employeesList.parallelStream().allMatch(emp->emp.salary>30000);//false
		
		boolean isNoEmpSalGreaterThan30K = employeesList.parallelStream().noneMatch(emp->emp.salary>30000);//false
		
		float sumSalary = employeesList.stream().map(emp->emp.salary).reduce(0f,(salarySum,empSalary)->{return salarySum=salarySum+empSalary;});//60030.0
		
		//aggregate methods should be handled properly in parallel stream.
		
		String employeeNames;
		employeeNames = employeesList.stream().map(emp->emp.name).reduce("",(totalName,empName)->{return totalName+=" "+empName;});//john alice mohhamed

		employeeNames = employeesList.parallelStream().unordered().map(emp->emp.name).reduce("",(totalName,empName)->{return totalName+=" "+empName;});//john alice mohhamed
		System.out.println(employeeNames);
	}
}
