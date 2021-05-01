package collectors_class;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import model.Product;
import model.Student;

public class CollectorsDemo {

	private static double[] doubleArrayprimitive = { 2.5d, 7.8d, 4.9d };
	private static Double[] doubleArray = { 2.5d, 7.8d, 4.9d };
	private static List<String> namesList = Arrays.asList("Jon", "Ajeet", "Steve", "Ajeet", "Jon", "Ajeet");

	private static List<Product> productsList = Arrays.asList(
		new Product(1, "HP Laptop", 25000f),
		new Product(2, "Dell Laptop", 30000f), 
		new Product(5, "Apple Laptop", 90000f),
		new Product(3, "Lenevo Laptop", 28000f), 
		new Product(4, "Sony Laptop", 28000f));
	
	private static List<Student> studentslist = Arrays.asList(
		new Student(11, "Jon", 22), 
		new Student(22, "Steve", 19),
		new Student(33, "Lucy", 23), 
		new Student(55, "Maggie", 18));

	public static void main(String[] args) {
		
		sumOfAllItemsOfDoubleArray();
		findNoOfOccurancesOfEachItemInAnArray();
		gatherAllProductPricesInList();
		sumOfAllprices();
		gatherProductIdWithName();
		gatherProductNameWithPrice();
		countTotalNoOfProducts();
		getAllStudentNames();
		findStudentWithMaxAge();
		findStudentWithMinAge();
		findStudentWithAgeGreaterThan11();
		summeryStatistics();

	}

	public static void sumOfAllItemsOfDoubleArray() {
		Double d = Stream.of(doubleArray).reduce(0.0, (Double d1, Double d2) -> d1 + d2);
		// Double d = Collectors.computeFinalSum(doubleArrayprimitive);
		System.out.println(d);

		//product of all items of the array
		Double res = (Double) Stream.of(doubleArray).collect(Collectors.reducing(1d, (num1, num2) -> num1 * num2));
		System.out.println(res);
	}

	public static void findNoOfOccurancesOfEachItemInAnArray() {
		Map<String, Long> map = namesList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(map);
		
		Map<String, Long> counts = namesList.stream().collect(Collectors.groupingBy(item -> item, Collectors.counting()));
		System.out.println(counts);
	}

	public static void gatherAllProductPricesInList() {

		// gather all the products prices to list
		List<Float> productPriceList = productsList.stream().map(product -> product.price).collect(Collectors.toList());
		System.out.println(productPriceList); // [25000.0, 30000.0, 90000.0, 28000.0, 28000.0]

		// OR

		// gathering all prices as a Set
		Set<Float> productPriceList2 = productsList.stream().map(product -> product.price).collect(Collectors.toSet());
		System.out.println(productPriceList2);
	}

	public static void sumOfAllprices() {

		// sum of all ids of all products
		int sumId = productsList.stream().collect(Collectors.summingInt(product -> product.id));
		System.out.println("Sum of all id's: " + sumId);
		
		Double average2 = productsList.stream().collect(Collectors.averagingInt(product -> product.id));
		System.out.println("Average id is: " + average2);

		// summ of all the prices of all products
		Double sumPrices = productsList.stream().collect(Collectors.summingDouble(product -> product.price));
		System.out.println("Sum of all prices: " + sumPrices); // Sum of prices: 201000.0

		// get average Price of all products
		Double average = productsList.stream().collect(Collectors.averagingDouble(product -> product.price));
		System.out.println("Average price is: " + average);

	}

	public static void gatherProductIdWithName() {

		Map<Integer, String> result1 = productsList.stream().collect(Collectors.toMap(Product::getId, Product::getName));
		System.out.println("After converting list map  : " + result1);

	}

	public static void gatherProductNameWithPrice() {
		Map<String, Float> result01 = productsList.stream().collect(Collectors.toMap(Product::getName, Product::getPrice));
		System.out.println("After converting list map  : " + result01);

		// #################### converting list to map ####################
		Map<String, Float> productNamePriceMap = productsList.stream().collect(Collectors.toMap(product -> product.getName(), product -> product.getPrice()));
		System.out.println("After converting list map  : " + productNamePriceMap);

		// sort by keys, a,b,c..., and return a new LinkedHashMap
		// toMap() will returns HashMap by default, we need LinkedHashMap to
		// keep the order.
		Map<String, Float> result = productNamePriceMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
						LinkedHashMap::new));
		System.out.println("sorted map based on key:" + result);

		// sort by values, and reserve it, 10,9,8,7,6...
		Map<String, Float> resultt = productNamePriceMap.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toMap(
						Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		System.out.println("sorted map based on value:" + resultt);

	}

	public static void countTotalNoOfProducts() {

		Long noOfElements = productsList.stream().collect(Collectors.counting());
		System.out.println("Total no of products : " + noOfElements);
	}

	public static void getAllStudentNames() {

		List<String> namesList = studentslist.stream().map(stud -> stud.name).collect(Collectors.toList());
		namesList.forEach(System.out::println);
	}
	
	public static void getAverageAgeOfAllStudents() {
		
		Double avgAge = studentslist.stream().collect(Collectors.averagingDouble(student -> student.age));
		System.out.println("Average Age of Students is: " + avgAge);
	}
	
	public static void findStudentWithMaxAge() {
		Comparator<Student> c = (Student user1, Student user2) -> user1.getAge() - user2.getAge();
		Optional<Student> s = studentslist.stream().collect(Collectors.maxBy(c));
		//Optional<Student> s = studenstlist.stream().collect(Collectors.maxBy(Comparator..reverseOrder()));
		System.out.println(s.get());
	}
	
	public static void findStudentWithAgeGreaterThan11() {
		Map<Boolean, List<Student> > map = studentslist.stream().collect(Collectors.partitioningBy(s -> s.age > 20));
		System.out.println(map);
		
		
	}
	
	public static void summeryStatistics() {
		//Using Collectors.summarizingInt()
	    IntSummaryStatistics intSummaryStatistics = studentslist
	        .stream()
	        .collect(Collectors.summarizingInt(Student::getAge));
	    System.out.println("IntSummaryStatistics for age: " + intSummaryStatistics);

	}
	
	
	
	public static void findStudentWithMinAge() {
		Comparator<Student> c = (Student user1, Student user2) -> user1.getAge() - user2.getAge();
		Optional<Student> s = studentslist.stream().collect(Collectors.minBy(c));
		System.out.println(s.get());
	}
	
	
	public static void getAllStudentsWhereIdGreaterThan22() {
		
		List<Student> studentsList = studentslist.stream().filter(stud -> stud.id > 22).collect(Collectors.toList());
		studentsList.forEach(System.out::println);
		//OR
		Set<Student> studentsSet = studentslist.stream().filter(stud -> stud.id > 22).collect(Collectors.toSet());
		studentsSet.forEach(System.out::println);
	}
}
