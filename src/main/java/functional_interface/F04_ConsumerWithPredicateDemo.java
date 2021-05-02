package functional_interface;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import model.Person;
import model.PersonRepository;

public class F04_ConsumerWithPredicateDemo {
	
	private static Predicate<Person> predicate1 = per -> per.getGender().equals("male");
	private static Predicate<Person> predicate2 = per -> per.getHeight() >= 140;
	private static BiConsumer<String, List<String>> hobbiesConsumer = (firstname, hobbies) -> System.out.println(firstname +"-"+ hobbies);
	private static Consumer<Person> personConsumer = (person) -> {
		if (predicate1.and(predicate2).test(person)) {
			hobbiesConsumer.accept(person.getFirstName(), person.getHobbies());
		}
	};
	
	private static Predicate<Person> predicate01 = person -> person.getGender().equals("male");
	private static Predicate<Person> predicate02 = person -> person.getHeight() >= 100;
	//private static Predicate<Person> predicate03 = person -> person.getGender().equals("male") && person.getHeight() >= 100;
	private static BiConsumer<String, List<String>> hobbiesBiConsumer = (name, hobbies) -> System.out.println(name + "-" + hobbies);
	private static Consumer<Person> personConsumer2 = person -> {
		if (predicate01.and(predicate02).test(person)) {
			hobbiesBiConsumer.accept(person.getFirstName(), person.getHobbies());
		}
	};

	public static void main(String[] args) {
		
		//ex-01 ,  using consumer with predicate demo.
		List<Person> list = Arrays.asList(new Person("punya", "nayak", 1000D, "male", 200, Arrays.asList("Music")));
		list.forEach(personConsumer);
		
		List<Person> list2 = PersonRepository.getAllPesons();
		list2.forEach(personConsumer);
		
		//ex-02 , using predicate with consumer.
		PersonRepository.getAllPesons().stream().filter(predicate01).collect(Collectors.toList()).forEach(personConsumer2);
	}
}
