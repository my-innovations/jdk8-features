package collections_class;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import model.Employee;

public class CollectionsDemo {

	// some dummy data to operate on
	private static int[] intArrayPrimitiveType = new int[] { 1, 34, 78, 90, 27, 45 };
	private static Integer[] intArrayWraperType = new Integer[] { 1, 34, 78, 90, 27, 45 };
	
	private static float[] floatArrayPrimitiveType = new float[] { 1.5f, 34.8f, 78.2f, 90.0f, 27.78f, 45.31f };
	private static float[] floatArrayWrapperType = new float[] { 1.5f, 34.8f, 78.2f, 90.0f, 27.78f, 45.31f };
	
	private static long[] longArrayPrimitiveType = new long[] { 1, 34, 78, 90, 27, 45 };
	private static Long[] longArrayWrapperType = new Long[] { 1l, 34l, 78l, 90l, 27l, 45l };
	
	private static double[] doubleArrayPrimitive = new double[] { 1, 34, 78, 90, 27, 45 };
	private static double[] doubleArrayWrapperType = new double[] { 1, 34, 78, 90, 27, 45 };
	
	private static char[] charArrayPrimitiveType = new char[] { 'a', 'm', 'y', 'u' };
	private static Character[] charArrayWrapperType = new Character[] { 'a', 'm', 'y', 'u' };
	
	private static String[] strArray = { "Punya", "Partha sarathi", "Aswini kumar" };

	//private static List<Byte> bytelist = Arrays.asList(1, 34, 78, 90, 27, 45); //CE
	//private static List<Short> shortlist = Arrays.asList(1, 34, 78, 90, 27, 45); //CE
	private static List<Integer> intlist = Arrays.asList(1, 34, 78, 90, 27, 45); 
	private static List<Float> floatlist = Arrays.asList(1.5f, 34.8f, 78.2f, 90.0f, 27.78f, 45.31f);
	private static List<Long> longlist = Arrays.asList(1l, 34l, 78l, 90l, 27l, 45l);
	private static List<Double> doublelist = Arrays.asList(1d, 34d, 78d, 90d, 27d, 45d);

	// private static Set<Integer> set = Arrays.asSet(1,34,78,90,27,45); //CE
	private static Set<Integer> numsSet = new HashSet(intlist);

	private static Map<Integer, String> map = new HashMap();

	private static List<String> strList = Arrays.asList("punya", "punyasmruti","pankaj kumar", "aswini k ssingh", "parthasarathi");
	private static List<Employee> empList = Arrays.asList(new Employee(1, "Shifoo", "acc1", "IT", 25, 150000d),new Employee(2, "Punya", "acc2", "IT", 40, 250000d));

	public static void main(String[] args) {
		
		sortIntegers();
		sortStrings();
		sortStringsByLength();
		countNoOfOccurancesOfEachItemInArrayOrList();
		

		//using DTO class
		//sortEmpByIdUsingJava7(); 
		//sortEmpByIdUsingJava8();
		//sortListEmpNamesUsingJava7();
		//sortEmpNamesUsingJava8();
		//sortEmpBySalaryUsingJava7();
		//sortEmpByAge();
		//convertEmpListToMap();
		

	}// main
	

