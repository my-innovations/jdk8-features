package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

class Employee2 {

	private int id;
	private String name;
	private double salary;
	private int age;

	public Employee2(int id, String name, double salary, int age) {

		this.id = id;
		this.name = name;
		this.salary = salary;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee2 [id=" + id + ", name=" + name + ", salary=" + salary + ", age=" + age + "]";
	}

}

public class Collections_sort_02 {

	public static void main(String[] args) {

		// Initial data
		ArrayList<Employee2> list = new ArrayList<Employee2>();
		list.add(new Employee2(500, "Shifoo", 150000, 24));
		list.add(new Employee2(504, "Oogway", 120000, 35));
		list.add(new Employee2(503, "Tigress", 100000, 20));
		list.add(new Employee2(730, "Mantis", 45000, 45));

		System.out.println("Initial List :");
		list.forEach((n) -> System.out.println(n));

		// Standard Comparator
		Comparator<Employee2> sortByName = new Comparator<Employee2>() {
			@Override
			public int compare(Employee2 e1, Employee2 e2) {
				return e1.getName().compareTo(e2.getName());
			}
		};

		// sortByName already defined in above snippet
		Collections.sort(list, sortByName);

		System.out.println("\nStandard Sorted by Name :");
		list.forEach(System.out::println);

		Comparator<Employee2> lambdaSortByName = (Employee2 e1, Employee2 e2) -> e1.getName().compareTo(e2.getName());

		// lambdaSortByName already defined in above snippet
		list.sort(lambdaSortByName);
		System.out.println("\nLambda Sorted by Name :");
		list.forEach(System.out::println);

		Comparator<Employee2> lambdaSortById = (Employee2 e1, Employee2 e2) -> e1.getId() - e2.getId();
		list.sort(lambdaSortById);

		System.out.println("\nSorted by Id :");
		list.forEach(System.out::println);

		// sort by age
		Collections.sort(list, new Comparator<Employee2>() {
			@Override
			public int compare(Employee2 o1, Employee2 o2) {
				return o1.getAge() - o2.getAge();
			}
		});

		System.out.println("After Sort by age ");
		for (Employee2 developer : list) {
			System.out.println(developer);
		}

		// sort by salary
		Collections.sort(list, new Comparator<Employee2>() {
			@Override
			public int compare(Employee2 o1, Employee2 o2) {
				return (int) (o1.getSalary() - o2.getSalary());
			}
		});

		System.out.println("After Sort by salary ");
		for (Employee2 developer : list) {
			System.out.println(developer);
		}

		/*
		 * ####### converting list to map and sorting sal in decreasing order
		 */

		// example 1
		Map result1 = list.stream().sorted(Comparator.comparingDouble(Employee2::getSalary).reversed())
				.collect(Collectors.toMap(Employee2::getName, Employee2::getSalary, (oldValue, newValue) -> oldValue,
						LinkedHashMap::new));

		System.out.println(" After sorting based on salary : " + result1);

		/* ####################################################### */
		Map<String, Integer> unsortMap = new HashMap<>();
		unsortMap.put("z", 10);
		unsortMap.put("b", 5);
		unsortMap.put("a", 6);
		unsortMap.put("c", 20);
		unsortMap.put("d", 1);
		unsortMap.put("e", 7);
		unsortMap.put("y", 8);
		unsortMap.put("n", 99);
		unsortMap.put("g", 50);
		unsortMap.put("m", 2);
		unsortMap.put("f", 9);

		System.out.println("Original...");
		System.out.println(unsortMap);

		// sort by keys, a,b,c..., and return a new LinkedHashMap
		// toMap() will returns HashMap by default, we need LinkedHashMap to
		// keep the order.
		Map<String, Integer> result = unsortMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
						LinkedHashMap::new));

		// sorting by values
		Map<String, Integer> result2 = unsortMap.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toMap(
						Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

		// sorting by values- Alternative way
		Map<String, Integer> result3 = new LinkedHashMap<>();
		unsortMap.entrySet().stream().sorted(Map.Entry.<String, Integer> comparingByValue().reversed())
				.forEachOrdered(x -> result2.put(x.getKey(), x.getValue()));

		System.out.println("Sorted...");
		System.out.println(result2);
		System.out.println(result3);

	}

}
