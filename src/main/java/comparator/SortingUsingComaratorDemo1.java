package comparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingUsingComaratorDemo1 {

	public static void main(String[] args) {

		List<String> namesList = new ArrayList<String>();
		namesList.add("Mahesh ");
		namesList.add("Suresh ");
		namesList.add("Ramesh ");
		namesList.add("Naresh ");
		namesList.add("Kalpesh ");

		SortingUsingComaratorDemo1 obj = new SortingUsingComaratorDemo1();

		System.out.println("Sort using Java 7 syntax: ");
		obj.sortUsingJava7(namesList);
		System.out.println(namesList);

		System.out.println("Sort using Java 8 syntax: ");
		obj.sortUsingJava8(namesList);
		System.out.println(namesList);
	}

	// sort using java 7
	private void sortUsingJava7(List<String> names) {
		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
			}
		});
	}

	// sort using java 8
	private void sortUsingJava8(List<String> names) {
		Collections.sort(names, (String str1, String str2) -> str1.compareTo(str2));
		//Collections.sort(names, (str1, str2) -> str1.compareTo(str2)); //OK
	}

}
