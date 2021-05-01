package stream_api;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import model.Employee;
import model.User;

public class CollectionObjectsWithStreamDemo {

		
	// primitive type data
	private static byte[] byteArrayPrimitiveType = { 10, 5, -44, -99, 47, 19, -35 };
	private static short[] shortArrayPrimitiveType = { 10, 5, -44, -99, 47, 198, -35 };
	private static int[] intArray = { 1, 2, 3, 4, 15, 6, 7, 8, 9, 10 };
	//private static int[] intArray = new int[] { 1, 34, 78, 90, 27, 45 };
	private static long[] longArrayPrimitiveType = new long[] { 1, 34, 78, 90, 27, 45 };
	private static float[] floatArrayPrimitiveType = new float[] { 1.5f, 34.8f, 78.2f, 90.0f, 27.78f, 45.31f };
	private static double[] doubleArrayPrimitiveType = { 10.6d, 5.8d, -44.7d, -99.1d, 47.4d, 198.9d, -35.7f };
	//private static double[] doubleArrayPrimitive = new double[] { 1, 34, 78, 90, 27, 45 };
	private static char[] charArrayPrimitiveType = new char[] { 'a', 'm', 'y', 'u' };
	
	
	//wrapper type data
	private static Byte[] byteArrayWrapperType = { 10, 5, -44, -99, 47, 19, -35 };
	private static Short[] shortArrayWrapperType = { 10, 5, -44, -99, 47, 198, -35 };
	private static Integer[] integerArray = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	private static Long[] longArrayWrapperType = new Long[] { 1l, 34l, 78l, 90l, 27l, 45l };
	private static Float[] floatArrayWrapperType = new Float[] { 1.5f, 34.8f, 78.2f, 90.0f, 27.78f, 45.31f };
	private static Double[] doubleArrayWrapperType = new Double[] { 1d, 34d, 78d, 90d, 27d, 45d };
	private static Character[] charArrayWrapperType = new Character[] { 'a', 'm', 'y', 'u' };
	private static String[] strArray = { "punya", "pankaj", "naveen", "sai", "aswini" };
	private static String[] stringArray = { "punya", "Partha", "Aswini", "punya","Arabind" };
	
	//List type data
	//private static List<Byte> byteList = Arrays.asList(1, 34, 78, 90, 27, 45); //CE
	//private static List<Short> shortList = Arrays.asList(1, 34, 78, 90, 27, 45); //CE
	private static List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
	//private static List<Integer> integerList2 = Arrays.asList(integerArray);
	//private static List<Integer> list = Arrays.asList( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 );
	private static List<Long> longlist = Arrays.asList(longArrayWrapperType);
	private static List<Float> floatlist = Arrays.asList(floatArrayWrapperType);
	private static List<Double> doublelist = Arrays.asList(doubleArrayWrapperType);
	private static List<Character> charlist = Arrays.asList(charArrayWrapperType);
	private static List<String> stringList = Arrays.asList("punya", "punyasmruti","pankaj kumar", "aswini k ssingh", "parthasarathi");
	private static List<String> namesList = Arrays.asList("punya", "kishore", "sai", "aswini");
	private static List<User> usersList = Arrays.asList(new User(19), new User(67), new User(50), new User(91));
	private static List<Employee> employeeList = Arrays.asList(new Employee(1, "Shifoo", "acc1", "IT", 25, 150000d),new Employee(2, "Punya", "acc2", "IT", 40, 250000d));
	
	
	//private static Set<Byte> byteSet = new HashSet(byteList); //CE
	private static Set<Integer> integerSet = new HashSet<>(integerList);
	private static Set<Long> longSet = new HashSet<>(longlist);
	private static Set<Float> floatSet = new HashSet<>(floatlist);
	private static Set<Double> doubleSet = new HashSet<>(doublelist);
	private static Set<Character> charSet = new HashSet<>(charlist);
	private static Set<String> stringSet = new HashSet<>(stringList);
	private static Set<Employee> employeeSet = new HashSet<>(employeeList);
	
	private static Map<String, Integer> unsortedMap = null;
	
	static {
		unsortedMap = new HashMap<>();
		unsortedMap.put("z", 10);
		unsortedMap.put("b", 5);
		unsortedMap.put("a", 6);
		unsortedMap.put("2", 20);
		unsortedMap.put("d", 1);
		unsortedMap.put("e", 7);
		unsortedMap.put("7", 8);
		unsortedMap.put("n", 99);
		unsortedMap.put("g", 50);
		unsortedMap.put("m", 2);
		unsortedMap.put("f", 9);
		
	}
	
	
	public static void main(String[] args) {

		/**
		 * ######## Working with primitive and wrapper types array ##################
		 */
		// using primitive and wrapper type data types.
		sortIntegerArrayWithAndWithoutUsingComparator();
		sortFloatArrayWithAndWithoutUsingComparator();
		arraySummation();
		sortStringArray();
		sortStringAtrrayByLength();
		countNoOfOccurancesOfEachItemInArrayOrList();
		convertAnyArrayToStream();
		find_largest_smallest_sum_avg_From_any_primitive_Array();
		find_largest_smallest_Item_From_any_wrapper_Array();
		removeDuplicateItemsFromAnyArray();
		countNoOfOccurancesOfPerticularItemInAnyArray();
		countNoOfOccurancesOfEachItemInAnyArray();
		countNoOfOccurancesOfEachItemwithRangeInAnyArray();
		sortAnyArray();
		parallelSortAnyArray();
		convertStringToCharArray();
		convertAnyArrayToList();
		convertAnyArrayToSet();
		namesStartingWithSpecificCharInStringArray();
		namesStartingWithSpecificCharInStringList();
		//sortContentOfFile();
		
		/**
		 * ######## Working List along with primitive and wrapper data types ##################
		 */
		
		sortIntegerList();
		convertingListToStream();
		removeDuplicateItemsfromList();
		sortingTheList();
		boxing_unboxing_stream();
		using_limit();
		using_skip();
		using_anymatch_allmatch();
		

		/**
		 * ########### Working with List and custom DTO class  #########
		 */
		sortEmployeeById();
		sortEmployeeByName();
		sortEmployeeByAge();
		sortEmployeeBySalary();
		sortEmployeeBySalaryUsingJava8();
		convertEmplpoyeeListToMap();
		sortUsers();
		
		
		/**
		 * ######## Working Set ##################
		 */


		
		/**
		 * ######## Working with Map ##################
		 */
		
		sortMapByKeys();
		sortMapByValues();
		
		/**
		 * ########### Working with Map and custom DTO class  #########
		 */
		
		

	}// main
	
	/**
	 *  ################################################ Working with primitive and wrapper types array ##########################################################################################################################################
	 * 
	 */
	
	public static void arraySummation() {
		
		int r = Arrays.stream(intArray).map(Integer :: new).sum();
		System.out.println(r);
		
		int intResult = IntStream.rangeClosed(0, 50).map(Integer :: new).sum();
		System.out.println("Int Result="+intResult);
		
		long longResult = LongStream.rangeClosed(0, 50).map(Long :: new).sum();
		System.out.println("Long Result="+longResult);
		
		//double sumResult3 = DoubleStream.rangeClosed(0d, 50d).map(Double :: new).sum();
		//System.out.println("Result="+sumResult3);
		
	}
	

