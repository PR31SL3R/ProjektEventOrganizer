import java.io.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.Calendar;
import java.text.ParseException;

public class Interface {

   Scanner in = new Scanner(System.in);

   String flag;
   String credentials;

//gets input from user
   public void getUserInput() throws InterruptedException, FileNotFoundException, ParseException {
      if (flag.equals("s")){
         System.out.println(
            "Press 1 to create event\nPress 2 to edit events\nPress 3 to update\nPress 4 to delete\nPress 5 to list events\nPress 6 to add user\nPress 7 to log-out\nPress 8 to quit");
         int a = in.nextInt();
         if (a == 1) {
            System.out.println("you have pressed 1\nYou can now create a new event\n");
            Event id = new Event();
            id.addEvent();
            getUserInput();
         }
         if (a == 2) {
            System.out.println("you have pressed 2\nYou can now edit current events\n");
            Event event = new Event();
            Testing.reader();
            event.editEvent();
            getUserInput();
         }
         if (a == 3) {
            System.out.println("you have pressed 3\nThe program will now update\n");
            TimeUnit.SECONDS.sleep(3);
            System.out.println("Update complete");
            getUserInput();
         }
         if (a == 4) {
            System.out.println("you have pressed 4\nYou can now delete an event\n");
            Testing.reader();
            System.out.println("\nPlease enter the eventID of event to be deleted\n");
            String temp = in.next();
            Testing.deleteEvent(temp);
            getUserInput();
         }
         if (a == 5) {
            System.out.println("you have pressed 5\nYou can now see current events\n");
            Testing.reader();
            getUserInput();
         }
         if (a == 6) {
            System.out.println("you have pressed 6\nA new user can now be added\n");
            User user = new User();
            user.addUser();
            getUserInput();
         }
         if (a == 7) {
            System.out.println("you have pressed 7\nThe System will now logout\n");
            User user = new User();
            user.validateUser2();
         }
         if (a == 8) {
            System.out.println("you have pressed 7\nThe program will now quit\n");
            System.exit(0);
         }
      }
      if (flag.equals("u")){
         System.out.println("Press 1 to see current events\nPress 2 to update program\nPress 3 to logout of system\nPress 4 to quit system");
         int a = in.nextInt();
         if (a == 4) {
            System.out.println("you have pressed 4\nThe program will now quit\n");
            System.exit(0);
         }
         if (a == 2) {
            System.out.println("you have pressed 2\nThe program will now update\n");
            TimeUnit.SECONDS.sleep(3);
            System.out.println("updating");
            getUserInput();
         }
         if (a == 1) {
            System.out.println("you have pressed 1\nYou can now see current events\n");
            Testing.reader(this.credentials);
            getUserInput();
         }  
         if (a == 3) {
            System.out.println("you have pressed 3\nThe System will now logout\n");
            User user = new User();
            user.validateUser2();
         }
      
      
      }
      
      if (flag.equals("u+")){
         System.out.println("Press 1 to see current events\nPress 2 to update program\nPress 3 to logout of system\nPress 4 to quit system");
         int a = in.nextInt();
         if (a == 4) {
            System.out.println("you have pressed 4\nThe program will now quit\n");
            System.exit(0);
         }
         if (a == 2) {
            System.out.println("you have pressed 2\nThe program will now update\n");
            TimeUnit.SECONDS.sleep(3);
            System.out.println("updating");
            getUserInput();
         }
         if (a == 1) {
            System.out.println("you have pressed 1\nYou can now see current events\n");
            Testing.reader();
            getUserInput();
         }  
         if (a == 3) {
            System.out.println("you have pressed 3\nThe System will now logout\n");
            User user = new User();
            user.validateUser2();
         }
      
      
      }
      if (flag.equals("null")){
         System.out.println("system error\n");
         startUpSequence();
      }
   
   }

//Runs startup Sequence
   public void startUpSequence() throws InterruptedException, FileNotFoundException, ParseException {
   
      System.out.println("Program is booting");
      TimeUnit.SECONDS.sleep(3);
      System.out.println("3......");
      TimeUnit.SECONDS.sleep(1);
      System.out.println("2......");
      TimeUnit.SECONDS.sleep(1);
      System.out.println("1......");
      TimeUnit.SECONDS.sleep(1);
      System.out.println("online");
      System.out.println("Hi - I am the interface\nWelcome to the eventplanning program\n");
      User user = new User();
      user.mainUsers();
      user.validateUser2();
   
   }

   public void setFlag(String flag) {
      this.flag = flag;
   
   }

   public void setCredentials(String credentials) {
      this.credentials = credentials;
   
   }

   public static void main(String[] args) throws InterruptedException, FileNotFoundException, ParseException {
      Interface newUser = new Interface();
      newUser.startUpSequence();
      
   }

}