	public static void sortIntegers() {

		Comparator<Integer> customComparator1 = new Comparator<Integer>() {
			@Override
			public int compare(Integer num1, Integer num2) {
				return num1.compareTo(num2); // ascending
				// return num2.compareTo(num1); // descending
			}
		};

		Comparator<Integer> customComparator2 = (Integer num1, Integer num2) -> num1.compareTo(num2); // ascending
		Comparator<Integer> customComparator3 = (Integer num1, Integer num2) -> num2.compareTo(num1); // descending

		Arrays.sort(intArrayWraperType); // default sort
		System.out.println(Arrays.toString(intArrayPrimitiveType));

		Arrays.sort(intArrayWraperType, customComparator1);
		System.out.println(Arrays.toString(intArrayPrimitiveType));

		Arrays.sort(intArrayWraperType, customComparator2);
		System.out.println(Arrays.toString(intArrayWraperType));

		Arrays.sort(intArrayWraperType, customComparator3);
		System.out.println(Arrays.toString(intArrayWraperType));

		intlist.sort(customComparator1);
		intlist.forEach((name) -> System.out.print(name + " "));

		System.out.println();
		intlist.sort(customComparator2);
		System.out.print(intlist + " ");

		System.out.println();
		intlist.sort(customComparator3);
		System.out.println(intlist);

		Collections.sort(Arrays.asList(intArrayWraperType)); // default sort
		System.out.println(Arrays.toString(intArrayWraperType));

		Collections.sort(Arrays.asList(intArrayWraperType), customComparator1);
		System.out.println(Arrays.toString(intArrayWraperType));

		Collections.sort(Arrays.asList(intArrayWraperType), customComparator2);
		System.out.println(Arrays.toString(intArrayWraperType));

		Collections.sort(Arrays.asList(intArrayWraperType), customComparator3);
		System.out.println(Arrays.toString(intArrayWraperType));

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
		

		Arrays.sort(strArray); //default sort
		System.out.println(Arrays.toString(strArray));

		Arrays.sort(strArray, customComparator1);
		System.out.println(Arrays.toString(strArray));
		
		Arrays.sort(strArray, customComparator2);
		System.out.println(Arrays.toString(strArray));
		
		Arrays.sort(strArray, customComparator3);
		System.out.println(Arrays.toString(strArray));
		
		strList.sort(customComparator1);
		strList.forEach((name) -> System.out.print(name +" "));
		
		System.out.println();
		strList.sort(customComparator2);
		System.out.print(strList +" ");
		
		System.out.println();
		strList.sort(customComparator3);
		System.out.println(strList);
		
		Collections.sort(Arrays.asList(strArray)); //default sort
		System.out.println(Arrays.toString(strArray));
		
		Collections.sort(Arrays.asList(strArray), customComparator1);
		System.out.println(Arrays.toString(strArray));
		
		Collections.sort(Arrays.asList(strArray), customComparator2);
		System.out.println(Arrays.toString(strArray));

		Collections.sort(Arrays.asList(strArray), customComparator3);
		System.out.println(Arrays.toString(strArray));

		Collections.sort(strList); // default sorting
		strList.forEach((name) -> System.out.print(name+" "));

		System.out.println();
		Collections.sort(strList, customComparator1);
		strList.forEach((name) -> System.out.print(name+" "));
		
		System.out.println();
		Collections.sort(strList, customComparator2);
		strList.forEach((name) -> System.out.print(name +" "));
		
		System.out.println();
		Collections.sort(strList, customComparator3);
		strList.forEach((name) -> System.out.print(name+" "));
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
		
		
		Arrays.sort(strArray, sortByLengthComparator1);
		System.out.println(Arrays.toString(strArray));
		
		Arrays.sort(strArray, sortByLengthComparator2);
		System.out.println(Arrays.toString(strArray));
		
		Arrays.sort(strArray, sortByLengthComparator3);
		System.out.println(Arrays.toString(strArray));
		
		strList.sort(sortByLengthComparator1);
		strList.forEach(System.out::println);
		// OR
		strList.sort(sortByLengthComparator2);
		strList.forEach(System.out::println);
		// OR
		Collections.sort(strList, sortByLengthComparator2);
		strList.forEach(System.out::println);
		//OR
		strList.sort(sortByLengthComparator2);
		strList.forEach(System.out::println);
		// OR
		Collections.sort(strList, sortByLengthComparator3);
		strList.forEach(System.out::println);
		
	}
	
private static void countNoOfOccurancesOfEachItemInArrayOrList() {
		
		//Integer array as input
		List<Integer> intlist1 = Arrays.asList(intArrayWraperType);
		Set<Integer> set1 = new HashSet<Integer>(intlist1);
		for (Integer num : set1)
			System.out.println(num + ": " + Collections.frequency(intlist1, num));

		System.out.println();

		//Integer list as input
		Set<Integer> set = new HashSet<Integer>(intlist);
		for (Integer num : set)
			System.out.println(num + ": " + Collections.frequency(intlist, num));

		System.out.println();

		//string list as input
		Set<String> set2 = new HashSet<>(strList);
		for (String name : set2)
			System.out.println(name + ": " + Collections.frequency(strList, name));
	}

	//**********************************************************************************************************
	