	public static void sortIntegerArrayWithAndWithoutUsingComparator() {
		
		Arrays.sort(intArray); // default sort
		System.out.println(Arrays.toString(intArray));
		
		// default sorting
		Arrays.stream(intArray).sorted().forEach(System.out::println);

		// default sorting with unique items
		Arrays.stream(intArray).sorted().distinct().forEach(System.out::println);
		
		Arrays.sort(integerArray); // default sort
		System.out.println(Arrays.toString(integerArray));
		
		Collections.sort(Arrays.asList(integerArray)); // default sort
		System.out.println(Arrays.toString(integerArray));
		
		//java7 comparator
		Comparator<Integer> customComparator1 = new Comparator<Integer>() {
			@Override
			public int compare(Integer num1, Integer num2) {
				return num1.compareTo(num2); // ascending
				// return num2.compareTo(num1); // descending
			}
		};

		//java8 comparator
		Comparator<Integer> customComparator2 = (Integer num1, Integer num2) -> num1.compareTo(num2); // ascending
		Comparator<Integer> customComparator3 = (Integer num1, Integer num2) -> num2.compareTo(num1); // descending
		
		//Arrays.sort(integerArray, customComparator1/customComparator2/customComparator3);
		Arrays.sort(integerArray, customComparator1);
		System.out.println(Arrays.toString(integerArray));
		
		//Collections.sort(Arrays.asList(integerArray), customComparator1 / customComparator2 / customComparator3);
		Collections.sort(Arrays.asList(integerArray), customComparator1);
		System.out.println(Arrays.toString(integerArray));

	}
	
	public static void sortFloatArrayWithAndWithoutUsingComparator() {
		
		Arrays.sort(floatArrayPrimitiveType); // default sort
		System.out.println(Arrays.toString(floatArrayPrimitiveType));
		
		Arrays.sort(floatArrayWrapperType); // default sort
		System.out.println(Arrays.toString(floatArrayWrapperType));
		
		Collections.sort(Arrays.asList(floatArrayWrapperType)); // default sort
		System.out.println(Arrays.toString(floatArrayWrapperType));
		
		//java7 comparator
		Comparator<Float> customComparator01 = new Comparator<Float>() {
			@Override
			public int compare(Float num1, Float num2) {
				return num1.compareTo(num2); // ascending
				// return num2.compareTo(num1); // descending
			}
		};

		//java8 comparator
		Comparator<Float> customComparator02 = (Float num1, Float num2) -> num1.compareTo(num2); // ascending
		Comparator<Float> customComparator03 = (Float num1, Float num2) -> num2.compareTo(num1); // descending
				
		//Arrays.sort(floatArrayWrapperType, customComparator01/customComparator02/customComparator03);
		Arrays.sort(floatArrayWrapperType, customComparator01);
		System.out.println(Arrays.toString(floatArrayWrapperType));
		
		//Collections.sort(Arrays.asList(floatArrayWrapperType), customComparator01)/customComparator02/customComparator03;
		Collections.sort(Arrays.asList(floatArrayWrapperType), customComparator01);
		System.out.println(Arrays.toString(floatArrayWrapperType));
		
	}
	
private static void find_largest_smallest_sum_avg_From_any_primitive_Array() {
		
	    int max1 = Arrays.stream(intArray).max().getAsInt();
		//int max = Arrays.stream(integerArray).max().getAsInt(); //CE
	    System.out.println(max1);
	    
	    int min1 = Arrays.stream(intArray).min().getAsInt();
	    // int min1 = Arrays.stream(integerArray).min().getAsInt(); //CE
	    System.out.println(min1);
	    
	    int sum =Arrays.stream(intArray).sum();
	    System.out.println("sum="+sum);
	    
	    OptionalDouble avg = Arrays.stream(intArray).average();
	    System.out.println("avg="+avg.getAsDouble());
	    
	    int intRes = Arrays.stream(intArray).sum();
	    System.out.println(intRes);
	    
	    
	    //  ******************
	    
	    long max2 = Arrays.stream(longArrayPrimitiveType).max().getAsLong();
		//long max2 = Arrays.stream(longArrayWrapperType).max().getAsLong(); //CE
	    System.out.println(max2);
	    
	    long min2 = Arrays.stream(longArrayPrimitiveType).min().getAsLong();
	    // long min2 = Arrays.stream(longArrayWrapperType).min().getAsLong(); //CE
	    System.out.println(min2);
	    
	//  ******************
	    
	    double max3 = Arrays.stream(doubleArrayPrimitiveType).max().getAsDouble();
		//double max3 = Arrays.stream(doubleArrayWrapperType).max().getAsDouble(); //CE
	    System.out.println(max3);
	    
	    double min3 = Arrays.stream(doubleArrayPrimitiveType).min().getAsDouble();
	    // double min3 = Arrays.stream(doubleArrayWrapperType).min().getAsDouble(); //CE
	    System.out.println(min3);
	    
	    
	}
	
	private static void find_largest_smallest_Item_From_any_wrapper_Array() {
		
		Comparator<Byte> byteComparator = (Byte num1, Byte num2) -> num1.compareTo(num2); // ascending
		int max1 = Arrays.stream(byteArrayWrapperType).max(byteComparator).get();
		//or
		//int max1 = Arrays.asList(byteArrayWrapperType).stream().max(byteComparator).get();
		System.out.println(max1);
		
		Comparator<Short> shortComparator = (Short num1, Short num2) -> num1.compareTo(num2); // ascending
		int max2 = Arrays.stream(shortArrayWrapperType).max(shortComparator).get();
		//OR
		//int max2 = Arrays.asList(shortArrayWrapperType).stream().max(shortComparator).get();
		System.out.println(max2);

		Comparator<Integer> intComparator = (Integer num1, Integer num2) -> num1.compareTo(num2); // ascending
		int max3 = Arrays.stream(integerArray).max(intComparator).get();
		//OR
		//int max3 = Arrays.asList(integerArray).stream().max(intComparator).get();
		System.out.println(max3);
		
		Comparator<Long> longComparator = (Long num1, Long num2) -> num1.compareTo(num2); // ascending
		Long max4 = Arrays.stream(longArrayWrapperType).max(longComparator).get();
		//OR
		//Long max4 = Arrays.asList(longArrayWrapperType).stream().max(longComparator).get();
		System.out.println(max4);
		
		Comparator<Float> floatComparator = (Float num1, Float num2) -> num1.compareTo(num2); // ascending
		Float max5 = Arrays.stream(floatArrayWrapperType).max(floatComparator).get();
		//OR
		//Float max5 = Arrays.asList(floatArrayWrapperType).stream().max(floatComparator).get();
		System.out.println(max5);
		
		Comparator<Double> doubleComparator = (Double num1, Double num2) -> num1.compareTo(num2); // ascending
		Double max6 = Arrays.stream(doubleArrayWrapperType).max(doubleComparator).get();
		//OR
		//Double max6 = Arrays.asList(doubleArrayWrapperType).stream().max(doubleComparator).get();
		System.out.println(max6);

	}
	
private static void countNoOfOccurancesOfEachItemInAnyArray() {
		
		// way-01
		List<Integer> list = Arrays.asList(integerArray);
		Set<Integer> set = new HashSet<Integer>(list);
		for (Integer item : set)
			System.out.println(item + ": " + Collections.frequency(list, item));

		// way-02
		Map<Integer, Long> counts = list.stream().collect(Collectors.groupingBy(item -> item, Collectors.counting()));
		System.out.println(counts);
	
	}

