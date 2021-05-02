package lambda_expression;

import java.util.Comparator;

import model.Person;

//using jdk7 and before
public class PersonComparator implements Comparator<Person> {
	
	@Override
	public int compare(Person emp1, Person emp2) {
		
		// based on ascending order of name
		//return emp1.getName().compareTo(emp2.getName());
		
		// based on descending order of name
		 return (emp2.getFirstName().compareTo(emp1.getFirstName()));
		 
		// based on descending order of sal
		//return emp1.getSalary().compareTo(emp2.getSalary());
	}

}
