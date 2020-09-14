package lambda_expression;

import java.util.Comparator;

public class ComparatorWithLamdaDemo {

	public static void main(String[] args) {

		// Before java-8
		Comparator<Integer> c1 = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		};
		System.out.println(c1.compare(10, 15));

		// java-8
		Comparator<Integer> c2 = (Integer i1, Integer i2) -> i1.compareTo(i2);
		System.out.println(c2.compare(30, 45));
		//OR
		Comparator<Integer> c3 = (x,y) -> x.compareTo(y);
		System.out.println(c3.compare(30, 45)); //-1
	}
}
