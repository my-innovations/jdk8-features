package method_ref;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

import model.Person;
import model.PersonRepository;

//ref to static method
//ref to instance method
//ref to constructor

//@FunctionalInterface is optional
@FunctionalInterface
interface MyFunctionalInterface_01 {
	public void display();
}

@FunctionalInterface
interface MyFunctionalInterface_02 {
	public Hello display(String s);
}

class Mul {
	//static method
	public static int multiply(int a, int b) {
		return a * b;
	}
}

//class with both instance and static methods.
class Hello {

	//constructor
	public Hello() {
	}

	//constructor
	public Hello(String s) {
		System.out.println(s);
	}

	//instance method
	public String hello(String s) {
		return "hello:" + s;
	}

	//static method
	public static int compare(Integer i1, Integer i2) {
		return Integer.compare(i1, i2); // -1
		// return i1.compareTo(i2); //-1
	}

}

//class with static methods.
class App02_Method_References_03_static_method {

	public static int compare(Integer x, Integer y) {
		return Integer.compare(x, y);
	}

	public static int matchStringLength(String str1, String str2) {
		return str1.length() - str2.length();
	}
}

public class MethodReferencesDemo {
	
	private static Function<String,String> function01 = str -> str.toUpperCase();
	private static Function<String,String> function02 = String :: toUpperCase;
	private static Predicate<Person> predicate01 = per -> per.getHeight() >= 100;
	private static Predicate<Person> predicate02 = MethodReferencesDemo :: heightCheckWithPredicate;
	private static BiPredicate<Person,Integer> biPredicate01 = MethodReferencesDemo :: heightCheckWithParamWithBiPredicate;
	
	// instance method.
	public void getMessage() {
		System.out.println("Instance Method");
	}

	// instance method.
	public void printByStringLength() {
		String names[] = { "abcde", "abc", "ab", "abcd", "a" };
		Arrays.sort(names, App02_Method_References_03_static_method::matchStringLength);
		System.out.println(Arrays.toString(names));
	}
	
	// static method.
	private static boolean heightCheckWithPredicate(Person p) {
		return p.getHeight() >= 100;
	}
	
	// static method.
	private static boolean heightCheckWithParamWithBiPredicate(Person p,Integer height) {
		return p.getHeight() >= height;
	}
	
	public static void main(String[] args) {

		MethodReferencesDemo MethodReferencesDemoObj = new MethodReferencesDemo();
		MethodReferencesDemoObj.printByStringLength();
		
		// Ex -  custom functional interface's single abstract method referencing to an instance method "myMethod" of Method_References_demo class.
		MyFunctionalInterface_01 myFunctionalInterface_01_obj = MethodReferencesDemoObj::getMessage;
		myFunctionalInterface_01_obj.display();
		
		// EX- custom functional interface Method references to a constructor of  Hello  class.
		MyFunctionalInterface_02 myFunctionalInterface_02_obj = Hello::new;
		myFunctionalInterface_02_obj.display("hi");
		
		//Ex -  predefined functional interface method referencing to an instance method "hello" of  Hello class.
		Hello helloObject = new Hello();
		Function<String,String> function1 = helloObject::hello;
		String res2 = function1.apply("punya");
		System.out.println(res2);
		
		// EX -  Method references to a instance method of an arbitrary object.
		String[] arr = { "AAA", "ZZZ", "ccc", "DDD" };
		Arrays.sort(arr, String::compareToIgnoreCase);
		for (String s : arr) {
			System.out.print(s + " ");
		}

		// EX -  predefined functional interface method referencing to an static method "multiply" of Mul class.
		BiFunction<Integer, Integer, Integer> bf = Mul::multiply;
		int res = bf.apply(11, 4);
		System.out.println("Mul Res = "+res);

		//EX-
		System.out.println(Hello.compare(10, 20));
		
		//EX - predefined functional interface's single abstract method references to static method of Hello class .
		Comparator<Integer> comp = Hello::compare;
		System.out.println(comp.compare(11, 22));
		
		//EX - predefined functional interface method points to static method of the class.
		Comparator<Integer> comparator = App02_Method_References_03_static_method :: compare;
		System.out.println(comparator.compare(10, 20));

		//EX - predefined functional interface's single abstract method references to instance method of String class.
		Function<String,String> fun1 = name -> name.toUpperCase();
		System.out.println(fun1.apply("punya"));
		System.out.println(function01.apply("punya"));
		
		//EX - predefined functional interface method references to static method.
		Function<String,String> fun2 = String::toUpperCase;
		System.out.println(fun2.apply("java"));
		System.out.println(function02.apply("punya"));
		
		predicate01.test(new Person(1,"punya", "nayak", 1000D, "male", 30,200,Arrays.asList("Music", "cricket")));
		System.out.println(predicate01.test(PersonRepository.getPerson()));
		
		//EX-  predefined functional interface's single abstract method points to static method of Method_References_demo class.
		predicate02.test(new Person(1,"punya", "nayak", 1000D, "male",30, 200,Arrays.asList("Music", "cricket")));
		System.out.println(predicate02.test(PersonRepository.getPerson()));
		
		//EX - predefined functional interface's single abstract method points to static method of Method_References_demo class.
		biPredicate01.test(new Person(1,"punya", "nayak", 1000D, "male", 35,200,Arrays.asList("Music", "cricket")), 100);
		System.out.println(biPredicate01.test(PersonRepository.getPerson(),125));

		System.out.println(App02_Method_References_03_static_method.compare(10, 20));
	
	}
}
