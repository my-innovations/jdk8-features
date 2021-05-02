package functional_interface;

import java.util.function.Consumer;

import model.Person;
import model.PersonRepository;

public class F01_ConsumerDemo {
	
	// Consumer needs one parameters and does not returns anything.
	private static Consumer<String> lengthConsumer = (String str) -> System.out.println(str.length());
	private static Consumer<String> uppercaseConsumer = (String str) -> System.out.println(str.toUpperCase());
	private static Consumer<String> lowercaseConsumer = (String str) -> System.out.println(str.toLowerCase());
	
	private static Consumer<Person> personConsumer = (Person person) -> System.out.println(person);
	private static Consumer<Person> firstnameToUppercaseConsumer = (Person person) -> System.out.println(person.getFirstName().toUpperCase());
	private static Consumer<Person> hubbiesConsumer = (Person person) -> System.out.println(person.getHobbies());
	
	private static Consumer<Person> nameConsumer = (Person person) -> System.out.print(person.getFirstName().toUpperCase());
	private static Consumer<Person> nameConsumer3 = (Person person) -> System.out.print(person.getFirstName().toUpperCase());
	
	private static Consumer<Person> hubbiesConsumer2 = (Person person) -> System.out.print(person.getHobbies() +"\n");
	private static Consumer<Person> hubbiesConsumer3 = (Person person) -> System.out.print(person.getHobbies());
	
	public static void main(String[] args) {

		 consumerDemo();
		 getPersonNameWithHobbiesFromListOfPersons();
		 getPersonFirstnameWithHobbiesWithGenderMaleAndHeightGreaterThan50FromListOfPersons();
	}
	
	private static void consumerDemo() {

		// Ex-01
		// it returns nothing, and accepts Wrapper class as input.

		// using accept method.
		lengthConsumer.accept("java-8"); //
		uppercaseConsumer.accept("features"); //
		lowercaseConsumer.accept("features"); //
		
		personConsumer.accept(PersonRepository.getPerson());
		firstnameToUppercaseConsumer.accept(PersonRepository.getPerson());
		hubbiesConsumer.accept(PersonRepository.getPerson());
		
		//using andThen
		lengthConsumer.andThen(uppercaseConsumer).andThen(lowercaseConsumer).accept("java-8");
		uppercaseConsumer.andThen(lowercaseConsumer).andThen(lengthConsumer).accept("java-8");
		lowercaseConsumer.andThen(uppercaseConsumer).andThen(lengthConsumer).accept("java-8");

		// OR
		// will execute from left to right.
		personConsumer.andThen(firstnameToUppercaseConsumer).andThen(hubbiesConsumer).accept(PersonRepository.getPerson());
	}
	
	private static void getPersonNameWithHobbiesFromListOfPersons() {
		System.out.println("\n--------using andThen.....");
		PersonRepository.getAllPesons().forEach(nameConsumer.andThen(hubbiesConsumer2));
	}
	
	private static void getPersonFirstnameWithHobbiesWithGenderMaleAndHeightGreaterThan50FromListOfPersons() {
		System.out.println("--------using andThen --- with condition");
		PersonRepository.getAllPesons().forEach(person -> {
			if (person.getGender().equals("male") && person.getHeight() >= 50) {
				nameConsumer3.andThen(hubbiesConsumer3).accept(person);
				System.out.println();
			}
		});
	}
}
