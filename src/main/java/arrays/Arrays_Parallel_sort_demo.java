package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Arrays_Parallel_sort_demo {

	public static void main(String[] args) {

		String[] array = { "a", "b", "c", "d", "e" };

		// Arrays.stream
		Stream<String> stream3 = Arrays.stream(array);
		stream3.forEach(x -> System.out.println(x));

		// Stream.of
		Stream<String> stream4 = Stream.of(array);
		stream4.forEach(x -> System.out.println(x));

		/* ################################### */
		// converting array to list
		int[] number1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		List<Integer> list0 = new ArrayList<>();
		for (int i : number1) {
			list0.add(i);
		}
		System.out.println("list : " + list0);

		/* ################################### */

		// Arrays.stream
		IntStream stream1 = Arrays.stream(number1);
		stream1.forEach(x -> System.out.println(x));

		// Stream.of
		Stream<int[]> stream2 = Stream.of(number1);
		stream2.forEach(x -> System.out.println(x));

		/* ################################### */
		// way-2 using jdk8
		int[] number = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		// IntStream.of or Arrays.stream, same output
		// List<Integer> list =
		// IntStream.of(number).boxed().collect(Collectors.toList());

		List<Integer> list = Arrays.stream(number).boxed().collect(Collectors.toList());
		System.out.println("list : " + list);

		/* ################################### */
		int numbers[] = { 10, 55, -4, 78 };
		int numbers2[] = { 10, 5, -44, -99, 47, 198, -35 };
		String fruits[] = { "guava", "apple", "banana" };
		String fruits1[] = { "guava", "apple", "banana" };

		Arrays.parallelSort(numbers);
		Arrays.stream(numbers).forEach(n -> System.out.print(n + " "));

		System.out.println("\n");

		Arrays.parallelSort(numbers2, 1, 4);
		Arrays.stream(numbers2).forEach(n -> System.out.print(n + " "));

		Arrays.sort(fruits);
		System.out.println(Arrays.toString(fruits));

		// with JDK 1.8, using Arrays.parallelSort()
		Arrays.parallelSort(fruits1);
		System.out.println(Arrays.toString(fruits1));

		/* ################################### */
		// converting string to char array
		String password = "password123";
		char[] passwordInCharArray = password.toCharArray();
		for (char temp : passwordInCharArray) {
			System.out.println(temp);
		}

	}

}
