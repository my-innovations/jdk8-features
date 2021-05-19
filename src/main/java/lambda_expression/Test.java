package lambda_expression;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {

		Integer[] arr = { 1, 2, 35, 4, 5, 6, 75, 9 };
		//int evenmax = Arrays.stream(arr).filter(item -> item %2 == 0).max().getAsInt();
		//int oddmin = Arrays.stream(arr).filter(item -> item %2 != 0).min().getAsInt();
		//System.out.println(evenmax);
		//System.out.println(oddmin);
		
		 List<Integer> list = Arrays.stream(arr).filter(item -> item.toString().contains("5")).collect(Collectors.toList());
		System.out.println(list);
		
	}

}
