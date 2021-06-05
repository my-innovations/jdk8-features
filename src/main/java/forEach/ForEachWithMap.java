package forEach;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ForEachWithMap {

	public static void main(String[] args) {

		// dummy data
		Map<Integer, String> hmap = new HashMap<Integer, String>();
		hmap.put(1, "Monkey");
		hmap.put(2, "Dog");
		hmap.put(3, "Cat");
		hmap.put(4, "Lion");
		hmap.put(5, "Tiger");
		hmap.put(6, "Bear");

		Map<String, String> countryCapitalMap = new HashMap<>();
		countryCapitalMap.put("India", "Delhi");
		countryCapitalMap.put("USA", "Washington, D.C.");
		countryCapitalMap.put("Japan", "Tokyo");
		countryCapitalMap.put("Canada", "Ottawa");

		// ##########################################################################################################

		// using jdk7
		for (Entry<Integer, String> entry : hmap.entrySet()) {
			System.out.println("ID: " + entry.getKey() + " : Animal: " + entry.getValue());
		}

		// using jdk7
		for (Entry<String, String> entry : countryCapitalMap.entrySet()) {
			System.out.println("Country: " + entry.getKey() + " : Capital: " + entry.getValue());
		}

		// using jdk8
		hmap.forEach((key, value) -> System.out.println(key + " : " + value));

		// using jdk8
		hmap.forEach((key, value) -> {
			if (key == 4) {
				System.out.println("Value associated with key: 4 is: " + value);
			}
		});

		// using jdk8
		hmap.forEach((key, value) -> {
			if ("Cat".equalsIgnoreCase(value)) {
				System.out.println("Key associated with Value Cat is: " + key);
			}
		});

		// using jdk8
		countryCapitalMap.forEach((k, v) -> System.out.println("Country: " + k + " : Capital: " + v));

		// using jdk8
		countryCapitalMap.forEach((key, val) -> {
			// you can implement some business logic here..
			// System.out.println("Key : " + k + " Value : " + v);
			if (val.equals("Delhi")) {
				System.out.println("Hello  " + val);
			}

		});
		
	}
}


