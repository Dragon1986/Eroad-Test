package test;

import static org.junit.Assert.*;

import org.junit.Test;

import code.Coords;

public class CoordsTest {
	private final String keyAPIGoogle = "AIzaSyBv3lmH_Or8hQD8K8uBmr0RaJdtqhS3idk";
	
	Coords coords;
	
	@Test
	public void test_getTimeZoneFromCoords_NoCoords() {
		coords = new Coords();
		String timeZone = coords.getTimeZone(keyAPIGoogle);
		assertEquals("", timeZone);
	}
	
	@Test
	public void test_getTimeZoneFromCoords_CoordsWrong() {
		coords = new Coords(0, 0);
		String timeZone = coords.getTimeZone(keyAPIGoogle);
		assertEquals("", timeZone);
	}
	
	@Test
	public void test_getTimeZoneFromCoords_CoordsRight1() {
		coords = new Coords(-44.490947, 171.220966);
		String timeZone = coords.getTimeZone(keyAPIGoogle);
		assertEquals("Pacific/Auckland", timeZone);
	}
	
	@Test
	public void test_getTimeZoneFromCoords_CoordsRight2() {
		coords = new Coords(-33.912167,151.215820);
		String timeZone = coords.getTimeZone(keyAPIGoogle);
		assertEquals("Australia/Sydney", timeZone);
	}

}
