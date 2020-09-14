package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Collections_sort_01 {

	public static void main(String[] args) {
		
		final List<String> namesList = new ArrayList<String>();
		namesList.add("punya");
		namesList.add("pankaj");
		namesList.add("Aswini");
		namesList.add("partha");

		// Java 7
		Collections.sort(namesList, (s1, s2) -> s1.length() - s2.length());
		System.out.println("java7==>" + namesList);

		// Java 8
		Collections.sort(namesList, (s1, s2) -> s1.length() - s2.length());
		System.out.println("java8==>" + namesList);

		// sorting the string based on length.
		namesList.sort(Comparator.comparingInt(String::length));
		System.out.println("java8==>" + namesList);
	
		//ex-02
		List<String> list = new ArrayList<String>();
		list.add("Mahesh ");
		list.add("Suresh ");
		list.add("Ramesh ");
		list.add("Naresh ");
		list.add("Kalpesh ");
		
		Collections_sort_01 tester = new Collections_sort_01();
		System.out.println("Sort using Java 7 syntax: ");
		tester.sortUsingJava7(list);
		System.out.println(list);

		System.out.println("Sort using Java 8 syntax: ");
		tester.sortUsingJava8(list);
		System.out.println(list);

	}

	// sort using java 7
	private void sortUsingJava7(List<String> names) {
		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
			}
		});
	}

	// sort using java 8
	private void sortUsingJava8(List<String> names) {
		Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
	}

}