	private static void countNoOfOccurancesOfPerticularItemInAnyArray() {
		
		//ex-01
		List<Integer> list3 = Arrays.asList(integerArray);
		long count = list3.stream().filter(item -> 11 == item).count();
		System.out.println(count);
		
		//ex-02
		List<String> list = Arrays.asList(stringArray);
		count = list.stream().filter(item -> "punya".equalsIgnoreCase(item)).count();
		System.out.println(count);
		
		//ex-03
		//count the no items starts with A.
		count = Arrays.stream(stringArray).filter(item -> item.startsWith("A")).count();
		System.out.println(count);
	}
	
	private static void countNoOfOccurancesOfEachItemwithRangeInAnyArray() {
		Map<Integer, Long> map = Arrays.stream(integerArray).filter(item -> item >=10 && item <=50).collect(Collectors.groupingBy(item -> item, Collectors.counting()));
		System.out.println(map);
		
	}

	private static void removeDuplicateItemsFromAnyArray() {
		
		List<Byte> list1 = Arrays.asList(byteArrayWrapperType);
		Set<Byte> set1 = new HashSet<>(list1);
		System.out.println(set1);
		
		Byte[] byteArrayWrapperType2 = (Byte[]) list1.stream().distinct().toArray();
		for(Byte b: byteArrayWrapperType2) {
			System.out.print(b+" ");
		}
		
		//byte[] res1 =  Arrays.stream(byteArrayPrimitiveType).distinct().toArray(); //CE
		Byte[] res2 = (Byte[]) Arrays.stream(byteArrayWrapperType).distinct().toArray();
		System.out.println(res2);
		
		List<Byte> res3 =  Arrays.stream(byteArrayWrapperType).distinct().collect(Collectors.toList());
		System.out.println(res3);
		
		
		List<Short> list2 = Arrays.asList(shortArrayWrapperType);
		Set<Short> set2 = new HashSet<>(list2);
		System.out.println(set2);

		List<Integer> list3 = Arrays.asList(integerArray);
		Set<Integer> set3 = new HashSet<>(list3);
		System.out.println(set3);
		
		List<Float> list4 = Arrays.asList(floatArrayWrapperType);
		Set<Float> set4 = new HashSet<>(list4);
		System.out.println(set4);
		
		List<Long> list5 = Arrays.asList(longArrayWrapperType);
		Set<Long> set5 = new HashSet<>(list5);
		System.out.println(set5);
		
		
		List<Double> list6 = Arrays.asList(doubleArrayWrapperType);
		Set<Double> set6 = new HashSet<>(list6);
		System.out.println(set6);
		
		List<String> list7 = Arrays.asList(stringArray);
		Set<String> set7 = new HashSet<>(list7);
		System.out.println(set7);
		
	}



	private static void convertAnyArrayToStream() {
		
		/**
		 * using stream.of(-)
		 */

		//display all items
		Stream<Integer> stream2 = Stream.of(1, 2, 3, 44, 5);
		stream2.forEach(item -> System.out.print(item+" "));

		//display all items
		System.out.println();
		Stream<Integer> stream3 = Stream.of(new Integer[] { 1, 2, 33, 4, 5 });
		stream3.forEach(item -> System.out.print(item+" "));
		
		//display all items
		Stream<Integer> stream1 = Stream.of(integerArray);
		stream1.forEach(item -> System.out.print(item + " "));

		// find largest item
		System.out.println();
		Stream.of(integerArray).sorted().findFirst().ifPresent(System.out::println);
		
		//display all items
		System.out.println();
		Stream<String> stream4 = Stream.of(strArray);
		stream4.forEach(x -> System.out.print(x+" "));

		//display first item after sorting
		System.out.println();
		Stream.of(strArray).sorted().findFirst().ifPresent(System.out::println);

		/**
		 * Way-02, using Arrays.stream(-)
		 */

		//display all items
		System.out.println();
		IntStream stream5 = Arrays.stream(intArray);
		stream5.forEach(item -> System.out.print(item + " "));
		
		//display all items
		System.out.println();
		List<Integer> list2 = Arrays.stream(intArray).boxed().collect(Collectors.toList());
		System.out.println("list2 : " + list2);

		//convert to wrapper type
		System.out.println();
		List<Integer> list = IntStream.of(intArray).boxed().collect(Collectors.toList());
		System.out.println(list);

		//display all items in the range
		System.out.println();
		IntStream.range(1, 20).forEach(System.out::println);
		
		//display all items in the range with skip
		System.out.println();
		IntStream.range(1, 20).skip(5).forEach(System.out::println);
		
		//find summation
		System.out.println();
		int res = IntStream.range(1, 20).sum();
		System.out.println(res);
		
		//find sum of all items in the array
		int r = Arrays.stream(intArray).map(Integer :: new).sum();
		System.out.println(r);

		System.out.println();
		Stream<String> stream6 = Arrays.stream(strArray);
		stream6.forEach(str -> System.out.println(str));

		System.out.println();
		Arrays.stream(strArray).forEach(n -> System.out.print(n + " "));
		
		System.out.println();
		Arrays.stream(strArray, 2, 4).forEach(n -> System.out.print(n + " "));
		
		//with sorting
		System.out.println();
		Arrays.stream(strArray).sorted().forEach(n -> System.out.print(n + " "));
		
		//with sorting and skip
		System.out.println();
		Arrays.stream(strArray).sorted().skip(2).forEach(n -> System.out.print(n + " "));
		
		//with sorting
		System.out.println();
		List<String> listt = Arrays.stream(strArray).sorted().collect(Collectors.toList());
		System.out.println(listt);

		//displays strings having more than 3 chars
		System.out.println();
		Arrays.stream(strArray).filter(str -> str.length() > 3).forEach(n -> System.out.print(n + " "));
		
		//@@@@@@ way-01

		// Arrays.stream(byteArrayPrimitiveType).forEach(System.out::print);//CE
		 Arrays.stream(byteArrayWrapperType).forEach(System.out::print);
		 
		// Arrays.stream(shortArrayPrimitiveType).forEach(System.out::print);//CE
		 Arrays.stream(shortArrayWrapperType).forEach(System.out::print);
		
		IntStream intStream = Arrays.stream(intArray);
		//IntStream s = Arrays.stream(integerArray);//CE
		intStream.forEach(System.out::println);
		//s.forEachOrdered(System.out::println);
		
		Arrays.stream(intArray).forEach(System.out::print);
		//Arrays.stream(intArray,2,3).forEach(System.out::print);
		
		Arrays.stream(integerArray).forEach(System.out::print);
		
		LongStream s2 = Arrays.stream(longArrayPrimitiveType);
		s2.forEach(System.out::println);
		
		Arrays.stream(longArrayPrimitiveType).forEach(System.out::print);
		//Arrays.stream(longArrayPrimitiveType,2,2).forEach(System.out::print);
		
		Arrays.stream(longArrayWrapperType).forEach(System.out::print);
		
		//Arrays.stream(floatArrayPrimitiveType).forEach(System.out::print);//CE
		Arrays.stream(floatArrayWrapperType).forEach(System.out::print);
		
		DoubleStream s3 = Arrays.stream(doubleArrayPrimitiveType);
		s3.forEach(System.out::println);
		
		Arrays.stream(doubleArrayPrimitiveType).forEach(System.out::print);
		//Arrays.stream(doubleArrayPrimitiveType,3,2).forEach(System.out::print);
		Arrays.stream(doubleArrayWrapperType).forEach(System.out::print);
		

		//@@@@@@ way-02
		
		Stream<byte[]> stream01 = Stream.of(byteArrayPrimitiveType);
		stream01.forEach(System.out::println);
		
		Stream<Byte> stream02 = Stream.of(byteArrayWrapperType);
		stream02.forEach(System.out::println);
	
		Stream<short[]> stream03 = Stream.of(shortArrayPrimitiveType);
		stream03.forEach(System.out::println);
		
		Stream<Short> stream04 = Stream.of(shortArrayWrapperType);
		stream04.forEach(System.out::println);
		
		Stream<int[]> stream05 = Stream.of(intArray);
		stream05.forEach(System.out::println);
		
		Stream<Integer> stream06 = Stream.of(integerArray);
		stream06.forEach(System.out::println);
				
		Stream.of(byteArrayPrimitiveType).forEach(System.out::print);
		Stream.of(byteArrayWrapperType).forEachOrdered(System.out::print);
		
		Stream.of(shortArrayPrimitiveType).forEach(System.out::print);
		Stream.of(shortArrayWrapperType).forEachOrdered(System.out::print);
		
		Stream.of(intArray).forEach(System.out::print);
		Stream.of(integerArray).forEachOrdered(System.out::print);
		
		Stream.of(longArrayPrimitiveType).forEachOrdered(System.out::print);
		Stream.of(longArrayWrapperType).forEachOrdered(System.out::print);
		
		Stream.of(floatArrayPrimitiveType).forEachOrdered(System.out::print);
		Stream.of(floatArrayWrapperType).forEachOrdered(System.out::print);
		
		Stream.of(doubleArrayPrimitiveType).forEachOrdered(System.out::print);
		Stream.of(doubleArrayWrapperType).forEachOrdered(System.out::print);
		
	}
	
	

