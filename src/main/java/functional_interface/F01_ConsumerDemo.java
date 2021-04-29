package functional_interface;

import java.util.function.Consumer;

import model.Person;
import model.PersonRepository;

public class F01_ConsumerDemo {
	
	public static void main(String[] args) {

		 consumerDemo();
		 getPersonNameWithHobbiesFromListOfPersons();
		 getPersonFirstnameWithHobbiesWithGenderMaleAndHeightGreaterThan50FromListOfPersons();
	}
	
	public static void consumerDemo() {

		// Ex-01
		// it returns nothing, and accepts Wraper class as input.

		// using accept method.
		Consumer<String> lengthConsumer = (str) -> System.out.println(str.length());// 6
		lengthConsumer.accept("java-8"); //

		Consumer<String> uppercaseConsumer = (str) -> System.out.println(str.toUpperCase());
		uppercaseConsumer.accept("features"); //

		Consumer<String> lowercaseConsumer = (str) -> System.out.println(str.toLowerCase());
		lowercaseConsumer.accept("features"); //
		
		//######################################################################################
		//using andThen
		Consumer<Person> personConsumer = (person) -> System.out.println(person);
		personConsumer.accept(PersonRepository.getPerson());

		Consumer<Person> firstnameToUppercaseConsumer = (person) -> System.out.println(person.getFirstName().toUpperCase());
		firstnameToUppercaseConsumer.accept(PersonRepository.getPerson());

		Consumer<Person> hubbiesConsumer = (person) -> System.out.println(person.getHobbies());
		hubbiesConsumer.accept(PersonRepository.getPerson());

		lengthConsumer.andThen(uppercaseConsumer).andThen(lowercaseConsumer).accept("java-8");
		uppercaseConsumer.andThen(lowercaseConsumer).andThen(lengthConsumer).accept("java-8");
		lowercaseConsumer.andThen(uppercaseConsumer).andThen(lengthConsumer).accept("java-8");

		// OR
		// will execute from left to right.
		personConsumer.andThen(firstnameToUppercaseConsumer).andThen(hubbiesConsumer).accept(PersonRepository.getPerson());
	}
	
	public static void getPersonNameWithHobbiesFromListOfPersons() {
		System.out.println("\n--------");
		Consumer<Person> nameConsumer = (person) -> System.out.print(person.getFirstName().toUpperCase());
		Consumer<Person> hubbiesConsumer = (person) -> System.out.print(person.getHobbies() +"\n");
		PersonRepository.getAllPesons().forEach(nameConsumer.andThen(hubbiesConsumer));
	}
	
	public static void getPersonFirstnameWithHobbiesWithGenderMaleAndHeightGreaterThan50FromListOfPersons() {
		System.out.println("--------");
		Consumer<Person> nameConsumer = (person) -> System.out.print(person.getFirstName().toUpperCase());
		Consumer<Person> hubbiesConsumer = (person) -> System.out.print(person.getHobbies());
		PersonRepository.getAllPesons().forEach(person -> {
			if (person.getGender().equals("male") && person.getHeight() >= 50) {
				nameConsumer.andThen(hubbiesConsumer).accept(person);
				System.out.println();
			}
		});
	}
}
