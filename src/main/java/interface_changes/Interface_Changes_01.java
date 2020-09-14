package interface_changes;

@FunctionalInterface
interface MyInterface02 {

	void exsistingMethod(String str);

	default void newMethod() {
		System.out.println("Newly added default method");
	}

	static void anotherNewMethod() {
		System.out.println("Newly added static method");
	}

	static void anotherNewMethod2() {
		System.out.println("Newly added static method2");
	}

}

public class Interface_Changes_01 implements MyInterface02 {

	@Override
	public void exsistingMethod(String str) {
		System.out.println(str);
	}

	public static void main(String[] args) {

		Interface_Changes_01 obj = new Interface_Changes_01();

		obj.exsistingMethod("Hello");

		// calling default method
		obj.newMethod();

		MyInterface02.anotherNewMethod();
		MyInterface02.anotherNewMethod2();

	}
}
