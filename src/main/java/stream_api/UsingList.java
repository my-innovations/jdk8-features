package stream_api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import model.User;

public class UsingList {

	// some dummy data
	private static List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
	
	private static List<Integer> numList = Arrays.asList(10, -7, 108, 17);
	private static List<Integer> list = Arrays.asList( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 );
	private static List<String> namesList = Arrays.asList("punya", "kishore", "sai", "aswini");
	private static List<User> usersList = Arrays.asList(new User(19), new User(67), new User(50), new User(91));

	public static void main(String[] args) {

		//convertingListToStream();
		//removeDuplicateItemsfromList();
		//sortingTheList();
		//boxing_unboxing_stream();
		using_limit();
		//using_skip();
		//using_anymatch_allmatch();
		//sortUsers();
	}
	
	
	public static void using_skip() {
		
		// using skip
		BinaryOperator<Integer> bi = (x, y) -> x + y;
		int skip = integerList.stream().skip(3).reduce(0, bi);
		System.out.println(skip);
		
	}
	
	
	public static void using_anymatch_allmatch() {
		
		// allMatch, anyMatch example
		boolean b = integerList.stream().allMatch(num -> num > 2);
		System.out.println(b);

		boolean b2 = integerList.stream().anyMatch(num -> num > 2);
		System.out.println(b2);
		
	}
	
	public static void using_limit() {
		
		// using limit
		integerList.stream().limit(2).forEach(System.out::println); //1,2

		System.out.println();
		// using with limit with reduce to find sum.
		int sum = integerList.stream().limit(3).reduce(0, (x, y) -> x + y);
		System.out.println("sum="+sum); //6 = 1+2+3

		
	}
	
	
	
	public static void boxing_unboxing_stream() {
		
		// boxing with stream - for converting primitive type to wrapper type.
		List<Integer> afterBoxing = IntStream.rangeClosed(1, 50) // primitive type
				.boxed() // wrapper class type
				.collect(Collectors.toList());
		System.out.println(afterBoxing);

		// un boxing with stream - 
		double doubleRes = IntStream.rangeClosed(1, 50) // primitive type
				.mapToDouble(x -> x) // wrapper type
				// or
				// .mapToObject(x -> x)
				.sum();
		System.out.println(doubleRes);
		
		
		int sumRes = integerList.stream().mapToInt(Integer::intValue).sum();
		System.out.println(sumRes);

	}
	
	public static void convertingListToStream() {
		
		// using IntStream
		IntStream obj = IntStream.rangeClosed(1, 6);
		obj.forEach(System.out::println);
		//System.out.println(obj.sum());

		IntStream obj2 = IntStream.range(1, 6);
		obj2.forEach(System.out::println);
		//System.out.println(obj2.sum());

		OptionalInt max = IntStream.rangeClosed(1, 50).max();
		System.out.println(max.getAsInt());

		// using LongStream
		LongStream obj3 = LongStream.rangeClosed(1, 6);
		obj3.forEach(System.out::println);
		//System.out.println(obj3.sum());

		OptionalLong max2 = LongStream.rangeClosed(1, 50).max();
		System.out.println(max2.getAsLong());

		OptionalDouble avg = LongStream.rangeClosed(1, 50).average();
		System.out.println(avg);

		// Retrieving the list
		for (String name : namesList)
			System.out.print(name);

		System.out.println();
		namesList.forEach(System.out::print);

		System.out.println();
		// converting list to stream
		Stream<String> stream1 = namesList.stream();
		stream1.forEach(name -> System.out.print(name));
		// stream1.forEach(name -> System.out.println(name));

		// ########## stream map example ##########
		System.out.println();
		List<Integer> nameLength = namesList.stream().map(String::length).collect(Collectors.toList());
		System.out.print(nameLength);

		// OR

		namesList.stream().map(String::length).collect(Collectors.toList()).forEach(System.out::println);

		// ########## flatmap demo ##########
		List<Integer> oddNums = Arrays.asList(1, 3, 5, 7);
		List<Integer> evenNums = Arrays.asList(2, 4, 6, 8);

		List<List<Integer>> listOfList = Arrays.asList(oddNums, evenNums);
		System.out.println(listOfList); // [[1, 3, 5, 7], [2, 4, 6, 8]]

		// converting to flat list
		Set<Integer> flatenList = listOfList.stream().flatMap(List::stream).sorted().collect(Collectors.toSet());
		System.out.println(flatenList); // [1, 2, 3, 4, 5, 6, 7, 8]

		// ########## filter demo ##########
		namesList.stream().filter(name -> name.length() > 3).forEach(System.out::print);
		System.out.println();
		namesList.stream().filter(name -> name.length() > 3).collect(Collectors.toList()).forEach(System.out::print);

		// ########## reduce demo ##########
		List<Integer> numsList = Arrays.asList(1, 2, 4, -5, 9);

		// counting
		int sum = numsList.stream().mapToInt(i -> 1).sum();
		System.out.println(sum); // 5

		// how many are -ve nos
		int cnt = (int) numsList.stream().filter(i -> i < 0).count();
		System.out.println("cnt=" + cnt); // 1

		// counting total items
		Long count = numsList.stream().mapToInt(i -> 1).count();
		System.out.println(count); // 5

		// evaluating the summation
		System.out.println(numsList.stream().reduce(0, (a, b) -> a + b)); // 11
		System.out.println(numsList.stream().reduce(1, (a, b) -> a * b)); // -360

	}

