package stream_api;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import model.Employee;

public class CollectionsWithStreamDemo {
	
	// some dummy data to operate on
	//private static byte[] byteArrayPrimitiveType = { 10, 5, -44, -99, 47, 19, -35 };
	//private static Byte[] byteArrayWrapperType = { 10, 5, -44, -99, 47, 19, -35 };
	//private static List<Byte> byteList = Arrays.asList(1, 34, 78, 90, 27, 45); //CE
	//private static Set<Byte> byteSet = new HashSet(byteList); //CE

	//private static short[] shortArrayPrimitiveType = { 10, 5, -44, -99, 47, 198, -35 };
	//private static Short[] shortArrayWrapperType = { 10, 5, -44, -99, 47, 198, -35 };
	//private static List<Short> shortList = Arrays.asList(1, 34, 78, 90, 27, 45); //CE

	private static int[] intArrayPrimitiveType = new int[] { 1, 34, 78, 90, 27, 45 };
	private static Integer[] intArrayWrapperType = new Integer[] { 1, 34, 78, 90, 27, 45 };
	private static List<Integer> integerlist = Arrays.asList(intArrayWrapperType); 
	private static Set<Integer> integerSet = new HashSet<>(integerlist);

	private static long[] longArrayPrimitiveType = new long[] { 1, 34, 78, 90, 27, 45 };
	private static Long[] longArrayWrapperType = new Long[] { 1l, 34l, 78l, 90l, 27l, 45l };
	private static List<Long> longlist = Arrays.asList(longArrayWrapperType);
	private static Set<Long> longSet = new HashSet<>(longlist);
	
	private static float[] floatArrayPrimitiveType = new float[] { 1.5f, 34.8f, 78.2f, 90.0f, 27.78f, 45.31f };
	private static Float[] floatArrayWrapperType = new Float[] { 1.5f, 34.8f, 78.2f, 90.0f, 27.78f, 45.31f };
	private static List<Float> floatlist = Arrays.asList(floatArrayWrapperType);
	private static Set<Float> floatSet = new HashSet<>(floatlist);
	
	private static double[] doubleArrayPrimitive = new double[] { 1, 34, 78, 90, 27, 45 };
	private static Double[] doubleArrayWrapperType = new Double[] { 1d, 34d, 78d, 90d, 27d, 45d };
	private static List<Double> doublelist = Arrays.asList(doubleArrayWrapperType);
	private static Set<Double> doubleSet = new HashSet<>(doublelist);
	
	private static char[] charArrayPrimitiveType = new char[] { 'a', 'm', 'y', 'u' };
	private static Character[] charArrayWrapperType = new Character[] { 'a', 'm', 'y', 'u' };
	private static List<Character> charlist = Arrays.asList(charArrayWrapperType);
	private static Set<Character> charSet = new HashSet<>(charlist);
	
	private static String[] stringArray = { "Punya", "Partha sarathi", "Aswini kumar" };
	private static List<String> stringList = Arrays.asList("punya", "punyasmruti","pankaj kumar", "aswini k ssingh", "parthasarathi");
	private static Set<String> stringSet = new HashSet<>(stringList);
	
	private static List<Employee> employeeList = Arrays.asList(new Employee(1, "Shifoo", "acc1", "IT", 25, 150000d),new Employee(2, "Punya", "acc2", "IT", 40, 250000d));
	private static Set<Employee> employeeSet = new HashSet<>(employeeList);
	
	public static void main(String[] args) {
		
		//using primitive and wrapper types
		sortIntegers();
		sortStrings();
		sortStringsByLength();
		countNoOfOccurancesOfEachItemInArrayOrList();
		
		//using DTO class
		sortEmpById(); 
		sortEmpByName();
		sortEmpByAge();
		sortEmpBySalary();
		sortEmpBySalaryUsingJava8();
		convertEmpListToMap();
		

	}// main
	

