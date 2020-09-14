package functional_interface;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

import model.Person;
import model.PersonRepository;

public class BiPredicateDemo {

	static BiPredicate<Integer, String> p3 = (height, gender) -> height >= 100 && gender.equals("male");
	static BiConsumer<String, List<String>> hobbiesConsumer = (name, hobbies) -> System.out.println(name + "-" + hobbies);
	static Consumer<Person> personConsumer = per -> {
		if (p3.test(per.getHeight(), per.getGender())) {
			hobbiesConsumer.accept(per.getFirstName(), per.getHobbies());
		}
	};

	public static void main(String[] args) {
		PersonRepository.getAllPesons().stream().forEach(personConsumer);
	}

}
