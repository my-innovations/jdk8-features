package functional_interface;

public class MyCustomFunctionalInterfaceDemo {

	public static void main(String[] args) {
		MyCustomFunctionalInterface obj1 = (a,b) -> a+b;
		int res = obj1.add(1, 2);
		System.out.println(res);

	}

}
