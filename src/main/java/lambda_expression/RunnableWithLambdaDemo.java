package lambda_expression;

public class RunnableWithLambdaDemo {

	public static void createAndStartThreadBeforeJdk8() {

		// way-01
		Runnable runnable1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("Th-0");
			}
		};
		new Thread(runnable1).start();

		// way-02
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Th-1");
			}
		}).start();

	}

	public static void createAndStartThreadInJdk8() {

		// creating and starting a thread using java-8
		// way-01
		Runnable runnable2 = () -> System.out.println("Th-3");
		new Thread(runnable2).start();

		// way-02
		Runnable runnable3 = () -> {
			System.out.println("Th-4");
		};
		new Thread(runnable3).start();

		// OR
		// way-03
		new Thread(() -> {
			System.out.println("Th-5");
		}).start();

	}

	public static void main(String[] args) {
		createAndStartThreadBeforeJdk8();
		createAndStartThreadInJdk8();
	}
}
