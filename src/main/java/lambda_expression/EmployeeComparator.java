package lambda_expression;

import java.util.Comparator;

import model.Employee;

//using jdk7 and before
public class EmployeeComparator implements Comparator<Employee> {
	
	@Override
	public int compare(Employee emp1, Employee emp2) {
		
		// based on ascending order of name
		//return emp1.getName().compareTo(emp2.getName());
		
		// based on descending order of name
		 return (emp2.getName().compareTo(emp1.getName()));
		 
		// based on descending order of sal
		//return emp1.getSalary().compareTo(emp2.getSalary());
	}

}
