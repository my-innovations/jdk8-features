package functional_interface;

@FunctionalInterface
public interface MyCustomFunctionalInterface {

	public int add(int x, int y); // SAM

	// default method
	default String hi() {
		return "hi";
	}

	// default method
	default String hello(String name) {
		return "hello" + name;
	}

	// static method
	static boolean isTrue() {
		return true;
	}
}
