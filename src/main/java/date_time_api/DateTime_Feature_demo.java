package date_time_api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

public class DateTime_Feature_demo {

	public static void main(String[] args) {

		Date d = new Date();
		System.out.println(d);

		// #########################################
		final Calendar cal = Calendar.getInstance();
		cal.add(Calendar.HOUR, 8);
		System.out.println(cal.getTime());
		// #########################################

		// TimeStamp t = new TimeStamp();

		// #########################################
		final LocalDate localDate = LocalDate.now();
		System.out.println(localDate);
		int dd = localDate.getDayOfMonth();
		System.out.println("dd=" + dd);
		int mm = localDate.getMonthValue();
		System.out.println("mm=" + mm);
		int yyyy = localDate.getYear();
		System.out.println("yy=" + yyyy);
		
		//find age
		final LocalDate birthdate = LocalDate.of(1980, 5, 11);
		Period p = Period.between(birthdate, localDate);
		System.out.println("====>"+p.getYears()+":"+p.getMonths()+":"+p.getDays());

		// #########################################
		final LocalTime localTime = LocalTime.now();
		System.out.println(localTime);
		int hr = localTime.getHour();
		int min = localTime.getMinute();
		int sec = localTime.getSecond();
		int nanoSec = localTime.getNano();
		System.out.println("hr=" + hr);
		System.out.println("min=" + min);
		System.out.println("sec=" + sec);
		System.out.println("nanoSec=" + nanoSec);
		// final LocalTime later = now.plus(8, Calendar.HOUR);
		// final LocalTime now = LocalTime.now(); final LocalTime later = now.plus(8,HOURS);
		// #########################################
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		System.out.println("After 6 months:" + ldt.plusMonths(6));
		System.out.println("Before 6 months:" + ldt.minusMonths(6));

		LocalDateTime ldt2 = LocalDateTime.of(2021, Month.MAY, 11, 11, 30);
		System.out.println(ldt2);
		// #########################################
		//leap year 
		int yr =1980;
		Year y = Year.of(yr);
		if(y.isLeap())
			System.out.println("leap year");
		// #########################################
		ZoneId zone = ZoneId.systemDefault();
		System.out.println(zone);
		
		ZoneId zone2 = ZoneId.of("America/Los_Angeles");
		ZonedDateTime zdt = ZonedDateTime.now(zone2);
		System.out.println(zdt);
	}

}
