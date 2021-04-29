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
	private static int[] intArray = new int[] { 1, 34, 78, 90, 27, 45 };
	private static Integer[] intArray2 = new Integer[] { 1, 34, 78, 90, 27, 45 };
	private static char[] charArray = new char[] { 'a', 'm', 'y', 'u' };
	private static float[] floatArray = new float[] { 1.5f, 34.8f, 78.2f, 90.0f, 27.78f, 45.31f };
	private static long[] longArray = new long[] { 1, 34, 78, 90, 27, 45 };
	private static double[] doubleArray = new double[] { 1, 34, 78, 90, 27, 45 };
	private static String[] strArray = { "Punya", "Partha", "Aswini" };

	private static List<Integer> intlist = Arrays.asList(1, 34, 78, 90, 27, 45);
	private static List<Float> floatlist = Arrays.asList(1.5f, 34.8f, 78.2f, 90.0f, 27.78f, 45.31f);
	private static List<Long> longlist = Arrays.asList(1l, 34l, 78l, 90l, 27l, 45l);
	private static List<Double> doublelist = Arrays.asList(1d, 34d, 78d, 90d, 27d, 45d);

	// private static Set<Integer> set = Arrays.asSet(1,34,78,90,27,45); //CE
	private static Set<Integer> numsSet = new HashSet(intlist);

	private static Map<Integer, String> map = new HashMap();

	private static List<String> namesList = Arrays.asList("punya", "pankaj kumar", "aswini", "parthasarathi");
	private static List<Employee> empList = Arrays.asList(new Employee(1, "Shifoo", "acc1", "IT", 25, 150000d),
			new Employee(2, "Punya", "acc2", "IT", 40, 250000d));

	public static void main(String[] args) {

		//sortArrayOfStringsByUsingJava7();
		//sortArrayOfStringsByUsingJava8();

		//sortListOfStringsByLengthUsingJava7();
		//sortListOfStringsByLengthUsingJava8();

		//sortListOfStringsUsingJava7();
		//sortListOfStringsUsingJava7_2();
		
		//sortListOfStringsUsingJava8();
		//sortListOfStringsByUsingJava8();

		//sortEmpByIdUsingJava7(); 
		//sortEmpByIdUsingJava8();
		//sortListEmpNamesUsingJava7();
		//sortEmpNamesUsingJava8();
		//sortEmpBySalaryUsingJava7();
		
		sortEmpByAge();

		//convertEmpListToMap();
		
		countNoOfOccurancesOfAnItemInArray();

	}// main
	
	
	public static void countNoOfOccurancesOfAnItemInArray() {
		List<Integer> list = Arrays.asList(intArray2);
		 Set<Integer> set = new HashSet<Integer>(list);
	        for (Integer i : set)
	            System.out.println(i + ": " + Collections.frequency(list, i));
	}

	public static void sortArrayOfStringsByUsingJava7() {
		
		Comparator<String> sortByLengthCustomComparator = new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				return str1.compareTo(str2);
			}
		};
		Arrays.sort(strArray);
		Arrays.sort(strArray, sortByLengthCustomComparator);
	}

	public static void sortArrayOfStringsByUsingJava8() {
		Comparator<String> sortByNameCustomComparator = (String str1, String str2) -> str1.compareTo(str2);
		Arrays.sort(strArray);
		Arrays.sort(strArray, sortByNameCustomComparator);
	}

	public static void sortListOfStringsByLengthUsingJava7() {

		Comparator<String> sortByLengthCustomComparator = new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				return str1.length() - str2.length();
				// return str1.compareTo(str2);
			}
		};
		namesList.sort(sortByLengthCustomComparator);
		namesList.forEach(System.out::println);
		// OR
		namesList.sort(Comparator.comparingInt(String::length));
		namesList.forEach(System.out::println);
		// OR
		Collections.sort(namesList, Comparator.comparingInt(String::length));
		namesList.forEach(System.out::println);
	}

	public static void sortListOfStringsByLengthUsingJava8() {

		Comparator<String> sortByLengthCustomComparator = (s1, s2) -> s1.length() - s2.length();
		// Comparator<String> sortByName = (String s1, String s2) -> s1.compareTo(s2); // sort by char
		namesList.sort(sortByLengthCustomComparator);
		namesList.forEach(System.out::println);
		// OR
		Collections.sort(namesList, sortByLengthCustomComparator);
		namesList.forEach(System.out::println);

	}

	public static void sortListOfStringsUsingJava7() {

		System.out.println("********  In ascending order :: ");

		Comparator<String> customComparator = new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				return str1.compareTo(str2); // ascending order
			}
		};
		namesList.sort(customComparator);
		namesList.forEach((n) -> System.out.println(n));
		// OR
		Collections.sort(namesList, customComparator);
		namesList.forEach((name) -> System.out.println(name));

	}

	public static void sortListOfStringsUsingJava7_2() {

		String[] strArray = { "Punya", "Partha", "Aswini" };

		// way-01
		// ex-01
		Arrays.sort(strArray);
		System.out.println(Arrays.toString(strArray));

		// or
		Collections.sort(Arrays.asList(strArray));
		System.out.println(Arrays.toString(strArray));

		// way-02
		// ex-2
		Comparator<String> strComparator = new Comparator<String>() {
			@Override
			public int compare(String name1, String name2) {
				// return name1.compareTo(name2);
				return name2.compareTo(name1);
			}
		};
		Arrays.sort(strArray, strComparator);
		System.out.println(Arrays.toString(strArray));

		Collections.sort(Arrays.asList(strArray), strComparator);
		System.out.println(Arrays.toString(strArray));

	}

	public static void sortListOfStringsUsingJava8() {
		Comparator<String> sortByNameComparatorWithLambda = (String str1, String str2) -> str1.compareTo(str2);
		namesList.sort(sortByNameComparatorWithLambda);
		System.out.println(namesList);
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
