import java.util.Scanner;
import java.io.*;
import java.text.*;

public class User{

      String[] emplyees =        { "jepr85" ,"bob123" ,"joh123" , };
		String[] emplyeepassword = { "1234"   ,"1234"   ,"1234" , };
		String[] superUser =       { "s"      ,"0"      ,"0" , };

      Scanner s = new Scanner(System.in);
      
      String password;
      String credentials;
      String flag;
      int trys;
      
      public String getFlag(){
      
      return this.flag;
      }
      
      public String getCredentials(){
      
      return this.credentials;
      }

public void validateUser() throws InterruptedException,FileNotFoundException,ParseException{
      
      System.out.println("Please enter credentials to log in");
            credentials = s.next();
            System.out.println("Please enter password");
            password = s.next();
		for (int i = 0; i < emplyees.length; i++) { 
            if (emplyees[i].equals(credentials)==true && emplyeepassword[i].equals(password)==true){
          
			
         System.out.println("welcome to the system " + emplyees[i]);
            this.credentials=emplyees[i];
            this.flag=superUser[i];
            Interface user = new Interface();
            user.setCredentials(this.credentials);
            user.setFlag(this.flag);
            user.getUserInput();
            
            }
            
		}
            trys++;
            if (trys == 4){
            System.out.println("Final Try");
            validateUser();
      }
            if (trys == 5){
            System.out.println("Validation failed");
            System.exit(1);
      }
            System.out.println("Please try again"); 
            validateUser();
   
	}





}