package forEach;

import java.util.Arrays;

public class ForEachWithArray {

	public static void main(String[] args) {
		
		Integer[] arr = {10,20,3,35};
		Arrays.stream(arr).forEachOrdered(System.out::println);
		

	}

}
