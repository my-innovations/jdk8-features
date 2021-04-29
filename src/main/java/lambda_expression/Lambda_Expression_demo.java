package lambda_expression;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;

import model.Person;

//Accessing Local and Class Variables in Lambda Expression 
//Java Lambda Expression Example: Creating Thread

//In Java lambda expression, if there is only one statement, you may or may not
//use return keyword. You must use return
//keyword when lambda expression contains multiple statements.

@FunctionalInterface
interface Circle {
	double get(double radius);
}

//functional interface
interface Sayable {
	public String say();
}

//Java Lambda Expression with no parameter
@FunctionalInterface
interface MyFunctionalInterface01 {
	// A method with no parameter
	public void sayHello();
}

/* This is lambdaExample */
interface interface1 {
	public String say(String name);
}

@FunctionalInterface
interface MyFunctionalInterface02 {
	// A method with single parameter
	public int incrementByFive(int a);
	// public int decrementByFive(int a); //CE
}

/* This is lambdaExample */
interface Addable1 {
	int add(int a, int b);
}

/* This is lambdaExample */
interface Addable {
	int add(int a, int b);
}

interface MathOperation_101 {
	int operation(int a, int b);
}

@FunctionalInterface
interface MyFunctionalInterface6 {
	public int add(int a, int b);
}

interface StringConcat2 {
	public String sconcat(String a, String b);
}

@FunctionalInterface
interface MyFunctionalInterface1 {
	// only one abstract method is allowed.
	String hello(String name);
}

interface GreetingService {
	void sayMessage(String message);
}

public class Lambda_Expression_demo {
	
	final static String salutation = "Hello! ";

	// instance variable
	public static String wildPerson2 = "Lion";
	
	final Runnable r1 = () -> out.println(this);
	Runnable r2 = () -> out.println(toString());

