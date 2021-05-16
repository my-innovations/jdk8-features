package stream_api;

import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import model.Product;

public class StreamWithCollectorsDemo {

	//some dummy data 
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
	private static List<String> stringList = Arrays.asList("Jon", "Ajeet", "Steve", "Ajeet", "Jon", "Ajeet");
	
	
	private static List<Product> productsList = Arrays.asList(
		new Product(1, "HP Laptop", 25000f),
		new Product(2, "Dell Laptop", 30000f), 
		new Product(5, "Apple Laptop", 90000f),
		new Product(3, "Lenevo Laptop", 28000f), 
		new Product(4, "Sony Laptop", 28000f));

	public static void main(String[] args) {
		
		//using Stream.reduce or Collectors.reducing
		summationOfAllItemsOfArray();
		multiplicationOfAllItemsOfArray();
		findNoOfOccurancesOfEachItemInAnArray();
		gatherAllProductPricesInList();
		sumOfAllpricesFromAllProducts();
		getProductIdWithproductName();
		getrProductNameWithProductPrice();
		countTotalNoOfProducts();
		getAllProductsNames();
		getAvgPriceOfAllProducts();
		findProductWithMaxPrice();
		summeryStatistics();
		findProductWithMinPrice();
		getAllProductssWherePriceGreaterThan20k();
		findProductWithPriceGreaterThan30k();
		
	}

	public static void summationOfAllItemsOfArray() {
		
		Integer sumRes5 = Stream.of(integerArrayWrapperType).reduce(0, (Integer d1, Integer d2) -> d1 + d2);
		System.out.println(sumRes5);

		Long sumRes2 = Stream.of(longArrayWrapperType).reduce(0L, (Long d1, Long d2) -> d1 + d2);
		System.out.println(sumRes2);

		Float sumRes3 = Stream.of(floatArrayWrapperType).reduce(0f, (Float d1, Float d2) -> d1 + d2);
		System.out.println(sumRes3);
		
		//Integer sumRes1 = Stream.of(integerArrayWrapperType).reduce(0, (Integer d1, Integer d2) -> d1 + d2); //OK
		// Integer sumRes1 = Collectors.computeFinalSum(IntegerArrayWrapperType);
		Integer sumRes1 = (Integer) Stream.of(integerArrayWrapperType).collect(Collectors.reducing(0, (Integer num1, Integer num2) -> num1 + num2));
		System.out.println(sumRes1);

		//Double sumRes4 = Stream.of(doubleArrayWrapperType).reduce(0.0, (Double d1, Double d2) -> d1 + d2); //Ok
		Double sumRes4 = (Double) Stream.of(doubleArrayWrapperType).collect(Collectors.reducing(0d, (Double num1, Double num2) -> num1 + num2));
		System.out.println(sumRes4);
	}
	
	public static void multiplicationOfAllItemsOfArray() {
		
		//way-01
		Double d = Stream.of(doubleArrayWrapperType).reduce(1.0, (Double d1, Double d2) -> d1 * d2);
		System.out.println(d);
		
		//way-02
		//product of all items of the array
		Double res = (Double) Stream.of(doubleArrayWrapperType).collect(Collectors.reducing(1d, (num1, num2) -> num1 * num2));
		System.out.println(res);
		
	}
	
	public static void findNoOfOccurancesOfEachItemInAnArray() {
		//way-01
		Map<String, Long> map = stringList
				.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(map);
		
		//way-02
		Map<String, Long> counts = stringList
				.stream()
				.collect(Collectors.groupingBy(item -> item, Collectors.counting()));
		System.out.println(counts);
	}
	
	
	/**
	 * ########################################
	 * Using Custom DTO
	 * ########################################
	 * 
	 */
	

	public static void gatherAllProductPricesInList() {

		// gather all the products prices to list
		List<Float> productPriceList = productsList
				.stream()
				.map(product -> product.getPrice()).collect(Collectors.toList());
		System.out.println(productPriceList); // [25000.0, 30000.0, 90000.0, 28000.0, 28000.0]

		// OR

		// gathering all prices as a Set
		Set<Float> productPriceList2 = productsList
				.stream()
				.map(product -> product.getPrice()).collect(Collectors.toSet());
		System.out.println(productPriceList2);
	}