	public static void sortIntegers() {
		
		Arrays.stream(intArrayPrimitiveType).sorted();
		Arrays.stream(intArrayPrimitiveType).sorted().distinct().forEach(System.out::println);

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
		
		Arrays.sort(intArrayPrimitiveType); // default sort
		System.out.println(Arrays.toString(intArrayPrimitiveType));
		
		Arrays.sort(intArrayWrapperType); // default sort
		System.out.println(Arrays.toString(intArrayWrapperType));

		Arrays.sort(intArrayWrapperType, customComparator1);
		System.out.println(Arrays.toString(intArrayWrapperType));
		
		Arrays.sort(intArrayWrapperType, customComparator2);
		System.out.println(Arrays.toString(intArrayWrapperType));

		Arrays.sort(intArrayWrapperType, customComparator3);
		System.out.println(Arrays.toString(intArrayWrapperType));
		
		
		integerlist.sort(customComparator1);
		integerlist.forEach((name) -> System.out.print(name + " "));

		System.out.println();
		integerlist.sort(customComparator2);
		System.out.print(integerlist + " ");

		System.out.println();
		integerlist.sort(customComparator3);
		System.out.println(integerlist);

		Collections.sort(Arrays.asList(intArrayWrapperType)); // default sort
		System.out.println(Arrays.toString(intArrayWrapperType));

		Collections.sort(Arrays.asList(intArrayWrapperType), customComparator1);
		System.out.println(Arrays.toString(intArrayWrapperType));

		Collections.sort(Arrays.asList(intArrayWrapperType), customComparator2);
		System.out.println(Arrays.toString(intArrayWrapperType));

		Collections.sort(Arrays.asList(intArrayWrapperType), customComparator3);
		System.out.println(Arrays.toString(intArrayWrapperType));
		
		Collections.sort(integerlist); // default sort
		System.out.println(integerlist);
		
		Collections.sort(integerlist); // default sort
		System.out.println(integerlist);
		
		Collections.sort(integerlist,customComparator1); // default sort
		System.out.println(integerlist);
		
		Collections.sort(integerlist,customComparator2); // default sort
		System.out.println(integerlist);
		
		Collections.sort(integerlist,customComparator3); // default sort
		System.out.println(integerlist);
		
		
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
		
		
		Arrays.sort(floatArrayPrimitiveType); // default sort
		System.out.println(Arrays.toString(floatArrayPrimitiveType));
		
		Arrays.sort(floatArrayWrapperType); // default sort
		System.out.println(Arrays.toString(floatArrayWrapperType));
		
		Arrays.sort(floatArrayWrapperType, customComparator01);
		System.out.println(Arrays.toString(floatArrayWrapperType));
		
		Arrays.sort(floatArrayWrapperType, customComparator02);
		System.out.println(Arrays.toString(floatArrayWrapperType));

		Arrays.sort(floatArrayWrapperType, customComparator03);
		System.out.println(Arrays.toString(floatArrayWrapperType));
		
		floatlist.sort(customComparator01);
		floatlist.forEach((name) -> System.out.print(name + " "));

		System.out.println();
		floatlist.sort(customComparator02);
		System.out.print(floatlist + " ");

		System.out.println();
		floatlist.sort(customComparator03);
		System.out.println(floatlist);
		
		
		Collections.sort(Arrays.asList(floatArrayWrapperType)); // default sort
		System.out.println(Arrays.toString(floatArrayWrapperType));

		Collections.sort(Arrays.asList(floatArrayWrapperType), customComparator01);
		System.out.println(Arrays.toString(floatArrayWrapperType));

		Collections.sort(Arrays.asList(floatArrayWrapperType), customComparator02);
		System.out.println(Arrays.toString(floatArrayWrapperType));

		Collections.sort(Arrays.asList(floatArrayWrapperType), customComparator03);
		System.out.println(Arrays.toString(floatArrayWrapperType));
		
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
	
	public static void sortStrings() {

		System.out.println();
		
		Comparator<String> customComparator1 = new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				// return str2.compareTo(str1); // descending order
				return str1.compareTo(str2); // ascending order
			}
		};

		Comparator<String> customComparator2 = (String str1, String str2) -> str1.compareTo(str2); //ascending order
		Comparator<String> customComparator3 = (String str1, String str2) -> str2.compareTo(str1);  //descending order
		

		Arrays.sort(stringArray); //default sort
		System.out.println(Arrays.toString(stringArray));

