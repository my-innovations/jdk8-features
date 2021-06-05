package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Test5 {

	public static void main(String[] args) {

		Integer[] arr = { 11, 5, 7, 47, 28, 4, 8, 38,21,37 };
		/*
		 * Integer[] res = new Integer[arr.length];
		 * 
		 * for (int i = 0; i < arr.length; i++) { if (arr[i] % 2 == 0) { res[i] =
		 * arr[i]; } } for (Integer num : res) { System.out.println(num); }
		 * 
		 * Set<Integer> set= new HashSet(Arrays.asList(res)); System.out.println(set);
		 */

		//List<Integer> list = Arrays.asList(arr).stream().filter(item-> item %2 ==0).sorted((i1,i2)-> i2.compareTo(i1)).collect(Collectors.toList());
		//System.out.println(list);
		
		
		List<Integer> list = Arrays.asList(arr).stream().filter(item -> item.toString().contains("3") | item.toString().contains("2") ).collect(Collectors.toList());
		Collections.sort(list,(item1,item2) -> item2.compareTo(item1));
		System.out.println(list);
	}

}
