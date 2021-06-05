package forEach;

import java.util.stream.IntStream;

public class Test {

	public static void main(String[] args) {
		
		//way-01
		int res=0;
		for(int i=0;i<=50;i++) {
			res +=i;
		}
		System.out.println(res);

		//way-02
		//using jdk8 - summation
		int total = IntStream.rangeClosed(0,50).map(Integer::new).sum();
		System.out.println(total);
	}

}
