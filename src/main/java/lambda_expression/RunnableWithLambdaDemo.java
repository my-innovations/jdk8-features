package lambda_expression;

public class RunnableWithLambdaDemo {

	public static void main(String[] args) {
		
		// ########################################################################
		// Before java-8
		Runnable r0 = new Runnable() {
			@Override
			public void run() {
				System.out.println("Th-0");
			}
		};
		new Thread(r0).start();
		// OR
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Th-1");
			}
		});

		// java-8
		Runnable r1 = () -> System.out.println("Th-2");
		new Thread(r1).start();
		new Thread(() -> {
			System.out.println("Th-2");
		}).start();

	}
}