	public static void sortEmpByIdUsingJava7() {
		Comparator<Employee> sortByIdCustomComparator = new Comparator<Employee>() {
			@Override
			public int compare(Employee emp1, Employee emp2) {
				return emp1.getId() - emp2.getId();
			}
		};
		empList.sort(sortByIdCustomComparator);
		empList.forEach(System.out::println);
		// OR
		Collections.sort(empList, sortByIdCustomComparator);
		empList.forEach(System.out::println);
	}

	public static void sortEmpByIdUsingJava8() {
		Comparator<Employee> sortByIdCustomComparator = (Employee emp1, Employee emp2) -> emp1.getId() - emp2.getId();
		empList.sort(sortByIdCustomComparator);
		empList.forEach(System.out::println);
		// OR
		Collections.sort(empList, sortByIdCustomComparator);
		empList.forEach(System.out::println);
		// or
		empList.stream().sorted((e1, e2) -> e1.getId().compareTo(e2.getId())).collect(Collectors.toList()).forEach(System.out::println);
	}

	public static void sortListEmpNamesUsingJava7() {
		Comparator<Employee> sortByNameComparator = new Comparator<Employee>() {
			@Override
			public int compare(Employee e1, Employee e2) {
				return e1.getName().compareTo(e2.getName());
			}
		};
		empList.sort(sortByNameComparator);
		empList.forEach(System.out::println);
		// OR
		Collections.sort(empList, sortByNameComparator);
		empList.forEach(System.out::println);

	}

	public static void sortEmpNamesUsingJava8() {
		Comparator<Employee> sortByNameComparatorWithLambda = (Employee e1, Employee e2) -> e1.getName().compareTo(e2.getName());
		empList.sort(sortByNameComparatorWithLambda);
		empList.forEach(System.out::println);
		// OR
		Collections.sort(empList, sortByNameComparatorWithLambda);
		empList.forEach(System.out::println);
		//or
		empList.stream().sorted((e1,e2) -> e1.getName().compareTo(e2.getName())).collect(Collectors.toList()).forEach(System.out::println);
	}

	public static void sortEmpBySalaryUsingJava7() {
		Comparator<Employee> sortBySal = new Comparator<Employee>() {
			@Override
			public int compare(Employee emp1, Employee emp2) {
				return (int) (emp1.getSalary() - emp2.getSalary());
			}
		};
		empList.sort(sortBySal);
		empList.forEach(System.out::println);
		// OR
		Collections.sort(empList, sortBySal);
		empList.forEach(System.out::println);
	}
	
	public static void sortEmpBySalaryUsingJava8() {
		
		Comparator<Employee> sortBySalComparator = (Employee e1, Employee e2) -> e1.getSalary().compareTo(e2.getSalary());
		empList.sort(sortBySalComparator);
		empList.forEach(System.out::println);
		// OR
		Collections.sort(empList, sortBySalComparator);
		empList.forEach(System.out::println);
		//or
		empList.stream().sorted((e1,e2) -> e1.getAge().compareTo(e2.getAge())).collect(Collectors.toList()).forEach(System.out::println);
	
	}


	public static void sortEmpByAge() {
		
		//way-01 , using jdk7
		Comparator<Employee> sortByAgeComparator1 = new Comparator<Employee>() {
			@Override
			public int compare(Employee emp1, Employee emp2) {
				return (int) (emp1.getAge() - emp2.getAge());
			}
		};
		empList.sort(sortByAgeComparator1);
		empList.forEach(System.out::println);
		//OR
		//way-02 , using jdk7
		Collections.sort(empList, sortByAgeComparator1);
		empList.forEach(System.out::println);
		//or
		//way-03 , using jdk8
		Comparator<Employee> sortByAgeComparator2 = (Employee e1, Employee e2) -> e1.getAge() - e2.getAge();
		empList.sort(sortByAgeComparator2);
		empList.forEach(System.out::println);
		// OR
		//way-04 , using jdk8
		empList.stream().sorted((e1,e2) -> e1.getAge().compareTo(e2.getAge())).collect(Collectors.toList()).forEach(System.out::println);
	
	}

	public static void convertEmpListToMap() {
		/*
		 * ####### converting list to map and sorting sal in desc order
		 */

		Map<String, Double> result1 = empList.stream()
				.sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).collect(Collectors.toMap(
						Employee::getName, Employee::getSalary, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		System.out.println(" After sorting based on salary in desc : " + result1);

	}
}
