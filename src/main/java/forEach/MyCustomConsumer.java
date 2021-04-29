package forEach;

import java.util.function.Consumer;

import model.Employee;

public class MyCustomConsumer implements Consumer<Employee> {
	
	@Override
	public void accept(Employee emp) {
		System.out.print(emp + " ");
	}
}