	public double circleOperation(double radius, Circle c) {
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
	
	private int operate(int a, int b, MathOperation_101 mathOperation) {
		return mathOperation.operation(a, b);
	}

	public static void main(String[] arg) {
		
	//// ########################################################################
		// app-01
		List<String> list = new ArrayList<String>();
		list.add("Rick");
		list.add("Negan");
		list.add("Daryl");
		list.add("Glenn");
		list.add("Carl");
		list.forEach((item) -> {System.out.println(item);});

		//// ########################################################################
		// app-02
		final List<String> list2 = new ArrayList<String>();
		list2.add("abc");
		list2.add("pqr");

		// Java 7
		for (final String s : list2) {
			System.out.print(s + " ");
		}

		// Java 8
		list2.forEach(System.out::println);
		
		//// ########################################################################
		// local var
		String domesticPerson2 = "Dog";

		new Thread(() -> {
			System.out.println("Class Level: " + wildPerson2);
			System.out.println("Method Level: " + domesticPerson2);
		}).start();

		// ########################################################################
		new Thread(new Runnable() {
			@Override
			public void run() {
				// System.out.println("Class Level: " + this.wildPerson2);
				System.out.println("Method Level: " + domesticPerson2);
			}
		}).start();

		// ########################################################################
		Runnable java8Runner = () -> {
			System.out.println("I am running");
		};
		new Thread(java8Runner).start();
		// ########################################################################
		// Lambda with functional interface demo
		Circle circleArea = (r) -> Math.PI * r * r;
		Circle circleCircumference = (r) -> 2 * Math.PI * r;

		Lambda_Expression_demo reference = new Lambda_Expression_demo();

		double area = reference.circleOperation(10, circleArea);
		System.out.println("Area=" + area);

		double circumference = reference.circleOperation(5, circleCircumference);
		System.out.println("circumfarence=" + circumference);

		// ########################################################################

		Callable<String>[] animals = new Callable[] { () -> "Lion", () -> "Crocodile" };
		// System.out.println(animals);
		try {
			System.out.println(animals[0].call());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// ########################################################################
		// Before Soorting
		Person[] personArr = { new Person("Lion"), new Person("Crocodile"), new Person("Tiger"),new Person("Elephant") };
		System.out.println("Before Sort: " + Arrays.toString(personArr));

		// After sorting
		Arrays.sort(personArr);
		System.out.println("After Sort: " + Arrays.toString(personArr));

		// ########################################################################
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

		// ########################################################################
		final Sayable s = () -> {
			return "I have nothing to say.";
		};
		System.out.println(s.say());

		// ########################################################################
		// lambda expression
		//overriding the method of functional interface using lambda(without method name).
		MyFunctionalInterface01 msg = () -> {
			System.out.println("Hello");
		};
		
		msg.sayHello();

		// ########################################################################
		// Lambda expression with single parameter.
		final interface1 s1 = (name) -> {
			return "Welcome " + name;
		};
		System.out.println(s1.say("Abi"));

		// without function parentheses
		final interface1 s2 = name -> {
			return "Welcome " + name;
		};
		System.out.println(s2.say("Abi"));

		// ########################################################################
		// lambda expression with single parameter num
		MyFunctionalInterface02 f = (num) -> num + 5;
		System.out.println(f.incrementByFive(22));

		// ########################################################################
		// Multiple parameters in lambda expression
		final Addable1 ad1 = (a, b) -> (a + b); // data type s optional
		System.out.println(ad1.add(10, 20));

		// ########################################################################
		// Lambda expression without return keyword.
		final Addable ad2 = (a, b) -> (a + b);
		System.out.println(ad2.add(10, 20));

		// Lambda expression with return keyword.
		final Addable ad3 = (int a, int b) -> {
			return (a + b);
		};
		System.out.println(ad3.add(100, 200));

		// ########################################################################
		// with type declaration
		final MathOperation_101 addition = (int a, int b) -> a + b;

		// with out type declaration
		final MathOperation_101 subtraction = (a, b) -> a - b;

		// with return statement along with curly braces
		final MathOperation_101 multiplication = (int a, int b) -> {
			return a * b;
		};

		// without return statement and without curly braces
		final MathOperation_101 division = (int a, int b) -> a / b;

		System.out.println("10 + 5 = " + addition.operation(10, 5));
		System.out.println("10 - 5 = " + subtraction.operation(10, 5));
		System.out.println("10 x 5 = " + multiplication.operation(10, 5));
		System.out.println("10 / 5 = " + division.operation(10, 5));

		// ########################################################################
		// app-01
		// lambda expression with multiple arguments
		StringConcat2 s3 = (str1, str2) -> str1 + str2;

		// System.out.println(s);
		System.out.println("Result: " + s3.sconcat("Hello ", "World"));

		// app-02 - Using user defined functional interfcae
		MyFunctionalInterface6 ref = (a, b) -> a + b;
		System.out.println(ref.add(2, 5));

		// app-03 - Using predefined functional interfcae
		// IntBinaryOperator is a predefined functional interface.
		IntBinaryOperator sum = (a, b) -> a + b;
		System.out.println(sum.applyAsInt(3, 8));
		
		//########################################################################
		// using forEach
		String abc = String.join(" ", "Java", "8");
		System.out.println(abc);

		Arrays.asList("a", "b", "d").forEach(e -> System.out.println(e));

		Arrays.asList("a", "b", "d").forEach(e -> {
			System.out.print(e);
		});

		final String separator = ",";
		Arrays.asList("a", "b", "d").forEach((String e) -> System.out.print(e + separator));
		Arrays.asList("a", "b", "d").sort((e1, e2) -> e1.compareTo(e2));
		
		//#################################################################################
		
		MyFunctionalInterface1 obj1 = (String name) -> {
			return "Hello " + name + " Hi";
		};

		MyFunctionalInterface1 obj2 = (String name) -> {
			return "Hello " + name;
		};

		System.out.println(obj1.hello("Lipun"));
		System.out.println(obj2.hello("Punya"));
		
		
		//#################################################################################
		Lambda_Expression_demo tester = new Lambda_Expression_demo();

		// with type declaration
		MathOperation_101 add = (int a, int b) -> a + b;

		// with out type declaration
		MathOperation_101 subtract = (a, b) -> a - b;

		// with return statement along with curly braces
		MathOperation_101 mul = (int a, int b) -> {
			return a * b;
		};

		// without return statement and without curly braces
		MathOperation_101 div = (int a, int b) -> a / b;

		System.out.println("10 + 5 = " + tester.operate(10, 5, add));
		System.out.println("10 - 5 = " + tester.operate(10, 5, subtract));
		System.out.println("10 x 5 = " + tester.operate(10, 5, mul));
		System.out.println("10 / 5 = " + tester.operate(10, 5, div));

		// without parenthesis
		GreetingService greetService1 = message -> System.out.println("Hello " + message);

		// with parenthesis
		GreetingService greetService2 = (message) -> System.out.println("Hello " + message);

		GreetingService greetService3 = message -> System.out.println(salutation + message);

		greetService1.sayMessage("Mahesh");
		greetService2.sayMessage("Suresh");
		greetService3.sayMessage("Mahesh");
		
		//###############################################################
		new Lambda_Expression_demo().r1.run();
		new Lambda_Expression_demo().r2.run();

	}
	
	@Override
	public String toString() {
		return "Hello, world!";
	}
}
