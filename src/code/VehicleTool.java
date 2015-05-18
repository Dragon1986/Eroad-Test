package code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class VehicleTool {

	public static void main(String[] args){
	
		String csvFileIn = "",  csvFileOut = "", line = null;
		//Date's format present in original File
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//The original file's date is in UTC
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		//KeyAPI from Google to use with TimeZone
		final String keyAPIGoogle = "AIzaSyBv3lmH_Or8hQD8K8uBmr0RaJdtqhS3idk";
		
	    try {
	    	csvFileIn =args[0];
	    	csvFileOut = csvFileIn.substring(0, csvFileIn.length()-4) + "Modified.csv";
	    } catch (Exception e) {
	        System.err.println("You should define the csv (with format xxxx.csv)");
	        System.exit(1);
	    }
	    
		
		try (BufferedReader br = new BufferedReader(new FileReader(csvFileIn));
			 BufferedWriter bw = new BufferedWriter(new FileWriter(csvFileOut))){

			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				
				//Getting the string which represents the long and lat asked for
				Coords coords = new Coords(Double.parseDouble(data[1]),Double.parseDouble(data[2]));
				String timezone = coords.getTimeZone(keyAPIGoogle);
				
				//Converting the UTC date to local date based in TimeZone
				java.util.Date originDate = formatter.parse(data[0]);
				String localDate = Date.convertToLocale(originDate, TimeZone.getTimeZone(timezone));
				
				bw.write(line+","+timezone+","+localDate);
				bw.newLine();
			}
			
			System.out.println("Process finished");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
