import java.util.Scanner;
import java.io.*;
import java.io.FileOutputStream; 
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;

public class Event{

public Event(){


}

int id;
String dStart;
String dEnd;
String timeStart;
String timeEnd;
String ansvarlig;
String description;

Scanner s = new Scanner(System.in);

public String[] eventArray = new String[10];

public String[] addEvent()throws FileNotFoundException,ParseException{ 

System.out.println("what date will the event start");
dStart = s.next();
System.out.println("what date will the event end");
dEnd = s.next();
System.out.println("what time will the event start");
timeStart = s.next();
System.out.println("what time will the event end");
timeEnd = s.next();
System.out.println("hvem er ansvarlig");
ansvarlig = s.next();
System.out.println("beskriv eventet");
description = s.next();

eventArray[0]=dStart;
eventArray[1]=dEnd;
eventArray[2]=timeStart;
eventArray[3]=timeEnd;
eventArray[4]=dStart;
eventArray[5]=ansvarlig;
eventArray[6]=description;
int price = eventPrice(this.eventArray);

System.out.print("the customer wil be billed " + price + "dkk for the event\n");
eventArray[7]=Integer.toString(price);

Testing.writer(eventArray);

return eventArray;
}

public int eventPrice(String [] eventArray)throws ParseException{

String firstDateString   = eventArray[0];
String secondDateString   = eventArray[1];

String firstTimeString = eventArray[2];
String secondTimeString = eventArray[3];


int firstDayInt = Integer.parseInt(firstDateString.substring(0,2));
int firstMonthInt = Integer.parseInt(firstDateString.substring(3,4));
//int firstYearInt = Integer.parseInt(firstDateString.substring(5,9));
int firstTimeInt = Integer.parseInt(firstTimeString.substring(0,2) + firstTimeString.substring(3,5));

int secondDayInt = Integer.parseInt(secondDateString.substring(0,2));
int secondMonthInt = Integer.parseInt(secondDateString.substring(3,4));
//int secondYearInt = Integer.parseInt(secondDateString.substring(5,9));
int secondTimeInt = Integer.parseInt(secondTimeString.substring(0,2) + secondTimeString.substring(3,5));


if ((firstDayInt - secondDayInt == 0) && (isWeekend(eventArray[0]) ==false) && (isWeekend(eventArray[1])==false)){

int price = 150 * (secondTimeInt-firstTimeInt);

return price;

}


return 1;
}

public boolean isWeekend(String input_date)throws ParseException{


      String date=input_date;
      SimpleDateFormat format1=new SimpleDateFormat("dd/MM-yyyy");
      Date dt1=format1.parse(date);
      DateFormat format2=new SimpleDateFormat("EEEE"); 
      String finalDay=format2.format(dt1);

if ((finalDay.equals("Lørdag"))|| (finalDay.equals("Søndag"))){
return true;
}
return false;
}



public static void main(String[] args)throws FileNotFoundException, ParseException{

Event test = new Event();
test.addEvent();

      
      
      
      
      

}
}