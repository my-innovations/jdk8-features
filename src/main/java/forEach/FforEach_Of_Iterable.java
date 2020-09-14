package forEach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;

public class FforEach_Of_Iterable {

	public static void main(String[] args) {

		// creating sample Collection and
		List<Integer> myList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++)
			myList.add(i);

		// ##################### Iterating over list using for loop
		System.out.println("\n traversing list using for loop");
		for (int j = 0; j < myList.size(); j++) {
			System.out.println(myList.get(j));
		}

		/*
		 * ##################### Iterating over list using iterator####################
		 */
		// traversing list using Iterator
		System.out.println("\ntraversing list using Iterator");
		Iterator<Integer> it = myList.iterator();
		while (it.hasNext()) {
			Integer i = it.next();
			System.out.print(i + " ");
		}
		// ###################################################################################
		for (Integer i : myList) {
			System.out.print(i + " ");
		}

		// ###################################################################################
		// using method ref
		myList.forEach(System.out::println);

		// ###################################################################################

		// using lambda expression of jdk8
		System.out.println("\ntraversing list using lambda");
		myList.forEach(item -> {
			// you can implement some business logic here..
			System.out.print(item + " ");
		});

		// ###################################################################################

		System.out.println("\nforEach anonymous class Value::");
		myList.forEach(new Consumer<Integer>() {
			@Override
			public void accept(Integer item) {
				System.out.print(item + " ");
			}
		});
		// ###################################################################################
		// way-02- traversing with Consumer interface implementation
		System.out.println("\nConsumer impl Value::");
		My_Consumer consumer = new My_Consumer();
		myList.forEach(consumer);

		// ###################################################################################
		/* ArrayList<Employee> list = new ArrayList<Employee>();
		list.add(new Employee(500, "Shifoo", 150000, 11));
		list.add(new Employee(504, "Oogway", 120000, 45));
		list.add(new Employee(503, "Tigress", 100000, 34));
		list.add(new Employee(730, "Mantis", 45000, 55));

		System.out.println("Printing List with forEach");
		list.forEach(employee -> System.out.println(employee));

		System.out.println("\nPrinting List after Filtering");
		list.stream().filter(employee -> employee.getSalary() > 100000).forEach(System.out::println);*/

		// ###################################################################################
		List<String> alphabets = Arrays.asList("A", "B", "C", "D");
		System.out.println("Printing with earlier JDK 1.5 for loop:");
		for (String str : alphabets) {
			System.out.print(str + "\t");
		}

		alphabets.forEach(System.out::println);
		alphabets.forEach((String str) -> System.out.print(str + "\t"));

		System.out.println("\nPrinting with latest forEach loop introduced with JDK 1.8 with lambda usage:");
		alphabets.forEach(str -> {
			System.out.print(str + "\t");
		});

		/*
		 * ##################### Iterating over Map ####################
		 */

		Map<String, String> countryMap = new HashMap<>();
		countryMap.put("India", "Delhi");
		countryMap.put("USA", "Washington, D.C.");
		countryMap.put("Japan", "Tokyo");
		countryMap.put("Canada", "Ottawa");

		System.out.println("<----------Iterating in normal way------------->");
		for (Entry<String, String> entry : countryMap.entrySet()) {
			System.out.println("Country: " + entry.getKey() + " : Capital: " + entry.getValue());
		}

		System.out.println("\n<----------Iterating using forEach method------------>");
		countryMap.forEach((k, v) -> System.out.println("Country: " + k + " : Capital: " + v));

		countryMap.forEach((k, v) -> {
			// you can implement some business logic here..
			// System.out.println("Key : " + k + " Value : " + v);
			if (v.equals("Delhi")) {
				System.out.println("Hello  " + v);
			}

		});

	}// main

}// class

// Consumer implementation that can be reused
class My_Consumer implements Consumer<Integer> {
	@Override
	public void accept(Integer t) {
		System.out.print(t + " ");
	}
}
