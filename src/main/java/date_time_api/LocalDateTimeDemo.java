package date_time_api;

import java.time.LocalDateTime;
import java.time.Month;

public class LocalDateTimeDemo {

	public static void main(String[] args) {

		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		System.out.println("After 6 months:" + ldt.plusMonths(6));
		System.out.println("Before 6 months:" + ldt.minusMonths(6));

		LocalDateTime ldt2 = LocalDateTime.of(2021, Month.MAY, 11, 11, 30);
		System.out.println(ldt2);

	}

}
