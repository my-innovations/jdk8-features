package date_time_api;

import java.util.Calendar;

public class CalendarDemo {

	public static void main(String[] args) {

		Calendar calendar = Calendar.getInstance();
		calendar.getFirstDayOfWeek();
		System.out.println(calendar.getTimeInMillis());
		
		calendar.add(Calendar.HOUR, 8);
		System.out.println(calendar.getTime()); //Wed Jun 02 01:12:27 IST 2021

	}

}
