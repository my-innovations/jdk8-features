package comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee1 {

	private String name;
	private Integer age;

	public Employee1(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	// --getters/setters for name and age go here
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Name:" + this.name + "  Age:" + this.age;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Employee1)) {
			return false;
		}
		Employee1 empObj = (Employee1) obj;
		return this.age == empObj.age && this.name.equalsIgnoreCase(empObj.name);
	}

	@Override
	public int hashCode() {
		int hash = 1;
		hash = hash * 17 + this.name.hashCode();
		hash = hash * 31 + this.age;
		return hash;
	}
}

class EmployeeComparator implements Comparator<Employee1> {
	@Override
	public int compare(Employee1 emp1, Employee1 emp2) {
		// based on ascending order of name
		return (emp1.getName().compareTo(emp2.getName()));
	}
}

public class Jdk7ComparatorDemo {

	static List<Employee1> employeeList = Arrays.asList(
			new Employee1("Tom Jones", 45),
			new Employee1("Harry Major", 35), 
			new Employee1("Harry Major", 25), 
			new Employee1("Ethan Hardy", 65),
			new Employee1("Nancy Smith", 15), 
			new Employee1("Deborah Sprightly", 29));

	public static void main(String[] args) {

		// 1: Ascending order
		Collections.sort(employeeList, new EmployeeComparator());
		employeeList.forEach(System.out::println);

		// 2: Reverse order using annonymous class
		Collections.sort(employeeList, new Comparator<Employee1>() {
			@Override
			public int compare(Employee1 e1, Employee1 e2) {
				return (e2.getName().compareTo(e1.getName()));
			}
		});
		employeeList.forEach(System.out::println);
	}

}
