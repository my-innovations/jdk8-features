package lambda_expression;

import static java.lang.System.out;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import model.Person;

//Accessing Local and Class Variables in Lambda Expression 
//Java Lambda Expression Example: Creating Thread

//In Java lambda expression, if there is only one statement, you may or may not
//use return keyword. You must use return
//keyword when lambda expression contains multiple statements.

//Java Lambda Expression with no parameter
@FunctionalInterface // optional
interface MyFunctionalInterface01 {
	// single abstract method with no parameter and not returns anything.
	public abstract void sayHello();
}

@FunctionalInterface // optional
interface MyFunctionalInterface02 {
	// single abstract method with no parameter and returns string.
	public abstract String sayHello();
}

@FunctionalInterface
interface MyFunctionalInterface03 {
	public abstract void sayHello(String message);
}

@FunctionalInterface
interface MyFunctionalInterface04 {
	public abstract String sayHello(String name);
}

@FunctionalInterface
interface MyFunctionalInterface05 {
	public abstract String concatStrings(String a, String b);
}

@FunctionalInterface // optional
interface MyFunctionalInterface06 {
	// single abstract method with single parameter
	public abstract int incrementByFive(int a);
	// public int decrementByFive(int a); //CE
}

@FunctionalInterface
interface MyFunctionalInterface07 {
	public abstract int mathOperations(int a, int b);
}

@FunctionalInterface
interface MyFunctionalInterface08 {
	public abstract double get(double radius);
}

public class Lambda_Expression_demo {

	// instance members

	private static Comparator<Integer> intComparator1 = new Comparator<Integer>() {
		@Override
		public int compare(Integer num1, Integer num2) {
			return num1.compareTo(num2);
		}
	};

	private static Comparator<Integer> intComparator2 = (Integer num1, Integer num2) -> num1.compareTo(num2);
	private static Comparator<Integer> intComparator3 = (x, y) -> x.compareTo(y);
	private static Comparator<Integer> intComparator4 = new Comparator<Integer>() {
		@Override
		public int compare(Integer num1, Integer num2) {
			return num1.compareTo(num2);
		}
	};

	private static Comparator<String> strComparatorAsc = (s1, s2) -> s1.length() - s2.length();
	private static Comparator<String> strComparatorAsc2 = new Comparator<String>() {
		@Override
		public int compare(String str1, String str2) {
			return str1.compareTo(str2);
		}
	};

	private static Comparator<String> strComparatorDesc = (s1, s2) -> s2.length() - s1.length();
	private static Comparator<String> strComparatorLength = Comparator.comparingInt(String::length);

	private static List<String> namesList = Arrays.asList("Mahesh", "Suresh", "Naresh", "Kalpesh ");
	private static List<Person> personList = Arrays.asList();

	public static final String salutation = "Mr ";
	public static final String wildPerson2 = "Lion";
	final Runnable r1 = () -> out.println(this);
	final Runnable r2 = () -> out.println(toString());

	public double circleOperation(double radius, MyFunctionalInterface08 c) {
		return c.get(radius);
	}

	public static int add(List<Integer> numList, Predicate<Integer> predicate) {
		int sum = 0;
		for (int number : numList) {
			if (predicate.test(number)) {
				sum += number;
			}
		}
		return sum;
	}

	private int operate(int a, int b, MyFunctionalInterface07 mathOperation) {
		return mathOperation.mathOperations(a, b);
	}

	public static void main(String[] arg) {

		lambdaWithFunctionalInterfaceDemo();
		lambdaWithFunctionalInterfaceWithNoParamDemo01();
		lambdaWithFunctionalInterfaceWitOneParamDemo01();
		lambdaWithFunctionalInterfaceWitTwoParamDemo01();
		lambdaWithForEachDemo();
		lambdaWithThread();
		lambdaWithPredicate();
		sortStrings();
		method1();
		method2();
		compareTwoIntBeforeJdk8();
		compareTwoIntInJdk8UsingLambda();
		sortingListOfStringUsingJdk8UsingLambda();
		custom_comparator_demo();
		sortNamesList();
		sortEmployeesByName();
		createAndStartThreadBeforeJdk8();
		createAndStartThreadInJdk8();

		new Lambda_Expression_demo().r1.run();
		new Lambda_Expression_demo().r2.run();

	} // main

