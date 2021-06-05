package forEach;

import java.util.Arrays;

public class ForEachWithArray {

	public static void main(String[] args) {
		
		Integer[] arr = {10,20,3,35};
		System.out.println(Arrays.toString(arr));
		
		Arrays.stream(arr).forEach(System.out::println);
		
		Arrays.stream(arr).forEachOrdered(System.out::print);
		System.out.println();
		
		Arrays.stream(arr).filter(item -> item > 5).forEach(System.out::println);
		

	}

}
