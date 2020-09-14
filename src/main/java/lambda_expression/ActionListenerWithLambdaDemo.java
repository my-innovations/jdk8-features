package lambda_expression;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerWithLambdaDemo {

	public static void main(String[] args) {

		// Before java-8
		final ActionListener al1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand());
			}
		};

		// Java 8
		final ActionListener al2 = (e) -> {
			System.out.println(e.getActionCommand());
		};

	}
}
