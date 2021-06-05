package date_time_api;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeDemo {

	public static void main(String[] args) {

		ZoneId myzone = ZoneId.systemDefault();
		System.out.println(myzone); //Asia/Calcutta

		ZoneId us_zone = ZoneId.of("America/Los_Angeles");
		System.out.println(us_zone); //Asia/Calcutta
		
		ZonedDateTime zdt = ZonedDateTime.now(us_zone);
		System.out.println(zdt); //2021-06-01T04:52:38.387-07:00[America/Los_Angeles]

	}

}
