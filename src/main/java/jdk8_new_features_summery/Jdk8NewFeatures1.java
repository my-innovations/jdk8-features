package jdk8_new_features_summery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.StringJoiner;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;



//########################################## 
//Lambda Expression and Functional Interface 
//##########################################
@FunctionalInterface
interface MyFunctionalInterface {
	// A method with no parameter
	public String sayHello();
}

@FunctionalInterface
interface MyFunctionalInterface2 {
	// A method with single parameter
	public int incrementByFive(int a);
}

interface StringConcat {
	public String sconcat(String a, String b);
}

@FunctionalInterface
interface MyFunctionalInterface3 {
	public int addMethod(int a, int b);
}

@FunctionalInterface
interface MyFunctionalInterface4 {
	// the abstract method
	public void singleMethod(String param);
}

class Demo {
	public void print(MyFunctionalInterface4 firstInterface) {
		firstInterface.singleMethod("apple");
	}
}

// ####################
// Method References
// ###################################
// 1. Method reference to an instance method of an object
@FunctionalInterface
interface MyInterface {
	void display();
}

// 2. Method reference to a static method of a class
class Multiplication {
	public static int multiply(int a, int b) {
		return a * b;
	}
}

@FunctionalInterface
interface MyInterface2 {
	Hello display(String say);
}

class Hello {
	// public Hello() {}
	public Hello(String say) {
		System.out.print(say);
	}
}

interface HelloFactory {
	public abstract Hello getHelloInstance(String msg);
}

// ################################################################
// Default method in Interface (Interface change) : Both instance
// and satic method inside an interface.
// ################################################################
// *******Having non static method in interface.
interface MyInterface3 {
	/*
	 * This is a default method so we need not to implement this method in the
	 * implementation classes
	 */
	default void newMethod() {
		System.out.println("Newly added default method");
	}

	/*
	 * Already existing public and abstract method We must need to implement this
	 * method in implementation classes.
	 */
	void existingMethod(String str);
}

class A implements MyInterface3 {
	// implementing abstract method
	@Override
	public void existingMethod(String str) {
		System.out.println("String is: " + str);
	}
}

// ********Having both static and non static method inside an interface.
interface MyInterface4 {
	/*
	 * This is a default method so we need not to implement this method in the
	 * implementation classes
	 */
	default void newMethod() {
		System.out.println("Newly added default method");
	}

	/*
	 * This is a static method. Static method in interface is similar to default
	 * method except that we cannot override them in the implementation classes.
	 * Similar to default methods, we need to implement these methods in
	 * implementation classes so we can safely add them to the existing interfaces.
	 */
	static void anotherNewMethod() {
		System.out.println("Newly added static method");
	}

	/*
	 * Already existing public and abstract method We must need to implement this
	 * method in implementation classes.
	 */
	void existingMethod(String str);
}

class A2 implements MyInterface4 {
	// implementing abstract method
	@Override
	public void existingMethod(String str) {
		System.out.println("String is: " + str);
	}
}

// ########################################
// For Collectors class
// ##########################################
class Student {
	int id;
	String name;
	int age;

	public Student(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
}

// #########################################
// For forEach() method in Iterable interface
// ###########################################

// Consumer implementation that can be reused
class MyConsumer implements Consumer<Integer> {
	@Override
	public void accept(Integer t) {
		System.out.println("Consumer impl Value::" + t);
	}
}

public class Jdk8NewFeatures1 {

	public void myMethod() {
		System.out.println("Instance Method invoked through method reference");
	}

