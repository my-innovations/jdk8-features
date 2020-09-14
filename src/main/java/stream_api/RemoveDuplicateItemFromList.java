package stream_api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicateItemFromList {

	public static void main(String[] args) {

		List<String> namesList = Arrays.asList("punya", "partha", "punya", "niraj");

		// Before java-8
		List<String> uniqueNames = new ArrayList<>();
		for (String name : namesList) {
			if (!uniqueNames.contains(name))
				uniqueNames.add(name);
		}
		System.out.println(uniqueNames);

		// java-8
		List<String> uniqueName2 = namesList.stream().distinct().collect(Collectors.toList());
		System.out.println(uniqueName2);

	}

}
