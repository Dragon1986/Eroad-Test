package code;

import java.util.TimeZone;

import com.google.maps.GeoApiContext;
import com.google.maps.PendingResult;
import com.google.maps.TimeZoneApi;
import com.google.maps.model.LatLng;

public class Coords {

	private double longitude;
	private double latitude;

	public Coords(double latitude, double longitude) {
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public Coords() {
		this.longitude = 0;
		this.latitude = 0;
	}

	public String getTimeZone(String keyAPIGoogle) {
		String zone = "";
		
		LatLng location = new LatLng(latitude, longitude);
		GeoApiContext context = new GeoApiContext().setApiKey(keyAPIGoogle);
		
		PendingResult<TimeZone> req = TimeZoneApi.getTimeZone(context, location);
	
		try {
			TimeZone result = req.await();
		    zone = result.getID();
		} catch (Exception e) {
		    zone = "";
		}

		req.awaitIgnoreError(); // No checked exception
		
		return zone;
	}

}
