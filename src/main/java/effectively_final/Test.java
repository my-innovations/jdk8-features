package effectively_final;

import java.util.function.Consumer;

public class Test {

	private static int k = 0;

	public static void main(String[] args) {
		
		int i = 10; //instance var

		// Consumer<Integer> c1 = (i) -> System.out.println(i); //CE
		
		Consumer<Integer> c1 = (j) -> {
			System.out.println(i);
		};
		
		// Consumer<Integer> c2 = (j) -> {i++; System.out.println(i);}; //CE
		
		Consumer<Integer> c3 = (j) -> System.out.println(j);
		
		Consumer<Integer> c4 = (j) -> {
			k = 25;
			System.out.println(i + k);
		};

		c1.accept(11);
		c3.accept(10);
		c4.accept(15);

	}

}
