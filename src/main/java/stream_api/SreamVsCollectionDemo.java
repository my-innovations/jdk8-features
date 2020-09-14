package stream_api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SreamVsCollectionDemo {

	public static void main(String[] args) {
		
		List<String> list =new ArrayList<>();
		list.add("Punya");
		list.add("Lipun");
		list.add("Partha");
		list.add("Dusmanta");
		
		for(String name:list)
			System.out.println(name);
		//OR
		Stream<String> s = list.stream();
		s.forEach(name -> System.out.println(name));
		//s.forEach(name -> System.out.println(name));
		
		//stream map example
		List<Integer> nameLength = list.stream().map(String :: length).collect(Collectors.toList());
		System.out.println(nameLength);
		//OR
		list.stream().map(String :: length).collect(Collectors.toList()).forEach(System.out::println);
		
		//flatmap demo
		List<Integer> oddNums = Arrays.asList(1,3,5,7);
		List<Integer> evenNums = Arrays.asList(2,4,6,8);
		
		List<List<Integer>> listOfList = Arrays.asList(oddNums,evenNums);
		System.out.println(listOfList);
		
		Set<Integer> flatenList = listOfList.stream().flatMap(List :: stream).sorted().collect(Collectors.toSet());
		System.out.println(flatenList);
		
		//filter demo
		list.stream().filter(len -> len.length() > 3).forEach(System.out::println);
		list.stream().filter(len -> len.length() > 3).collect(Collectors.toList()).forEach(System.out::println);
		
		//reduce demo
		List<Integer> nums = Arrays.asList(1,2,4,5,9);
		int sum = nums.stream().mapToInt(i -> 1).sum();
		System.out.println(sum);
		Long count = nums.stream().mapToInt(i -> 1).count();
		System.out.println(count);
		System.out.println(nums.stream().reduce(1, (a,b) -> a*b));
		System.out.println(nums.stream().reduce(0, (a,b) -> a+b));
		
	}

}
