package functional_interface;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryBinaryDemp {

	static UnaryOperator<String> uo1 = name -> name.toUpperCase();
	static UnaryOperator<Integer> uo2 = num -> num + 10;

	static Comparator<Integer> comp1 = (a, b) -> a.compareTo(b);

	public static void main(String[] args) {

		System.out.println(uo1.apply("punya"));
		System.out.println(uo2.apply(11));

		// way-1
		BinaryOperator<Integer> bo1 = BinaryOperator.maxBy((a, b) -> (a > b) ? 1 : (a == b) ? 0 : -1);
		System.out.println(bo1.apply(11, 15));

		// way-2
		BinaryOperator<Integer> bo2 = BinaryOperator.maxBy(comp1);
		System.out.println(bo2.apply(15, 50));

	}

}
