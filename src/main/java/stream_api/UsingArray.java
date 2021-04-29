package stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class UsingArray {

	public static void main(String[] args) {
		convertArrayToStream();
	}
	
	public static void convertArrayToStream() {
		
		Stream<Integer> s1 = Stream.of(1,2,3,4,5);
		s1.forEach(item -> System.out.println(item));
		
		Stream<Integer> s2 = Stream.of(new Integer[] {1,2,3,4,5});
		s2.forEach(item -> System.out.println(item));

		//some dummy data
		int[] arr1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		String[] arr2 = { "punya", "pankaj", "naveen", "sai", "aswini" };

		// ex-1
		Stream<int[]> stream1 = Stream.of(arr1);
		stream1.forEach(item -> System.out.println(item));
		
		//ex-2
		IntStream stream2 = Arrays.stream(arr1);
		stream2.forEach(item -> System.out.println(item));
		
		IntStream.range(1, 20).forEach(System.out::println);
		
		IntStream.range(1, 20).skip(5).forEach(System.out::println);
		
		int res = IntStream.range(1, 20).sum();
		System.out.println(res);

		// ex-3
		Stream<String> stream3 = Arrays.stream(arr2);
		stream3.forEach(str -> System.out.println(str));
		
		//ex-4
		Stream<String> stream4 = Stream.of(arr2);
		stream4.forEach(x -> System.out.println(x));
		// Or
		// using chaining
		Arrays.stream(arr2).forEach(n -> System.out.print(n + " "));
		
		Stream.of(arr2).sorted().findFirst().ifPresent(System.out::println);;
		
		Arrays.stream(arr2,2,4).forEach(n -> System.out.print(n + " "));
		
		Arrays.stream(arr2).sorted().forEach(n -> System.out.print(n + " "));
		
		Arrays.stream(arr2).sorted().skip(2).forEach(n -> System.out.print(n + " "));
		
		List<String> listt = Arrays.stream(arr2).sorted().collect(Collectors.toList());
		System.out.println(listt);
		
		Arrays.stream(arr2).filter(str -> str.length() > 3 ).forEach(n -> System.out.print(n + " "));

		// ex-5
		// IntStream.of or Arrays.stream, same output
		List<Integer> list = IntStream.of(arr1).boxed().collect(Collectors.toList());
		System.out.println(list);

		List<Integer> list2 = Arrays.stream(arr1).boxed().collect(Collectors.toList());
		System.out.println("list : " + list2);
	}
}
