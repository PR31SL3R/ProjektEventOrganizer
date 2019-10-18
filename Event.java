import java.util.Scanner;
import java.io.*;
import java.io.FileOutputStream;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Arrays;

public class Event {

	Scanner s = new Scanner(System.in);
	Random r = new Random();

	public String[] eventArray = new String[10];

	public void editEvent() throws FileNotFoundException {

		String[] editArray = new String[10];
		Scanner input = new Scanner(new File("database.txt"));
		System.out.println("\nplease chose the eventID of the event to change");
		String searchString = s.next();
		while (input.hasNextLine()) {
			String line = input.nextLine();
			if (line.contains(searchString)) {
				System.out.println("tou have chosen to edit this event");
				System.out.println(line);
				Scanner lineScan = new Scanner(line);
				while (lineScan.hasNext()) {
					for (int i = 0; i < 10; i++) {
						{
							String word = lineScan.next();
							editArray[i] = word;
						}
					}

				}
				System.out.println(
						"what to edit\n1=Eventnavn\n2=facilitator\n3=kunde\n4=startDato\n5=SlutDato\n6=StartTid\n7=SlutTid\n8=SætPris");
				int temp123 = s.nextInt();
				System.out.println("please enter new value");
				String editValue123 = s.next();
				editArray[temp123] = editValue123.replace(" ", "_");
				Testing.deleteEvent(editArray[0]);
				Testing.writer(editArray);
			}

		}
	}

	public void addEvent() throws FileNotFoundException, ParseException {

//Id til eventet
		String eventID = Integer.toString(r.nextInt(10000) + 1);
		System.out.println("Enter event name:");
		String eventName = s.nextLine();
		eventName = eventName.replace(" ", "_");
		System.out.println("Navn på facilitator:");
		String facilitator = s.nextLine();
		facilitator = facilitator.replace(" ", "_");
		System.out.println("Customer Name");
		String costumer = s.nextLine();
		costumer = costumer.replace(" ", "_");
		System.out.println("Starting date: dd/mm-yyyy");
		String startDate = s.nextLine();
		System.out.println("Ending date: dd/mm-yyyy");
		String endDate = s.nextLine();
		System.out.println("Starting time: hh:mm");
		String startTime = s.nextLine();
		System.out.println("Ending time: hh:mm");
		String endTime = s.nextLine();
		System.out.println("Description:");
		String description = s.nextLine();
		description = description.replace(" ", "_");

		eventArray[0] = eventID;
		eventArray[1] = eventName;
		eventArray[2] = facilitator;
		eventArray[3] = costumer;
		eventArray[4] = startDate;
		eventArray[5] = endDate;
		eventArray[6] = startTime;
		eventArray[7] = endTime;
		eventArray[9] = description;
		int price = eventPrice(this.eventArray);

		System.out.print("the customer wil be billed " + price + "dkk for the event\n");
		eventArray[8] = Integer.toString(price);

		Testing.writer(eventArray);
		Testing.writer(eventArray, eventArray[3]);

	}

	public int eventPrice(String[] eventArray) throws ParseException {

		String firstDateString = eventArray[4];
		String secondDateString = eventArray[5];

		String firstTimeString = eventArray[6];
		String secondTimeString = eventArray[7];

		int firstDayInt = Integer.parseInt(firstDateString.substring(0, 2));
		int firstMonthInt = Integer.parseInt(firstDateString.substring(3, 4));
		// int firstYearInt = Integer.parseInt(firstDateString.substring(5,9));
		int firstTimeInt = Integer.parseInt(firstTimeString.substring(0, 2) + firstTimeString.substring(3, 5));

		int secondDayInt = Integer.parseInt(secondDateString.substring(0, 2));
		int secondMonthInt = Integer.parseInt(secondDateString.substring(3, 4));
		// int secondYearInt = Integer.parseInt(secondDateString.substring(5,9));
		int secondTimeInt = Integer.parseInt(secondTimeString.substring(0, 2) + secondTimeString.substring(3, 5));

		if ((firstDayInt - secondDayInt == 0) && (isWeekend(eventArray[4]) == false)
				&& (isWeekend(eventArray[5]) == false)) {

			int price = 150 * ((secondTimeInt - firstTimeInt) / 100);

			return price;

		}

		if ((firstDayInt - secondDayInt == 0) && (isWeekend(eventArray[4]) == true)
				&& (isWeekend(eventArray[5]) == true)) {

			int price = 300 * ((secondTimeInt - firstTimeInt) / 100);

			return price;

		}

		if ((firstDayInt - secondDayInt != 0) && (isWeekend(eventArray[4]) == true)
				&& (isWeekend(eventArray[5]) == true)) {

			int price = 300 * ((Math.abs(24 - (secondTimeInt - firstTimeInt) / 100)));

			return price;

		}

		if ((firstDayInt - secondDayInt != 0) && (isWeekend(eventArray[4]) == false)
				&& (isWeekend(eventArray[5]) == false)) {

			int price = 150 * ((Math.abs(24 - (secondTimeInt - firstTimeInt) / 100)));

			return price;

		}

		if ((firstDayInt - secondDayInt != 0) && (isWeekend(eventArray[4]) == false)
				&& (isWeekend(eventArray[5]) == true)) {

			int price = (150 * (24 - (firstTimeInt / 100)) + 300 * (secondTimeInt / 100));

			return price;

		}

		int price = (300 * (24 - (firstTimeInt / 100)) + 150 * (secondTimeInt / 100));

		return price;
	}

	public boolean isWeekend(String input_date) throws ParseException {

		String date = input_date;
		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM-yyyy");
		Date dt1 = format1.parse(date);
		DateFormat format2 = new SimpleDateFormat("EEEE");
		String finalDay = format2.format(dt1);

		if ((finalDay.equals("lørdag")) || (finalDay.equals("søndag"))) {
			return true;
		}
		return false;
	}

}