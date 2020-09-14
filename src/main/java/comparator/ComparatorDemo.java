package comparator;

import java.util.Comparator;

public class ComparatorDemo {

	public static void main(String[] args) {

		// Before java-8
		Comparator<Integer> comp1 = new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				return i1.compareTo(i2);
			}
		};
		System.out.println(comp1.compare(10, 20)); //-1

		// java-8
		Comparator<Integer> comp2 = (Integer i1, Integer i2) -> i1.compareTo(i2);
		System.out.println(comp2.compare(25, 15)); // 1

	}

}
