package date_time_api;

import java.time.LocalTime;
import java.util.Calendar;

public class DateTime_Feature_demo {

	public static void main(String[] args) {

		final Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR, 8);
		System.out.println(cal.getTime());

		final LocalTime now = LocalTime.now();
		System.out.println(now);
		// final LocalTime later = now.plus(8, Calendar.HOUR);

		final Calendar cal6 = Calendar.getInstance();
		cal6.add(Calendar.HOUR, 8);
		System.out.println(cal6.getTime());

		/*
		 * final LocalTime now = LocalTime.now(); final LocalTime later = now.plus(8,
		 * HOURS);
		 */

	}

}
