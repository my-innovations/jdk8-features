package collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class Product {

	int id;
	String name;
	float price;

	public Product(int id, String name, float price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}

public class Collectors_class_01 {

	public static void main(String[] args) {
		
		
		List<Product> productsList = new ArrayList<Product>();
		productsList.add(new Product(1, "HP Laptop", 25000f));
		productsList.add(new Product(2, "Dell Laptop", 30000f));
		productsList.add(new Product(5, "Apple Laptop", 90000f));
		productsList.add(new Product(3, "Lenevo Laptop", 28000f));
		productsList.add(new Product(4, "Sony Laptop", 28000f));

		// Fetching data as a List
		// fetching price and collecting as list
		List<Float> productPriceList = productsList.stream().map(x -> x.price).collect(Collectors.toList());
		System.out.println(productPriceList);

		// summing the prices
		Double sumPrices = productsList.stream().collect(Collectors.summingDouble(x -> x.price)); // collecting
																									// as
		// Converting Data as a Set
		Set<Float> productPriceList2 = productsList.stream().map(x -> x.price).collect(Collectors.toSet());
		System.out.println(productPriceList2);

		// using sum method // list
		System.out.println("Sum of prices: " + sumPrices);
		Integer sumId = productsList.stream().collect(Collectors.summingInt(x -> x.id));
		System.out.println("Sum of id's: " + sumId);

		// Getting Product Average Price
		Double average = productsList.stream().collect(Collectors.averagingDouble(p -> p.price));
		System.out.println("Average price is: " + average);

		// Counting Elements
		Long noOfElements = productsList.stream().collect(Collectors.counting());
		System.out.println("Total elements : " + noOfElements);

		// converting list to map
		// key = id, value - websites
		Map<Integer, String> result1 = productsList.stream()
				.collect(Collectors.toMap(Product::getId, Product::getName));
		System.out.println("After converting list map  : " + result1);

		// converting list to map
		// Same with result1, just different syntax
		// key = id, value = name
		Map<Integer, Float> result3 = productsList.stream()
				.collect(Collectors.toMap(x -> x.getId(), x -> x.getPrice()));

		System.out.println("After converting list map  : " + result3);

		// sort by keys, a,b,c..., and return a new LinkedHashMap
		// toMap() will returns HashMap by default, we need LinkedHashMap to
		// keep the order.
		Map result = result3.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors
				.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		System.out.println("sorted map based on key:" + result);

		// sort by values, and reserve it, 10,9,8,7,6...
		Map resultt = result3.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
						LinkedHashMap::new));
		System.out.println("sorted map based on value:" + resultt);
	}

}
