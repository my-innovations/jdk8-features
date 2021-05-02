package forEach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import model.Person;

public class ForEachWithList {

	// dummy data
	private static List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5, 6);
	private static List<String> alphabets = Arrays.asList("A", "B", "C", "D");
	private static List<String> strList = Arrays.asList("A", "B", "C", "D");
	private static List<String> namesList = Arrays.asList("Melisandre", "Sansa", "Jon", "Daenerys", "Joffery", "Sansa");
	private static List<Object[]> splitUpNames = Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long").stream().map(name -> name.split(" ")).collect(Collectors.toList());
	private static List<Person> personList = Arrays.asList(new Person(1,"punya","nayak",1000d,"male",40,100,Arrays.asList("reading","music")),new Person(2,"pankaj","prajapati",2000d,"male",30,120,Arrays.asList("cricket","music")));

	public static void main(String[] args) {
		iterateListUsingForEachLoop();
		findUniqueNamesFromList();
	}

	public static void iterateListUsingForEachLoop() {

		// ex-01
		System.out.println("\n traversing list using for loop");
		for (int j = 0; j < personList.size(); j++) {
			System.out.println(personList.get(j));
		}
		// OR
		for (Person i : personList) {
			System.out.print(i + " ");
		}
		// or
		personList.forEach(emp -> System.out.println(emp));
		personList.forEach(System.out::println);

		// ex-2
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

		// Ex-
		personList.forEach(new Consumer<Person>() {
			@Override
			public void accept(Person item) {
				System.out.print(item + " ");
			}
		});

		// EX-
		// way-02- traversing with Consumer interface implementation
		System.out.println("\nConsumer impl Value::");
		MyCustomConsumer consumer = new MyCustomConsumer();
		personList.forEach(consumer);

	}

	public static void iterateListUsingIterator() {
		System.out.println("\ntraversing list using Iterator");
		Iterator<Person> it = personList.iterator();
		while (it.hasNext()) {
			Person i = it.next();
			System.out.println(i);
		}
	}

	public void splitdata() {
		splitUpNames.forEach(name -> System.out.println(name[0] + "-" + name[1]));
	}

	public static void traversingListusingLambda() {

		// using lambda expression of jdk8
		System.out.println("\ntraversing list using lambda");
		personList.forEach(item -> {
			// you can implement some business logic here..
			System.out.print(item + " ");
		});

		System.out.println("Printing List with forEach");
		personList.forEach(employee -> System.out.println(employee));

		System.out.println("\nPrinting List after Filtering");
		personList.stream().filter(employee -> employee.getSal() > 100000).forEach(System.out::println);
		System.out.println(personList);

		personList.stream().filter(employee -> employee.getSal() > 100000).collect(Collectors.toList());
		System.out.println(personList);

		// Ex-02
		List<String> strList = Arrays.asList("A", "B", "C", "D");
		// filtering names that starts with M
		strList.stream().filter(f -> f.startsWith("M")).forEach(System.out::println); // displaying the stream using
																						// forEach

		// EX-03
		namesList.stream().filter(f -> f.startsWith("M")).parallel().forEach(n -> System.out.println(n));

		// ex-04
		namesList.stream().filter(f -> f.startsWith("M")).parallel().forEachOrdered(n -> System.out.println(n));

		// ex-05
		// Creating the stream of all names
		Stream<String> allNames = namesList.stream();
		// Creating another stream by filtering long names using filter()
		Stream<String> longNames = allNames.filter(str -> str.length() > 6);
		// displaying the long names
		longNames.forEach(str -> System.out.print(str + " "));

		// Stream filter() and collect()
		List<String> longnames = namesList.stream() // converting the list to stream
				.filter(str -> str.length() > 6) // filter the stream to create a new stream
				.collect(Collectors.toList()); // collect the final stream and convert it to a List

		longnames.forEach(System.out::println);

		// ex-
		List<String> longnames3 = namesList.stream().filter(str -> str.length() > 6 && str.length() < 8).collect(Collectors.toList());
		longnames3.forEach(System.out::println);

		// EX-
		List<Integer> squares = numList.stream().map(n -> n * n).collect(Collectors.toList());
		System.out.println(squares);

	}

	public static void findUniqueNamesFromList() {
		
		// EX-way-01
		List<String> list = new ArrayList<>();
		for (String name : namesList) {
			if (!list.contains(name)) {
				list.add(name);
			}
		}
		System.out.println(list);

		// EX-way-02
		List<String> uniqueNames = namesList.stream().distinct().collect(Collectors.toList());
		System.out.println(uniqueNames);

	}
}