	public static void removeDuplicateItemsfromList() {
		

		String AfeterConcatinatingnames = namesList.stream().reduce("", (a, b) -> a.concat(b));
		System.out.println(AfeterConcatinatingnames);

		// ########################################################################################
		// Before java-8
		List<String> uniqueNames = new ArrayList<>();
		for (String name : namesList) {
			if (!uniqueNames.contains(name))
				uniqueNames.add(name);
		}
		System.out.println(uniqueNames);

		// using java-8
		List<String> uniqueName2 = namesList.stream().distinct().collect(Collectors.toList());
		System.out.println(uniqueName2);

		// using java-8
		List<Integer> numList2 = numList.stream().distinct().collect(Collectors.toList());
		System.out.println(numList2);

	}

	public static void sortingTheList() {

		// sorting in asc
		numList.sort(null);
		System.out.println(numList);

		// sorting in desc
		numList.sort(Collections.reverseOrder());
		System.out.println(numList);

		// sorting in asc
		Collections.sort(namesList, String::compareToIgnoreCase);
		System.out.println(namesList);

		// sorting in desc
		Collections.sort(namesList, Collections.reverseOrder());
		System.out.println(namesList);

		// sorting in asc
		List<String> result = namesList.stream().sorted(Comparator.comparing(name -> name.toString()))
				.collect(Collectors.toList());
		System.out.println(result);

		// sorting in desc
		List<String> result2 = namesList.stream().sorted(Comparator.comparing(name -> name.toString()).reversed()).collect(Collectors.toList());
		System.out.println(result2);

		

	}
	
	public static void sortUsers() {
		
		// Lambda expression for sorting by score
		Comparator<User> c = (User user1, User user2) -> user1.getScore() - user2.getScore();
		 usersList.sort(c);
		usersList.forEach((user)->System.out.println(user));

		// sorting in asc
		List<User> sortedUsersInAsc = usersList.stream().sorted(Comparator.comparing(User::getScore)).collect(Collectors.toList());
		sortedUsersInAsc.forEach(System.out::print);

		// sorting in desc order
		System.out.println();
		List<User> sortedUsersInDesc2 = usersList.stream().sorted(Comparator.comparing(User::getScore).reversed()).collect(Collectors.toList());
		sortedUsersInDesc2.forEach(System.out::print);
		
		// sorting in asc
		Collections.sort(usersList, Comparator.comparingDouble((User user) -> user.getScore()));
		System.out.println(usersList);

	}
}
