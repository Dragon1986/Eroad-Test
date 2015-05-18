package test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

import org.junit.Before;
import org.junit.Test;


import code.Date;

public class DateTest {
	
	java.util.Date originDate;
			
	@Before
	public void setUp() throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		originDate = formatter.parse("2013-07-10 02:52:49");
	}
	
	@Test
	public void test_getLocalTimeFromUTCTime1(){		
		TimeZone tz = TimeZone.getTimeZone("Pacific/Auckland");
		String localDate = Date.convertToLocale(originDate, tz);
		assertEquals("2013-07-10T14:52:49", localDate);
	}
	
	@Test
	public void test_getLocalTimeFromUTCTime2(){		
		TimeZone tz = TimeZone.getTimeZone("Australia/Sydney");
		String localDate = Date.convertToLocale(originDate, tz);
		assertEquals("2013-07-10T12:52:49", localDate);
	}

}
