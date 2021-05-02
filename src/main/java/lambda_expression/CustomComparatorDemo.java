package lambda_expression;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import model.Employee;
import model.Person;

public class CustomComparatorDemo {
	
	private static List<String> namesList = Arrays.asList("Mahesh","Suresh","Naresh","Kalpesh ");
	private static List<Employee> employeeList = Arrays.asList(new Employee(1,"Shifoo","acc1","IT",25, 150000d),	new Employee(2,"Punya","acc2","IT",40, 250000d));
	private static List<Person> personList = Arrays.asList(new Person("Tom Jones", "abc"), new Person("Harry Major", "bcw"),new Person("Harry Major", "mnf"));
	
	private static Comparator<Integer> comparator1 = new Comparator<Integer>() {
		@Override
		public int compare(Integer num1, Integer num2) {
			return num1.compareTo(num2);
		}
	};


	public static void main(String[] args) {

		custom_comparator_demo();
		sortNamesList();
		sortEmployeesByName();

	}// main

	public static void custom_comparator_demo() {

		// ex-01 using java-7 comparator
		System.out.println(comparator1.compare(10, 20)); // -1
		System.out.println(comparator1.compare(20, 10)); // 1

		// ex-02 using java-8 comparator
		Comparator<Integer> comparator2 = (Integer i1, Integer i2) -> i1.compareTo(i2);
		System.out.println(comparator2.compare(15, 25)); // -1
		System.out.println(comparator2.compare(25, -15)); // -1

	}

	public static void sortNamesList() {
		
		Collections.sort(namesList);
		System.out.println(namesList);

		// using jdk7, using in line comparator
		Collections.sort(namesList, new Comparator<String>() {
			@Override
			public int compare(String name1, String name2) {
				return name1.compareTo(name2);
				// return name2.compareTo(name1);
			}
		});
		System.out.println(namesList);

		// way-02
		Comparator<String> nameComparator = new Comparator<String>() {
			@Override
			public int compare(String name1, String name2) {
				return name1.compareTo(name2);
			}
		};

		Collections.sort(namesList, nameComparator);
		System.out.println(namesList);

		// using jdk8
		Collections.sort(namesList, (String name1, String name2) -> name1.compareTo(name2));
		// Collections.sort(namesList, (name1, name2) -> name1.compareTo(name2)); //OK
		System.out.println(namesList);
	}

	
	public static void sortEmployeesByName() {

		// only gathering the employee names and sorting in natural order.
		List<String> empNamesList = employeeList.stream().map(Employee::getName).collect(Collectors.toList());
		empNamesList.sort(Comparator.naturalOrder());
		empNamesList.forEach(System.out::println);

		Comparator<Employee> empNameComparator = Comparator.comparing(Employee::getName).reversed();
		Collections.sort(employeeList, empNameComparator);
		employeeList.forEach(System.out::println);

		// java8
		personList.sort(Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName));
		personList.forEach(System.out::println);

		// java8
		Collections.sort(personList, (p1, p2) -> {
			final int n = p1.getLastName().compareTo(p2.getLastName());
			if (n == 0) {
				return p1.getFirstName().compareTo(p2.getFirstName());
			}
			return n;
		});

		System.out.println(personList);

		// Comparator with sort key null and using nullsFirst()
		Comparator<Employee> empNameComparator5 = Comparator.comparing(Employee::getName,Comparator.nullsFirst(String::compareTo));
		Collections.sort(employeeList, empNameComparator5);
		employeeList.forEach(System.out::println);

		// Comparator with sort key null and using nullsLast()
		Comparator<Employee> empNameComparator6 = Comparator.comparing(Employee::getName,Comparator.nullsLast(String::compareTo));
		Collections.sort(employeeList, empNameComparator6);
		employeeList.forEach(System.out::println);

		// ex--01 using jdk7, using in line comparator
		Collections.sort(employeeList, new Comparator<Employee>() {
			@Override
			public int compare(Employee e1, Employee e2) {
				// return (e1.getName().compareTo(e2.getName()));
				// return (e2.getName().compareTo(e1.getName()));
				return (e1.getAge().compareTo(e2.getAge()));
				// return (e2.getAge().compareTo(e1.getAge()));
			}
		});
		employeeList.forEach(System.out::println);

		// ex-02 , using jdk7 external comparator
		Collections.sort(employeeList, new EmployeeComparator());
		employeeList.forEach(System.out::println);

		// ex-03 - Comparator creation using static method comparing()
		Comparator<Employee> empNameComparator2 = Comparator.comparing(Employee::getName).thenComparing(Employee::getAge);
		Collections.sort(employeeList, empNameComparator2);
		employeeList.forEach(System.out::println);

		// ex-04 , using jdk8 Defining a Comparator using lambda expression
		Comparator<Employee> empNameComparator4 = (Employee emp1, Employee emp2) -> {return (emp1.getName().compareTo(emp2.getName()));};
		Collections.sort(employeeList, empNameComparator4);
		employeeList.forEach(System.out::println);
	}
}


