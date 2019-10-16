import java.util.Scanner;
import java.io.*;
import java.io.FileOutputStream; 


public class Testing  {

public void reader()throws FileNotFoundException{

Scanner input = new Scanner(new File("database.txt"));
while (input.hasNextLine())
{String line = input.nextLine();
System.out.println(line);
Scanner lineScan= new Scanner(line);
while (lineScan.hasNext()) 
{String word = lineScan.next();
//System.out.println(word);
}
}}

public void reader(String credentials)throws FileNotFoundException{
String test = credentials;
System.out.print(test);
Scanner input = new Scanner(new File("database.txt"));
while (input.hasNextLine())
{String line = input.nextLine();
System.out.println(line);
Scanner lineScan= new Scanner(line);
while (lineScan.hasNext()) 
{String word = lineScan.next();
//System.out.println(word);
}
}}


//overload function to write envoice
static void writer(String[] databasewrite)throws FileNotFoundException{
try {
//PrintStream output= new PrintStream(new File("test2.txt"));
PrintStream output = new PrintStream(new FileOutputStream("database.txt",true));

for (int i =0; i <databasewrite.length;i++){
output.append(databasewrite[i] + " ");

}
output.append("\n");
output.close();
}

catch (FileNotFoundException ex)
{
System.out.println("fail");
}



}



}