	public static void sumOfAllpricesFromAllProducts() {

		// sum of all product ids of all products
		int sumId = productsList
				.stream()
				.collect(Collectors.summingInt(product -> product.getId()));
		System.out.println("Sum of all products id's: " + sumId);
		
		Double average2 = productsList
				.stream()
				.collect(Collectors.averagingInt(product -> product.getId()));
		System.out.println("Average of all products id is: " + average2);

		// summ of all the prices of all products
		Double sumPrices = productsList
				.stream()
				.collect(Collectors.summingDouble(product -> product.getPrice()));
		System.out.println("Sum of all products prices: " + sumPrices); // Sum of prices: 201000.0

		// get average Price of all products
		Double average = productsList
				.stream()
				.collect(Collectors.averagingDouble(product -> product.getPrice()));
		System.out.println("Average of all product price is: " + average);

	}

	public static void getProductIdWithproductName() {

		Map<Integer, String> result1 = productsList
				.stream()
				.collect(Collectors.toMap(Product::getId, Product::getName));
		System.out.println("After converting list map  : " + result1);
	}

	public static void getrProductNameWithProductPrice() {
		
		//way-01
		Map<String, Float> result01 = productsList
				.stream()
				.collect(Collectors.toMap(Product::getName, Product::getPrice));
		
		System.out.println("After converting list map  : " + result01);

		//way-02
		Map<String, Float> productNamePriceMap = productsList
				.stream()
				.collect(Collectors.toMap(product -> product.getName(), product -> product.getPrice()));
		
		System.out.println("After converting list map  : " + productNamePriceMap);

		// sort by keys, a,b,c..., and return a new LinkedHashMap
		// toMap() will returns HashMap by default, we need LinkedHashMap to
		// keep the order.
		Map<String, Float> result = productNamePriceMap.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,	LinkedHashMap::new));
		System.out.println("sorted map based on key:" + result);

		// sort by values, and reserve it, 10,9,8,7,6...
		Map<String, Float> resultt = productNamePriceMap.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		System.out.println("sorted map based on value:" + resultt);

	}

	public static void countTotalNoOfProducts() {

		Long noOfElements = productsList
				.stream()
				.collect(Collectors.counting());
		System.out.println("Total no of products : " + noOfElements);
	}

	public static void getAllProductsNames() {

		List<String> namesList = productsList
				.stream()
				.map(product -> product.getName())
				.collect(Collectors.toList());
		namesList.forEach(System.out::println);
	}
	
	public static void getAvgPriceOfAllProducts() {
		
		Double avgPrice = productsList
				.stream()
				.collect(Collectors.averagingDouble(product -> product.getPrice()));
		System.out.println("Average price of Product is: " + avgPrice);
	}
	
	public static void findProductWithMaxPrice() {
		Comparator<Product> priceComparator = (Product product1, Product product2) -> product1.getPrice().compareTo(product2.getPrice());
		Optional<Product> product = productsList
				.stream()
				.collect(Collectors.maxBy(priceComparator));
		//Optional<Product> product = productsList.stream().collect(Collectors.maxBy(Comparator..reverseOrder()));
		System.out.println(product.get());
	}
	
	public static void findProductWithMinPrice() {
		System.out.println();
		Comparator<Product> priceComparator = (Product product1, Product product2) -> product1.getPrice().compareTo(product2.getPrice());
		Optional<Product> productWithMinPrice = productsList
				.stream()
				.collect(Collectors.minBy(priceComparator));
		System.out.println(productWithMinPrice.get());
	}
	
	public static void summeryStatistics() {
		System.out.println();
	    DoubleSummaryStatistics intSummaryStatistics = productsList
	        .stream()
	        .collect(Collectors.summarizingDouble(Product::getPrice));
	    System.out.println("IntSummaryStatistics for price: " + intSummaryStatistics);
	}
	
	public static void getAllProductssWherePriceGreaterThan20k() {
		System.out.println();
		//List<Product> products = productsList.stream().filter(product -> product.price > 20000).collect(Collectors.toList());
		//products.forEach(System.out::println);
		//OR
		Set<Product> allProducts = productsList
				.stream()
				.filter(product -> product.getPrice() > 20000)
				.collect(Collectors.toSet());
		allProducts.forEach(System.out::println);
	}
	
	public static void findProductWithPriceGreaterThan30k() {
		Map<Boolean, List<Product> > map = productsList
				.stream()
				.collect(Collectors.partitioningBy(product -> product.getPrice() > 30000));
		System.out.println(map);
	}
}
