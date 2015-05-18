package code;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class Date {

	public static String convertToLocale(java.util.Date UTCDate, TimeZone tz) {
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		
		formatter2.setTimeZone(tz);

		return formatter2.format(UTCDate);
	}
}
