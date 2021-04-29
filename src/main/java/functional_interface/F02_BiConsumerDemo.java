package functional_interface;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

import model.Person;
import model.PersonRepository;

public class F02_BiConsumerDemo {

	public static void main(String[] args) {
		// workingWithListUsingBiConsumer_1();
		workingWithListUsingBiConsumerWithAndThen();
	}

	public static void addTwoNumsUsingBiConsumer() {
		// BiConsumer needs two parameters.
		BiConsumer<Integer, Integer> addBiConsumer = (Integer a, Integer b) -> System.out.println(a + b);
		addBiConsumer.accept(10, 20);
	}

	public static void toCheckSizeOgTwoListsUsingBiConsumer() {
		// ex-02 - using list as params , checking the size of two lists.
		List<Integer> list1 = Arrays.asList(new Integer(1), new Integer(2));
		List<Integer> list2 = Arrays.asList(new Integer(10), new Integer(20));
		BiConsumer<List<Integer>, List<Integer>> biConsumer2 = (List<Integer> list01, List<Integer> list02) -> {
			if (list01.size() == list02.size())
				System.out.println("true");
			else
				System.out.println("false");
		};
		biConsumer2.accept(list1, list2);
	}

	public static void workingWithListUsingBiConsumer_1() {

		BiConsumer<String, Integer> personBiConsumer01 = (name, height) -> System.out.println(name + "-" + height);
		List<Person> personList = PersonRepository.getAllPesons();
		personList.forEach(person -> personBiConsumer01.accept(person.getFirstName(), person.getHeight()));
	}

	public static void workingWithListUsingBiConsumerWithAndThen() {

		BiConsumer<String, Integer> personNameAndHeightBiConsumer = (name, height) -> System.out.println(name + "-" + height);
		BiConsumer<String, List<String>> personNameAndHubbiesBiConsumer = (name, hobbiesList) -> System.out.println(name + "-" + hobbiesList);

		List<Person> personList = PersonRepository.getAllPesons();

		// using andThen , when input datatypes are same.
		personList.forEach(pperson -> {
			personNameAndHeightBiConsumer.accept(pperson.getFirstName(), pperson.getHeight());
			personNameAndHubbiesBiConsumer.accept(pperson.getFirstName(), pperson.getHobbies());
		});
	}

	public static void usingAndThenWithBiConsumer() {

		// ex-03 using andThen()
		BiConsumer<Integer, Integer> addBiconsumer = (a, b) -> System.out.println(a + b);
		BiConsumer<Integer, Integer> subBiconsumer = (a, b) -> System.out.println(a - b);
		BiConsumer<Integer, Integer> mulBiconsumer = (a, b) -> System.out.println(a * b);

		addBiconsumer.accept(10, 20);
		subBiconsumer.accept(3, 7);
		mulBiconsumer.accept(11, 22);
		// OR
		// executes from left to right.
		addBiconsumer.andThen(subBiconsumer).andThen(mulBiconsumer).accept(10, 20);
	}
}