	private static void convertAnyArrayToList() {

		//List<byte> list001 = Arrays.asList(byteArrayWrapperType);//CE
		List<Byte> list001 = Arrays.asList(byteArrayWrapperType);
		System.out.println("byte array=" + list001.toString());

		//List<short> list002 = Arrays.asList(shortArrayWrapperType); //CE
		List<Short> list002 = Arrays.asList(shortArrayWrapperType);
		System.out.println("short array=" + list002.toString());

		// way-01
		List<Integer> list01 = new ArrayList<>();
		for (Integer i : intArray) {
			list01.add(i);
		}
		System.out.println(list01);

		// way-02
		
		List<Integer> list03 = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println(list03);

		List<Integer> list3 = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 });
		System.out.println(list3);

		// way-03
		//List<Integer> list02 = Arrays.asList(intArray); //CE
		List<Integer> list2 = Arrays.asList(integerArray);
		System.out.println(list2);

		// List<float> list4 = Arrays.asList(floatArray1); //CE
		// System.out.println(list4);

		List<Float> list4 = Arrays.asList(floatArrayWrapperType);
		System.out.println(list4);

		// List<long> list5 = Arrays.asList(longArray1); //CE
		// System.out.println(list5);

		// List<double> list6 = Arrays.asList(doubleArray1); //CE
		// System.out.println(list6);

		List<Double> list6 = Arrays.asList(doubleArrayWrapperType);
		System.out.println(list6);

		// List<char> list003 = Arrays.asList(charArray1); //CE
		// System.out.println(list003);

		List<Character> list003 = Arrays.asList(charArrayWrapperType);
		System.out.println(list003);

		// converting string array to string list
		List<String> list7 = Arrays.asList("Jon", "Ajeet", "Steve", "Ajeet", "Jon", "Ajeet");
		System.out.println(list7);

		// converting string array to string list
		List<String> list8 = Arrays.asList(stringArray);
		System.out.println(list8);
	}

	
	
	public static void sortStringArray() {
		System.out.println();
		
		Arrays.sort(stringArray); //default sort
		System.out.println(Arrays.toString(stringArray));
		
		Collections.sort(Arrays.asList(stringArray)); //default sort
		System.out.println(Arrays.toString(stringArray));
		
		Comparator<String> customComparator1 = new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				// return str2.compareTo(str1); // descending order
				return str1.compareTo(str2); // ascending order
			}
		};

		Comparator<String> customComparator2 = (String str1, String str2) -> str1.compareTo(str2); //ascending order
		Comparator<String> customComparator3 = (String str1, String str2) -> str2.compareTo(str1);  //descending order
		
		//Arrays.sort(stringArray, customComparator1/customComparator2/customComparator3);
		Arrays.sort(stringArray, customComparator1);
		System.out.println(Arrays.toString(stringArray));
		
	
		//Collections.sort(Arrays.asList(stringArray), customComparator1/customComparator2/customComparator3);
		Collections.sort(Arrays.asList(stringArray), customComparator1);
		System.out.println(Arrays.toString(stringArray));
		
	}
	
	
	public static void sortStringList() {
		
		Collections.sort(stringList); // default sorting
		stringList.forEach((name) -> System.out.print(name+" "));
		
		//java7 comparator
		Comparator<String> customComparator1 = new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				// return str2.compareTo(str1); // descending order
				return str1.compareTo(str2); // ascending order
			}
		};

		//java8 comparator
		Comparator<String> customComparator2 = (String str1, String str2) -> str1.compareTo(str2); //ascending order
		Comparator<String> customComparator3 = (String str1, String str2) -> str2.compareTo(str1);  //descending order
		
		//stringList.sort(customComparator1/customComparator2/customComparator3);
		stringList.sort(customComparator1);
		stringList.forEach((name) -> System.out.print(name +" "));
		
		System.out.println();
		//Collections.sort(stringList, customComparator1/customComparator2/customComparator3);
		Collections.sort(stringList, customComparator1);
		stringList.forEach((name) -> System.out.print(name+" "));
		
	}

	

	private static void sortStringAtrrayByLength() {
		
		//jdk7
		Comparator<String> sortByLengthComparator1 = new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				return str1.length() - str2.length();
				//return str2.length() - str1.length();
			}
		};
		
		Comparator<String> sortByLengthComparator2 = Comparator.comparingInt(String::length);
		//Comparator<String> sortByLengthComparator2 = Comparator.comparingInt(String::length).reversed();
		
		//jdk8
		Comparator<String> sortByLengthComparator3 = (s1, s2) -> s1.length() - s2.length();
		//Comparator<String> sortByLengthComparator3 = (s1, s2) -> s2.length() - s1.length();
		
		//Arrays.sort(stringArray, sortByLengthComparator1/sortByLengthComparator2/sortByLengthComparator3);
		Arrays.sort(stringArray, sortByLengthComparator1);
		System.out.println(Arrays.toString(stringArray));
		
		//stringList.sort(sortByLengthComparator1/sortByLengthComparator2/sortByLengthComparator3);
		stringList.sort(sortByLengthComparator1);
		stringList.forEach(System.out::println);
		
		// OR
		//Collections.sort(stringList, sortByLengthComparator1/sortByLengthComparator2/sortByLengthComparator3,);
		Collections.sort(stringList, sortByLengthComparator2);
		stringList.forEach(System.out::println);
		
	}
	
	
