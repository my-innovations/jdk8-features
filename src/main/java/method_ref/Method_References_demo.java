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
	public static int multiply(int a, int b) {
		return a * b;
	}
}

class Hello {
	
	public Hello() {}
	
	public Hello(String s) {
		System.out.println(s);
	}
	
	public String hello(String s) {
		return "hello:"+s;
	}
	
	public static int compare(Integer i1,Integer i2) {
		return Integer.compare(i1,i2); //-1
		//return i1.compareTo(i2); //-1
	}
	
}

class App02_Method_References_03_static_method {
	
	public static int compare(Integer x,Integer y) {
		return Integer.compare(x, y);
	}

	public static int matchStringLength(String str1, String str2) {
		return str1.length() - str2.length();
	}
}

public class Method_References_demo {
	
	private static Function<String,String> fun1 = str -> str.toUpperCase();
	private static Function<String,String> fun2 = String :: toUpperCase;
	
	private static Predicate<Person> p1 = per -> per.getHeight() >= 100;
	private static Predicate<Person> p2 = Method_References_demo :: heightCheck2;
	private static BiPredicate<Person,Integer> p3 = Method_References_demo :: heightCheckWithParam2;
	
	
	private static boolean heightCheck2(Person p) {
		return p.getHeight() >= 100;
	}
	
	private static boolean heightCheckWithParam2(Person p,Integer height2) {
		return p.getHeight() >= height2;
	}

	// instance method.
	public void myMethod() {
		System.out.println("Instance Method");
	}

	public void printByStringLength() {
		String names[] = { "abcde", "abc", "ab", "abcd", "a" };
		Arrays.sort(names, App02_Method_References_03_static_method::matchStringLength);
		System.out.println(Arrays.toString(names));
	}

	public static void main(String[] args) {

		Method_References_demo obj = new Method_References_demo();
		
		obj.printByStringLength();
		
		System.out.println(App02_Method_References_03_static_method.compare(10, 20));
		
		Comparator<Integer> com = App02_Method_References_03_static_method :: compare;
		System.out.println(com.compare(10, 20));
		
		System.out.println(fun1.apply("punya"));
		System.out.println(fun2.apply("punya"));
		
		p1.test(new Person("punya", "nayak", 1000D, "male", 200,Arrays.asList("Music", "cricket")));
		p2.test(new Person("punya", "nayak", 1000D, "male", 200,Arrays.asList("Music", "cricket")));
		p3.test(new Person("punya", "nayak", 1000D, "male", 200,Arrays.asList("Music", "cricket")), 100);
		

		// app-01
		// method referencing to an instance method of a class.
		MyFunctionalInterface_01 ref = obj::myMethod;
		ref.display();
		
		Hello h = new Hello();
		Function<String,String> f01 = h::hello;
		String res2 = f01.apply("punya");
		System.out.println(res2);

		// app-02
		// method referencing to a static method of a class
		BiFunction<Integer, Integer, Integer> bf = Mul::multiply;
		int res = bf.apply(11, 4);
		System.out.println("Mul Res = "+res);

		// app-03
		// Method references to a instance method of an arbitrary object.
		String[] arr = { "AAA", "ZZZ", "ccc", "DDD" };
		Arrays.sort(arr, String::compareToIgnoreCase);
		for (String s : arr) {
			System.out.print(s + " ");
		}

		// app-04
		// Method references to a constructor.
		MyFunctionalInterface_02 mf = Hello::new;
		mf.display("hi");
		
		//app-05
		System.out.println(Hello.compare(10, 20));
		
		//app-06
		Comparator<Integer> c = Hello::compare;
		System.out.println(c.compare(11, 22));
		
		//app-07
		Function<String,String> f1 = name -> name.toUpperCase();
		Function<String,String> f2 = String::toUpperCase;
		
		System.out.println(f1.apply("punya"));
		System.out.println(f2.apply("java"));
		
		//app-08 , with using lambda
		Predicate<Person> p1 = per -> per.getHeight() >= 100;
		System.out.println(p1.test(PersonRepository.getPerson()));
		
		//app-09 , using method references.
		Predicate<Person> p2 = Method_References_demo::heightCheck;
		System.out.println(p2.test(PersonRepository.getPerson()));
		
		BiPredicate<Person,Integer> p02 = Method_References_demo::heightCheckWithParam;
		System.out.println(p02.test(PersonRepository.getPerson(),125));
		
	}
	
	static boolean heightCheck(Person p) {
		return p.getHeight() >= 100;
	}
	
	static boolean heightCheckWithParam(Person p,Integer height) {
		return p.getHeight() >= height;
	}
}
