package date_time_api;

import java.time.LocalTime;

public class LocalTimeDemo {

	public static void main(String[] args) {
		
		final LocalTime localTime = LocalTime.now();
		System.out.println(localTime);
		
		int hr = localTime.getHour();
		System.out.println("hr=" + hr);
		
		int min = localTime.getMinute();
		System.out.println("min=" + min);
		
		int sec = localTime.getSecond();
		System.out.println("sec=" + sec);
		
		int nanoSec = localTime.getNano();
		System.out.println("nanoSec=" + nanoSec);
		// final LocalTime later = now.plus(8, Calendar.HOUR);
		// final LocalTime now = LocalTime.now(); final LocalTime later = now.plus(8,HOURS);

	}

}