	public static void main(String[] args) {

		// ###################################################
		// Feature - Functional interface and Lambda expression
		// ##################################################
		// Prog-1 : Java Lambda Expression with no parameter
		MyFunctionalInterface msg = () -> {
			return "Hello";
		};
		System.out.println(msg.sayHello());

		// prog-2 : Java Lambda Expression with single parameter
		// lambda expression with single parameter num
		MyFunctionalInterface2 f = (num) -> num + 5;
		System.out.println(f.incrementByFive(22));

		// prog-3 : java lambda expression with multiple arguments
		StringConcat s2 = (str1, str2) -> str1 + str2;
		System.out.println("Result: " + s2.sconcat("Hello ", "World"));

		// prog-4 : lambda expression with for each
		List<String> list = new ArrayList<String>();
		list.add("Rick");
		list.add("Negan");
		list.add("Daryl");
		list.add("Glenn");
		list.add("Carl");
		list.forEach((names) -> System.out.println(names));

		// prog-5 : lambda expression with for each
		Map<Integer, String> hmap = new HashMap<Integer, String>();
		hmap.put(1, "Monkey");
		hmap.put(2, "Dog");
		hmap.put(3, "Cat");
		hmap.put(4, "Lion");
		hmap.put(5, "Tiger");
		hmap.put(6, "Bear");
		/*
		 * forEach to iterate and display each key and value pair of HashMap.
		 */
		hmap.forEach((key, value) -> System.out.println(key + " - " + value));
		/*
		 * forEach to iterate a Map and display the value of a particular key
		 */
		hmap.forEach((key, value) -> {
			if (key == 4) {
				System.out.println("Value associated with key 4 is: " + value);
			}
		});
		/*
		 * forEach to iterate a Map and display the key associated with a particular
		 * value
		 */
		hmap.forEach((key, value) -> {
			if ("Cat".equals(value)) {
				System.out.println("Key associated with Value Cat is: " + key);
			}
		});

		// Prog6:
		MyFunctionalInterface3 sum = (a, b) -> a + b;
		System.out.println("Result: " + sum.addMethod(12, 100));

		// Prog7 : Using predefined functional interface
		IntBinaryOperator sum2 = (a, b) -> a + b;
		System.out.println("Result: " + sum2.applyAsInt(12, 100));

		// Prog8
		Runnable r1 = () -> {
			System.out.println("My Runnable");
		};
		Thread th = new Thread(r1);
		th.start();

		// Prog-9
		Demo printer = new Demo();
		printer.print((String res) -> {
			System.out.println("===> " + res);
		});

		// #####################################################
		// Feature - Interface Changes : Default and static
		// methods inside interface
		// #####################################################
		// Prog-1
		//variables_Demo_52 obj2 = new variables_Demo_52();
		// calling the default method of interface
		//obj2.newMethod();
		// calling the abstract method of interface
		//obj2.existingMethod("Java 8 is easy to learn");

		// Prog-2
		A2 obj4 = new A2();
		// calling the default method of interface
		obj4.newMethod();
		// calling the static method of interface
		MyInterface4.anotherNewMethod();
		// calling the abstract method of interface
		obj4.existingMethod("Java 8 is easy to learn");

		// ##############################################
		// Feature - Method References
		// ###############################################
		// 1. Method reference to a instance method of a class
		Jdk8NewFeatures1 obj = new Jdk8NewFeatures1();
		// Method reference using the object of the class
		MyInterface ref = obj::myMethod;
		// Calling the method of functional interface
		ref.display();

		// 2. Method reference to a static method of a class
		BiFunction<Integer, Integer, Integer> product = Multiplication::multiply;
		int pr = product.apply(11, 5);
		System.out.println("Product of given number is: " + pr);

		// 3. Method reference to an instance method of an arbitrary object of a
		// particular type.
		String[] stringArray = { "Steve", "Rick", "Aditya", "Negan", "Lucy", "Sansa", "Jon" };
		/*
		 * Method reference to an instance method of an arbitrary object of a particular
		 * type
		 */
		Arrays.sort(stringArray, String::compareToIgnoreCase);
		for (String str : stringArray) {
			System.out.println(str);
		}

		// 4.Method reference to a constructor
		MyInterface2 ref2 = Hello::new;
		ref2.display("Hello World!");

		//
		HelloFactory factory = Hello::new;
		Hello h = factory.getHelloInstance("I am punya");

		// 5. Reference to a static method
		Function<String, Double> doubleConvertor = Double::parseDouble;
		Function<String, Double> doubleConvertorLambda = (String s) -> Double.parseDouble(s);
		System.out.println("double value using method reference - " + doubleConvertor.apply("0.254"));
		System.out.println("double value using Lambda - " + doubleConvertorLambda.apply("0.254"));

		// 6.:Reference to an instance method of an object
		Consumer<String> stringPrinter = System.out::println;
		Consumer<String> stringPrinterLambda = (String s) -> System.out.println(s);
		stringPrinter.accept("Print from method reference based instance");
		stringPrinterLambda.accept("Print from instance created from Lambda");

		// 7. Reference to an instance method of an arbitrary object of a particular
		// type
		List<Integer> intList = Arrays.asList(1, 2, 3, 4);
		BiPredicate<List<Integer>, Integer> isPartOf = List::contains;
		BiPredicate<List<Integer>, Integer> isPartOfLambda = (List<Integer> listInt, Integer value) -> listInt
				.contains(value);
		System.out.println("Is 1 a part of the intList - " + isPartOf.test(intList, 1));
		System.out.println("Is 1 a part of the intList - " + isPartOfLambda.test(intList, 1));

		// #################################
		// Feature - Collectors Class of JDK8
		// ################################
		// prog-1: Stream Collectors groupingBy and counting Example
		List<String> names = Arrays.asList("Jon", "Ajeet", "Steve", "Ajeet", "Jon", "Ajeet");
		Map<String, Long> map = names.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(map);

		// Prog-2 : Stream Collectors example of fetching data as List
		List<Student> studentlist = new ArrayList<Student>();
		// Adding Students
		studentlist.add(new Student(11, "Jon", 22));
		studentlist.add(new Student(22, "Steve", 18));
		studentlist.add(new Student(33, "Lucy", 22));
		studentlist.add(new Student(44, "Sansa", 23));
		studentlist.add(new Student(55, "Maggie", 18));
		// Fetching student names as List
		List<String> names2 = studentlist.stream().map(n -> n.name).collect(Collectors.toList());
		System.out.println(names2);

		// Prog-3 : Collecting Data as Set
		List<Student> studentlist2 = new ArrayList<Student>();
		// Adding Students
		studentlist2.add(new Student(11, "Jon", 22));
		studentlist2.add(new Student(22, "Steve", 18));
		studentlist2.add(new Student(33, "Lucy", 22));
		studentlist2.add(new Student(44, "Sansa", 23));
		studentlist2.add(new Student(55, "Maggie", 18));
		// Fetching student data as a Set
		Set<Student> studentsSet = studentlist2.stream().filter(n -> n.id > 22).collect(Collectors.toSet());
		// Iterating Set
		for (Student stu : studentsSet) {
			System.out.println(stu.id + " " + stu.name + " " + stu.age);
		}

		// Prog-4 : Getting the average age of students using averagingInt() method
		List<Student> studentlist3 = new ArrayList<Student>();
		// Adding Students
		studentlist3.add(new Student(11, "Jon", 22));
		studentlist3.add(new Student(22, "Steve", 18));
		studentlist3.add(new Student(33, "Lucy", 22));
		studentlist3.add(new Student(44, "Sansa", 23));
		studentlist3.add(new Student(55, "Maggie", 18));
		// Getting the average Age
		Double avgAge = studentlist3.stream().collect(Collectors.averagingInt(s -> s.age));
		System.out.println("Average Age of Students is: " + avgAge);

		// ####################################
		// Feature - StringJoinner Class of JDK8
		// ####################################
		// Prog-1 : Joining strings by specifying delimiter
		// Passing Hyphen(-) as delimiter
		StringJoiner mystring = new StringJoiner("-");
		// Joining multiple strings by using add() method
		mystring.add("Logan");
		mystring.add("Magneto");
		mystring.add("Rogue");
		mystring.add("Storm");
		// Displaying the output String
		System.out.println(mystring);

		// Prog-2 : Adding prefix and suffix to the output String
		StringJoiner mystring2 = new StringJoiner(",", "(", ")");
		// Joining multiple strings by using add() method
		mystring2.add("Negan");
		mystring2.add("Rick");
		mystring2.add("Maggie");
		mystring2.add("Daryl");
		// Displaying the output String
		System.out.println(mystring2);

		// Prog-3 : Merging two StringJoiner objects
		/*
		 * Passing comma(,) as delimiter and opening bracket "(" as prefix and closing
		 * bracket ")" as suffix
		 */
		StringJoiner mystring3 = new StringJoiner(",", "(", ")");

		mystring3.add("Negan");
		mystring3.add("Rick");
		mystring3.add("Maggie");
		mystring3.add("Daryl");

		System.out.println("First String: " + mystring3);

		/*
		 * Passing hyphen(-) as delimiter and string "pre" as prefix and string "suff"
		 * as suffix
		 */
		StringJoiner myanotherstring = new StringJoiner("-", "pre", "suff");

		myanotherstring.add("Sansa");
		myanotherstring.add("Imp");
		myanotherstring.add("Jon");
		myanotherstring.add("Ned");

		System.out.println("Second String: " + myanotherstring);

		/*
		 * Merging both the strings The important point to note here is that the output
		 * string will be having the delimiter prefix and suffix of the first string
		 * (the string which is calling the merge method of StringJoiner)
		 */
		StringJoiner mergedString = mystring3.merge(myanotherstring);
		System.out.println(mergedString);

		// Prog-4 : setEmptyValue(), length() and toString() methods
		// Comma(,) as delimiter
		StringJoiner mystring4 = new StringJoiner(",");

		/*
		 * Using setEmptyValue() method, we can set the default value of a StringJoiner
		 * instance, so if the StringJoiner is empty and we print the value of it, this
		 * default value will be displayed
		 */
		mystring4.setEmptyValue("This is a default String");

		/*
		 * We have not added any string to StringJoiner yet so this should display the
		 * default value of StringJoiner
		 */
		System.out.println("Default String: " + mystring4);

		// Adding strings to StringJoiner
		mystring4.add("Apple");
		mystring4.add("Banana");
		mystring4.add("Orange");
		mystring4.add("Kiwi");
		mystring4.add("Grapes");
		System.out.println(mystring4);

		/*
		 * The length() method of StringJoiner class returns the length of the string
		 * (the number of characters in the StringJoiner instance)
		 */
		int length = mystring4.length();
		System.out.println("Length of the StringJoiner: " + length);

		/*
		 * The toString() method is used for converting a StringJoiner instance to a
		 * String.
		 */
		String s = mystring4.toString();
		System.out.println(s);

		// ######################################
		// Feature - Using Optional Class of JDK8
		// ######################################
		// Prog-1 : Problem
		String[] str = new String[10];
		// Getting the substring
		// String str2 = str[9].substring(2, 5); // RE : NPE
		// Displaying substring
		// System.out.print(str2);

		// Prog-2: soln using Optional
		String[] strArr = new String[10];
		Optional<String> isNull = Optional.ofNullable(strArr[9]);
		if (isNull.isPresent()) {
			// Getting the substring
			String ss = str[9].substring(2, 5);
			// Displaying substring
			System.out.print("Substring is: " + ss);
		} else {
			System.out.println("Cannot get the substring from an empty string");
		}

		strArr[9] = "AgraIsCool";
		Optional<String> isNull2 = Optional.ofNullable(str[9]);
		if (isNull2.isPresent()) {
			// Getting the substring
			String ss = str[9].substring(2, 5);
			// Displaying substring
			System.out.print("Substring is: " + ss);
		} else {
			System.out.println("Cannot get the substring from an empty string");
		}

		// Prog-3: Optional isPresent() vs ifPresent() methods
		// Creating Optional object from a String
		Optional<String> GOT = Optional.of("Game of Thrones");
		// Optional.empty() creates an empty Optional object
		Optional<String> nothing = Optional.empty();
		/*
		 * isPresent() method: Checks whether the given Optional Object is empty or not.
		 */
		if (GOT.isPresent()) {
			System.out.println("Watching Game of Thrones");
		} else {
			System.out.println("I am getting Bored");
		}
		/*
		 * ifPresent() method: It executes only if the given Optional object is
		 * non-empty.
		 */
		// This will print as the GOT is non-empty
		GOT.ifPresent(s4 -> System.out.println("Watching GOT is fun!"));
		// This will not print as the nothing is empty
		nothing.ifPresent(s4 -> System.out.println("I prefer getting bored"));

		// Prog-4 : Optional orElse() and orElseGet() methods
		// Creating Optional object from a String
		Optional<String> GOTIT = Optional.of("Game of Thrones");
		// Optional.empty() creates an empty Optional object
		Optional<String> nothingg = Optional.empty();

		// orElse() method
		System.out.println(GOTIT.orElse("Default Value"));
		System.out.println(nothingg.orElse("Default Value"));

		// orElseGet() method
		System.out.println(GOTIT.orElseGet(() -> "Default Value"));
		System.out.println(nothingg.orElseGet(() -> "Default Value"));

		// Prog-5 Optional.map and Optional.flatMap
		// Creating Optional object from a String
		Optional<String> GOT2 = Optional.of("Game of Thrones");
		// Optional.empty() creates an empty Optional object
		Optional<String> nothing2 = Optional.empty();
		System.out.println(GOT2.map(String::toLowerCase));
		System.out.println(nothing2.map(String::toLowerCase));

		Optional<Optional<String>> anotherOptional = Optional.of(Optional.of("BreakingBad"));
		System.out.println("Value of Optional object" + anotherOptional);
		System.out.println("Optional.map: " + anotherOptional.map(gender -> gender.map(String::toUpperCase)));
		// Optional<Optional<String>> -> flatMap -> Optional<String>
		System.out.println("Optional.flatMap: " + anotherOptional.flatMap(gender -> gender.map(String::toUpperCase)));

		// Prog-6 : Optional with filter
		// Creating Optional object from a String
		Optional<String> GOT6 = Optional.of("Game of Thrones");
		/*
		 * Filter returns an empty Optional instance if the output doesn't contain any
		 * value, else it returns the Optional object of the given value.
		 */
		System.out.println(GOT6.filter(str6 -> str6.equals("GAME OF THRONES")));
		System.out.println(GOT6.filter(str7 -> str7.equalsIgnoreCase("GAME OF THRONES")));

		// ##################################
		// Feature - Arrays Class Parallel sort
		// ###################################
		// Example 1
		int numbers[] = { 22, 89, 1, 32, 19, 5 };
		// Parallel Sort method for sorting int array
		Arrays.parallelSort(numbers);
		// converting the array to stream and displaying using forEach
		Arrays.stream(numbers).forEach(n -> System.out.print(n + " "));

		// Example 2: Parallel Sort by specifying the start and end index
		int numbers2[] = { 22, 89, 1, 32, 19, 5 };
		/*
		 * Specifying the start and end index. The start index is 1 here and the end
		 * index is 5. which means the the elements starting from index 1 till index 5
		 * would be sorted.
		 */
		Arrays.parallelSort(numbers2, 1, 5);
		// converting the array to stream and displaying using forEach
		Arrays.stream(numbers2).forEach(n -> System.out.print(n + " "));

		// #####################################################
		// Feature - Using Stream And Stream Filter class in JDK8
		// ####################################################
		// Prog-1 : without using Stream
		List<String> namesList = new ArrayList<String>();
		namesList.add("Ajeet");
		namesList.add("Negan");
		namesList.add("Aditya");
		namesList.add("Steve");
		int count = 0;
		for (String name : namesList) {
			if (name.length() < 6)
				count++;
		}
		System.out.println("There are " + count + " strings with length less than 6");

		// prog-2 :
		long count2 = namesList.stream().filter(name -> name.length() < 6).count();
		System.out.println("There are " + count2 + " strings with length less than 6");

		// Prog-3
		Stream.iterate(1, x -> x + 1).filter(number -> number % 3 == 0).limit(6).forEach(System.out::println);

		// Prog-4 : Concatenating two streams
		// list 1
		List<String> alphabets = Arrays.asList("A", "B", "C");
		// list 2
		List<String> names3 = Arrays.asList("Sansa", "Jon", "Arya");

		// creating two streams from the two lists and concatenating them into one
		Stream<String> opstream = Stream.concat(alphabets.stream(), names3.stream());

		// displaying the elements of the concatenated stream
		opstream.forEach(a -> System.out.print(a + " "));

		// Prog-5 : Using Filter()
		List<String> names5 = Arrays.asList("Melisandre", "Sansa", "Jon", "Daenerys", "Joffery");
		// Creating the stream of all names
		Stream<String> allNames = names5.stream();
		// Creating another stream by filtering long names using filter()
		Stream<String> longNames = allNames.filter(z -> z.length() > 6);
		// displaying the long names
		longNames.forEach(z -> System.out.print(str + " "));

		// Prog-6 : using Stream filter() and collect()
		List<String> names6 = Arrays.asList("Melisandre", "Sansa", "Jon", "Daenerys", "Joffery");
		List<String> longnames = names6.stream() // converting the list to stream
				.filter(p -> p.length() > 6) // filter the stream to create a new stream
				.collect(Collectors.toList()); // collect the final stream and convert it to a List
		longnames.forEach(System.out::println);

		// Prog-7 : Stream filter() with multiple conditions
		List<String> names7 = Arrays.asList("Melisandre", "Sansa", "Jon", "Daenerys", "Joffery");
		List<String> longnames7 = names7.stream().filter(q -> q.length() > 6 && q.length() < 8) // Multiple conditions
				.collect(Collectors.toList());
		longnames7.forEach(System.out::println);

		// Prog-8 : Stream filter() and map() method in Java
		List<Integer> num = Arrays.asList(1, 2, 3, 4, 5, 6);
		List<Integer> squares = num.stream().map(n -> n * n).collect(Collectors.toList());
		System.out.println(squares);

		// #######################################################
		// Feature : forEach() method in Iterable interface of JDK8
		// #####################################################
		// Prog-1 Before
		// creating sample Collection
		List<Integer> myList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++)
			myList.add(i);
		// traversing using Iterator
		Iterator<Integer> it = myList.iterator();
		while (it.hasNext()) {
			Integer i = it.next();
			System.out.println("Iterator Value::" + i);
		}

		// Prog-2 : After
		myList.forEach(new Consumer<Integer>() {
			@Override
			public void accept(Integer t) {
				System.out.println("forEach anonymous class Value::" + t);
			}

		});

		// traversing with our custom Consumer interface implementation.
		MyConsumer action = new MyConsumer();
		myList.forEach(action);

	}

}

// Refer : https://beginnersbook.com/2017/10/java-8-features-with-examples/
