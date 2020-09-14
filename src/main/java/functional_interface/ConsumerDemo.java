package functional_interface;

import java.util.function.Consumer;

import model.Person;
import model.PersonRepository;

public class ConsumerDemo {
	
	static Consumer<Person> consumer3 = (person) -> System.out.println(person);
	static Consumer<Person> consumer4 = (person) -> System.out.println(person.getFirstName().toUpperCase());
	static Consumer<Person> consumer5 = (person) -> System.out.println(person.getHobbies());
	
	public static void getPersonWithHobbies() {
		PersonRepository.getAllPesons().forEach(consumer4.andThen(consumer5));
	}
	
	public static void getPersonWithHobbiesWithGenderMale() {
		PersonRepository.getAllPesons().forEach(person -> {
			if (person.getGender().equals("male") && person.getHeight() >= 50) {
				consumer4.andThen(consumer5).accept(person);;
			}
		});
	}
	

	public static void main(String[] args) {

		//Ex-01
		// it returns nothing, and accepts Wraper class as input.
		Consumer<String> consumer1 = (str) -> System.out.println(str.length());
		Consumer<String> consumer2 = (str) -> System.out.println(str.toLowerCase());
		
		// consumer1.accept("java-8"); //Ok
		// consumer2.accept("features"); //OK
		consumer1.andThen(consumer2).accept("java-8");
		
		//Ex-02
		//consumer3.accept(PersonRepository.getPerson());
		//consumer4.accept(PersonRepository.getPerson());
		//consumer5.accept(PersonRepository.getPerson());
		//OR
		//will execute from left to right.
		//consumer3.andThen(consumer4).andThen(consumer5).accept(PersonRepository.getPerson());
		
		//Ex-03
		//getPersonWithHobbies();
		
		getPersonWithHobbiesWithGenderMale();
		

	}
}
