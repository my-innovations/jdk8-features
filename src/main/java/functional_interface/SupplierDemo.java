package functional_interface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import model.Person;
import model.PersonRepository;

public class SupplierDemo {

	static Supplier<Person> supplier1 = () -> new Person("punya", "nayak", 1000D, "male", 200,Arrays.asList("Music", "cricket"));
	static Supplier<Person> supplier3 = () -> PersonRepository.getPerson();
	static Supplier<List<Person>> supplier2 = () -> PersonRepository.getAllPesons();

	public static void main(String[] args) {
		System.out.println(supplier1.get());
		System.out.println(supplier2.get());
	}
}
