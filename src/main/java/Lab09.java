import java.util.*;
import java.io.*;

public class Lab09 {
	public static void main(String[] args) throws FileNotFoundException, TimeException {
		File Times = new File("times.txt");
		Scanner scan = new Scanner(Times);
		File output = new File("12htimes.txt");
		PrintWriter pwriter = new PrintWriter(output);
		pwriter.println("      24-hour        12-hour\n ----------------------------");

		while (scan.hasNextLine()) {
			String Time24h = scan.nextLine();
			int colon = Time24h.indexOf(":");
			int hours = Integer.parseInt(Time24h.substring(0, colon));// from XXto:
			int minutes = Integer.parseInt(Time24h.substring(3)); // from :toXX
			String XM; // AM or PM
			try {
				if (hours < 12) {
					XM = "AM";
				} else
					XM = "PM";
				if (hours >= 24 || hours < 0 || minutes < 0 || minutes >= 60 || Time24h.length() != 5) {
					throw new TimeException();
				}

				else if (hours == 00) {
					hours = hours + 12;
					pwriter.println(hours + ":" + minutes + " " + XM);
				} else if (hours == 12) {
					pwriter.println(hours + ":" + minutes + " " + XM);
				} else if (hours >= 12) {
					hours = hours - 12;
					pwriter.println(hours + ":" + minutes + " " + XM);
				} else {
					pwriter.println(hours + ":" + minutes + " " + XM);
				}
	
			} catch (TimeException e) {
				pwriter.println("Time Exception");
			} catch (Exception e) {
				pwriter.println("Time Exception");
			}
		}
		scan.close();
		pwriter.close(); 
	}
}

class TimeException extends Exception {
	public TimeException() {
		super("Time Exception");
	}
}