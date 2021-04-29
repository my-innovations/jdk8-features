package arrays_class;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArraysDemo {
	

	// dummy data
	private static byte[] byteArrayPrimitiveType = { 10, 5, -44, -99, 47, 19, -35 };
	private static Byte[] byteArrayWrapperType = { 10, 5, -44, -99, 47, 19, -35 };

	private static short[] shortArrayPrimitiveType = { 10, 5, -44, -99, 47, 198, -35 };
	private static Short[] shortArrayWrapperType = { 10, 5, -44, -99, 47, 198, -35 };

	private static int[] intArrayPrimitiveType = { 10, 5, -44, -99, 47, 198, -35 };
	private static Integer[] intArrayWrapperType = { 10, 5, -44, -99, 47, 198, -35 ,5,10};

	private static long[] longArrayPrimitiveType = { 10l, 5, -44l, -99, 47, 198, -35 };
	private static Long[] longArrayWrapperType = { 10l, 5l, -44l, -99l, 47l, 198l, -35l };

	private static float[] floatArrayPrimitiveType = { 10.6f, 5.8f, -44.7f, -99.1f, 47.4f, 198.9f, -35.7f };
	private static Float[] floatArrayWrapperType = { 10.6f, 5.8f, -44.7f, -99.1f, 47.4f, 198.9f, -35.7f };

	private static double[] doubleArrayPrimitiveType = { 10.6d, 5.8d, -44.7d, -99.1d, 47.4d, 198.9d, -35.7f };
	private static Double[] doubleArrayWrapperType = { 10.6d, 5.8d, -44.7d, -99.1d, 47.4d, 198.9d, -35.7d };

	private static char[] charArrayPrimitiveType = { 'A', 'Y', 'p','b' };
	private static Character[] charArrayWrapperType = { 'A', 'Y', 'R','p','b'  };

	private static String[] strArray = { "punya", "Partha", "Aswini", "punya","Arabind" };

	public static void main(String[] args) throws IOException {
		
		largestItemFromIntArray();
		smallestItemFromIntArray();
		
		removeDuplicateItemsFromAnyArray();
		
		countNoOfOccurancesOfAnItemItemInAnyArray();
		countNoOfOccurancesOfEachItemInAnyArray();
		countNoOfOccurancesOfEachItemwithRangeInAnyArray();
		
		sortAnyArray();
		parallelSortAnyArray();

		convertStringToCharArray();
		convertAnyArrayToList();
		convertAnyArrayToSet();
		convertAnyArrayToMapWithNoOfOccurances();
		
		namesStartingWithSpecificCharInStringArray();
		sortContentOfFile();
		
		sortStringArrayByUsingJava7();
		sortArrayOfStringsByUsingJava8();
		
		convertAnyArrayToStream();
			
	}
	
	private static void largestItemFromIntArray() {
	    int max = Arrays.stream(intArrayPrimitiveType).max().getAsInt();
	    System.out.println(max);
	}
	
	private static void smallestItemFromIntArray() {
	    int min = Arrays.stream(intArrayPrimitiveType).min().getAsInt();
	    System.out.println(min);
	}
	
	
	public static void sortStringArrayByUsingJava7() {

		Arrays.sort(strArray);
		// OR

		Comparator<String> sortByLengthComparator = new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				return str1.compareTo(str2);
			}
		};

		Arrays.sort(strArray, sortByLengthComparator);
	}

	public static void sortArrayOfStringsByUsingJava8() {
		
		Arrays.sort(strArray);
		//OR
		Comparator<String> sortByNameCustomComparator = (String str1, String str2) -> str1.compareTo(str2);
		Arrays.sort(strArray, sortByNameCustomComparator);
	}
	
	private static void convertAnyArrayToMapWithNoOfOccurances() {
		
		List<Integer> list = Arrays.asList(intArrayWrapperType);
		Map<Integer, Long> counts = list.stream().collect(Collectors.groupingBy(item -> item, Collectors.counting()));
		System.out.println(counts);
		
	}

	private static void countNoOfOccurancesOfAnItemItemInAnyArray() {
		
		//ex-01
		List<Integer> list3 = Arrays.asList(intArrayWrapperType);
		long count = list3.stream().filter(item -> 11 == item).count();
		System.out.println(count);
		
		//ex-02
		List<String> list = Arrays.asList(strArray);
		count = list.stream().filter(item -> "punya".equalsIgnoreCase(item)).count();
		System.out.println(count);
		
		//count the no items starts with A.
		count = Arrays.stream(strArray).filter(item -> item.startsWith("A")).count();
	}
	
	
	private static void countNoOfOccurancesOfEachItemInAnyArray() {
		
		// way-01
		List<Integer> list = Arrays.asList(intArrayWrapperType);
		Set<Integer> set = new HashSet<Integer>(list);
		for (Integer item : set)
			System.out.println(item + ": " + Collections.frequency(list, item));

		// way-02
		Map<Integer, Long> counts = list.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
		System.out.println(counts);
	
	}
	
	
	private static void countNoOfOccurancesOfEachItemwithRangeInAnyArray() {
		Map<Integer, Long> map = Arrays.stream(intArrayWrapperType).filter(item -> item >=10 && item <=50).collect(Collectors.groupingBy(item -> item, Collectors.counting()));
		System.out.println(map);
		
	}

	private static void removeDuplicateItemsFromAnyArray() {
		
		//List<Integer> list3 = Arrays.asList(intArrayPrimitiveType); //CE
		List<Byte> list1 = Arrays.asList(byteArrayWrapperType);
		Set<Byte> set1 = new HashSet<>(list1);
		System.out.println(set1);
		
		//Byte[] res1 = (Byte[]) Arrays.stream(byteArrayPrimitiveType).distinct().toArray(); //CE
		Byte[] res2 = (Byte[]) Arrays.stream(byteArrayWrapperType).distinct().toArray();
		System.out.println(res2);
		
		
		//List<Integer> list3 = Arrays.asList(shortArrayPrimitiveType); //CE
		List<Short> list2 = Arrays.asList(shortArrayWrapperType);
		Set<Short> set2 = new HashSet<>(list2);
		System.out.println(set2);

		
		//List<Integer> list3 = Arrays.asList(intArrayPrimitiveType); //CE
		List<Integer> list3 = Arrays.asList(intArrayWrapperType);
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
		
		
		List<String> list7 = Arrays.asList(strArray);
		Set<String> set7 = new HashSet<>(list7);
		System.out.println(set7);
		
	}



	private static void convertAnyArrayToStream() {

		// way-01
		// Arrays.stream(byteArray).forEach(System.out::print);//CE
		// Arrays.stream(shortArray).forEach(System.out::print);//CE
		Arrays.stream(intArrayPrimitiveType).forEach(System.out::print);
		Arrays.stream(longArrayPrimitiveType).forEach(System.out::print);
		//Arrays.stream(floatArray1).forEach(System.out::print);//CE
		Arrays.stream(doubleArrayPrimitiveType).forEach(System.out::print);

		// way-02
		Stream.of(byteArrayPrimitiveType).forEach(System.out::print);
		Stream.of(shortArrayPrimitiveType).forEach(System.out::print);
		Stream.of(intArrayPrimitiveType).forEach(System.out::print);
		//Stream<Integer> stream1 = Stream.of(intArray1); //CE
		Stream<Integer> stream1 = Stream.of(intArrayWrapperType);
		stream1.forEach(System.out::println);


		// way-03
		Stream.of(byteArrayPrimitiveType).forEachOrdered(System.out::print);
		Stream.of(shortArrayPrimitiveType).forEachOrdered(System.out::print);
		Stream.of(intArrayPrimitiveType).forEachOrdered(System.out::print);
		Stream.of(longArrayPrimitiveType).forEachOrdered(System.out::print);
		Stream.of(floatArrayPrimitiveType).forEachOrdered(System.out::print);
		Stream.of(doubleArrayPrimitiveType).forEachOrdered(System.out::print);
	}

	private static void convertAnyArrayToList() {

		//List<byte> list001 = Arrays.asList(byteArrayWrapperType);//CE
		List<Byte> list001 = Arrays.asList(byteArrayWrapperType);
		System.out.println("byte array=" + list001);

		//List<short> list002 = Arrays.asList(shortArrayWrapperType); //CE
		List<Short> list002 = Arrays.asList(shortArrayWrapperType);
		System.out.println("short array=" + list002);

		// way-01
		List<Integer> list01 = new ArrayList<>();
		for (Integer i : intArrayPrimitiveType) {
			list01.add(i);
		}
		System.out.println(list01);

		// way-02
		
		List<Integer> list03 = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println(list03);

		List<Integer> list3 = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 });
		System.out.println(list3);

		// way-03
		//List<Integer> list02 = Arrays.asList(intArrayPrimitiveType); //CE
		List<Integer> list2 = Arrays.asList(intArrayWrapperType);
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
		List<String> list8 = Arrays.asList(strArray);
		System.out.println(list8);
	}
	
	
	private static void convertAnyArrayToSet() {
		
		//List<Integer> list3 = Arrays.asList(intArrayPrimitiveType); //CE
		List<Integer> list3 = Arrays.asList(intArrayWrapperType);
		Set<Integer> set3 = new HashSet<>(list3);
		System.out.println(set3);
	}

	public static void sortAnyArray() {

		// ***************************************************** with both primitive and wrapper  type ********************************************************

		// way-01 , sorting int array in ascending order

		Arrays.sort(byteArrayPrimitiveType);
		System.out.println("byte arr after sort:" + Arrays.toString(byteArrayPrimitiveType));

		Arrays.sort(byteArrayWrapperType);
		System.out.println("byte arr after sort:" + Arrays.toString(byteArrayWrapperType));

		Arrays.sort(shortArrayPrimitiveType);
		System.out.println(Arrays.toString(shortArrayPrimitiveType));

		Arrays.sort(shortArrayWrapperType);
		System.out.println(Arrays.toString(shortArrayWrapperType));

		Arrays.sort(intArrayPrimitiveType);
		System.out.println(Arrays.toString(intArrayPrimitiveType));

		Arrays.sort(intArrayWrapperType);
		System.out.println(Arrays.toString(intArrayWrapperType));

		Arrays.sort(floatArrayPrimitiveType);
		System.out.println(Arrays.toString(floatArrayPrimitiveType));

		Arrays.sort(floatArrayWrapperType);
		System.out.println(Arrays.toString(floatArrayWrapperType));

		Arrays.sort(longArrayPrimitiveType);
		System.out.println(Arrays.toString(longArrayPrimitiveType));

		Arrays.sort(doubleArrayPrimitiveType);
		System.out.println(Arrays.toString(doubleArrayPrimitiveType));

		Arrays.sort(doubleArrayWrapperType);
		System.out.println(Arrays.toString(doubleArrayWrapperType));

		Arrays.sort(charArrayPrimitiveType);
		System.out.println(Arrays.toString(charArrayPrimitiveType));

		Arrays.sort(charArrayWrapperType);
		System.out.println(Arrays.toString(charArrayWrapperType));

		Arrays.sort(strArray);
		System.out.println(Arrays.toString(strArray));

		// ***************************************************** with wrapper type only   ********************************************************

		// OR
		// using custom comparator.
		Comparator<Byte> byteComparator = new Comparator<Byte>() {
			@Override
			public int compare(Byte i1, Byte i2) {
				return i2.compareTo(i1);
			}
		};
		
		// Arrays.sort(byteArray1, byteComparator); //CE
		Arrays.sort(byteArrayWrapperType, byteComparator);
		System.out.println("byte arr ===>" + Arrays.toString(byteArrayWrapperType));

		// *****************************************************

		// ex-03
		Comparator<Short> shortComparator = new Comparator<Short>() {
			@Override
			public int compare(Short i1, Short i2) {
				return i2.compareTo(i1);
			}
		};
		// Arrays.sort(shortArray1, shortComparator); //CE
		Arrays.sort(shortArrayWrapperType, shortComparator);
		System.out.println("short arr === "+Arrays.toString(shortArrayWrapperType));

		// *****************************************************

		Comparator<Integer> intComparator = new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				// ascending order
				// return i1.compareTo(i2);
				// descending order
				return i2.compareTo(i1);
			}
		};

		Arrays.sort(intArrayWrapperType, intComparator);
		System.out.println("int array == "+Arrays.toString(intArrayPrimitiveType));

		// *****************************************************

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

		// *****************************************************
		
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
		list22.add(12L);
		list22.add(33l);
		Collections.sort(list022, longComparator);

		// *****************************************************
		
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



		// *****************************************************

		Comparator<String> strComparator = new Comparator<String>() {
			@Override
			public int compare(String name1, String name2) {
				// return name1.compareTo(name2);
				return name2.compareTo(name1);
			}
		};
		Arrays.sort(strArray, strComparator);
		System.out.println("str arr === "+Arrays.toString(strArray));

	}

	public static void parallelSortAnyArray() {

		Arrays.parallelSort(intArrayPrimitiveType);
		Arrays.stream(intArrayPrimitiveType).forEach(item -> System.out.print(item + " "));

		System.out.println();

		Arrays.parallelSort(floatArrayPrimitiveType);
		// Arrays.parallelSort(floatArr, 1, 4);
		System.out.println(Arrays.toString(floatArrayPrimitiveType));

		// Arrays.stream(floatArray).forEach(n -> System.out.print(n + " ")); //CE

		Arrays.parallelSort(strArray);
		System.out.println(Arrays.toString(strArray));

		Arrays.parallelSort(strArray, Collections.reverseOrder());
		System.out.println(Arrays.toString(strArray));
	}

	public static void namesStartingWithSpecificCharInStringArray() {
		Arrays.stream(strArray).filter(s -> s.startsWith("A")).sorted().forEach(System.out::println);
		Arrays.stream(strArray).map(String::toUpperCase).filter(s -> s.startsWith("A")).forEach(System.out::println);
		Arrays.stream(strArray).map(String::toLowerCase).filter(s -> s.startsWith("p")).forEach(System.out::println);
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
}
