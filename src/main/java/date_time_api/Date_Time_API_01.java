package date_time_api;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class Date_Time_API_01 {

	public static void main(String[] args) throws InterruptedException {
		
		// Read more:
		// http://java67.blogspot.com/2012/12/how-to-convert-sql-date-to-util-date.html#ixzz4CxzHTqrG
		// https://javarevisited.blogspot.com/2015/03/20-examples-of-date-and-time-api-from-Java8.html#axzz6ue9olbTT

		LocalDateTime localDateTime1 = LocalDateTime.now();
		System.out.println("localDateTime1 : " + localDateTime1); //2021-05-12T19:37:12.925
		
		//extracting month,date from localDateTime.
		Month month = localDateTime1.getMonth();
		int day = localDateTime1.getDayOfMonth();
		int seconds = localDateTime1.getSecond();
		int yr = localDateTime1.getYear();
		System.out.println("Year:"+yr +" Month: " + month + " day: " + day + " seconds: " + seconds); //Month: MAYday: 12seconds: 12
		
		LocalDateTime localDateTime2 = localDateTime1.withDayOfMonth(10).withYear(2012);
		System.out.println("localDateTime2: " + localDateTime2); //2012-05-10T19:38:26.877
		
		//converting localDateTime to localDate
		LocalDate localDate1 = localDateTime1.toLocalDate();
		System.out.println("localDate1 : " + localDate1);//localDate1 : 2021-05-12

		LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
		System.out.println("date3: " + date3); // 2014-12-12

		// 22 hour 15 minutes
		LocalTime localTime1 = LocalTime.of(22, 15);
		System.out.println("date4: " + localTime1);

		// parse a string
		LocalTime date5 = LocalTime.parse("20:15:30");
		System.out.println("date5: " + date5);

		// creating instances of java.util.Date which represents today's date
		// and time
		final java.util.Date utilDate = new java.util.Date();
		System.out.println("Value of java.util.Date : " + utilDate);

		// converting java.util.Date to java.sql.Date in Java
		final java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		System.out.println("Converted value of java.sql.Date : " + sqlDate);

		// converting java.sql.Date to java.util.Date back
		final java.util.Date utilDate2 = new java.util.Date(sqlDate.getTime());
		System.out.println("Converted value of java.util.Date : " + utilDate2);

		// Get the current date and time
		ZonedDateTime date11 = ZonedDateTime.parse("2007-12-03T10:15:30+05:30[Asia/Karachi]");
		System.out.println("date1: " + date11);
		
		OffsetDateTime offsetDateTime = OffsetDateTime.now();
		System.out.println(offsetDateTime);

		ZoneId id = ZoneId.of("Europe/Paris");
		System.out.println("ZoneId: " + id);

		ZoneId currentZone = ZoneId.systemDefault();
		System.out.println("CurrentZone: " + currentZone);

		// Get the current date
		LocalDate today = LocalDate.now();
		System.out.println("Current date: " + today);

		// add 1 week to the current date
		LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
		System.out.println("Next week: " + nextWeek);

		// add 1 month to the current date
		LocalDate nextMonth = today.plus(1, ChronoUnit.MONTHS);
		System.out.println("Next month: " + nextMonth);

		// add 1 year to the current date
		LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
		System.out.println("Next year: " + nextYear);

		// add 10 years to the current date
		LocalDate nextDecade = today.plus(1, ChronoUnit.DECADES);
		System.out.println("Date after ten year: " + nextDecade);

		// Get the current date
		LocalDate date71 = LocalDate.now();
		System.out.println("Current date: " + date71);

		// add 1 month to the current date
		LocalDate date72 = localDate1.plus(1, ChronoUnit.MONTHS);
		System.out.println("Next month: " + date72);

		Period period = Period.between(date72, date71);
		System.out.println("Period: " + period);

		LocalTime time1 = LocalTime.now();
		Duration twoHours = Duration.ofHours(2);

		LocalTime time2 = time1.plus(twoHours);
		Duration duration = Duration.between(time1, time2);

		System.out.println("Duration: " + duration);

		// Get the current date
		LocalDate date19 = LocalDate.now();
		System.out.println("Current date: " + date19);

		// get the next tuesday
		LocalDate nextTuesday = localDate1.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
		System.out.println("Next Tuesday on : " + nextTuesday);

		// get the second saturday of next month
		LocalDate firstInYear = LocalDate.of(localDate1.getYear(), localDate1.getMonth(), 1);
		LocalDate secondSaturday = firstInYear.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY))
				.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
		System.out.println("Second Saturday on : " + secondSaturday);

		/* Backword compatibility */
		// Get the current date
		Date currentDate = new Date();
		System.out.println("Current date: " + currentDate);

		// Get the instant of current date in terms of milliseconds
		Instant now = currentDate.toInstant();
		ZoneId currentZone01 = ZoneId.systemDefault();

		LocalDateTime localDateTime3 = LocalDateTime.ofInstant(now, currentZone01);
		System.out.println("Local date: " + localDateTime3);

		ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(now, currentZone01);
		System.out.println("Zoned date: " + zonedDateTime);

		// App-0
		// Creating Date in java with today's date.
		final Date dateNow = new Date();

		// change date into string yyyyMMdd format example "20110914"
		final SimpleDateFormat dateformatyyyyMMdd = new SimpleDateFormat("yyyyMMdd");
		String date_to_string = dateformatyyyyMMdd.format(dateNow);
		System.out.println("date into yyyyMMdd format: " + date_to_string);

		// converting date into ddMMyyyy format example "14092011"
		final SimpleDateFormat dateformatddMMyyyy = new SimpleDateFormat("ddMMyyyy");
		date_to_string = dateformatddMMyyyy.format(dateNow);
		System.out.println("Today's date into ddMMyyyy format: " + date_to_string);

		// change date to string on dd-MM-yyyy format e.g. "14-09-2011"
		final SimpleDateFormat dateformatJava = new SimpleDateFormat("dd-MM-yyyy");
		date_to_string = dateformatJava.format(dateNow);
		System.out.println("Today's date into dd-MM-yyyy format: " + date_to_string);

		// converting date to string dd/MM/yyyy format for example "14/09/2011"
		final SimpleDateFormat formatDateJava = new SimpleDateFormat("dd/MM/yyyy");
		date_to_string = formatDateJava.format(dateNow);
		System.out.println("Today's date into dd/MM/yyyy format: " + date_to_string);

		// date to dd-MMM-yy format e.g. "14-Sep-11"
		final SimpleDateFormat ddMMMyyFormat = new SimpleDateFormat("dd-MMM-yy");
		date_to_string = ddMMMyyFormat.format(dateNow);
		System.out.println("Today's date into dd-MMM-yy format: " + date_to_string);

		// convert date to dd-MMMM-yy format e.g. "14-September-11"
		final SimpleDateFormat ddMMMMyyFormat = new SimpleDateFormat("dd-MMMM-yy");
		date_to_string = ddMMMMyyFormat.format(dateNow);
		System.out.println("date into dd-MMMM-yy format: " + date_to_string);

		// app-1
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		String date = "16/08/2016";
		// convert String to LocalDate
		LocalDate localDate = LocalDate.parse(date, formatter);
		System.out.println(localDate);

		// app-2
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("d-MMM-yyyy");
		String date101 = "16-Aug-2016";
		LocalDate localDate3 = LocalDate.parse(date101, formatter1);
		System.out.println(localDate3); // default, print ISO_LOCAL_DATE
		System.out.println(formatter.format(localDate3));

		// app-3
		String date21 = "2016-08-16";
		// default, ISO_LOCAL_DATE
		LocalDate localDate2 = LocalDate.parse(date21);
		System.out.println(localDate2);

		// app-4
		DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("d/MM/yyyy");
		String date41 = "16/08/2016";
		LocalDate localDate41 = LocalDate.parse(date41, formatter4);
		System.out.println(localDate41);
		System.out.println(formatter.format(localDate41));

		// app-5
		DateTimeFormatter formatter5 = DateTimeFormatter.ofPattern("E, MMM d yyyy");
		String date15 = "Tue, Aug 16 2016";
		LocalDate localDate5 = LocalDate.parse(date15, formatter5);
		System.out.println(localDate5);
		System.out.println(formatter5.format(localDate5));

		// app-6
		DateTimeFormatter formatter6 = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy HH:mm:ss a");
		String date6 = "Tuesday, Aug 16, 2016 12:10:56 PM";
		LocalDateTime localDateTime6 = LocalDateTime.parse(date6, formatter6);
		System.out.println(localDateTime6);
		System.out.println(formatter6.format(localDateTime6));

		// app-7
		String dateInString7 = "2016-08-16T15:23:01Z";
		Instant instant7 = Instant.parse(dateInString7);
		System.out.println("Instant : " + instant7);
		// get date time only
		LocalDateTime result = LocalDateTime.ofInstant(instant7, ZoneId.of(ZoneOffset.UTC.getId()));
		// get localdate
		System.out.println("LocalDate : " + result.toLocalDate());
		// get date time + timezone
		ZonedDateTime zonedDateTime3 = instant7.atZone(ZoneId.of("Asia/Tokyo"));
		System.out.println(zonedDateTime3);
		// get date time + timezone
		ZonedDateTime zonedDateTime2 = instant7.atZone(ZoneId.of("Europe/Athens"));
		System.out.println(zonedDateTime2);

		// app-8
		String date8 = "2016-08-16T10:15:30+08:00";
		ZonedDateTime result8 = ZonedDateTime.parse(date8, DateTimeFormatter.ISO_DATE_TIME);
		System.out.println("ZonedDateTime : " + result8);
		System.out.println("TimeZone : " + result8.getZone());
		LocalDate localDate8 = result.toLocalDate();
		System.out.println("LocalDate : " + localDate8);
	}
}
