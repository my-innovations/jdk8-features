package functional_interface;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import model.Person;

public class BiFunctionDemo {

	static BiFunction<String, String, String> bf1 = (a, b) -> (a + " " + b);
	
	//bifunction with predicate
	static Predicate<Person> predicate1 = person -> person.getHeight() >= 100;
	static Predicate<Person> predicate2 = person -> person.getGender().contentEquals("male");
	static BiFunction<List<Person>, Predicate<Person>, Map<String, Double>> bf2 = (persons, predicate) -> {
		Map<String, Double> map = new HashMap<>();
		persons.forEach(person -> {
			if (predicate1.and(predicate).test(person))
				map.put(person.getFirstName(), person.getSal());
		});
		return map;
	};

	public static void main(String[] args) {
		// ex-1
		System.out.println(bf1.apply("java-8", "features"));
		// ex-2
		Map<String, Double> map = bf2.apply(Arrays.asList(new Person("punya", "nayak", 1000D,"male", 200, Arrays.asList("cricket"))), predicate2);
		System.out.println(map);
	}
}
