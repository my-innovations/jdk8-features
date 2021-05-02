package forEach;

import java.util.function.Consumer;

import model.Person;

public class MyCustomConsumer implements Consumer<Person> {
	
	@Override
	public void accept(Person emp) {
		System.out.print(emp + " ");
	}
}
