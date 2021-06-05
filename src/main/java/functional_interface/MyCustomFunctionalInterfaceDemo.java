package functional_interface;

public class MyCustomFunctionalInterfaceDemo {

	public static void main(String[] args) {
		MyCustomFunctionalInterface obj1 = (a,b) -> a+b;
		int res = obj1.add(1, 2);
		System.out.println(res);

	}

}


@FunctionalInterface
interface MyCustomFunctionalInterface {

	public int add(int x, int y); // SAM

	// default method
	default String hello(String name) {
		return "hello" + name;
	}

	// default method
	default String hi() {
		return "hi";
	}

	// static method
	static boolean isTrue() {
		return true;
	}
}

