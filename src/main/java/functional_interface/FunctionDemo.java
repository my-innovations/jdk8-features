package functional_interface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

import model.Person;
import model.PersonRepository;

public class FunctionDemo {

	// rightmost param is output param.
	static Function<String, String> fun1 = name -> name.toUpperCase();
	static Function<String, String> fun2 = name -> name.toUpperCase().concat(" features");
	static Function<String, Integer> fun3 = name -> name.length();
	static Function<List<Person>, Map<String, Integer>> fun4 = personList -> {
		Map<String, Integer> map = new HashMap<>();
		personList.forEach(p -> {
			map.put(p.getFirstName(), p.getHeight());
		});
		return map;
	};

	// function with predicate demo
	static Predicate<Person> p1 = per -> per.getHeight() >= 100;
	static Predicate<Person> p2 = per -> per.getGender().equals("male");
	static Function<List<Person>, Map<String, Integer>> fun5 = personList -> {
		Map<String, Integer> map = new HashMap<>();
		personList.forEach(p -> {
			if (p1.and(p2).test(p))
				map.put(p.getFirstName(), p.getHeight());
		});
		return map;
	};

	public static void main(String[] args) {
		System.out.println(fun1.apply("java8"));
		System.out.println(fun2.apply("java8"));
		System.out.println(fun3.apply("java8"));
		// executes from left to right
		System.out.println(fun1.andThen(fun2).apply("java8"));
		// first fun2 will process then fun1
		System.out.println(fun1.compose(fun2).apply("java8"));

		// ex-
		Map<String, Integer> res = fun4.apply(PersonRepository.getAllPesons());
		System.out.println(res);

		// ex-
		Map<String, Integer> res5 = fun5.apply(PersonRepository.getAllPesons());
		System.out.println(res5);
	}
}
