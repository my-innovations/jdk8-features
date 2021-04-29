package string_joiner;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class StringJoiner_demo {
	public static void main(String[] args) {

		String abc = String.join(" ", "Java", "8");
		System.out.println(abc); // java 8
		
		String result2 = String.join("-", "2015", "10", "31");
		System.out.println(result2); // 2015-10-31
		
		List<String> list = Arrays.asList("java", "python", "nodejs", "ruby");
		String result3 = String.join(", ", list);
		System.out.println(result3); // java, python, nodejs, ruby

		StringJoiner sj = new StringJoiner("/", "DOB-", " ");
		sj.add("2016");
		sj.add("02");
		sj.add("26");
		String result = sj.toString(); // DOB-2016/02/26 
		System.out.println(result);

		List<String> list2 = Arrays.asList("java", "python", "nodejs", "ruby");
		String result02 = list2.stream().map(x -> x).collect(Collectors.joining(" | ")); // java | python | nodejs | ruby
		System.out.println(result02);

		// passing comma(,) as delimiter
		StringJoiner joinNames = new StringJoiner(",");
		// Adding values to StringJoiner
		joinNames.add("Rahul");
		joinNames.add("Raju");
		joinNames.add("Peter");
		joinNames.add("Raheem");
		System.out.println(joinNames);

		// app-02
		// passing comma(,) and square-brackets as delimiter
		StringJoiner joinNames2 = new StringJoiner(",", "[", "]");
		// Adding values to StringJoiner
		joinNames2.add("Rahul");
		joinNames2.add("Raju");
		joinNames2.add("Peter");
		joinNames2.add("Raheem");
		System.out.println(joinNames2); //[Rahul,Raju,Peter,Raheem]

		// app-03 - Merge Two StringJoiner
		// passing comma(,) and square-brackets as delimiter
		StringJoiner joinNames3 = new StringJoiner(",", "[", "]");

		// Adding values to StringJoiner
		joinNames3.add("Rahul");
		joinNames3.add("Raju");

		// Creating StringJoiner with :(colon) delimiter
		// passing colon(:) and square-brackets as delimiter
		StringJoiner joinNames4 = new StringJoiner(":", "[", "]");

		// Adding values to StringJoiner
		joinNames4.add("Peter");
		joinNames4.add("Raheem");

		// Merging two StringJoiner
		StringJoiner merge = joinNames3.merge(joinNames4);
		System.out.println(merge);

		// app-04 - StringJoiner class Methods
		StringJoiner joinNames5 = new StringJoiner(","); // passing comma(,) as delimiter
		// Prints nothing because it is empty
		System.out.println(joinNames5);

		// We can set default empty value.
		joinNames5.setEmptyValue("It is empty");
		System.out.println(joinNames5); // It is empty

		// Adding values to StringJoiner
		joinNames5.add("Rahul");
		joinNames5.add("Raju");
		System.out.println(joinNames5); //Rahul,Raju

		// Returns length of StringJoiner
		int length = joinNames5.length();
		System.out.println("Length: " + length); //Length: 10

		// Returns StringJoiner as String type
		String str = joinNames5.toString();
		System.out.println(str); //Rahul,Raju

		// Now, we can apply String methods on it
		char ch = str.charAt(3);
		System.out.println("Character at index 3: " + ch); //Character at index 3: u

		// Adding one more element
		joinNames5.add("Sorabh");
		System.out.println(joinNames5); //Rahul,Raju,Sorabh

		// Returns length
		int newLength = joinNames5.length();
		System.out.println("New Length: " + newLength); //17
	}
}
