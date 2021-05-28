package functional_interface;

import java.util.function.Predicate;
import java.util.stream.Collectors;

import model.Person;
import model.PersonRepository;

//Predicate (it contains SAM test(-), and(),or(),negate() ,isEqual() are default methods),

public class F03_PedicateDemo {
	
	private static Predicate<Integer> numLessThan50OrNot = num -> (num <= 50);
	private static Predicate<Integer> numGreaterThanAndEqualTo100OrNot = num -> num >= 100;
	private static Predicate<Integer> numEqualToZeroOrNot = (num) -> (num == 0);
	private static  Predicate<Person> personHeightGreaterThanAndEqualTo150OrNot = person -> person.getHeight() >= 150;
	private static  Predicate<Person> personGenderIsMaleOrNot = person -> person.getGender().equals("male");
	private static  Predicate<Person> personGenderIsMaleAndHeightGreaterThanEqualTo150OrNot = person -> person.getGender().equals("male") && person.getHeight() >= 100;
	
	public static void main(String[] args) {

		// ex-01
		boolean res = numLessThan50OrNot.test(55);
		System.out.println(res); // false

		// ex-02
		// using and
		boolean res1 = numLessThan50OrNot.and(numGreaterThanAndEqualTo100OrNot).and(numEqualToZeroOrNot).test(25);
		System.out.println(res1); // flase

		// ex-03
		// using both and, or , it executes from left to right
		boolean res2 = numLessThan50OrNot.and(numGreaterThanAndEqualTo100OrNot).or(numEqualToZeroOrNot).test(25);
		System.out.println(res2); // false

		// ex-04
		// using and , or, negate , it executes from left to right
		boolean res3 = numLessThan50OrNot.and(numGreaterThanAndEqualTo100OrNot).or(numEqualToZeroOrNot).negate().test(25);
		System.out.println(res3); // true

		// ex-05
		// using person repository , list
		PersonRepository.getAllPesons().stream().filter(person -> person.getHeight() >= 100).collect(Collectors.toList()).forEach(person -> {
		// PersonRepository.getAllPesons().stream().filter(predicate03).collect(Collectors.toList()).forEach(person -> { //OK
					if (personHeightGreaterThanAndEqualTo150OrNot.test(person) && personGenderIsMaleOrNot.test(person))
					// if(personHeightGreaterThanAndEqualTo150Predicate.and(personGenderIsMalePredicate).test(person))
					// if(personHeightGreaterThanAndEqualTo150Predicate.or(personGenderIsMalePredicate).test(person))
						System.out.println(person);
				});

	}
}
