package stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class UsingArray {

	// some dummy data
	private static int[] intArray = { 1, 2, 3, 4, 15, 6, 7, 8, 9, 10 };
	private static Integer[] intArray2 = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	private static String[] strArray = { "punya", "pankaj", "naveen", "sai", "aswini" };

	public static void main(String[] args) {
		convertArrayToStream();
	}

	public static void convertArrayToStream() {

		/**
		 * using stream.of(-)
		 */

		Stream<Integer> stream1 = Stream.of(intArray2);
		stream1.forEach(item -> System.out.print(item + " "));

		//sort with ascending
		// find largest item
		System.out.println();
		Stream.of(intArray2).sorted().findFirst().ifPresent(System.out::println);

		Stream<Integer> stream2 = Stream.of(1, 2, 3, 44, 5);
		stream2.forEach(item -> System.out.print(item+" "));

		System.out.println();
		Stream<Integer> stream3 = Stream.of(new Integer[] { 1, 2, 33, 4, 5 });
		stream3.forEach(item -> System.out.print(item+" "));

		System.out.println();
		Stream<String> stream4 = Stream.of(strArray);
		stream4.forEach(x -> System.out.print(x+" "));

		System.out.println();
		Stream.of(strArray).sorted().findFirst().ifPresent(System.out::println);

		/**
		 * Way-02, using Arrays.stream(-)
		 */

		System.out.println();
		IntStream stream5 = Arrays.stream(intArray);
		stream5.forEach(item -> System.out.print(item + " "));

		System.out.println();
		IntStream.range(1, 20).forEach(System.out::println);
		
		System.out.println();
		IntStream.range(1, 20).skip(5).forEach(System.out::println);
		
		System.out.println();
		int res = IntStream.range(1, 20).sum();
		System.out.println(res);

		System.out.println();
		Stream<String> stream6 = Arrays.stream(strArray);
		stream6.forEach(str -> System.out.println(str));

		System.out.println();
		// using chaining
		Arrays.stream(strArray).forEach(n -> System.out.print(n + " "));
		
		System.out.println();
		Arrays.stream(strArray, 2, 4).forEach(n -> System.out.print(n + " "));
		
		System.out.println();
		Arrays.stream(strArray).sorted().forEach(n -> System.out.print(n + " "));
		
		System.out.println();
		Arrays.stream(strArray).sorted().skip(2).forEach(n -> System.out.print(n + " "));
		
		System.out.println();
		List<String> listt = Arrays.stream(strArray).sorted().collect(Collectors.toList());
		System.out.println(listt);

		System.out.println();
		Arrays.stream(strArray).filter(str -> str.length() > 3).forEach(n -> System.out.print(n + " "));

		System.out.println();
		List<Integer> list2 = Arrays.stream(intArray).boxed().collect(Collectors.toList());
		System.out.println("list2 : " + list2);

		System.out.println();
		// IntStream.of or Arrays.stream, same output
		List<Integer> list = IntStream.of(intArray).boxed().collect(Collectors.toList());
		System.out.println(list);

	}
}
