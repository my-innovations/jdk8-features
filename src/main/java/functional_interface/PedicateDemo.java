package functional_interface;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import model.Person;
import model.PersonRepository;

public class PedicateDemo {

	static Predicate<Person> p1 = per -> per.getHeight() >= 100;
	static Predicate<Person> p2 = per -> per.getGender().equals("male");
	static Predicate<Person> p3 = per -> per.getGender().equals("male") && per.getGender().equals("male");

	static BiConsumer<String, List<String>> hobbiesConsumer = (name, hobbies) -> System.out.println(name + "-" + hobbies);
	static Consumer<Person> personConsumer = per -> {
		if (p1.and(p2).test(per)) {
			hobbiesConsumer.accept(per.getFirstName(), per.getHobbies());
		}
	};

	public static void main(String[] args) {

		Predicate<Integer> predicate1 = a -> a <= 50;
		Predicate<Integer> predicate2 = a -> a >= 100;
		Predicate<Integer> predicate3 = a -> a == 0;

		boolean res = predicate1.test(55);
		System.out.println(res);

		// using and
		boolean res1 = predicate1.and(predicate2).and(predicate3).test(25);
		System.out.println(res1);

		// using and , or
		// executes from left to right
		boolean res2 = predicate1.and(predicate2).or(predicate3).test(25);
		System.out.println(res2);

		// using and , or, negate
		// executes from left to right
		boolean res3 = predicate1.and(predicate2).or(predicate3).negate().test(25);
		System.out.println(res3);
		
		//using person repository
		PersonRepository.getAllPesons().stream().filter(p1).collect(Collectors.toList()).forEach(person -> {
			if (p1.test(person))
				// if(p1.and(p2).test(person))
				// if(p1.or(p2).test(person))
				System.out.println(person);
		});

		// Ex-
		PersonRepository.getAllPesons().stream().filter(p1).collect(Collectors.toList()).forEach(personConsumer);

	}
}