		Arrays.sort(stringArray, customComparator1);
		System.out.println(Arrays.toString(stringArray));
		
		Arrays.sort(stringArray, customComparator2);
		System.out.println(Arrays.toString(stringArray));
		
		Arrays.sort(stringArray, customComparator3);
		System.out.println(Arrays.toString(stringArray));
		
		stringList.sort(customComparator1);
		stringList.forEach((name) -> System.out.print(name +" "));
		
		System.out.println();
		stringList.sort(customComparator2);
		System.out.print(stringList +" ");
		
		System.out.println();
		stringList.sort(customComparator3);
		System.out.println(stringList);
		
		Collections.sort(Arrays.asList(stringArray)); //default sort
		System.out.println(Arrays.toString(stringArray));
		
		Collections.sort(Arrays.asList(stringArray), customComparator1);
		System.out.println(Arrays.toString(stringArray));
		
		Collections.sort(Arrays.asList(stringArray), customComparator2);
		System.out.println(Arrays.toString(stringArray));

		Collections.sort(Arrays.asList(stringArray), customComparator3);
		System.out.println(Arrays.toString(stringArray));

		Collections.sort(stringList); // default sorting
		stringList.forEach((name) -> System.out.print(name+" "));

		System.out.println();
		Collections.sort(stringList, customComparator1);
		stringList.forEach((name) -> System.out.print(name+" "));
		
		System.out.println();
		Collections.sort(stringList, customComparator2);
		stringList.forEach((name) -> System.out.print(name +" "));
		
		System.out.println();
		Collections.sort(stringList, customComparator3);
		stringList.forEach((name) -> System.out.print(name+" "));
	}

	

	private static void sortStringsByLength() {
		
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
		
		
		Arrays.sort(stringArray, sortByLengthComparator1);
		System.out.println(Arrays.toString(stringArray));
		
		Arrays.sort(stringArray, sortByLengthComparator2);
		System.out.println(Arrays.toString(stringArray));
		
		Arrays.sort(stringArray, sortByLengthComparator3);
		System.out.println(Arrays.toString(stringArray));
		
		stringList.sort(sortByLengthComparator1);
		stringList.forEach(System.out::println);
		// OR
		stringList.sort(sortByLengthComparator2);
		stringList.forEach(System.out::println);
		// OR
		Collections.sort(stringList, sortByLengthComparator2);
		stringList.forEach(System.out::println);
		//OR
		stringList.sort(sortByLengthComparator2);
		stringList.forEach(System.out::println);
		// OR
		Collections.sort(stringList, sortByLengthComparator3);
		stringList.forEach(System.out::println);
		
	}
	
