package functional_interface;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import model.Person;

public class F07_BiFunctionDemo {

	private static BiFunction<String, String, String> concatBiFunction = (a, b) -> (a + " " + b);
	//bifunction with predicate
	private static Predicate<Person> personHeightGreaterThanEqualTo100Predicate = person -> person.getHeight() >= 100;
	private static Predicate<Person> personGenderIsMalePredicate = person -> person.getGender().contentEquals("male");
	private static BiFunction<List<Person>, Predicate<Person>, Map<String, Double>> personFirstnameWithSalaryBiFunction = (personsList, personGenderIsMalePredicate) -> {
		Map<String, Double> firstnameAndSalMap = new HashMap<>();
		personsList.forEach(person -> {
			if (personHeightGreaterThanEqualTo100Predicate.and(personGenderIsMalePredicate).test(person))
				firstnameAndSalMap.put(person.getFirstName(), person.getSal());
		});
		return firstnameAndSalMap;
	};

	public static void main(String[] args) {
		// ex-1
		System.out.println(concatBiFunction.apply("java-8", "features"));
		// ex-2
		Map<String, Double> map = personFirstnameWithSalaryBiFunction.apply(Arrays.asList(new Person(1,"punya", "nayak", 1000D,"male", 200, 40,Arrays.asList("cricket"))), personGenderIsMalePredicate);
		System.out.println(map);
	}
}
