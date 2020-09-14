package comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import model.Person;

public class F6 {

	public static void main(String[] args) {

		final Person p1 = new Person();
		p1.firstName = "punya";
		p1.lastName = "nayak";

		final Person p2 = new Person();
		p2.firstName = "sandeep";
		p2.lastName = "Gupta";

		final List<Person> list = new ArrayList<Person>();
		list.add(p1);
		list.add(p2);

		// java7
		/*
		 * Collections.sort(list, (p1, p2) -> { final int n =
		 * p1.getLastName().compareTo(p2.getLastName()); if (n == 0) { return
		 * p1.getFirstName().compareTo(p2.getFirstName()); } return n; });
		 */

		// java8
		list.sort(Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName));
		list.forEach(System.out::println);

	}

}
