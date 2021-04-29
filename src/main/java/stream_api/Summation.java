package stream_api;

import java.util.stream.IntStream;

public class Summation {
	
	public static void main(String[] args) {
		int sumResult = IntStream.rangeClosed(0, 50).map(Integer :: new).sum();
		System.out.println("Result="+sumResult);
	}
}
