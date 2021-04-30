package stream_api;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Summation {
	
	public static void main(String[] args) {
		
		int sumResult = IntStream.rangeClosed(0, 50).map(Integer :: new).sum();
		System.out.println("Result="+sumResult);
		
		long sumResult2 = LongStream.rangeClosed(0, 50).map(Long :: new).sum();
		System.out.println("Result="+sumResult2);
	}
}