public static void sortAnyArray() {
	
		
		// way-01 , sorting byte array in ascending order
		Arrays.sort(byteArrayPrimitiveType);
		System.out.println("byte arr after sort:" + Arrays.toString(byteArrayPrimitiveType));

		Arrays.sort(byteArrayWrapperType);
		System.out.println("byte arr after sort:" + Arrays.toString(byteArrayWrapperType));
		
		Comparator<Byte> byteComparator1 = new Comparator<Byte>() {
			@Override
			public int compare(Byte i1, Byte i2) {
				return i2.compareTo(i1);
			}
		};
		
		//way-02
		Comparator<Byte> byteComparator2 = (Byte num1, Byte num2) -> num1.compareTo(num2); // ascending
		Comparator<Byte> byteComparator3 = (Byte num1, Byte num2) -> num2.compareTo(num1); // descending
		
		// Arrays.sort(byteArrayPrimitiveType, byteComparator1); //CE
		Arrays.sort(byteArrayWrapperType, byteComparator1);
		System.out.println("byte arr ===>" + Arrays.toString(byteArrayWrapperType));
		
		//Arrays.stream(byteArrayPrimitiveType).sorted(); //CE
		Arrays.stream(byteArrayWrapperType).sorted().forEach(System.out::println);
		Arrays.stream(byteArrayWrapperType).sorted().distinct().forEach(System.out::println);
		
		//way-03
		Stream.of(byteArrayPrimitiveType).sorted().forEach(System.out::println);;
		Stream.of(byteArrayWrapperType).sorted().forEach(System.out::println);;
		Stream.of(byteArrayWrapperType).sorted(byteComparator1).forEach(System.out::println);;
		Stream.of(byteArrayWrapperType).sorted(byteComparator2).forEach(System.out::println);;
		Stream.of(byteArrayWrapperType).sorted(byteComparator3).forEach(System.out::println);;
		
		//************************************************************************************

		//way-01
		Arrays.sort(shortArrayPrimitiveType);
		System.out.println(Arrays.toString(shortArrayPrimitiveType));

		Arrays.sort(shortArrayWrapperType);
		System.out.println(Arrays.toString(shortArrayWrapperType));
		
		Comparator<Short> shortComparator1 = new Comparator<Short>() {
			@Override
			public int compare(Short i1, Short i2) {
				return i2.compareTo(i1);
			}
		};
		
		//way-02
		Comparator<Short> shortComparator2 = (Short num1, Short num2) -> num1.compareTo(num2); // ascending
		Comparator<Short> shortComparator3 = (Short num1, Short num2) -> num2.compareTo(num1); // descending
		
		// Arrays.sort(shortArrayPrimitiveType, shortComparator); //CE
		Arrays.sort(shortArrayWrapperType, shortComparator1);
		System.out.println("short arr === "+Arrays.toString(shortArrayWrapperType));
		
		//Arrays.stream(shortArrayPrimitiveType).sorted(); //CE
		Arrays.stream(shortArrayWrapperType).sorted().forEach(System.out::println);;
		Arrays.stream(shortArrayWrapperType).sorted().distinct().forEach(System.out::println);
		
		//way-03
		Stream.of(shortArrayPrimitiveType).sorted().forEach(System.out::println);;
		Stream.of(shortArrayPrimitiveType).sorted().distinct().forEach(System.out::println);;
		Stream.of(shortArrayWrapperType).sorted().forEach(System.out::println);;
		Stream.of(shortArrayWrapperType).sorted().distinct().forEach(System.out::println);;
		Stream.of(shortArrayWrapperType).sorted(shortComparator1).forEach(System.out::println);
		Stream.of(shortArrayWrapperType).sorted(shortComparator2).forEach(System.out::println);;
		Stream.of(shortArrayWrapperType).sorted(shortComparator3).forEach(System.out::println);;
		
		//************************************************************************************
		
		Arrays.sort(intArray);
		System.out.println(Arrays.toString(intArray));

		Arrays.sort(integerArray);
		System.out.println(Arrays.toString(integerArray));
		
		Comparator<Integer> intComparator1 = new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				// ascending order
				// return i1.compareTo(i2);
				// descending order
				return i2.compareTo(i1);
			}
		};
		
		Comparator<Integer> intComparator2 = (Integer num1, Integer num2) -> num1.compareTo(num2); // ascending
		Comparator<Integer> intComparator3 = (Integer num1, Integer num2) -> num2.compareTo(num1); // descending
		
		Arrays.sort(integerArray);
		System.out.println("int array == "+Arrays.toString(integerArray));
		Arrays.sort(integerArray, intComparator1);
		System.out.println("int array == "+Arrays.toString(integerArray));
		Arrays.sort(integerArray, intComparator2);
		System.out.println("int array == "+Arrays.toString(integerArray));
		Arrays.sort(integerArray, intComparator3);
		System.out.println("int array == "+Arrays.toString(integerArray));
		
		Arrays.stream(intArray).sorted().forEach(System.out::println);
		Arrays.stream(intArray).sorted().distinct().forEach(System.out::println);
		Arrays.stream(integerArray).sorted().forEach(System.out::println);
		Arrays.stream(integerArray).sorted().distinct().forEach(System.out::println);
		Arrays.stream(integerArray).sorted(intComparator1).distinct().forEach(System.out::println);
		Arrays.stream(integerArray).sorted(intComparator2).distinct().forEach(System.out::println);
		Arrays.stream(integerArray).sorted(intComparator3).distinct().forEach(System.out::println);
		
		Stream.of(intArray).sorted().forEach(System.out::println);
		Stream.of(integerArray).sorted(intComparator1).forEach(System.out::println);
		Stream.of(integerArray).sorted(intComparator2).forEach(System.out::println);
		Stream.of(integerArray).sorted(intComparator3).forEach(System.out::println);
		
		//************************************************************************************

		Arrays.sort(floatArrayPrimitiveType);
		System.out.println(Arrays.toString(floatArrayPrimitiveType));

		Arrays.sort(floatArrayWrapperType);
		System.out.println(Arrays.toString(floatArrayWrapperType));
		
		Comparator<Object> floatComparator = new Comparator<Object>() {
			@Override
			public int compare(Object i1, Object i2) {
				Float num1 = (Float) i1;
				Float num2 = (Float) i2;
				return num2.compareTo(num1);
			}
		};
		//Arrays.sort(longArray1, longComparator);//CE
		Arrays.sort(floatArrayWrapperType, floatComparator);
		System.out.println("float arr ====="+Arrays.toString(floatArrayWrapperType));

		List<Long> list022 = new ArrayList<>();
		list022.add(12L);
		list022.add(33l);
		Collections.sort(list022, floatComparator);

		
		//************************************************************************************

		Arrays.sort(longArrayPrimitiveType);
		System.out.println(Arrays.toString(longArrayPrimitiveType));
		
		Comparator<Object> longComparator = new Comparator<Object>() {
			@Override
			public int compare(Object i1, Object i2) {
				Long num1 = (Long) i1;
				Long num2 = (Long) i2;
				return num2.compareTo(num1);
			}
		};
		//Arrays.sort(longArray1, longComparator);//CE
		Arrays.sort(longArrayWrapperType, longComparator);
		System.out.println("long arr ====="+Arrays.toString(longArrayWrapperType));

		List<Long> list22 = new ArrayList<>();
		list22.add(12L);
		list22.add(33l);
		Collections.sort(list22, longComparator);
		
		Arrays.stream(longArrayWrapperType).sorted();
		Arrays.stream(longArrayWrapperType).sorted().distinct().forEach(System.out::println);
		
		Stream.of(longArrayWrapperType).sorted();
		Stream.of(longArrayWrapperType).sorted(longComparator);
		
		//************************************************************************************

		Arrays.sort(doubleArrayPrimitiveType);
		System.out.println(Arrays.toString(doubleArrayPrimitiveType));

		Arrays.sort(doubleArrayWrapperType);
		System.out.println(Arrays.toString(doubleArrayWrapperType));
		
		Comparator<Object> doubleComparator = new Comparator<Object>() {
			@Override
			public int compare(Object i1, Object i2) {
				Double num1 = (Double) i1;
				Double num2 = (Double) i2;
				return num2.compareTo(num1);
			}
		};
		//Arrays.sort(doubleArray1, longComparator);//CE
		Arrays.sort(doubleArrayWrapperType, doubleComparator);
		System.out.println("double arr ====="+Arrays.toString(doubleArrayWrapperType));

		Arrays.stream(doubleArrayWrapperType).sorted();
		Arrays.stream(doubleArrayWrapperType).sorted().distinct().forEach(System.out::println);
		
		Stream.of(doubleArrayWrapperType).sorted();
		Stream.of(doubleArrayWrapperType).sorted(doubleComparator);

		
		//************************************************************************************

		Arrays.sort(charArrayPrimitiveType);
		System.out.println(Arrays.toString(charArrayPrimitiveType));

		Arrays.sort(charArrayWrapperType);
		System.out.println(Arrays.toString(charArrayWrapperType));
		
		//************************************************************************************
		//way-01
		Arrays.sort(stringArray);
		System.out.println(Arrays.toString(stringArray));
		
		//way-02
		Comparator<String> strComparator = new Comparator<String>() {
			@Override
			public int compare(String name1, String name2) {
				// return name1.compareTo(name2);
				return name2.compareTo(name1);
			}
		};
		
		Comparator<String> sortByNameCustomComparator = (String str1, String str2) -> str1.compareTo(str2);
		
		Arrays.sort(stringArray, strComparator);
		System.out.println("str arr === "+Arrays.toString(stringArray));
		
		Arrays.sort(stringArray, sortByNameCustomComparator);
		System.out.println("str arr === "+Arrays.toString(stringArray));
		
		
		//way-03
		Comparator<String> sortByLengthComparator = new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				return str1.compareTo(str2);
			}
		};

		Arrays.sort(stringArray, sortByLengthComparator);
		
	}
	
	
	
	/**
	 *  ################################################ Working with List Object ##########################################################################################################################################
	 * 
	 */
	
	
	
	
