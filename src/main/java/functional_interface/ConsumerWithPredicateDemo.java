package functional_interface;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

import model.Person;

public class ConsumerWithPredicateDemo {

	static Predicate<Person> p1 = per -> per.getHeight() >= 140;
	static Predicate<Person> p2 = per -> per.getGender().equals("male");
	static BiConsumer<String, List<String>> hobbiesConsumer = (firstname, hobbies) -> System.out
			.println(firstname + hobbies);
	static Consumer<Person> personConsumer = per -> {
		if (p1.and(p2).test(per)) {
			hobbiesConsumer.accept(per.getFirstName(), per.getHobbies());
		}
	};

	public static void main(String[] args) {
		List<Person> list = Arrays.asList(new Person("punya", "nayak", 1000D,"male", 200, Arrays.asList("cricket")));
		list.forEach(personConsumer);
	}

}
