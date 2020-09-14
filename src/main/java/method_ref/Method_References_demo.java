package method_ref;

import java.util.Arrays;
import java.util.function.BiFunction;

//@FunctionalInterface is optional
@FunctionalInterface
interface MyFunctionalInterface001 {
	void display();
}

@FunctionalInterface
interface MyFunctionalInterface002 {
	Hello2 display(String s);
}

class Mul {
	public static int multiply(int a, int b) {
		return a * b;
	}
}

class Hello2 {
	public Hello2(String s) {
		System.out.println(s);
	}
}

class App02_Method_References_03_static_method {

	public static int matchStringLength(String str1, String str2) {
		return str1.length() - str2.length();
	}
}

public class Method_References_demo {

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

		// app-01
		// method referencing to an instance method of a class.
		MyFunctionalInterface001 ref = obj::myMethod;
		ref.display();

		// app-02
		// method referencing to a static method of a class
		BiFunction<Integer, Integer, Integer> bf = Mul::multiply;
		int res = bf.apply(11, 4);
		System.out.println(res);

		// app-03
		String[] arr = { "AAA", "ZZZ", "ccc", "DDD" };
		// Method references to a instance method of an arbitary object.
		Arrays.sort(arr, String::compareToIgnoreCase);
		for (String s : arr) {
			System.out.print(s + " ");
		}

		// app-04
		// Method references to a constructor.
		MyFunctionalInterface002 ref2 = Hello2::new;
		ref2.display("hi");

		// app-05
		obj.printByStringLength();

	}

}
