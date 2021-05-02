package string_joiner;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class StringJoiner_demo {
	
	public static void main(String[] args) {

		//joins strings by space
		String abc = String.join(" ", "Java", "8");
		System.out.println(abc); // java 8
		
		//joins strings by -
		String result2 = String.join("-", "2015", "10", "31");
		System.out.println(result2); // 2015-10-31
		
		//joins strings by ,
		List<String> list = Arrays.asList("java", "python", "nodejs", "ruby");
		String result3 = String.join(", ", list);
		System.out.println(result3); // java, python, nodejs, ruby
		
		//joins strings by |
		List<String> list2 = Arrays.asList("java", "python", "nodejs", "ruby");
		String result02 = list2.stream().map(x -> x).collect(Collectors.joining(" | ")); // java | python | nodejs | ruby
		System.out.println(result02);

		//joins strings by / with initial DOB-
		StringJoiner joinner1 = new StringJoiner("/", "DOB-", " ");
		joinner1.add("2016");
		joinner1.add("02");
		joinner1.add("26");
		String result = joinner1.toString(); // DOB-2016/02/26 
		System.out.println(result);

		
		// joins strings by comma
		StringJoiner joinNames = new StringJoiner(",");
		// Adding values to StringJoiner
		joinNames.add("Rahul");
		joinNames.add("Raju");
		joinNames.add("Peter");
		joinNames.add("Raheem");
		System.out.println(joinNames);

		// joins string by comma and square-brackets as delimiter
		StringJoiner joinNames2 = new StringJoiner(",", "[", "]");
		// Adding values to StringJoiner
		joinNames2.add("Rahul");
		joinNames2.add("Raju");
		joinNames2.add("Peter");
		joinNames2.add("Raheem");
		System.out.println(joinNames2); //[Rahul,Raju,Peter,Raheem]

		//Ex- joins string by comma and Merge Two StringJoiner
		// passing comma(,) and square-brackets as delimiter
		StringJoiner joinNames3 = new StringJoiner(",", "[", "]");
		joinNames3.add("Rahul");
		joinNames3.add("Raju");

		//Ex-05 , 
		// Creating StringJoiner with :(colon) delimiter
		// passing colon(:) and square-brackets as delimiter
		StringJoiner joinNames4 = new StringJoiner(":", "[", "]");
		joinNames4.add("Peter");
		joinNames4.add("Raheem");

		//Ex-06 , 
		// Merging two StringJoiner
		StringJoiner merge = joinNames3.merge(joinNames4);
		System.out.println(merge);

		//Ex-07 , StringJoiner class Methods
		StringJoiner joinner2 = new StringJoiner(","); // passing comma(,) as delimiter
		// Prints nothing because it is empty
		System.out.println(joinner2);

		// We can set default empty value.
		joinner2.setEmptyValue("It is empty");
		System.out.println(joinner2); // It is empty

		// Adding values to StringJoiner
		joinner2.add("Rahul");
		joinner2.add("Raju");
		System.out.println(joinner2); //Rahul,Raju

		// Returns length of StringJoiner
		int length = joinner2.length();
		System.out.println("Length: " + length); //Length: 10

		// Returns StringJoiner as String type
		String str = joinner2.toString();
		System.out.println(str); //Rahul,Raju

		// Now, we can apply String methods on it
		char ch = str.charAt(3);
		System.out.println("Character at index 3: " + ch); //Character at index 3: u

		// Adding one more element
		joinner2.add("Sorabh");
		System.out.println(joinner2); //Rahul,Raju,Sorabh

		// Returns length
		int newLength = joinner2.length();
		System.out.println("New Length: " + newLength); //17
	}
}
