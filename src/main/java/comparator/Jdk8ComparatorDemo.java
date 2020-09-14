package comparator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Jdk8ComparatorDemo {

	// some dummy data for testing
	static List<Employee1> employeeList = Arrays.asList(new Employee1("Tom Jones", 45), new Employee1("Harry Major", 35),
			new Employee1("Harry Major", 25), new Employee1("Ethan Hardy", 65), new Employee1("Nancy Smith", 15),
			new Employee1("Deborah Sprightly", 29));

	public static void main(String[] args) {

		// 0 - How Comparator was used prior to Java 8 (JDK7)
		Collections.sort(employeeList, new EmployeeComparator());
		employeeList.forEach(System.out::println);

		System.out.println("######################################");

		// 1- Defining a Comparator using lambda expression
		Comparator<Employee1> empNameComparator = (Employee1 emp1, Employee1 emp2) -> {
			return (emp1.getName().compareTo(emp2.getName()));
		};
		Collections.sort(employeeList, empNameComparator);
		employeeList.forEach(System.out::println);

		System.out.println("######################################");

		// 2 - Comparator creation using static method comparing()
		Comparator<Employee1> empNameComparator2 = Comparator.comparing(Employee1::getName)
				.thenComparing(Employee1::getAge);
		Collections.sort(employeeList, empNameComparator2);
		employeeList.forEach(System.out::println);

		System.out.println("######################################");

		// 3 - Comparator's thenComparing() method for multiple sort criteria
		Comparator<Employee1> empNameComparator3 = Comparator.comparing(Employee1::getName)
				.thenComparing(Employee1::getAge);
		Collections.sort(employeeList, empNameComparator3);
		employeeList.forEach(System.out::println);

		System.out.println("######################################");

		// 4 - Comparator natural order sorting
		List<String> empNames = employeeList.stream().map(Employee1::getName).collect(Collectors.toList());
		empNames.sort(Comparator.naturalOrder());
		empNames.forEach(System.out::println);

		System.out.println("######################################");

		// 5- Comparator with sort key null and using nullsFirst()
		Comparator<Employee1> empNameComparator5 = Comparator.comparing(Employee1::getName,
				Comparator.nullsFirst(String::compareTo));
		Collections.sort(employeeList, empNameComparator5);
		employeeList.forEach(System.out::println);

		System.out.println("######################################");

		// 6 - Comparator with sort key null and using nullsLast()
		Comparator<Employee1> empNameComparator6 = Comparator.comparing(Employee1::getName,
				Comparator.nullsLast(String::compareTo));
		Collections.sort(employeeList, empNameComparator6);
		employeeList.forEach(System.out::println);

		System.out.println("######################################");

		// 7 - Comparator order reversal using reversed() method
		Comparator<Employee1> empNameComparator7 = Comparator.comparing(Employee1::getName).reversed();
		Collections.sort(employeeList, empNameComparator7);
		employeeList.forEach(System.out::println);

	}

}
