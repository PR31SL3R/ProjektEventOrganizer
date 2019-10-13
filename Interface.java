import java.io.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.Calendar;

public class Interface {

	int id;
	boolean flag = false;

//gets input from user
	public void getUserInput() throws InterruptedException, FileNotFoundException {
		System.out.println(
				"Press 1 to create event\nPress 2 to see current events\nPress 3 to update\nPress 4 to delete");
		Scanner in = new Scanner(System.in);

		if (flag == true) {
			int a = in.nextInt();
			if (a == 1) {
				System.out.println("you have pressed 1\nYou can now create a new event");
				id++;
				Event id = new Event();
				id.addEvent();
				getUserInput();

			}
			if (a == 2) {
				System.out.println("you have pressed 2\nYou can now see current events");
				Testing test = new Testing();
				test.reader();
				getUserInput();
			}
			if (a == 3) {
				System.out.println("you have pressed 3\nThe program will now update");
				TimeUnit.SECONDS.sleep(3);
				System.out.println("updating");
				getUserInput();
			}
			if (a == 4) {
				System.out.println("you have pressed 4\nYou can now delete an event");
				getUserInput();
			} else {
				System.out.println("here are the current events");
				Testing test = new Testing();
				test.reader();
				getUserInput();
			}
		}
	}

//Runs startup Sequence
	public void startUpSequence() throws InterruptedException, FileNotFoundException {

		System.out.println("Program is booting");
		validateUser();
		/*
		 * TimeUnit.SECONDS.sleep(3); System.out.println("3......");
		 * TimeUnit.SECONDS.sleep(1); System.out.println("2......");
		 * TimeUnit.SECONDS.sleep(1); System.out.println("1......");
		 * TimeUnit.SECONDS.sleep(1); System.out.println("online"); System.out.
		 * println("Hi - I am the interface\nWelcome to the eventplanning program");
		 */
		getUserInput();

	}

	public void validateUser() {
		System.out.println("Please enter credentials");
		Scanner s = new Scanner(System.in);
		String credentials = s.next();
		System.out.println("Please enter password");
		String password = s.next();
		String[] emplyees = { "jepr85", "bob123" };
		String[] emplyeepassword = { "1234", "1234" };
		String[] superUser = { "s", "0" };

		for (int i = 0; i < emplyees.length; i++) {

			if ((emplyees[i].equals(credentials)) && (emplyeepassword[i].equals(password))) {
				System.out.println("welcome to the system " + emplyees[i]);
				if (superUser[i].equals("s")) {
					flag = true;
				}
			}

		}

	}

	public static void main(String[] args) throws InterruptedException, FileNotFoundException {
		Interface newUser = new Interface();
		newUser.startUpSequence();

		Calendar calendar = Calendar.getInstance();
		System.out.println("The current date is : " + calendar.getTime());
		calendar.add(Calendar.DATE, -15);
		System.out.println("15 days ago: " + calendar.getTime());
		calendar.add(Calendar.MONTH, 4);
		System.out.println("4 months later: " + calendar.getTime());
		calendar.add(Calendar.YEAR, 2);
		System.out.println("2 years later: " + calendar.getTime());

	}

}
