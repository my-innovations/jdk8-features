package optional;

import java.util.Optional;

public class App08_Optional_class_03 {
	public static void main(String args[]) {

		final App08_Optional_class_03 java8Tester = new App08_Optional_class_03();
		final Integer value1 = null;
		final Integer value2 = new Integer(10);

		// Optional.ofNullable - allows passed parameter to be null.
		final Optional<Integer> a = Optional.ofNullable(value2);

		// Optional.of - throws NullPointerException if passed parameter is null
		final Optional<Integer> b = Optional.of(value1);
		System.out.println(java8Tester.sum(a, b));
	}

	public Integer sum(Optional<Integer> a, Optional<Integer> b) {

		// Optional.isPresent - checks the value is present or not

		System.out.println("First parameter is present: " + a.isPresent());
		System.out.println("Second parameter is present: " + b.isPresent());

		// Optional.orElse - returns the value if present otherwise returns
		// the default value passed.
		final Integer value1 = a.orElse(new Integer(0));

		// Optional.get - gets the value, value should be present
		final Integer value2 = b.get();
		return value1 + value2;
	}
}