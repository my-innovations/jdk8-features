package functional_interface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import model.Person;
import model.PersonRepository;

public class F08_SupplierDemo {
	
	//it does not take any input data.
	//it returns the output data.
	//it is having get()

	private static Supplier<Person> personSupplier1 = () -> new Person(1,"punya", "nayak", 1000D, "male", 40,200,Arrays.asList("Music", "cricket"));
	private static Supplier<Person> personSupplier2 = () -> PersonRepository.getPerson();
	private static Supplier<List<Person>> personsListSupplier = () -> PersonRepository.getAllPesons();
	
	public static void main(String[] args) {
		System.out.println(personSupplier1.get());
		System.out.println(personSupplier2.get());
		System.out.println(personsListSupplier.get());
	}
}
