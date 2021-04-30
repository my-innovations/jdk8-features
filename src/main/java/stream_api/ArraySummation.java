package stream_api;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class ArraySummation {
	
	private static int[] intArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	
	public static void main(String[] args) {
		
		int r = Arrays.stream(intArray).map(Integer :: new).sum();
		System.out.println(r);
		
		int sumResult = IntStream.rangeClosed(0, 50).map(Integer :: new).sum();
		System.out.println("Result="+sumResult);
		
		long sumResult2 = LongStream.rangeClosed(0, 50).map(Long :: new).sum();
		System.out.println("Result="+sumResult2);
	}
}
