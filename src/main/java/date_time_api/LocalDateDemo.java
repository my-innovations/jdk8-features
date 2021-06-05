package date_time_api;

import java.time.LocalDate;
import java.time.Period;

public class LocalDateDemo {

	public static void main(String[] args) {
		
		final LocalDate localDate = LocalDate.now();
		System.out.println(localDate);
		
		int dd = localDate.getDayOfMonth();
		System.out.println("dd=" + dd);
		
		int mm = localDate.getMonthValue();
		System.out.println("mm=" + mm);
		
		int yyyy = localDate.getYear();
		System.out.println("yy=" + yyyy);
		
		//find age from date of birth
		final LocalDate birthdate = LocalDate.of(1980, 5, 11);
		Period p = Period.between(birthdate, localDate);
		System.out.println("====>"+p.getYears()+":"+p.getMonths()+":"+p.getDays());

	}

}