public static void sortIntegerList() {
		
		//############ int data type
		Comparator<Integer> customComparator1 = new Comparator<Integer>() {
			@Override
			public int compare(Integer num1, Integer num2) {
				return num1.compareTo(num2); // ascending
				// return num2.compareTo(num1); // descending
			}
		};

		Comparator<Integer> customComparator2 = (Integer num1, Integer num2) -> num1.compareTo(num2); // ascending
		Comparator<Integer> customComparator3 = (Integer num1, Integer num2) -> num2.compareTo(num1); // descending
		
		integerList.sort(customComparator1);
		integerList.sort(Comparator.naturalOrder());
		integerList.forEach((name) -> System.out.print(name + " "));

		System.out.println();
		integerList.sort(customComparator2);
		System.out.print(integerList + " ");

		System.out.println();
		integerList.sort(customComparator3);
		System.out.println(integerList);
		
		Collections.sort(integerList); // default sort
		System.out.println(integerList);
		
		Collections.sort(integerList); // default sort
		System.out.println(integerList);
		
		Collections.sort(integerList,customComparator1); // default sort
		System.out.println(integerList);
		
		Collections.sort(integerList,customComparator2); // default sort
		System.out.println(integerList);
		
		Collections.sort(integerList,customComparator3); // default sort
		System.out.println(integerList);
		
		
		//############ float data type
		Comparator<Float> customComparator01 = new Comparator<Float>() {
			@Override
			public int compare(Float num1, Float num2) {
				return num1.compareTo(num2); // ascending
				// return num2.compareTo(num1); // descending
			}
		};

		Comparator<Float> customComparator02 = (Float num1, Float num2) -> num1.compareTo(num2); // ascending
		Comparator<Float> customComparator03 = (Float num1, Float num2) -> num2.compareTo(num1); // descending
		
		
		floatlist.sort(customComparator01);
		floatlist.forEach((name) -> System.out.print(name + " "));

		System.out.println();
		floatlist.sort(customComparator02);
		System.out.print(floatlist + " ");

		System.out.println();
		floatlist.sort(customComparator03);
		System.out.println(floatlist);
		
		Collections.sort(floatlist); // default sort
		System.out.println(floatlist);
		
		Collections.sort(floatlist); // default sort
		System.out.println(floatlist);
		
		Collections.sort(floatlist,customComparator01); // default sort
		System.out.println(floatlist);
		
		Collections.sort(floatlist,customComparator02); // default sort
		System.out.println(floatlist);
		
		Collections.sort(floatlist,customComparator03); // default sort
		System.out.println(floatlist);
		
		
	}
	
	
	
	private static void convertAnyArrayToSet() {
		
		//List<Integer> list = Arrays.asList(intArray); //CE
		List<Integer> list = Arrays.asList(integerArray);
		Set<Integer> set = new HashSet<>(list);
		System.out.println(set);
	}

	

	public static void parallelSortAnyArray() {

		Arrays.parallelSort(intArray);
		Arrays.stream(intArray).forEach(item -> System.out.print(item + " "));

		System.out.println();

		Arrays.parallelSort(floatArrayPrimitiveType);
		// Arrays.parallelSort(floatArr, 1, 4);
		System.out.println(Arrays.toString(floatArrayPrimitiveType));

		// Arrays.stream(floatArray).forEach(n -> System.out.print(n + " ")); //CE

		Arrays.parallelSort(stringArray);
		System.out.println(Arrays.toString(stringArray));

		Arrays.parallelSort(stringArray, Collections.reverseOrder());
		System.out.println(Arrays.toString(stringArray));
	}

	public static void namesStartingWithSpecificCharInStringArray() {
		Arrays.stream(stringArray).filter(str -> str.startsWith("A")).forEach(System.out::println);
		Arrays.stream(stringArray).filter(s -> s.startsWith("A")).sorted().forEach(System.out::println);
		Arrays.stream(stringArray).map(String::toUpperCase).filter(s -> s.startsWith("A")).forEach(System.out::println);
		Arrays.stream(stringArray).map(String::toLowerCase).filter(s -> s.startsWith("p")).forEach(System.out::println);
		Arrays.stream(stringArray).map(String::toLowerCase).filter(s -> s.length() == 5).forEach(System.out::println);
	
	}
	
	public static void namesStartingWithSpecificCharInStringList() {
		
		stringList.stream().filter(str -> str.startsWith("A")).forEach(System.out::println);
		stringList.stream().filter(s -> s.startsWith("A")).sorted().forEach(System.out::println);
		stringList.stream().map(String::toUpperCase).filter(s -> s.startsWith("A")).forEach(System.out::println);
		stringList.stream().map(String::toLowerCase).filter(s -> s.startsWith("p")).forEach(System.out::println);
		stringList.stream().map(String::toLowerCase).filter(s -> s.length() == 5).forEach(System.out::println);
		
	}

	public static void convertStringToCharArray() {
		String str = "password123";
		char[] charArray = str.toCharArray();
		for (char ch : charArray) {
			System.out.print(ch + " ");
		}
	}

	public static void sortContentOfFile() throws IOException {

		// sorting the content of the file.
		Stream<String> names = Files.lines(Paths.get("states.txt"));
		names.sorted().filter(x -> x.length() > 30).forEach(System.out::println);
		names.close();

		Stream<String> names2 = Files.lines(Paths.get("names.txt"));
		names2.sorted().filter(x -> x.contains("punya")).collect(Collectors.toList()).forEach(System.out::println);
		names2.close();

		Stream<String> names3 = Files.lines(Paths.get("csvfile.txt"));
		int count = (int) names3.map(x -> x.split(",")).filter(x -> x.length == 3).count();
		System.out.println(count);
		names3.close();

	}
	
