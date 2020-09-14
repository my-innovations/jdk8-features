package lambda_expression;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingWithComparatorAndLambda {

	public static void main(String[] args) {

		final List<String> list = new ArrayList<String>();
		list.add("abca");
		list.add("pqrnnn");
		list.add("mno");
		list.add("defuuuuu");

		// Java 7
		Collections.sort(list, (s1, s2) -> s1.length() - s2.length());
		System.out.println("java7==>" + list);

		// Java 8
		Collections.sort(list, (s1, s2) -> s1.length() - s2.length());
		System.out.println("java8==>" + list);

		// or

		list.sort(Comparator.comparingInt(String::length));
		System.out.println("java8==>" + list);

	}

}
