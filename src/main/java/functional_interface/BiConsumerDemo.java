package functional_interface;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

import model.Person;
import model.PersonRepository;

public class BiConsumerDemo {

	public static void main(String[] args) {

		// ex-1
		BiConsumer<Integer, Integer> biConsumer1 = (Integer a, Integer b) -> System.out.println(a + b);
		biConsumer1.accept(10, 20);

		// ex-2 - checking the size of two lists.
		List<Integer> list1 = Arrays.asList(new Integer(1), new Integer(2));
		List<Integer> list2 = Arrays.asList(new Integer(10), new Integer(20));
		BiConsumer<List<Integer>, List<Integer>> biConsumer2 = (List<Integer> list01, List<Integer> list02) -> {
			if (list01.size() == list02.size())
				System.out.println("true");
			else
				System.out.println("false");
		};
		biConsumer2.accept(list1, list2);

		// ex-3 using andThen()
		BiConsumer<Integer, Integer> addBiconsumer = (a, b) -> System.out.println(a + b);
		BiConsumer<Integer, Integer> subBiconsumer = (a, b) -> System.out.println(a - b);
		BiConsumer<Integer, Integer> mulBiconsumer = (a, b) -> System.out.println(a * b);

		// addBiconsumer.accept(10, 20);
		// subBiconsumer.accept(3, 7);
		// mulBiconsumer.accept(11, 22);
		// OR
		// executes from left to right.
		addBiconsumer.andThen(subBiconsumer).andThen(mulBiconsumer).accept(10, 20);
		
		//ex-04
		BiConsumer<String,List<String>> personBiConsumer = (name,hobbies) -> System.out.println(name+"-"+hobbies);
		BiConsumer<String,Integer> personBiConsumer2 = (name,height) -> System.out.println(name+"-"+height);
		
		List<Person> personList = PersonRepository.getAllPesons();
		personList.forEach(p -> personBiConsumer.accept(p.getFirstName(),p.getHobbies()));
		//ex-05 , using andThen , if input datatypes are same.
		personList.forEach(p -> {
			personBiConsumer.accept(p.getFirstName(), p.getHobbies());
			personBiConsumer2.accept(p.getFirstName(), p.getHeight());
		});
	}
}
