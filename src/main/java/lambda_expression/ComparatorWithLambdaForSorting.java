package lambda_expression;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorWithLambdaForSorting {

	public static void compareTwoIntBeforeJdk8() {

		Comparator<Integer> c1 = new Comparator<Integer>() {
			@Override
			public int compare(Integer num1, Integer num2) {
				return num1.compareTo(num2);
			}
		};
		System.out.println(c1.compare(10, 15)); //-1
	}

	public static void compareTwoIntInJdk8UsingLambda() {

		Comparator<Integer> c2 = (Integer num1, Integer num2) -> num1.compareTo(num2);
		System.out.println(c2.compare(30, 45)); // -1

		// OR, without using datatype
		Comparator<Integer> c3 = (x, y) -> x.compareTo(y);
		System.out.println(c3.compare(30, 45)); // -1
	}

	public static void sortingListOfStringUsingJdk8UsingLambda() {

		final List<String> nameslist = new ArrayList<String>();

		nameslist.add("punya");
		nameslist.add("Aswini");
		nameslist.add("omkar");
		nameslist.add("pankaj");

		Collections.sort(nameslist, (s1, s2) -> s1.length() - s2.length());
		System.out.println("java8 ==>" + nameslist); // [punya, omkar, Aswini, pankaj]

		Collections.sort(nameslist, (s1, s2) -> s2.length() - s1.length());
		System.out.println("java8 ==>" + nameslist); // [Aswini, pankaj, punya, omkar]
		// or
		nameslist.sort(Comparator.comparingInt(String::length));
		System.out.println("java8 ==>" + nameslist); // [punya, omkar, Aswini, pankaj]

		// using custom comparator for sorting
		Comparator<String> mycomp = new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				return str1.compareTo(str2);
			}
		};

		Collections.sort(nameslist, mycomp);
		System.out.println(nameslist); // [Aswini, omkar, pankaj, punya]

	}

	public static void main(String[] args) {
		compareTwoIntBeforeJdk8();
		compareTwoIntInJdk8UsingLambda();
		sortingListOfStringUsingJdk8UsingLambda();

	}
}
