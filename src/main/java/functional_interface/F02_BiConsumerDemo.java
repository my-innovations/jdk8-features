package functional_interface;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

import model.Person;
import model.PersonRepository;

public class F02_BiConsumerDemo {
	
	// BiConsumer needs two parameters and does not returns anything.
	private static BiConsumer<Integer, Integer> addBiConsumer = (Integer a, Integer b) -> System.out.println(a + b);
	private static BiConsumer<List<Integer>, List<Integer>> biConsumer2 = (List<Integer> list01, List<Integer> list02) -> {
		if (list01.size() == list02.size())
			System.out.println("true");
		else
			System.out.println("false");
	};
	
	private static BiConsumer<String, Integer> personBiConsumer01 = (String name, Integer height) -> System.out.println(name + "-" + height);
	private static BiConsumer<String, Integer> personNameAndHeightBiConsumer = (String name, Integer height) -> System.out.println(name + "-" + height);
	private static BiConsumer<String, List<String>> personNameAndHubbiesBiConsumer = (String name, List<String> hobbiesList) -> System.out.println(name + "-" + hobbiesList);
	private static BiConsumer<Integer, Integer> addBiconsumer = (Integer a, Integer b) -> System.out.println(a + b);
	private static BiConsumer<Integer, Integer> subBiconsumer = (Integer a, Integer b) -> System.out.println(a - b);
	private static BiConsumer<Integer, Integer> mulBiconsumer = (Integer a, Integer b) -> System.out.println(a * b);
	
	

	public static void main(String[] args) {
		workingWithListUsingBiConsumer_1();
		workingWithListUsingBiConsumerWithAndThen();
	}

	public static void addTwoNumsUsingBiConsumer() {
		addBiConsumer.accept(10, 20);
	}

	public static void toCheckSizeOgTwoListsUsingBiConsumer() {
		// ex-02 - using list as params , checking the size of two lists.
		List<Integer> list1 = Arrays.asList(new Integer(1), new Integer(2));
		List<Integer> list2 = Arrays.asList(new Integer(10), new Integer(20));
		biConsumer2.accept(list1, list2);
	}

	public static void workingWithListUsingBiConsumer_1() {

		
		List<Person> personList = PersonRepository.getAllPesons();
		personList.forEach(person -> personBiConsumer01.accept(person.getFirstName(), person.getHeight()));
	}

	public static void workingWithListUsingBiConsumerWithAndThen() {
		List<Person> personList = PersonRepository.getAllPesons();
		// using andThen , when input data types are same.
		personList.forEach(pperson -> {
			personNameAndHeightBiConsumer.accept(pperson.getFirstName(), pperson.getHeight());
			personNameAndHubbiesBiConsumer.accept(pperson.getFirstName(), pperson.getHobbies());
		});
	}

	public static void usingAndThenWithBiConsumer() {

		// ex-03 using andThen()
		addBiconsumer.accept(10, 20);
		subBiconsumer.accept(3, 7);
		mulBiconsumer.accept(11, 22);
		// OR
		// executes from left to right.
		addBiconsumer.andThen(subBiconsumer).andThen(mulBiconsumer).accept(10, 20);
	}
}