private static void countNoOfOccurancesOfEachItemInArrayOrList() {
		
		//Integer array as input
		List<Integer> intlist1 = Arrays.asList(integerArray);
		Set<Integer> set1 = new HashSet<Integer>(intlist1);
		for (Integer num : set1)
			System.out.println(num + ": " + Collections.frequency(intlist1, num));

		System.out.println();

		//Integer list as input
		Set<Integer> set = new HashSet<Integer>(integerList);
		for (Integer num : set)
			System.out.println(num + ": " + Collections.frequency(integerList, num));

		System.out.println();

		//string list as input
		Set<String> set2 = new HashSet<>(stringList);
		for (String name : set2)
			System.out.println(name + ": " + Collections.frequency(stringList, name));
	}

	
	/**
	 * *********************************************************************************************************
	 * Using Map
	 * *********************************************************************************************************
	 */
	
	
	public static void sortMapByKeys() {
		
		System.out.println("Original map ...");
		System.out.println(unsortedMap);
	
		// sort by keys, a,b,c..., and return a new LinkedHashMap
		// toMap() will returns HashMap by default, we need LinkedHashMap to
		// keep the order.
		Map<String, Integer> resultMap = unsortedMap.entrySet()
												.stream()
												.sorted(Map.Entry.comparingByKey())
												.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,LinkedHashMap::new));
		System.out.println("Sorted based on key in asc...");
		System.out.println(resultMap);
		
	}
	
	
	public static void sortMapByValues() {
		
		//way-01
		System.out.println("Sorted based on values in desc order...");
		Map<String, Integer> result2 = unsortedMap.entrySet().stream()
															.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
															.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		
		System.out.println(result2);
		
		//way-02
		// sorting by values- Alternative way
		System.out.println("Sorted based on values in desc order...");
		Map<String, Integer> resultMap = new LinkedHashMap<>();
		Comparator<Map.Entry<String, Integer>> c = Map.Entry.<String, Integer> comparingByValue().reversed();
		unsortedMap.entrySet()
							.stream()
							.sorted(c)
							.forEachOrdered(x -> resultMap.put(x.getKey(), x.getValue()));
		System.out.println(resultMap);
		
	}
	
