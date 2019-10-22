import java.util.Scanner;
import java.io.*;
import java.text.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.util.Arrays;

public class User {

	Scanner s = new Scanner(System.in);
   Random r = new Random();

	String password;
	String credentials;
	String flag;
	int trys;
    
      
      static ArrayList<String>Employees=new ArrayList <String>();
      static ArrayList<String>Password=new ArrayList <String>();
      static ArrayList<String>Flag=new ArrayList <String>();
      
      public void validateUser2() throws InterruptedException, FileNotFoundException, ParseException {
   
		System.out.println("Please enter credentials to log in");
		credentials = s.next();
		System.out.println("Please enter password");
		password = s.next();
		for (int i = 0; i < Employees.size(); i++) {
			if (Employees.get(i).equals(credentials) == true && Password.get(i).equals(password) == true) {
				System.out.println("welcome to the system " + Employees.get(i));
				this.credentials = Employees.get(i);
				this.flag = Flag.get(i);
				Interface user = new Interface();
				user.setCredentials(this.credentials);
				user.setFlag(this.flag);
				user.getUserInput();

			}

		}
		trys++;
		if (trys == 4) {
			System.out.println("Final Try");
			validateUser2();
		}
		if (trys == 5) {
			System.out.println("Validation failed");
			System.exit(1);
		}
		System.out.println("Please try again");
		validateUser2();

	}
      
   public void addUser()throws InterruptedException,FileNotFoundException,ParseException{
      
      String nameGenerator = "";
      String password = Integer.toString(r.nextInt(10000)+1000);
      String flag = "";
      
      System.out.println("Please enter first and last name of employee to be added");
      String name = s.nextLine();
      for (String token : name.split("\\s+")){
      nameGenerator += token.substring(0,2);
      }
      nameGenerator += Integer.toString(r.nextInt(100)+10);
      Employees.add(nameGenerator);
      Password.add(password);
      System.out.println("What acces shuld the user have\nPress 1 for User\nPress 2 for SuperUser\nPress 3 for Admin");
      int input2 = s.nextInt();
      do {
      if (input2 == 1){
      System.out.println("A new user has been created with the following properties\nCredentials = " + nameGenerator + "\nPassword = " + password);
      Flag.add("u");
      break;
      }
      if (input2 == 2){
      System.out.println("A new user has been created with the following properties\nCredentials = " + nameGenerator + "\nPassword = " + password);
      Flag.add("s");
      break;
      }
      if (input2 == 3){
      System.out.println("A new user has been created with the following properties\nCredentials = " + nameGenerator + "\nPassword = " + password);
      Flag.add("u+");
      break;
      }
      System.out.println("please enter the number 1,2,3");
      input2 = s.nextInt();
      }while((input2 == 1) || (input2 == 2) || (input2 ==3));
      }
   
   
   public void mainUsers(){
   
   Employees.add("jepr85");
   Password.add("1234");
   Flag.add("s");
      
   Employees.add("brho31");
   Password.add("1234");
   Flag.add("u");
   
   Employees.add("lima65");
   Password.add("1234");
   Flag.add("u");
   
   Employees.add("osla76");
   Password.add("1234");
   Flag.add("u");
   
   Employees.add("jabu98");
   Password.add("1234");
   Flag.add("u");
      
   Employees.add("jone76");
   Password.add("1234");
   Flag.add("u+");
   
   }
   
   static boolean isFacilitator(String inputCredentials){
   
  String credentials = inputCredentials;
   
   for (int i =0; i < Employees.size(); i++){
   
   if ((Flag.get(i).equals("u"))&&(Employees.get(i).equals(credentials))){
   return true;
   }
   }
   return false;
   }
   

}