private static void countNoOfOccurancesOfEachItemInArrayOrList() {
		
		//Integer array as input
		List<Integer> intlist1 = Arrays.asList(intArrayWrapperType);
		Set<Integer> set1 = new HashSet<Integer>(intlist1);
		for (Integer num : set1)
			System.out.println(num + ": " + Collections.frequency(intlist1, num));

		System.out.println();

		//Integer list as input
		Set<Integer> set = new HashSet<Integer>(integerlist);
		for (Integer num : set)
			System.out.println(num + ": " + Collections.frequency(integerlist, num));

		System.out.println();

		//string list as input
		Set<String> set2 = new HashSet<>(stringList);
		for (String name : set2)
			System.out.println(name + ": " + Collections.frequency(stringList, name));
	}

	//**********************************************************************************************************
	
	public static void sortEmpById() {
		
		Comparator<Employee> sortByIdComparator = new Comparator<Employee>() {
			@Override
			public int compare(Employee emp1, Employee emp2) {
				return emp1.getId().compareTo(emp2.getId());
				//return emp1.getId() - emp2.getId();
			}
		};
		
		//Comparator<Employee> sortByIdComparator2 = (Employee emp1, Employee emp2) -> emp1.getId().compareTo(emp2.getId()); //OK
		//Comparator<Employee> sortByIdComparator3 = (Employee emp1, Employee emp2) -> emp1.getId() - emp2.getId(); //Ok
		
		employeeList.sort(sortByIdComparator);
		employeeList.forEach(System.out::println);
		// OR
		Collections.sort(employeeList, sortByIdComparator);
		employeeList.forEach(System.out::println);
		// or
		employeeList.stream().sorted(sortByIdComparator).collect(Collectors.toList()).forEach(System.out::println);
	}



	public static void sortEmpByName() {
		
		Comparator<Employee> sortByNameComparator = new Comparator<Employee>() {
			@Override
			public int compare(Employee e1, Employee e2) {
				return e1.getName().compareTo(e2.getName());
			}
		};
		
		Comparator<Employee> sortByNameComparator1 = (Employee e1, Employee e2) -> e1.getName().compareTo(e2.getName());
		Comparator<Employee> sortByNameComparator2 = (e1,e2) -> e1.getName().compareTo(e2.getName());
		
		employeeList.sort(sortByNameComparator);
		employeeList.forEach(System.out::println);
		// OR
		Collections.sort(employeeList, sortByNameComparator1);
		employeeList.forEach(System.out::println);
		//or
		employeeList.stream().sorted(sortByNameComparator2).collect(Collectors.toList()).forEach(System.out::println);

	}
	
	public static void sortEmpByAge() {
		
		//way-01 , using jdk7
		Comparator<Employee> sortByAgeComparator1 = new Comparator<Employee>() {
			@Override
			public int compare(Employee emp1, Employee emp2) {
				return (int) (emp1.getAge() - emp2.getAge());
			}
		};
		
		//using jdk8
		Comparator<Employee> sortByAgeComparator2 = (Employee e1, Employee e2) -> e1.getAge() - e2.getAge();
		Comparator<Employee> sortByAgeComparator3 = (e1,e2) -> e1.getAge().compareTo(e2.getAge());
		
		employeeList.sort(sortByAgeComparator1);
		employeeList.forEach(System.out::println);
		//OR
		//way-02 , using jdk7
		Collections.sort(employeeList, sortByAgeComparator2);
		employeeList.forEach(System.out::println);
		//or
		//way-03 , using jdk8
		employeeList.sort(sortByAgeComparator3);
		employeeList.forEach(System.out::println);
		// OR
		//way-04 , using jdk8
		employeeList.stream().sorted(sortByAgeComparator3).collect(Collectors.toList()).forEach(System.out::println);
	
	}

	public static void sortEmpBySalary() {
		
		Comparator<Employee> sortBySalComparator1 = new Comparator<Employee>() {
			@Override
			public int compare(Employee emp1, Employee emp2) {
				return (int) (emp1.getSalary() - emp2.getSalary());
			}
		};
		
		Comparator<Employee> sortBySalComparator2 = (Employee e1, Employee e2) -> e1.getSalary().compareTo(e2.getSalary());
		
		employeeList.sort(sortBySalComparator1);
		//employeeList.sort(sortBySalComparator);
		employeeList.forEach(System.out::println);
		// OR
		Collections.sort(employeeList, sortBySalComparator1);
		employeeList.forEach(System.out::println);
		//OR
		Collections.sort(employeeList, sortBySalComparator2);
		employeeList.forEach(System.out::println);
	}
	
	public static void sortEmpBySalaryUsingJava8() {
		
		Comparator<Employee> sortByAgeComparator = (e1,e2) -> e1.getAge().compareTo(e2.getAge());
		Comparator<Employee> sortBySalComparator = (Employee e1, Employee e2) -> e1.getSalary().compareTo(e2.getSalary());
		
		employeeList.sort(sortBySalComparator);
		employeeList.forEach(System.out::println);
		// OR
		Collections.sort(employeeList, sortBySalComparator);
		employeeList.forEach(System.out::println);
		//or
		employeeList.stream().sorted(sortByAgeComparator).collect(Collectors.toList()).forEach(System.out::println);
	
	}

	public static void convertEmpListToMap() {
		
		/*
		 * ####### converting list to map and sorting sal in desc order
		 */
		
		Comparator<Employee> sortBySalaryComparator = Comparator.comparingDouble(Employee::getSalary);
		Map<String, Double> result1 = employeeList.stream()
				.sorted(sortBySalaryComparator)
				.collect(Collectors.toMap(Employee::getName, Employee::getSalary, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		System.out.println(" After sorting based on salary in desc : " + result1);

	}
}
