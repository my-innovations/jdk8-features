package functional_interface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

import model.Person;
import model.PersonRepository;

public class F06_FunctionDemo {
	//Function functional interface accepts two params. left param is input and right param is output param.it contains apply method.
	private static Function<String, String> toUppercaseFunction = name -> name.toUpperCase();
	private static Function<String, String> toUppercaseWithConcatFunction = name -> name.toUpperCase().concat(" features");
	private static Function<String, Integer> lengthFungth = name -> name.length();
	private static Function<List<Person>, Map<String, Integer>> personNameAndHeightFunction = personList -> {
		Map<String, Integer> personNameHeightmap = new HashMap<>();
		personList.forEach(person -> {
			personNameHeightmap.put(person.getFirstName(), person.getHeight());
		});
		return personNameHeightmap;
	};

	// using function with predicate
	private static Predicate<Person> personHeightGreaterThanEqualTo100Predicate = person -> person.getHeight() >= 100;
	private static Predicate<Person> personGenderIsMalePredicate = person -> person.getGender().equals("male");
	private static Function<List<Person>, Map<String, Integer>> fun5 = personList -> {
		Map<String, Integer> map = new HashMap<>();
		personList.forEach(personp -> {
			if (personHeightGreaterThanEqualTo100Predicate.and(personGenderIsMalePredicate).test(personp))
				map.put(personp.getFirstName(), personp.getHeight());
		});
		return map;
	};

	public static void main(String[] args) {
		
		System.out.println(toUppercaseFunction.apply("java8"));
		System.out.println(toUppercaseWithConcatFunction.apply("java8"));
		System.out.println(lengthFungth.apply("java8"));
		
		// executes from left to right
		System.out.println("andThen res:"+toUppercaseFunction.andThen(toUppercaseWithConcatFunction).apply("java8"));
		
		// first fun2 will process then fun1
		System.out.println("compose res: "+toUppercaseFunction.compose(toUppercaseWithConcatFunction).apply("java8"));

		// ex- using List
		Map<String, Integer> res = personNameAndHeightFunction.apply(PersonRepository.getAllPesons());
		System.out.println(res);

		// ex-
		Map<String, Integer> res5 = fun5.apply(PersonRepository.getAllPesons());
		System.out.println(res5);
	}
}
