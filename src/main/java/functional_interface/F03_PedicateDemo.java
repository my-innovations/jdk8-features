package functional_interface;

import java.util.function.Predicate;
import java.util.stream.Collectors;

import model.Person;
import model.PersonRepository;

public class F03_PedicateDemo {
	
	private static Predicate<Integer> leassThan50Predicate = num -> (num <= 50);
	private static Predicate<Integer> greaterThanAndEqualPredicate = num -> num >= 100;
	private static Predicate<Integer> equalToZeroPredicate = (num) -> (num == 0);
	private static  Predicate<Person> personHeightGreaterThanAndEqualTo150Predicate = person -> person.getHeight() >= 150;
	private static  Predicate<Person> personGenderIsMalePredicate = person -> person.getGender().equals("male");
	private static  Predicate<Person> personGenderIsMaleAndHeightGreaterThanEqualTo150Predicate = person -> person.getGender().equals("male") && person.getHeight() >= 100;
	
	public static void main(String[] args) {

		// ex-01
		boolean res = leassThan50Predicate.test(55);
		System.out.println(res); // false

		// ex-02
		// using and
		boolean res1 = leassThan50Predicate.and(greaterThanAndEqualPredicate).and(equalToZeroPredicate).test(25);
		System.out.println(res1); // flase

		// ex-03
		// using both and, or , it executes from left to right
		boolean res2 = leassThan50Predicate.and(greaterThanAndEqualPredicate).or(equalToZeroPredicate).test(25);
		System.out.println(res2); // false

		// ex-04
		// using and , or, negate , it executes from left to right
		boolean res3 = leassThan50Predicate.and(greaterThanAndEqualPredicate).or(equalToZeroPredicate).negate().test(25);
		System.out.println(res3); // true

		// ex-05
		// using person repository , list
		PersonRepository.getAllPesons().stream().filter(person -> person.getHeight() >= 100).collect(Collectors.toList()).forEach(person -> {
		// PersonRepository.getAllPesons().stream().filter(predicate03).collect(Collectors.toList()).forEach(person -> { //OK
					if (personHeightGreaterThanAndEqualTo150Predicate.test(person))
					// if(personHeightGreaterThanAndEqualTo150Predicate.and(personGenderIsMalePredicate).test(person))
					// if(personHeightGreaterThanAndEqualTo150Predicate.or(personGenderIsMalePredicate).test(person))
						System.out.println(person);
				});

	}
}
