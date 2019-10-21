import java.util.Scanner;
import java.io.*;
import java.io.FileOutputStream;

public class Testing {

	public void reader() throws FileNotFoundException {

		Scanner input = new Scanner(new File("database.txt"));
		while (input.hasNextLine()) {
			String line = input.nextLine();
			System.out.println(line);
			Scanner lineScan = new Scanner(line);
			while (lineScan.hasNext()) {
				String word = lineScan.next();
          //System.out.println(word);
			}
		}
	}

	static void reader(String credentials) throws FileNotFoundException {
		String test = credentials;
		Scanner input = new Scanner(new File("database.txt"));
		while (input.hasNextLine()) {
			String line = input.nextLine();
         if(line.contains(test)){
			System.out.println(line);
         }
		}
	}

	static void writer(String[] databasewrite) throws FileNotFoundException {
		try {
			PrintStream output = new PrintStream(new FileOutputStream("database.txt", true));
			for (int i = 0; i < databasewrite.length; i++) {
				output.append(databasewrite[i] + " ");
			}
			output.append("\n");
			output.close();
		} catch (FileNotFoundException ex) {
			System.out.println("fail");
		}
	}

//overload writer function to write envoice
	static void writer(String[] databasewrite, String name) throws FileNotFoundException {
		try {

			PrintStream output = new PrintStream(new FileOutputStream(name +"_"+databasewrite[0]+ ".txt", true));

			output.append("Hi, your event number " + databasewrite[0] + " has been booked\n\n");
			output.append("We are looking forward in hosting your " + databasewrite[1].replace("_", " ") + "\n");
			output.append("Your event will be facilitated by " + databasewrite[2].replace("_", " ") + "\n");
			output.append("Plese check details for the event:\nStarting date is " + databasewrite[4] + " at "
					+ databasewrite[6] + "\n");
			output.append("\nEvent is set to end " + databasewrite[5] + " at "
					+ databasewrite[7] + "\n");
			output.append("Please check details specific for your event \n" + databasewrite[9].replace("_", " "));
			output.append("\nAmount owed is " + databasewrite[8] + "dkk");

			output.close();
		}

		catch (FileNotFoundException ex) {
			System.out.println("fail");
		}
	}

	static void deleteEvent(String eventID) throws FileNotFoundException {

		File inputFile = new File("database.txt");
		File tempFile = new File("tempDatabase.txt");

		Scanner reader = new Scanner(inputFile);
		PrintStream writer = new PrintStream(new FileOutputStream(tempFile));

		while (reader.hasNextLine()) {
			String line = reader.nextLine();
			if (line.contains(eventID) != true)
				writer.append(line + "\n");
			continue;
		}
		writer.close();
		reader.close();
		tempFile.renameTo(inputFile);
	}
}