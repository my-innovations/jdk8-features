package test;

import java.util.Arrays;
import java.util.Comparator;

public class Test3 {

	public static void main(String[] args) {
		
		Integer arr3[] = {1,6,8,3,5};
		
		//way01
		Arrays.sort(arr3, new MyComparator() );
		System.out.println(Arrays.toString(arr3));
		
		//way-02
		Arrays.sort(arr3, (i1,i2) -> i2.compareTo(i1));
		System.out.println(Arrays.toString(arr3));

	}

}

class MyComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		return o2.compareTo(o1);
	}
}
