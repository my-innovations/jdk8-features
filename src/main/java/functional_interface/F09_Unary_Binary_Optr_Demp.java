package functional_interface;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class F09_Unary_Binary_Optr_Demp {

	static UnaryOperator<String> toUppercaseUnaryOperator = name -> name.toUpperCase();
	static UnaryOperator<Integer> addWith10UnaryOperator = num -> num + 10;

	// using with comparator with BinaryOperator.
	static Comparator<Integer> comparator1 = ((a, b) -> (a > b) ? 1 : (a == b) ? 0 : -1);
	static BinaryOperator<Integer> bo1 = BinaryOperator.maxBy(comparator1);

	// using with comparator.
	static Comparator<Integer> comparator2 = (a, b) -> a.compareTo(b);
	static BinaryOperator<Integer> bo2 = BinaryOperator.minBy(comparator2);

	public static void main(String[] args) {

		System.out.println(toUppercaseUnaryOperator.apply("punya")); //PUNYA
		System.out.println(addWith10UnaryOperator.apply(11)); //21

		// way-1
		System.out.println(bo1.apply(11, 15)); //15

		// way-2 using with comparator.
		System.out.println(bo2.apply(15, 5)); //5

	}
}
