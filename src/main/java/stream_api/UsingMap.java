package stream_api;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class UsingMap {
	
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
		
		//sortByKeys();
		sortByValues();
		
	}
	
	
	public static void sortByKeys() {
		
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
	
	
	public static void sortByValues() {
		
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

}
