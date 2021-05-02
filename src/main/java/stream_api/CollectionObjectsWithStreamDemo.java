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

		
	// primitive type array
	private static byte[] byteArrayPrimitiveType = { 10, 5, -44, -99, 47, 19, -35 };
	//private static byte[] byteArrayPrimitiveType2 = new byte[]{ 10, 5, -44, -99, 47, 19, -35 }; //OK
	private static short[] shortArrayPrimitiveType = { 10, 5, -44, -99, 47, 198, -35 };
	//private static short[] shortArrayPrimitiveType2 = new short[]{ 10, 5, -44, -99, 47, 198, -35 }; //OK
	private static int[] intArrayPrimitiveType = { 1, 2, 3, 4, 15, 6, 7, 8, 9, 10 };
	//private static int[] intArrayPrimitiveType = new int[] { 1, 34, 78, 90, 27, 45 }; //OK
	private static long[] longArrayPrimitiveType = { 1, 34, 78, 90, 27, 45 }; //OK
	//private static long[] longArrayPrimitiveType2 = new long[] { 1, 34, 78, 90, 27, 45 };
	private static float[] floatArrayPrimitiveType = { 1.5f, 34.8f, 78.2f, 90.0f, 27.78f, 45.31f }; //OK
	//private static float[] floatArrayPrimitiveType2 = new float[] { 1.5f, 34.8f, 78.2f, 90.0f, 27.78f, 45.31f };
	private static double[] doubleArrayPrimitiveType = { 10.6d, 5.8d, -44.7d, -99.1d, 47.4d, 198.9d, -35.7f };
	//private static double[] doubleArrayPrimitive = new double[] { 1, 34, 78, 90, 27, 45 }; //Ok
	private static char[] charArrayPrimitiveType = { 'a', 'm', 'y', 'u' };
	//private static char[] charArrayPrimitiveType2 = new char[] { 'a', 'm', 'y', 'u' }; //OK
	
	//wrapper type array
	private static Byte[] byteArrayWrapperType = { 10, 5, -44, -99, 47, 19, -35 };
	//private static Byte[] byteArrayWrapperType2 = new Byte[]{ 10, 5, -44, -99, 47, 19, -35 }; //OK
	private static Short[] shortArrayWrapperType = { 10, 5, -44, -99, 47, 198, -35 };
	//private static Short[] shortArrayWrapperType2 = new Short[]{ 10, 5, -44, -99, 47, 198, -35 }; //OK
	private static Integer[] integerArrayWrapperType = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	//private static Integer[] integerArrayWrapperType2 = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };//OK
	private static Long[] longArrayWrapperType =  { 1l, 34l, 78l, 90l, 27l, 45l };
	//private static Long[] longArrayWrapperType2 = new Long[] { 1l, 34l, 78l, 90l, 27l, 45l }; //OK
	private static Float[] floatArrayWrapperType = { 1.5f, 34.8f, 78.2f, 90.0f, 27.78f, 45.31f };
	//private static Float[] floatArrayWrapperType2 = new Float[] { 1.5f, 34.8f, 78.2f, 90.0f, 27.78f, 45.31f }; //OK
	private static Double[] doubleArrayWrapperType =  { 1d, 34d, 78d, 90d, 27d, 45d };
	//private static Double[] doubleArrayWrapperType2 = new Double[] { 1d, 34d, 78d, 90d, 27d, 45d }; //OK
	private static Character[] charArrayWrapperType = { 'a', 'm', 'y', 'u' };
	// private static Character[] charArrayWrapperType2 = new Character[] { 'a', 'm', 'y', 'u' }; //OK
	private static String[] stringArray = { "punya", "Partha", "Aswini", "punya","Arabind" };
	//private static String[] stringArray2 = new String[]{ "punya", "Partha", "Aswini", "punya","Arabind" }; //Ok
	
	//List type data
	//private static List<Byte> byteList = Arrays.asList(1, 34, 78, 90, 27, 45); //CE
	//private static List<Short> shortList = Arrays.asList(1, 34, 78, 90, 27, 45); //CE
	//private static List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5); //OK
	private static List<Integer> integerList = Arrays.asList(integerArrayWrapperType);
	private static List<Long> longlist = Arrays.asList(longArrayWrapperType);
	private static List<Float> floatlist = Arrays.asList(floatArrayWrapperType);
	private static List<Double> doublelist = Arrays.asList(doubleArrayWrapperType);
	private static List<Character> charlist = Arrays.asList(charArrayWrapperType);
	private static List<String> stringList = Arrays.asList(stringArray);
	//private static List<String> stringList = Arrays.asList("punya", "punyasmruti","pankaj kumar", "aswini k ssingh", "parthasarathi");
	//private static List<String> namesList = Arrays.asList("punya", "kishore", "sai", "aswini");
	
	private static List<User> usersList = Arrays.asList(new User(19), new User(67), new User(50), new User(91));
	private static List<Employee> employeeList = Arrays.asList(new Employee(1, "Shifoo", "acc1", "IT", 25, 150000d),new Employee(2, "Punya", "acc2", "IT", 40, 250000d));
	
	//set type data
	//private static Set<Byte> byteSet = new HashSet(byteList); //CE
	private static Set<Integer> integerSet = new HashSet<>(integerList);
	private static Set<Long> longSet = new HashSet<>(longlist);
	private static Set<Float> floatSet = new HashSet<>(floatlist);
	private static Set<Double> doubleSet = new HashSet<>(doublelist);
	private static Set<Character> charSet = new HashSet<>(charlist);
	private static Set<String> stringSet = new HashSet<>(stringList);
	private static Set<Employee> employeeSet = new HashSet<>(employeeList);
	
	//map type data
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
		convertArrayToStream();
		find_max_min_sum_avg_From_any_Array();
		
		sortAnyArray();
		parallelSortAnyArray();
		
		countNoOfOccurancesOfEachItemInArrayOrList();
		
		sortStringArrayBasedOnStringValue();
		sortStringAtrrayBasedOnStringLength();
		
		removeDuplicateItemsFromWrapperArray();
		countNoOfOccurancesOfPerticularItemInArray();
		countNoOfOccurancesOfEachItemInArray();
		countNoOfOccurancesOfEachItemwithRangeInArray();
		
		convertStringToCharArray();
		convertArrayToList();
		convertAnyArrayToSet();
		namesStartingWithSpecificCharInStringArray();
		namesStartingWithSpecificCharInStringList();
		//sortContentOfFile();
		
		using_intstream();
		
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
	
	private static void using_intstream() {
		
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
	}
	
	private static void convertArrayToStream() {
		
		/**
		 * way-01
		 * using stream.of(any primitive/wrapper type array)
		 */

		//display all items of the array using stream
		
		Stream<byte[]> stream0001 = Stream.of(byteArrayPrimitiveType);
		stream0001.forEach(System.out::println);
		stream0001.forEach(item -> System.out.print(item+" "));
		
		Stream.of(byteArrayPrimitiveType).forEach(System.out::print);
		
		
		Stream<short[]> stream03 = Stream.of(shortArrayPrimitiveType);
		stream03.forEach(System.out::println);
		stream03.forEach(item -> System.out.print(item+" "));
		
		Stream.of(shortArrayPrimitiveType).forEach(System.out::print);
		
		Stream<Integer> stream2 = Stream.of(1, 2, 3, 44, 5);
		stream2.forEach(item -> System.out.print(item+" "));
		
		Stream<int[]> stream001 = Stream.of(intArrayPrimitiveType);
		stream001.forEach(item -> System.out.print(item+" "));
		
		Stream.of(intArrayPrimitiveType).forEach(System.out::print);
		
		Stream<int[]> stream05 = Stream.of(intArrayPrimitiveType);
		stream05.forEach(System.out::println);
		
		Stream<long[]> stream30 = Stream.of(longArrayPrimitiveType);
		stream30.forEach(item -> System.out.print(item+" "));
		
		Stream.of(longArrayPrimitiveType).forEachOrdered(System.out::print);
		
		Stream<float[]> stream31 = Stream.of(floatArrayPrimitiveType);
		stream31.forEach(item -> System.out.print(item+" "));
		
		Stream.of(floatArrayPrimitiveType).forEachOrdered(System.out::print);
		
		Stream<double[]> stream32 = Stream.of(doubleArrayPrimitiveType);
		stream32.forEach(item -> System.out.print(item+" "));
		
		Stream.of(doubleArrayPrimitiveType).forEachOrdered(System.out::print);
		
		Stream<Byte> stream41 = Stream.of(byteArrayWrapperType);
		stream41.forEach(item -> System.out.print(item + " "));
		
		Stream.of(byteArrayWrapperType).forEachOrdered(System.out::print);
		
		Stream<Short> stream42 = Stream.of(shortArrayWrapperType);
		stream42.forEach(item -> System.out.print(item + " "));
		
		Stream<Short> stream04 = Stream.of(shortArrayWrapperType);
		stream04.forEach(System.out::println);
		
		Stream.of(shortArrayWrapperType).forEachOrdered(System.out::print);
		
		Stream<Integer> stream3 = Stream.of(new Integer[] { 1, 2, 33, 4, 5 });
		stream3.forEach(item -> System.out.print(item+" "));
		
		Stream<Integer> stream1 = Stream.of(integerArrayWrapperType);
		stream1.forEach(item -> System.out.print(item + " "));
		
		Stream<Integer> stream06 = Stream.of(integerArrayWrapperType);
		stream06.forEach(System.out::println);
		
		Stream.of(integerArrayWrapperType).forEachOrdered(System.out::print);
		
		Stream<Long> stream43 = Stream.of(longArrayWrapperType);
		stream43.forEach(item -> System.out.print(item + " "));
		
		Stream.of(longArrayWrapperType).forEachOrdered(System.out::print);
		
		Stream<Float> stream44 = Stream.of(floatArrayWrapperType);
		stream44.forEach(item -> System.out.print(item + " "));
		
		Stream.of(floatArrayWrapperType).forEachOrdered(System.out::print);
		
		Stream<Double> stream45 = Stream.of(doubleArrayWrapperType);
		stream45.forEach(item -> System.out.print(item + " "));
		
		Stream.of(doubleArrayWrapperType).forEachOrdered(System.out::print);
				

		System.out.println();
		Stream<String> stream4 = Stream.of(stringArray);
		stream4.forEach(x -> System.out.print(x+" "));
		
		
		/**
		 * Way-02, 
		 * using Arrays.stream(intArrayPrimitiveType/longArrayPrimitiveType/doubleArrayPrimitiveType/anyWrapperTypeArray)
		 */

		// Arrays.stream(byteArrayPrimitiveType).forEach(System.out::print);//CE
		 Arrays.stream(byteArrayWrapperType).forEach(System.out::print);
		 
		// Arrays.stream(shortArrayPrimitiveType).forEach(System.out::print);//CE
		 Arrays.stream(shortArrayWrapperType).forEach(System.out::print);
		
		//display all items
		System.out.println();
		IntStream stream5 = Arrays.stream(intArrayPrimitiveType);
		stream5.forEach(item -> System.out.print(item + " "));
		
		//display all items
		System.out.println();
		List<Integer> list2 = Arrays.stream(intArrayPrimitiveType).boxed().collect(Collectors.toList());
		System.out.println("list2 : " + list2);

		//display all items
		System.out.println();
		List<Integer> list = IntStream.of(intArrayPrimitiveType).boxed().collect(Collectors.toList());
		System.out.println(list);


		//find sum of all items in the array
		int r = Arrays.stream(intArrayPrimitiveType).map(Integer :: new).sum();
		System.out.println(r);
		
		IntStream intStream = Arrays.stream(intArrayPrimitiveType);
		//IntStream s = Arrays.stream(integerArray);//CE
		intStream.forEach(System.out::println);
		//s.forEachOrdered(System.out::println);
		
		Arrays.stream(intArrayPrimitiveType).forEach(System.out::print);
		//Arrays.stream(intArray,2,3).forEach(System.out::print);
		
		Arrays.stream(integerArrayWrapperType).forEach(System.out::print);
		
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
		
		System.out.println();
		Stream<String> stream6 = Arrays.stream(stringArray);
		stream6.forEach(str -> System.out.println(str));

		System.out.println();
		Arrays.stream(stringArray).forEach(n -> System.out.print(n + " "));
		
		System.out.println();
		Arrays.stream(stringArray, 2, 4).forEach(n -> System.out.print(n + " "));
		
		//with sorting
		System.out.println();
		Arrays.stream(stringArray).sorted().forEach(n -> System.out.print(n + " "));
		
		//with sorting and skip
		System.out.println();
		Arrays.stream(stringArray).sorted().skip(2).forEach(n -> System.out.print(n + " "));
		
		//with sorting
		System.out.println();
		List<String> listt = Arrays.stream(stringArray).sorted().collect(Collectors.toList());
		System.out.println(listt);

		//displays strings having more than 3 chars
		System.out.println();
		Arrays.stream(stringArray).filter(str -> str.length() > 3).forEach(n -> System.out.print(n + " "));
				
	}
	

	private static void sortAnyArray() {
		
		
		// way-01 , sorting byte array in ascending order
		Arrays.sort(byteArrayPrimitiveType);
		System.out.println("byte arr after sort:" + Arrays.toString(byteArrayPrimitiveType));
		
		Stream.of(byteArrayPrimitiveType).sorted().forEach(System.out::println);;

		Arrays.sort(byteArrayWrapperType);
		System.out.println("byte arr after sort:" + Arrays.toString(byteArrayWrapperType));
		
		Stream.of(byteArrayWrapperType).sorted().forEach(System.out::println);;
		
		//way-02
		Comparator<Byte> byteComparator1 = new Comparator<Byte>() {
			@Override
			public int compare(Byte i1, Byte i2) {
				return i2.compareTo(i1);
			}
		};
		
		Comparator<Byte> byteComparator2 = (Byte num1, Byte num2) -> num1.compareTo(num2); // ascending
		Comparator<Byte> byteComparator3 = (Byte num1, Byte num2) -> num2.compareTo(num1); // descending
		
		// Arrays.sort(byteArrayPrimitiveType, byteComparator1); //CE
		Arrays.sort(byteArrayWrapperType, byteComparator1);
		System.out.println("byte arr ===>" + Arrays.toString(byteArrayWrapperType));
		
		//Arrays.stream(byteArrayPrimitiveType).sorted(); //CE
		Arrays.stream(byteArrayWrapperType).sorted().forEach(System.out::println);
		Arrays.stream(byteArrayWrapperType).sorted().distinct().forEach(System.out::println);
		
		//way-03
		
		Stream.of(byteArrayWrapperType).sorted().forEach(System.out::println);;
		Stream.of(byteArrayWrapperType).sorted(byteComparator1).forEach(System.out::println);;
		Stream.of(byteArrayWrapperType).sorted(byteComparator2).forEach(System.out::println);;
		Stream.of(byteArrayWrapperType).sorted(byteComparator3).forEach(System.out::println);;
				
		//****************************************************************************
		
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

		//****************************************************************************
		
		Arrays.sort(intArrayPrimitiveType); // default sort
		System.out.println(Arrays.toString(intArrayPrimitiveType));
		
		// default sorting
		Arrays.stream(intArrayPrimitiveType).sorted().forEach(System.out::println);

		// default sorting with unique items
		Arrays.stream(intArrayPrimitiveType).sorted().distinct().forEach(System.out::println);
		
		// find largest item
		System.out.println();
		Stream.of(integerArrayWrapperType).sorted().findFirst().ifPresent(System.out::println);

		Arrays.sort(integerArrayWrapperType); // default sort
		System.out.println(Arrays.toString(integerArrayWrapperType));
		
		Collections.sort(Arrays.asList(integerArrayWrapperType)); // default sort
		System.out.println(Arrays.toString(integerArrayWrapperType));
		
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
		Arrays.sort(integerArrayWrapperType, customComparator1);
		System.out.println(Arrays.toString(integerArrayWrapperType));
		
		//Collections.sort(Arrays.asList(integerArray), customComparator1 / customComparator2 / customComparator3);
		Collections.sort(Arrays.asList(integerArrayWrapperType), customComparator1);
		System.out.println(Arrays.toString(integerArrayWrapperType));
		
		//display first item after sorting
		System.out.println();
		Stream.of(stringArray).sorted().findFirst().ifPresent(System.out::println);
		
		//****************************************************************************
		Arrays.sort(intArrayPrimitiveType);
		System.out.println(Arrays.toString(intArrayPrimitiveType));

		Arrays.sort(integerArrayWrapperType);
		System.out.println(Arrays.toString(integerArrayWrapperType));
		
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
		
		Arrays.sort(integerArrayWrapperType);
		System.out.println("int array == "+Arrays.toString(integerArrayWrapperType));
		Arrays.sort(integerArrayWrapperType, intComparator1);
		System.out.println("int array == "+Arrays.toString(integerArrayWrapperType));
		Arrays.sort(integerArrayWrapperType, intComparator2);
		System.out.println("int array == "+Arrays.toString(integerArrayWrapperType));
		Arrays.sort(integerArrayWrapperType, intComparator3);
		System.out.println("int array == "+Arrays.toString(integerArrayWrapperType));
		
		Arrays.stream(intArrayPrimitiveType).sorted().forEach(System.out::println);
		Arrays.stream(intArrayPrimitiveType).sorted().distinct().forEach(System.out::println);
		Arrays.stream(integerArrayWrapperType).sorted().forEach(System.out::println);
		Arrays.stream(integerArrayWrapperType).sorted().distinct().forEach(System.out::println);
		Arrays.stream(integerArrayWrapperType).sorted(intComparator1).distinct().forEach(System.out::println);
		Arrays.stream(integerArrayWrapperType).sorted(intComparator2).distinct().forEach(System.out::println);
		Arrays.stream(integerArrayWrapperType).sorted(intComparator3).distinct().forEach(System.out::println);
		
		Stream.of(intArrayPrimitiveType).sorted().forEach(System.out::println);
		Stream.of(integerArrayWrapperType).sorted(intComparator1).forEach(System.out::println);
		Stream.of(integerArrayWrapperType).sorted(intComparator2).forEach(System.out::println);
		Stream.of(integerArrayWrapperType).sorted(intComparator3).forEach(System.out::println);
		
		
		
		//****************************************************************************
		
		Arrays.sort(longArrayPrimitiveType); // default sort
		System.out.println(Arrays.toString(longArrayPrimitiveType));
		
		Arrays.sort(longArrayWrapperType); // default sort
		System.out.println(Arrays.toString(longArrayWrapperType));
		
		Collections.sort(Arrays.asList(longArrayWrapperType)); // default sort
		System.out.println(Arrays.toString(longArrayWrapperType));
		
		//java7 comparator
		Comparator<Long> customComparator01 = new Comparator<Long>() {
			@Override
			public int compare(Long num1, Long num2) {
				return num1.compareTo(num2); // ascending
				// return num2.compareTo(num1); // descending
			}
		};

		//java8 comparator
		Comparator<Long> customComparator02 = (Long num1, Long num2) -> num1.compareTo(num2); // ascending
		Comparator<Long> customComparator03 = (Long num1, Long num2) -> num2.compareTo(num1); // descending
				
		//Arrays.sort(floatArrayWrapperType, customComparator01/customComparator02/customComparator03);
		Arrays.sort(longArrayWrapperType, customComparator01);
		System.out.println(Arrays.toString(longArrayWrapperType));
		
		//Collections.sort(Arrays.asList(floatArrayWrapperType), customComparator01)/customComparator02/customComparator03;
		Collections.sort(Arrays.asList(longArrayWrapperType), customComparator01);
		System.out.println(Arrays.toString(longArrayWrapperType));
		
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
		
		
		
		//****************************************************************************
		
		Arrays.sort(floatArrayPrimitiveType); // default sort
		System.out.println(Arrays.toString(floatArrayPrimitiveType));
		
		Arrays.sort(floatArrayWrapperType); // default sort
		System.out.println(Arrays.toString(floatArrayWrapperType));
		
		Collections.sort(Arrays.asList(floatArrayWrapperType)); // default sort
		System.out.println(Arrays.toString(floatArrayWrapperType));
		
		//java7 comparator
		Comparator<Float> floatComparator01 = new Comparator<Float>() {
			@Override
			public int compare(Float num1, Float num2) {
				return num1.compareTo(num2); // ascending
				// return num2.compareTo(num1); // descending
			}
		};

		//java8 comparator
		Comparator<Float> floatComparator02 = (Float num1, Float num2) -> num1.compareTo(num2); // ascending
		Comparator<Float> floatComparator03 = (Float num1, Float num2) -> num2.compareTo(num1); // descending
				
		//Arrays.sort(floatArrayWrapperType, customComparator01/customComparator02/customComparator03);
		Arrays.sort(floatArrayWrapperType, floatComparator01);
		System.out.println(Arrays.toString(floatArrayWrapperType));
		
		//Collections.sort(Arrays.asList(floatArrayWrapperType), customComparator01)/customComparator02/customComparator03;
		Collections.sort(Arrays.asList(floatArrayWrapperType), floatComparator01);
		System.out.println(Arrays.toString(floatArrayWrapperType));
		
		//****************************************************************************
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
		
		
		//****************************************************************************
		
		Arrays.sort(doubleArrayPrimitiveType); // default sort
		System.out.println(Arrays.toString(doubleArrayPrimitiveType));
		
		Arrays.sort(doubleArrayWrapperType); // default sort
		System.out.println(Arrays.toString(doubleArrayWrapperType));
		
		Collections.sort(Arrays.asList(doubleArrayWrapperType)); // default sort
		System.out.println(Arrays.toString(doubleArrayWrapperType));
		
		//java7 comparator
		Comparator<Double> doubleComparator01 = new Comparator<Double>() {
			@Override
			public int compare(Double num1, Double num2) {
				return num1.compareTo(num2); // ascending
				// return num2.compareTo(num1); // descending
			}
		};

		//java8 comparator
		Comparator<Double> doubleComparator02 = (Double num1, Double num2) -> num1.compareTo(num2); // ascending
		Comparator<Double> doubleComparator03 = (Double num1, Double num2) -> num2.compareTo(num1); // descending
				
		//Arrays.sort(floatArrayWrapperType, doubleComparator01/doubleComparator02/doubleComparator03);
		Arrays.sort(doubleArrayWrapperType, doubleComparator01);
		System.out.println(Arrays.toString(doubleArrayWrapperType));
		
		//Collections.sort(Arrays.asList(floatArrayWrapperType), customComparator01)/customComparator02/customComparator03;
		Collections.sort(Arrays.asList(doubleArrayWrapperType), doubleComparator01);
		System.out.println(Arrays.toString(doubleArrayWrapperType));
		
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
	
	
private static void find_max_min_sum_avg_From_any_Array() {
	
		//summation
		
	    int max1 = Arrays.stream(intArrayPrimitiveType).max().getAsInt();
		//int max = Arrays.stream(integerArray).max().getAsInt(); //CE
	    System.out.println(max1);
	    
	    int min1 = Arrays.stream(intArrayPrimitiveType).min().getAsInt();
	    // int min1 = Arrays.stream(integerArray).min().getAsInt(); //CE
	    System.out.println(min1);
	    
	    int sum =Arrays.stream(intArrayPrimitiveType).sum();
  	    System.out.println("sum="+sum);
  	    
  	    int sum2 = Arrays.stream(intArrayPrimitiveType).map(Integer :: new).sum();
  		System.out.println(sum2);
  	    
  	    OptionalDouble avg = Arrays.stream(intArrayPrimitiveType).average();
  	    System.out.println("avg="+avg.getAsDouble());
  		
  		int intResult = IntStream.rangeClosed(0, 50).map(Integer :: new).sum();
  		System.out.println("Int Result="+intResult);
	    
	   
	    long max2 = Arrays.stream(longArrayPrimitiveType).max().getAsLong();
		//long max2 = Arrays.stream(longArrayWrapperType).max().getAsLong(); //CE
	    System.out.println(max2);
	    
	    long min2 = Arrays.stream(longArrayPrimitiveType).min().getAsLong();
	   // long min2 = Arrays.stream(longArrayWrapperType).min().getAsLong(); //CE
	    System.out.println(min2);
	    
	    long sum4 =Arrays.stream(longArrayPrimitiveType).sum();
  	    System.out.println("sum="+sum4);
  	    
  	    long longResult = LongStream.rangeClosed(0, 50).map(Long :: new).sum();
  		System.out.println("Long Result="+longResult);
  		
  		OptionalDouble avg2 = Arrays.stream(longArrayPrimitiveType).average();
  	    System.out.println("avg2="+avg2.getAsDouble());
  	    
  	    double sum3 =Arrays.stream(doubleArrayPrimitiveType).sum();
  	    System.out.println("sum="+sum3);
  	    
  	    OptionalDouble avg3 = Arrays.stream(doubleArrayPrimitiveType).average();
  	    System.out.println("avg3="+avg3.getAsDouble());
	    
	    double max3 = Arrays.stream(doubleArrayPrimitiveType).max().getAsDouble();
		//double max3 = Arrays.stream(doubleArrayWrapperType).max().getAsDouble(); //CE
	    System.out.println(max3);
	    
	    double min3 = Arrays.stream(doubleArrayPrimitiveType).min().getAsDouble();
	    // double min3 = Arrays.stream(doubleArrayWrapperType).min().getAsDouble(); //CE
	    System.out.println(min3);
	    
	    
  		//double sumResult3 = DoubleStream.rangeClosed(0d, 50d).map(Double :: new).sum();
  		//System.out.println("Result="+sumResult3);
  		
	  	  //*****************************************************
		Comparator<Byte> byteComparatorAsc = (Byte num1, Byte num2) -> num1.compareTo(num2);
		Comparator<Byte> byteComparatorDesc = (Byte num1, Byte num2) -> num1.compareTo(num2);
		
		int max_byte = Arrays.stream(byteArrayWrapperType).max(byteComparatorAsc).get();
		//or
		//int max_byte = Arrays.asList(byteArrayWrapperType).stream().max(byteComparator).get();
		int min_byte = Arrays.stream(byteArrayWrapperType).max(byteComparatorDesc).get();
		
		System.out.println(max_byte);
		System.out.println(min_byte);
		
		Comparator<Short> shortComparatorAsc = (Short num1, Short num2) -> num1.compareTo(num2);
		Comparator<Short> shortComparatorDesc = (Short num1, Short num2) -> num1.compareTo(num2);
		
		int max_short = Arrays.stream(shortArrayWrapperType).max(shortComparatorAsc).get();
		//OR
		//int max_short = Arrays.asList(shortArrayWrapperType).stream().max(shortComparator).get();
		int min_short = Arrays.stream(shortArrayWrapperType).max(shortComparatorDesc).get();
		
		System.out.println(max_short);
		System.out.println(min_short);

		Comparator<Integer> intComparatorAsc = (Integer num1, Integer num2) -> num1.compareTo(num2); // ascending
		Comparator<Integer> intComparatorDesc = (Integer num1, Integer num2) -> num2.compareTo(num1); // ascending
		
		int max_int = Arrays.stream(integerArrayWrapperType).max(intComparatorAsc).get();
		//OR
		//int max_int = Arrays.asList(integerArray).stream().max(intComparator).get();
		int min_int = Arrays.stream(integerArrayWrapperType).max(intComparatorDesc).get();
		
		System.out.println(max_int);
		System.out.println(min_int);
		
		Comparator<Long> longComparator = (Long num1, Long num2) -> num1.compareTo(num2); // ascending
		Long max_long = Arrays.stream(longArrayWrapperType).max(longComparator).get();
		//OR
		//Long max_long = Arrays.asList(longArrayWrapperType).stream().max(longComparator).get();
		Long min_long = Arrays.stream(longArrayWrapperType).max(longComparator).get();
		
		System.out.println(max_long);
		System.out.println(min_long);
		
		Comparator<Float> floatComparatorAsc = (Float num1, Float num2) -> num1.compareTo(num2); // ascending
		Comparator<Float> floatComparatorDesc = (Float num1, Float num2) -> num2.compareTo(num1); // ascending
		
		
		Float max_float = Arrays.stream(floatArrayWrapperType).max(floatComparatorAsc).get();
		//OR
		//Float max5 = Arrays.asList(floatArrayWrapperType).stream().max(floatComparator).get();
		Float min_float = Arrays.stream(floatArrayWrapperType).max(floatComparatorDesc).get();
		
		System.out.println(max_float);
		System.out.println(min_float);
		
		Comparator<Double> doubleComparatorAsc = (Double num1, Double num2) -> num1.compareTo(num2);
		Comparator<Double> doubleComparatorDesc = (Double num1, Double num2) -> num2.compareTo(num1);
		
		Double max_double = Arrays.stream(doubleArrayWrapperType).max(doubleComparatorAsc).get();
		//OR
		//Double max6 = Arrays.asList(doubleArrayWrapperType).stream().max(doubleComparator).get();
		Double min_double = Arrays.stream(doubleArrayWrapperType).max(doubleComparatorDesc).get();
		
		System.out.println(max_double);
		System.out.println(min_double);
		
		 //way-01
  		Double sumRes = Stream.of(doubleArrayWrapperType)
  				.reduce(0.0, (Double d1, Double d2) -> d1 + d2);
  		// Double d = Collectors.computeFinalSum(doubleArrayprimitive);
  		System.out.println(sumRes);
  		
  		//way-02
  		Double res = (Double) Stream.of(doubleArrayWrapperType)
  				.collect(Collectors.reducing(0d, (num1, num2) -> num1 + num2));
  		System.out.println(res);
		
		
	}
	
	private static void countNoOfOccurancesOfPerticularItemInArray() {
		
		//ex-01
		List<Integer> list3 = Arrays.asList(integerArrayWrapperType);
		long count = list3.stream().filter(item -> 11 == item).count();
		System.out.println(count);
		
		List<Long> list4 = Arrays.asList(longArrayWrapperType);
		long count4 = list4.stream().filter(item -> 11L == item).count();
		System.out.println(count4);
		
		List<Float> list03 = Arrays.asList(floatArrayWrapperType);
		long count03 = list03.stream().filter(item -> 11.5f == item).count();
		System.out.println(count03);
		
		List<Double> list5 = Arrays.asList(doubleArrayWrapperType);
		long count5 = list5.stream().filter(item -> 11d == item).count();
		System.out.println(count5);
		
		//ex-02
		List<String> list = Arrays.asList(stringArray);
		long count6 = list.stream().filter(item -> "punya".equalsIgnoreCase(item)).count();
		System.out.println(count6);
		
		
	}
	
	
private static void countNoOfOccurancesOfEachItemInArray() {
		
		// way-01
		List<Integer> list = Arrays.asList(integerArrayWrapperType);
		Set<Integer> set = new HashSet<Integer>(list);
		for (Integer item : set)
			System.out.println(item + ": " + Collections.frequency(list, item));

		// way-02
		Map<Integer, Long> counts = list.stream().collect(Collectors.groupingBy(item -> item, Collectors.counting()));
		System.out.println(counts);
	
	}

	
	private static void countNoOfOccurancesOfEachItemwithRangeInArray() {
		Map<Integer, Long> map = Arrays.stream(integerArrayWrapperType).filter(item -> item >=10 && item <=50).collect(Collectors.groupingBy(item -> item, Collectors.counting()));
		System.out.println(map);
		
	}

	private static void removeDuplicateItemsFromWrapperArray() {
		
		//way-01
		//byte[] res1 =  Arrays.stream(byteArrayPrimitiveType).distinct().toArray(); //CE
		Byte[] byteArrayWrapperType2 = (Byte[]) Arrays.asList(byteArrayWrapperType).stream().distinct().toArray();
		for(Byte b: byteArrayWrapperType2) {
			System.out.print(b+" ");
		}
		
		//way-02
		List<Byte> byteArrayWrapperType3 = Arrays.stream(byteArrayWrapperType).distinct().collect(Collectors.toList());
		//OR
		//List<Byte> byteArrayWrapperType3 =  Arrays.asList(byteArrayWrapperType).stream().distinct().collect(Collectors.toList());
		for(Byte b: byteArrayWrapperType3) {
			System.out.print(b+" ");
		}
		
		//way-03
		List<Byte> list1 = Arrays.asList(byteArrayWrapperType);
		Set<Byte> set1 = new HashSet<>(list1);
		System.out.println(set1);
		
		//way-01
		//byte[] res1 =  Arrays.stream(byteArrayPrimitiveType).distinct().toArray(); //CE
		Short[] shortArrayWrapperType2 = (Short[]) Arrays.asList(shortArrayWrapperType).stream().distinct().toArray();
		for(Short b: shortArrayWrapperType2) {
			System.out.print(b+" ");
		}
		
		//way-02
		List<Short> shortArrayWrapperType3 = Arrays.stream(shortArrayWrapperType).distinct().collect(Collectors.toList());
		//OR
		//List<Short> shortArrayWrapperType3 =  Arrays.asList(byteArrayWrapperType).stream().distinct().collect(Collectors.toList());
		for(Short b: shortArrayWrapperType3) {
			System.out.print(b+" ");
		}
		
		
		List<Short> list2 = Arrays.asList(shortArrayWrapperType);
		Set<Short> set2 = new HashSet<>(list2);
		System.out.println(set2);
		
		
		//way-01
		//int[] res1 =  Arrays.stream(intArrayPrimitiveType).distinct().toArray(); //CE
		Integer[] intArrayWrapperType2 = (Integer[]) Arrays.asList(shortArrayWrapperType).stream().distinct().toArray();
		for(Integer b: intArrayWrapperType2) {
			System.out.print(b+" ");
		}
		
		//way-02
		List<Integer> intArrayWrapperType3 = Arrays.stream(integerArrayWrapperType).distinct().collect(Collectors.toList());
		//OR
		//List<Integer> intArrayWrapperType3 =  Arrays.asList(integerArrayWrapperType).stream().distinct().collect(Collectors.toList()); //OK
		for(Integer b: intArrayWrapperType3) {
			System.out.print(b+" ");
		}
		
		List<Integer> list3 = Arrays.asList(integerArrayWrapperType);
		Set<Integer> set3 = new HashSet<>(list3);
		System.out.println(set3);
		
		//way-01
		//long[] res1 =  Arrays.stream(longArrayPrimitiveType).distinct().toArray(); //CE
		Long[] longArrayWrapperType2 = (Long[]) Arrays.asList(shortArrayWrapperType).stream().distinct().toArray();
		for(Long b: longArrayWrapperType2) {
			System.out.print(b+" ");
		}
		
		//way-02
		List<Long> longArrayWrapperType3 = Arrays.stream(longArrayWrapperType).distinct().collect(Collectors.toList());
		//OR
		//List<Long> longArrayWrapperType3 =  Arrays.asList(integerArrayWrapperType).stream().distinct().collect(Collectors.toList()); //OK
		for(Long b: longArrayWrapperType3) {
			System.out.print(b+" ");
		}
		
		List<Long> list5 = Arrays.asList(longArrayWrapperType);
		Set<Long> set5 = new HashSet<>(list5);
		System.out.println(set5);
		
		//way-01
		//float[] res1 =  Arrays.stream(floatArrayPrimitiveType).distinct().toArray(); //CE
		Float[] floatArrayWrapperType2 = (Float[]) Arrays.asList(floatArrayWrapperType).stream().distinct().toArray();
		for(Float b: floatArrayWrapperType2) {
			System.out.print(b+" ");
		}
		
		//way-02
		List<Float> floatArrayWrapperType3 = Arrays.stream(floatArrayWrapperType).distinct().collect(Collectors.toList());
		//OR
		//List<Float> floatArrayWrapperType3 =  Arrays.asList(integerArrayWrapperType).stream().distinct().collect(Collectors.toList()); //OK
		for(Float b: floatArrayWrapperType3) {
			System.out.print(b+" ");
		}
		
		List<Float> list4 = Arrays.asList(floatArrayWrapperType);
		Set<Float> set4 = new HashSet<>(list4);
		System.out.println(set4);
		
		//way-01
		//double[] res1 =  Arrays.stream(doubleArrayPrimitiveType).distinct().toArray(); //CE
		Double[] doubleArrayWrapperType2 = (Double[]) Arrays.asList(doubleArrayWrapperType).stream().distinct().toArray();
		for(Double b: doubleArrayWrapperType2) {
			System.out.print(b+" ");
		}
		
		//way-02
		List<Double> doubleArrayWrapperType3 = Arrays.stream(doubleArrayWrapperType).distinct().collect(Collectors.toList());
		//OR
		//List<Double> doubleArrayWrapperType3 =  Arrays.asList(doubleArrayWrapperType).stream().distinct().collect(Collectors.toList()); //OK
		for(Double b: doubleArrayWrapperType3) {
			System.out.print(b+" ");
		}
		
		List<Double> list6 = Arrays.asList(doubleArrayWrapperType);
		Set<Double> set6 = new HashSet<>(list6);
		System.out.println(set6);
		
		List<String> list7 = Arrays.asList(stringArray);
		Set<String> set7 = new HashSet<>(list7);
		System.out.println(set7);
		
	}


	private static void convertArrayToList() {
		
		// way-01 - old style
		List<Byte> list01 = new ArrayList<>();
		for (Byte i : byteArrayWrapperType) {
			list01.add(i);
		}
		System.out.println(list01);

		//way-02 , new style
		//List<byte> list001 = Arrays.asList(byteArrayWrapperType);//CE
		List<Byte> list001 = Arrays.asList(byteArrayWrapperType);
		System.out.println("byte array=" + list001.toString());
		
		//List<short> list002 = Arrays.asList(shortArrayWrapperType); //CE
		List<Short> list002 = Arrays.asList(shortArrayWrapperType);
		System.out.println("short array=" + list002.toString());

		List<Integer> list03 = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println(list03);

		List<Integer> list3 = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 });
		System.out.println(list3);

		// way-03
		//List<Integer> list02 = Arrays.asList(intArray); //CE
		List<Integer> list2 = Arrays.asList(integerArrayWrapperType);
		System.out.println(list2);

		// List<float> list4 = Arrays.asList(floatArray1); //CE
		// System.out.println(list4);
		
		List<Long> list04 = Arrays.asList(longArrayWrapperType);
		System.out.println(list04);

		List<Float> list4 = Arrays.asList(floatArrayWrapperType);
		System.out.println(list4);

		List<Double> list6 = Arrays.asList(doubleArrayWrapperType);
		System.out.println(list6);

		List<Character> list003 = Arrays.asList(charArrayWrapperType);
		System.out.println(list003);

		// converting string array to string list
		List<String> list7 = Arrays.asList("Jon", "Ajeet", "Steve", "Ajeet", "Jon", "Ajeet");
		System.out.println(list7);

		// converting string array to string list
		List<String> list8 = Arrays.asList(stringArray);
		System.out.println(list8);
	}


	private static void sortStringArrayBasedOnStringValue() {
		
		System.out.println();
		
		//without using comparator
		
		Arrays.sort(stringArray); //default sort
		System.out.println(Arrays.toString(stringArray));
		
		Collections.sort(Arrays.asList(stringArray)); //default sort
		System.out.println(Arrays.toString(stringArray));
		
		//with using comparator
		
		Comparator<String> stringComparator1 = new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				// return str2.compareTo(str1); // descending order
				return str1.compareTo(str2); // ascending order
			}
		};

		Comparator<String> stringComparator2 = (String str1, String str2) -> str1.compareTo(str2); //ascending order
		Comparator<String> stringComparator3 = (String str1, String str2) -> str2.compareTo(str1);  //descending order
		
		//Arrays.sort(stringArray,stringComparator1/stringComparator2/stringComparator3);
		Arrays.sort(stringArray, stringComparator1);
		System.out.println(Arrays.toString(stringArray));
		
	
		//Collections.sort(Arrays.asList(stringArray),stringComparator1/stringComparator2/stringComparator3);
		Collections.sort(Arrays.asList(stringArray), stringComparator1);
		System.out.println(Arrays.toString(stringArray));
		
	}
	
	private static void sortStringAtrrayBasedOnStringLength() {

		// jdk7
		Comparator<String> sortByLengthComparator1 = new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				return str1.length() - str2.length();
				// return str2.length() - str1.length();
			}
		};

		Comparator<String> sortByLengthComparator2 = Comparator.comparingInt(String::length);
		// Comparator<String> sortByLengthComparator2 = Comparator.comparingInt(String::length).reversed();

		// jdk8
		Comparator<String> sortByLengthComparator3 = (s1, s2) -> s1.length() - s2.length();
		// Comparator<String> sortByLengthComparator3 = (s1, s2) -> s2.length() - s1.length();

		// Arrays.sort(stringArray,sortByLengthComparator1/sortByLengthComparator2/sortByLengthComparator3);
		Arrays.sort(stringArray, sortByLengthComparator1);
		System.out.println(Arrays.toString(stringArray));

		// stringList.sort(sortByLengthComparator1/sortByLengthComparator2/sortByLengthComparator3);
		stringList.sort(sortByLengthComparator1);
		stringList.forEach(System.out::println);

		// OR
		// Collections.sort(stringList,sortByLengthComparator1/sortByLengthComparator2/sortByLengthComparator3,);
		Collections.sort(stringList, sortByLengthComparator2);
		stringList.forEach(System.out::println);

	}
	

	/**
	 *  ################################################ Working with List Object ##########################################################################################################################################
	 * 
	 */
	
	private static void sortIntegerList() {
		
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
		List<Integer> list = Arrays.asList(integerArrayWrapperType);
		Set<Integer> set = new HashSet<>(list);
		System.out.println(set);
	}

	

	private static void parallelSortAnyArray() {

		Arrays.parallelSort(intArrayPrimitiveType);
		Arrays.stream(intArrayPrimitiveType).forEach(item -> System.out.print(item + " "));

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

	private static void namesStartingWithSpecificCharInStringArray() {
		//ex-03
		//count the no items starts with A.
		long count7 = Arrays.stream(stringArray).filter(item -> item.startsWith("A")).count();
		System.out.println(count7);
				
		Arrays.stream(stringArray).filter(str -> str.startsWith("A")).forEach(System.out::println);
		Arrays.stream(stringArray).filter(s -> s.startsWith("A")).sorted().forEach(System.out::println);
		Arrays.stream(stringArray).map(String::toUpperCase).filter(s -> s.startsWith("A")).forEach(System.out::println);
		Arrays.stream(stringArray).map(String::toLowerCase).filter(s -> s.startsWith("p")).forEach(System.out::println);
		Arrays.stream(stringArray).map(String::toLowerCase).filter(s -> s.length() == 5).forEach(System.out::println);
	
	}
	
	private static void namesStartingWithSpecificCharInStringList() {
		
		stringList.stream().filter(str -> str.startsWith("A")).forEach(System.out::println);
		stringList.stream().filter(s -> s.startsWith("A")).sorted().forEach(System.out::println);
		stringList.stream().map(String::toUpperCase).filter(s -> s.startsWith("A")).forEach(System.out::println);
		stringList.stream().map(String::toLowerCase).filter(s -> s.startsWith("p")).forEach(System.out::println);
		stringList.stream().map(String::toLowerCase).filter(s -> s.length() == 5).forEach(System.out::println);
		
	}

	private static void convertStringToCharArray() {
		String str = "password123";
		char[] charArray = str.toCharArray();
		for (char ch : charArray) {
			System.out.print(ch + " ");
		}
	}

	private static void sortContentOfFile() throws IOException {

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
		List<Integer> intlist1 = Arrays.asList(integerArrayWrapperType);
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

private static void sortStringList() {
		
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

	
	/**
	 * *********************************************************************************************************
	 * Using Map
	 * *********************************************************************************************************
	 */
	
	
	private static void sortMapByKeys() {
		
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
	
	
	private static void sortMapByValues() {
		
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
	
	private static void using_skip() {
		
		// using skip
		BinaryOperator<Integer> bi = (x, y) -> x + y;
		int skip = integerList.stream().skip(3).reduce(0, bi);
		System.out.println(skip);
		
	}
	
	
	private static void using_anymatch_allmatch() {
		
		// allMatch, anyMatch example
		boolean b = integerList.stream().allMatch(num -> num > 2);
		System.out.println(b);

		boolean b2 = integerList.stream().anyMatch(num -> num > 2);
		System.out.println(b2);
		
	}
	
	private static void using_limit() {
		
		// using limit
		integerList.stream().limit(2).forEach(System.out::println); //1,2

		System.out.println();
		// using with limit with reduce to find sum.
		int sum = integerList.stream().limit(3).reduce(0, (x, y) -> x + y);
		System.out.println("sum="+sum); //6 = 1+2+3
	}
	
	
	
	private static void boxing_unboxing_stream() {
		
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
	
	private static void convertingListToStream() {
		
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
		for (String name : stringList)
			System.out.print(name);

		System.out.println();
		stringList.forEach(System.out::print);

		System.out.println();
		// converting list to stream
		Stream<String> stream1 = stringList.stream();
		stream1.forEach(name -> System.out.print(name));
		// stream1.forEach(name -> System.out.println(name));

		// ########## stream map example ##########
		System.out.println();
		List<Integer> nameLength = stringList.stream().map(String::length).collect(Collectors.toList());
		System.out.print(nameLength);

		// OR

		stringList.stream().map(String::length).collect(Collectors.toList()).forEach(System.out::println);

		// ########## flatmap demo ##########
		List<Integer> oddNums = Arrays.asList(1, 3, 5, 7);
		List<Integer> evenNums = Arrays.asList(2, 4, 6, 8);

		List<List<Integer>> listOfList = Arrays.asList(oddNums, evenNums);
		System.out.println(listOfList); // [[1, 3, 5, 7], [2, 4, 6, 8]]

		// converting to flat list
		Set<Integer> flatenList = listOfList.stream().flatMap(List::stream).sorted().collect(Collectors.toSet());
		System.out.println(flatenList); // [1, 2, 3, 4, 5, 6, 7, 8]

		// ########## filter demo ##########
		stringList.stream().filter(name -> name.length() > 3).forEach(System.out::print);
		System.out.println();
		stringList.stream().filter(name -> name.length() > 3).collect(Collectors.toList()).forEach(System.out::print);

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

	private static void removeDuplicateItemsfromList() {
		

		String AfeterConcatinatingnames = stringList.stream().reduce("", (a, b) -> a.concat(b));
		System.out.println(AfeterConcatinatingnames);

		// ########################################################################################
		// Before java-8
		List<String> uniqueNames = new ArrayList<>();
		for (String name : stringList) {
			if (!uniqueNames.contains(name))
				uniqueNames.add(name);
		}
		System.out.println(uniqueNames);

		// using java-8
		List<String> uniqueName2 = stringList.stream().distinct().collect(Collectors.toList());
		System.out.println(uniqueName2);

		// using java-8
		List<Integer> numList2 = integerList.stream().distinct().collect(Collectors.toList());
		System.out.println(numList2);

	}

	private static void sortingTheList() {

		// sorting in asc
		integerList.sort(null);
		System.out.println(integerList);

		// sorting in desc
		integerList.sort(Collections.reverseOrder());
		System.out.println(integerList);

		// sorting in asc
		Collections.sort(stringList, String::compareToIgnoreCase);
		System.out.println(stringList);

		// sorting in desc
		Collections.sort(stringList, Collections.reverseOrder());
		System.out.println(stringList);

		// sorting in asc
		List<String> result = stringList.stream().sorted(Comparator.comparing(name -> name.toString()))
				.collect(Collectors.toList());
		System.out.println(result);

		// sorting in desc
		List<String> result2 = stringList.stream().sorted(Comparator.comparing(name -> name.toString()).reversed()).collect(Collectors.toList());
		System.out.println(result2);

	}


	/**
	 * *********************************************************************************************************
	 * Using Custom DTO 
	 * *********************************************************************************************************
	 */
	
	private static void sortEmployeeById() {

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

	private static void sortEmployeeByName() {

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

	private static void sortEmployeeByAge() {

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

	private static void sortEmployeeBySalary() {

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
		
		Comparator<Employee> sortBySalComparator = (Employee e1, Employee e2) -> e1.getSalary().compareTo(e2.getSalary());
		employeeList.sort(sortBySalComparator);
		employeeList.forEach(System.out::println);
		// OR
		Collections.sort(employeeList, sortBySalComparator);
		employeeList.forEach(System.out::println);
		
	}
	
	private static void sortEmployeeByAge2() {
		Comparator<Employee> sortByAgeComparator = (e1, e2) -> e1.getAge().compareTo(e2.getAge());
		employeeList.stream().sorted(sortByAgeComparator).collect(Collectors.toList()).forEach(System.out::println);
	}


	private static void convertEmplpoyeeListToMap() {
		Comparator<Employee> sortBySalaryComparator = Comparator.comparingDouble(Employee::getSalary);
		Map<String, Double> result1 = employeeList.stream().sorted(sortBySalaryComparator).collect(Collectors.toMap(Employee::getName, Employee::getSalary, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		System.out.println(" After sorting based on salary in desc : " + result1);

	}

	private static void sortUsers() {

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