public static void using_skip() {
		
		// using skip
		BinaryOperator<Integer> bi = (x, y) -> x + y;
		int skip = integerList.stream().skip(3).reduce(0, bi);
		System.out.println(skip);
		
	}
	
	
	public static void using_anymatch_allmatch() {
		
		// allMatch, anyMatch example
		boolean b = integerList.stream().allMatch(num -> num > 2);
		System.out.println(b);

		boolean b2 = integerList.stream().anyMatch(num -> num > 2);
		System.out.println(b2);
		
	}
	
	public static void using_limit() {
		
		// using limit
		integerList.stream().limit(2).forEach(System.out::println); //1,2

		System.out.println();
		// using with limit with reduce to find sum.
		int sum = integerList.stream().limit(3).reduce(0, (x, y) -> x + y);
		System.out.println("sum="+sum); //6 = 1+2+3
	}
	
	
	
	public static void boxing_unboxing_stream() {
		
		// boxing with stream - for converting primitive type to wrapper type.
		List<Integer> afterBoxing = IntStream.rangeClosed(1, 50) // primitive type
				.boxed() // wrapper class type
				.collect(Collectors.toList());
		System.out.println(afterBoxing);

		// un boxing with stream - 
		double doubleRes = IntStream.rangeClosed(1, 50) // primitive type
				.mapToDouble(x -> x) // wrapper type
				// or
				// .mapToObject(x -> x)
				.sum();
		System.out.println(doubleRes);
		
		
		int sumRes = integerList.stream().mapToInt(Integer::intValue).sum();
		System.out.println(sumRes);

	}
	
	public static void convertingListToStream() {
		
		// using IntStream
		IntStream obj = IntStream.rangeClosed(1, 6);
		obj.forEach(System.out::println);
		//System.out.println(obj.sum());

		IntStream obj2 = IntStream.range(1, 6);
		obj2.forEach(System.out::println);
		//System.out.println(obj2.sum());

		OptionalInt max = IntStream.rangeClosed(1, 50).max();
		System.out.println(max.getAsInt());

		// using LongStream
		LongStream obj3 = LongStream.rangeClosed(1, 6);
		obj3.forEach(System.out::println);
		//System.out.println(obj3.sum());

		OptionalLong max2 = LongStream.rangeClosed(1, 50).max();
		System.out.println(max2.getAsLong());

		OptionalDouble avg = LongStream.rangeClosed(1, 50).average();
		System.out.println(avg);

		// Retrieving the list
		for (String name : namesList)
			System.out.print(name);

		System.out.println();
		namesList.forEach(System.out::print);

		System.out.println();
		// converting list to stream
		Stream<String> stream1 = namesList.stream();
		stream1.forEach(name -> System.out.print(name));
		// stream1.forEach(name -> System.out.println(name));

		// ########## stream map example ##########
		System.out.println();
		List<Integer> nameLength = namesList.stream().map(String::length).collect(Collectors.toList());
		System.out.print(nameLength);

		// OR

		namesList.stream().map(String::length).collect(Collectors.toList()).forEach(System.out::println);

		// ########## flatmap demo ##########
		List<Integer> oddNums = Arrays.asList(1, 3, 5, 7);
		List<Integer> evenNums = Arrays.asList(2, 4, 6, 8);

		List<List<Integer>> listOfList = Arrays.asList(oddNums, evenNums);
		System.out.println(listOfList); // [[1, 3, 5, 7], [2, 4, 6, 8]]

		// converting to flat list
		Set<Integer> flatenList = listOfList.stream().flatMap(List::stream).sorted().collect(Collectors.toSet());
		System.out.println(flatenList); // [1, 2, 3, 4, 5, 6, 7, 8]

		// ########## filter demo ##########
		namesList.stream().filter(name -> name.length() > 3).forEach(System.out::print);
		System.out.println();
		namesList.stream().filter(name -> name.length() > 3).collect(Collectors.toList()).forEach(System.out::print);

		// ########## reduce demo ##########
		List<Integer> numsList = Arrays.asList(1, 2, 4, -5, 9);

		// counting
		int sum = numsList.stream().mapToInt(i -> 1).sum();
		System.out.println(sum); // 5

		// how many are -ve nos
		int cnt = (int) numsList.stream().filter(i -> i < 0).count();
		System.out.println("cnt=" + cnt); // 1

		// counting total items
		Long count = numsList.stream().mapToInt(i -> 1).count();
		System.out.println(count); // 5

		// evaluating the summation
		System.out.println(numsList.stream().reduce(0, (a, b) -> a + b)); // 11
		System.out.println(numsList.stream().reduce(1, (a, b) -> a * b)); // -360

	}

	public static void removeDuplicateItemsfromList() {
		

		String AfeterConcatinatingnames = namesList.stream().reduce("", (a, b) -> a.concat(b));
		System.out.println(AfeterConcatinatingnames);

		// ########################################################################################
		// Before java-8
		List<String> uniqueNames = new ArrayList<>();
		for (String name : namesList) {
			if (!uniqueNames.contains(name))
				uniqueNames.add(name);
		}
		System.out.println(uniqueNames);

		// using java-8
		List<String> uniqueName2 = namesList.stream().distinct().collect(Collectors.toList());
		System.out.println(uniqueName2);

		// using java-8
		List<Integer> numList2 = integerList.stream().distinct().collect(Collectors.toList());
		System.out.println(numList2);

	}

	public static void sortingTheList() {

		// sorting in asc
		integerList.sort(null);
		System.out.println(integerList);

		// sorting in desc
		integerList.sort(Collections.reverseOrder());
		System.out.println(integerList);

		// sorting in asc
		Collections.sort(namesList, String::compareToIgnoreCase);
		System.out.println(namesList);

		// sorting in desc
		Collections.sort(namesList, Collections.reverseOrder());
		System.out.println(namesList);

		// sorting in asc
		List<String> result = namesList.stream().sorted(Comparator.comparing(name -> name.toString()))
				.collect(Collectors.toList());
		System.out.println(result);

		// sorting in desc
		List<String> result2 = namesList.stream().sorted(Comparator.comparing(name -> name.toString()).reversed()).collect(Collectors.toList());
		System.out.println(result2);

	}


	/**
	 * *********************************************************************************************************
	 * Using Custom DTO 
	 * *********************************************************************************************************
	 */
	
	public static void sortEmployeeById() {

		Comparator<Employee> sortByIdComparator = new Comparator<Employee>() {
			@Override
			public int compare(Employee emp1, Employee emp2) {
				return emp1.getId().compareTo(emp2.getId());
				// return emp1.getId() - emp2.getId();
			}
		};

		// Comparator<Employee> sortByIdComparator2 = (Employee emp1, Employee emp2) ->
		// emp1.getId().compareTo(emp2.getId()); //OK
		// Comparator<Employee> sortByIdComparator3 = (Employee emp1, Employee emp2) ->
		// emp1.getId() - emp2.getId(); //Ok

		employeeList.sort(sortByIdComparator);
		employeeList.forEach(System.out::println);
		// OR
		Collections.sort(employeeList, sortByIdComparator);
		employeeList.forEach(System.out::println);
		// or
		employeeList.stream().sorted(sortByIdComparator).collect(Collectors.toList()).forEach(System.out::println);
	}

	public static void sortEmployeeByName() {

		Comparator<Employee> sortByNameComparator = new Comparator<Employee>() {
			@Override
			public int compare(Employee e1, Employee e2) {
				return e1.getName().compareTo(e2.getName());
			}
		};

		Comparator<Employee> sortByNameComparator1 = (Employee e1, Employee e2) -> e1.getName().compareTo(e2.getName());
		Comparator<Employee> sortByNameComparator2 = (e1, e2) -> e1.getName().compareTo(e2.getName());

		employeeList.sort(sortByNameComparator);
		employeeList.forEach(System.out::println);
		// OR
		Collections.sort(employeeList, sortByNameComparator1);
		employeeList.forEach(System.out::println);
		// or
		employeeList.stream().sorted(sortByNameComparator2).collect(Collectors.toList()).forEach(System.out::println);

	}

	public static void sortEmployeeByAge() {

		// way-01 , using jdk7
		Comparator<Employee> sortByAgeComparator1 = new Comparator<Employee>() {
			@Override
			public int compare(Employee emp1, Employee emp2) {
				return (int) (emp1.getAge() - emp2.getAge());
			}
		};

		// using jdk8
		Comparator<Employee> sortByAgeComparator2 = (Employee e1, Employee e2) -> e1.getAge() - e2.getAge();
		Comparator<Employee> sortByAgeComparator3 = (e1, e2) -> e1.getAge().compareTo(e2.getAge());

		employeeList.sort(sortByAgeComparator1);
		employeeList.forEach(System.out::println);
		// OR
		// way-02 , using jdk7
		Collections.sort(employeeList, sortByAgeComparator2);
		employeeList.forEach(System.out::println);
		// or
		// way-03 , using jdk8
		employeeList.sort(sortByAgeComparator3);
		employeeList.forEach(System.out::println);
		// OR
		// way-04 , using jdk8
		employeeList.stream().sorted(sortByAgeComparator3).collect(Collectors.toList()).forEach(System.out::println);

	}

	public static void sortEmployeeBySalary() {

		Comparator<Employee> sortBySalComparator1 = new Comparator<Employee>() {
			@Override
			public int compare(Employee emp1, Employee emp2) {
				return (int) (emp1.getSalary() - emp2.getSalary());
			}
		};

		Comparator<Employee> sortBySalComparator2 = (Employee e1, Employee e2) -> e1.getSalary().compareTo(e2.getSalary());

		employeeList.sort(sortBySalComparator1);
		// employeeList.sort(sortBySalComparator);
		employeeList.forEach(System.out::println);
		// OR
		Collections.sort(employeeList, sortBySalComparator1);
		employeeList.forEach(System.out::println);
		// OR
		Collections.sort(employeeList, sortBySalComparator2);
		employeeList.forEach(System.out::println);
	}

	public static void sortEmployeeBySalaryUsingJava8() {

		Comparator<Employee> sortByAgeComparator = (e1, e2) -> e1.getAge().compareTo(e2.getAge());
		Comparator<Employee> sortBySalComparator = (Employee e1, Employee e2) -> e1.getSalary().compareTo(e2.getSalary());

		employeeList.sort(sortBySalComparator);
		employeeList.forEach(System.out::println);
		// OR
		Collections.sort(employeeList, sortBySalComparator);
		employeeList.forEach(System.out::println);
		// or
		employeeList.stream().sorted(sortByAgeComparator).collect(Collectors.toList()).forEach(System.out::println);

	}

	public static void convertEmplpoyeeListToMap() {

		Comparator<Employee> sortBySalaryComparator = Comparator.comparingDouble(Employee::getSalary);
		Map<String, Double> result1 = employeeList.stream().sorted(sortBySalaryComparator).collect(Collectors.toMap(Employee::getName, Employee::getSalary, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		System.out.println(" After sorting based on salary in desc : " + result1);

	}

	public static void sortUsers() {

		// Lambda expression for sorting by score
		Comparator<User> c = (User user1, User user2) -> user1.getScore() - user2.getScore();
		usersList.sort(c);
		usersList.forEach((user) -> System.out.println(user));

		// sorting in asc
		List<User> sortedUsersInAsc = usersList.stream().sorted(Comparator.comparing(User::getScore)).collect(Collectors.toList());
		sortedUsersInAsc.forEach(System.out::print);

		// sorting in desc order
		System.out.println();
		List<User> sortedUsersInDesc2 = usersList.stream().sorted(Comparator.comparing(User::getScore).reversed()).collect(Collectors.toList());
		sortedUsersInDesc2.forEach(System.out::print);

		// sorting in asc
		Collections.sort(usersList, Comparator.comparingDouble((User user) -> user.getScore()));
		System.out.println(usersList);

	}
}
