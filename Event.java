import java.util.Scanner;
import java.io.*;
import java.io.FileOutputStream; 

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

public String[] addEvent()throws FileNotFoundException{ 

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

//(dStart +" " + dEnd +" " + timeStart + " "+ timeEnd + " "+ ansvarlig +" " + description);
//dStart,dEnd,timeStart,timeEnd,ansvarlig,description};

Testing.writer(eventArray);
return eventArray;


}

public int eventPrice(String [] eventArray){


int temp = Integer.parseInt(eventArray[0]);			

System.out.println(temp);


return 1;
}


public static void main(String[] args)throws FileNotFoundException{

Event test = new Event();
test.addEvent();

}
}