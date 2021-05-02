package collectors_class;

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

public class CollectorsDemo {

	//some dummy data 
	private static Double[] doubleArrayWrapperType = { 2.5d, 7.8d, 4.9d };
	private static List<String> namesList = Arrays.asList("Jon", "Ajeet", "Steve", "Ajeet", "Jon", "Ajeet");
	private static List<Product> productsList = Arrays.asList(
		new Product(1, "HP Laptop", 25000f),
		new Product(2, "Dell Laptop", 30000f), 
		new Product(5, "Apple Laptop", 90000f),
		new Product(3, "Lenevo Laptop", 28000f), 
		new Product(4, "Sony Laptop", 28000f));

	public static void main(String[] args) {
		
		summationOfAllItemsOfDoubleArray();
		multiplicationOfAllItemsOfDoubleArray();
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

	public static void summationOfAllItemsOfDoubleArray() {
		
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
	
	public static void multiplicationOfAllItemsOfDoubleArray() {
		
		//way-01
		Double d = Stream.of(doubleArrayWrapperType)
				.reduce(1.0, (Double d1, Double d2) -> d1 * d2);
		// Double d = Collectors.computeFinalSum(doubleArrayprimitive);
		System.out.println(d);
		
		//way-02
		//product of all items of the array
		Double res = (Double) Stream.of(doubleArrayWrapperType)
				.collect(Collectors.reducing(1d, (num1, num2) -> num1 * num2));
		System.out.println(res);
		
	}
	
	public static void findNoOfOccurancesOfEachItemInAnArray() {
		//way-01
		Map<String, Long> map = namesList
				.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(map);
		
		//way-02
		Map<String, Long> counts = namesList
				.stream()
				.collect(Collectors.groupingBy(item -> item, Collectors.counting()));
		System.out.println(counts);
	}

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