	private static void lambdaWithFunctionalInterfaceWithNoParamDemo01() {

		// Before java-8
		final ActionListener al1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand());
			}
		};

		// Java 8
		final ActionListener al2 = (e) -> {
			System.out.println(e.getActionCommand());
		};

		// EX-01
		// lambda expression
		// overriding the method of functional interface using lambda(without method
		// name).
		MyFunctionalInterface01 msg = () -> {
			System.out.println("Hello");
		};

		msg.sayHello();

		// EX-02
		final MyFunctionalInterface02 s = () -> {
			return "I have nothing to say.";
		};
		System.out.println(s.sayHello());
	}

	private static void lambdaWithFunctionalInterfaceWitOneParamDemo01() {

		// Ex-01
		// lambda expression with single parameter num
		MyFunctionalInterface06 f = (num) -> num + 5;
		System.out.println(f.incrementByFive(22));

		MyFunctionalInterface06 f1 = num -> num + 5;
		System.out.println(f1.incrementByFive(22));

		// EX-02
		// Lambda expression with single parameter.
		final MyFunctionalInterface04 s1 = (name) -> {
			return "Welcome " + name;
		};
		System.out.println(s1.sayHello("Lipu"));

		final MyFunctionalInterface04 s2 = name -> {
			return "Welcome " + name;
		};
		System.out.println(s2.sayHello("Punya"));

		// Ex-03

		MyFunctionalInterface04 obj1 = (String name) -> {
			return "Hi " + name;
		};
		System.out.println(obj1.sayHello("Lipun"));

		MyFunctionalInterface04 obj2 = (name) -> {
			return "Hello " + name;
		};
		System.out.println(obj2.sayHello("Punya"));

	}

	private static void lambdaWithFunctionalInterfaceWitTwoParamDemo01() {

		// Ex-03
		// with type declaration
		final MyFunctionalInterface07 addition = (int a, int b) -> a + b;
		System.out.println("10 + 5 = " + addition.mathOperations(10, 5));

		// with out type declaration
		final MyFunctionalInterface07 subtraction = (a, b) -> a - b;
		System.out.println("10 - 5 = " + subtraction.mathOperations(10, 5));

		// with return statement along with curly braces
		final MyFunctionalInterface07 multiplication = (int a, int b) -> {
			return a * b;
		};
		System.out.println("10 x 5 = " + multiplication.mathOperations(10, 5));

		// without return statement and without curly braces
		final MyFunctionalInterface07 division = (int a, int b) -> a / b;
		System.out.println("10 / 5 = " + division.mathOperations(10, 5));

		// EX-04
		// lambda expression with multiple arguments
		MyFunctionalInterface05 s3 = (str1, str2) -> str1 + str2;
		System.out.println("Add Result: " + s3.concatStrings("Hello ", "World"));

		// app-03 - Using predefined functional interfcae
		// IntBinaryOperator is a predefined functional interface.
		IntBinaryOperator sum = (a, b) -> a + b;
		System.out.println(sum.applyAsInt(3, 8));

	}

	private static void sortStrings() {

		// Before Soorting
		Person[] personArr = { new Person("Lion"), new Person("Crocodile"), new Person("Tiger"),
				new Person("Elephant") };
		System.out.println("Before Sort: " + Arrays.toString(personArr));

		// After sorting
		Arrays.sort(personArr);
		System.out.println("After Sort: " + Arrays.toString(personArr));
	}

	private static void lambdaWithPredicate() {
		//// Predicates and Lambda Expressions
		List<Integer> numList = new ArrayList<>();

		numList.add(new Integer(10));
		numList.add(new Integer(20));
		numList.add(new Integer(30));
		numList.add(new Integer(40));
		numList.add(new Integer(50));

		System.out.println("Add Everything: " + add(numList, n -> true));
		System.out.println("Add Nothing: " + add(numList, n -> false));
		// System.out.println("Add Less Than 25: " + add(numList, n -> n < 25));
		// System.out.println("Add 3 Multiples: " + add(numList, n -> n % 3 ==
		// 0));
	}

	private static void lambdaWithThread() {

		// Ex-01
		String domesticPerson2 = "Dog";
		new Thread(() -> {
			System.out.println("Class Level: " + wildPerson2);
			System.out.println("Method Level: " + domesticPerson2);
		}).start();

		// ex-04
		Callable<String>[] animals = new Callable[] { () -> "Lion", () -> "Crocodile" };
		try {
			System.out.println(animals[0].call());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void lambdaWithForEachDemo() {

		Arrays.asList("name1", "name2", "name3").forEach(str -> System.out.println(str));
		Arrays.asList("name1", "name2", "name3").forEach(str -> {
			System.out.print(str);
		});

		final String separator = ",";
		Arrays.asList("name1", "name2", "name3").forEach((String e) -> System.out.print(e + separator));

		List<String> list = new ArrayList<String>();
		list.add("Rick");
		list.add("Negan");
		list.add("Daryl");
		list.add("Glenn");
		list.add("Carl");

		// Java 7
		for (final String str : list) {
			System.out.print(str + " ");
		}

		// Java 8
		list.forEach(System.out::println);
		list.forEach((str) -> {
			System.out.println(str);
		});

		String str = String.join(" ", "Java", "8", "features");
		System.out.println(str);

		Arrays.asList("name1", "name3", "name2").sort((str1, str2) -> str1.compareTo(str2));
	}

	private static void lambdaWithFunctionalInterfaceDemo() {

		Lambda_Expression_demo obj = new Lambda_Expression_demo();

		// ex-01
		MyFunctionalInterface08 finfCircleCircumferenceUsingRadius = (r) -> 2 * Math.PI * r;
		double circumference = obj.circleOperation(5, finfCircleCircumferenceUsingRadius);
		System.out.println("circle circumfarence=" + circumference);

		// ex-02
		MyFunctionalInterface08 finfCircleAreaUsingRadius = (r) -> Math.PI * r * r;
		double area = obj.circleOperation(10, finfCircleAreaUsingRadius);
		System.out.println(" Circle Area=" + area);

	}

	private static void method1() {
		Lambda_Expression_demo tester = new Lambda_Expression_demo();

		// with type declaration
		MyFunctionalInterface07 add = (int a, int b) -> a + b;

		// with out type declaration
		MyFunctionalInterface07 subtract = (a, b) -> a - b;

		// with return statement along with curly braces
		MyFunctionalInterface07 mul = (int a, int b) -> {
			return a * b;
		};

		// without return statement and without curly braces
		MyFunctionalInterface07 div = (int a, int b) -> a / b;

		System.out.println("10 + 5 = " + tester.operate(10, 5, add));
		System.out.println("10 - 5 = " + tester.operate(10, 5, subtract));
		System.out.println("10 x 5 = " + tester.operate(10, 5, mul));
		System.out.println("10 / 5 = " + tester.operate(10, 5, div));
	}

	private static void method2() {
		// without parenthesis
		MyFunctionalInterface03 greetService1 = message -> System.out.println("Hello " + message);

		// with parenthesis
		MyFunctionalInterface03 greetService2 = (message) -> System.out.println("Hello " + message);

		MyFunctionalInterface03 greetService3 = message -> System.out.println(salutation + message);

		greetService1.sayHello("Mahesh");
		greetService2.sayHello("Suresh");
		greetService3.sayHello("Mahesh");
	}

	@Override
	public String toString() {
		return "Hello, world!";
	}

	private static void compareTwoIntBeforeJdk8() {
		System.out.println(intComparator1.compare(10, 15)); // -1
	}

	private static void compareTwoIntInJdk8UsingLambda() {
		System.out.println(intComparator2.compare(30, 45)); // -1
		// OR, without using datatype
		System.out.println(intComparator3.compare(30, 45)); // -1
	}

	private static void sortingListOfStringUsingJdk8UsingLambda() {

		final List<String> nameslist = new ArrayList<String>();
		nameslist.add("punya");
		nameslist.add("Aswini");
		nameslist.add("omkar");
		nameslist.add("pankaj");

		Collections.sort(nameslist, strComparatorAsc);
		System.out.println("names ==>" + nameslist); // [punya, omkar, Aswini, pankaj]

		Collections.sort(nameslist, strComparatorDesc);
		System.out.println("names ==>" + nameslist); // [Aswini, pankaj, punya, omkar]
		// or
		nameslist.sort(strComparatorLength);
		System.out.println("names ==>" + nameslist); // [punya, omkar, Aswini, pankaj]

		// using custom comparator for sorting
		Collections.sort(nameslist, strComparatorAsc2);
		System.out.println(nameslist); // [Aswini, omkar, pankaj, punya]

	}

	private static void custom_comparator_demo() {

		// ex-01 using java-7 comparator
		System.out.println(intComparator4.compare(10, 20)); // -1
		System.out.println(intComparator4.compare(20, 10)); // 1

		// ex-02 using java-8 comparator
		Comparator<Integer> comparator2 = (Integer i1, Integer i2) -> i1.compareTo(i2);
		System.out.println(comparator2.compare(15, 25)); // -1
		System.out.println(comparator2.compare(25, -15)); // -1

	}

	private static void sortNamesList() {

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

	private static void sortEmployeesByName() {

		// only gathering the employee names and sorting in natural order.
		List<String> empNamesList = personList.stream().map(Person::getFirstName).collect(Collectors.toList());
		empNamesList.sort(Comparator.naturalOrder());
		// empNamesList.sort(Comparator.reverseOrder());
		empNamesList.forEach(System.out::println);

		Comparator<Person> empNameComparator = Comparator.comparing(Person::getFirstName).reversed();
		Collections.sort(personList, empNameComparator);
		personList.forEach(System.out::println);

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
		Comparator<Person> personFirstNameComparator5 = Comparator.comparing(Person::getFirstName,
				Comparator.nullsFirst(String::compareTo));
		Collections.sort(personList, personFirstNameComparator5);
		personList.forEach(System.out::println);

		// Comparator with sort key null and using nullsLast()
		Comparator<Person> empNameComparator6 = Comparator.comparing(Person::getFirstName,
				Comparator.nullsLast(String::compareTo));
		Collections.sort(personList, empNameComparator6);
		personList.forEach(System.out::println);

		// ex--01 using jdk7, using in line comparator
		Collections.sort(personList, new Comparator<Person>() {
			@Override
			public int compare(Person e1, Person e2) {
				// return (e1.getName().compareTo(e2.getName()));
				// return (e2.getName().compareTo(e1.getName()));
				return (e1.getAge().compareTo(e2.getAge()));
				// return (e2.getAge().compareTo(e1.getAge()));
			}
		});
		personList.forEach(System.out::println);

		// ex-02 , using jdk7 external comparator
		Collections.sort(personList, new PersonComparator());
		personList.forEach(System.out::println);

		// ex-03 - Comparator creation using static method comparing()
		Comparator<Person> empNameComparator2 = Comparator.comparing(Person::getFirstName)
				.thenComparing(Person::getAge);
		Collections.sort(personList, empNameComparator2);
		personList.forEach(System.out::println);

		// ex-04 , using jdk8 Defining a Comparator using lambda expression
		Comparator<Person> empNameComparator4 = (Person emp1, Person emp2) -> {
			return (emp1.getFirstName().compareTo(emp2.getFirstName()));
		};
		Collections.sort(personList, empNameComparator4);
		personList.forEach(System.out::println);
	}

	private static void createAndStartThreadBeforeJdk8() {

		Runnable runnable1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("Th-0");
			}
		};
		new Thread(runnable1).start();
		// OR
		String domesticPerson2 = "Dog";
		new Thread(new Runnable() {
			@Override
			public void run() {
				// System.out.println("Class Level: " + this.wildPerson2);
				System.out.println("Th-1:" + domesticPerson2);
			}
		}).start();
	}

	private static void createAndStartThreadInJdk8() {

		Runnable runnable3 = () -> {
			System.out.println("Th-4");
		};
		new Thread(runnable3).start();
		// OR
		new Thread(() -> {
			System.out.println("Th-5");
		}).start();

	}
}
