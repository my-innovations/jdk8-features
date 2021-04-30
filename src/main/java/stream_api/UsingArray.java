package stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class UsingArray {

	// some dummy data
	private static int[] intArray = { 1, 2, 3, 4, 15, 6, 7, 8, 9, 10 };
	private static Integer[] integerArray = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	private static String[] strArray = { "punya", "pankaj", "naveen", "sai", "aswini" };

	public static void main(String[] args) {
		convertArrayToStream();
	}

	public static void convertArrayToStream() {

		/**
		 * using stream.of(-)
		 */

		//display all items
		Stream<Integer> stream2 = Stream.of(1, 2, 3, 44, 5);
		stream2.forEach(item -> System.out.print(item+" "));

		//display all items
		System.out.println();
		Stream<Integer> stream3 = Stream.of(new Integer[] { 1, 2, 33, 4, 5 });
		stream3.forEach(item -> System.out.print(item+" "));
		
		//display all items
		Stream<Integer> stream1 = Stream.of(integerArray);
		stream1.forEach(item -> System.out.print(item + " "));

		// find largest item
		System.out.println();
		Stream.of(integerArray).sorted().findFirst().ifPresent(System.out::println);
		
		//display all items
		System.out.println();
		Stream<String> stream4 = Stream.of(strArray);
		stream4.forEach(x -> System.out.print(x+" "));

		//display first item after sorting
		System.out.println();
		Stream.of(strArray).sorted().findFirst().ifPresent(System.out::println);

		/**
		 * Way-02, using Arrays.stream(-)
		 */

		//display all items
		System.out.println();
		IntStream stream5 = Arrays.stream(intArray);
		stream5.forEach(item -> System.out.print(item + " "));
		
		//display all items
		System.out.println();
		List<Integer> list2 = Arrays.stream(intArray).boxed().collect(Collectors.toList());
		System.out.println("list2 : " + list2);

		//convert to wrapper type
		System.out.println();
		List<Integer> list = IntStream.of(intArray).boxed().collect(Collectors.toList());
		System.out.println(list);

		//display all items in the range
		System.out.println();
		IntStream.range(1, 20).forEach(System.out::println);
		
		//display all items in the range with skip
		System.out.println();
		IntStream.range(1, 20).skip(5).forEach(System.out::println);
		
		//find summation
		System.out.println();
		int res = IntStream.range(1, 20).sum();
		System.out.println(res);
		
		//find sum of all items in the array
		int r = Arrays.stream(intArray).map(Integer :: new).sum();
		System.out.println(r);

		System.out.println();
		Stream<String> stream6 = Arrays.stream(strArray);
		stream6.forEach(str -> System.out.println(str));

		System.out.println();
		Arrays.stream(strArray).forEach(n -> System.out.print(n + " "));
		
		System.out.println();
		Arrays.stream(strArray, 2, 4).forEach(n -> System.out.print(n + " "));
		
		//with sorting
		System.out.println();
		Arrays.stream(strArray).sorted().forEach(n -> System.out.print(n + " "));
		
		//with sorting and skip
		System.out.println();
		Arrays.stream(strArray).sorted().skip(2).forEach(n -> System.out.print(n + " "));
		
		//with sorting
		System.out.println();
		List<String> listt = Arrays.stream(strArray).sorted().collect(Collectors.toList());
		System.out.println(listt);

		//displays strings having more than 3 chars
		System.out.println();
		Arrays.stream(strArray).filter(str -> str.length() > 3).forEach(n -> System.out.print(n + " "));
	}
}
