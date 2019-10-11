import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;  

public class CreateDatabase {

    /**
     * This class shows how to create a File in Java
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        String fileSeparator = System.getProperty("file.separator");
        
        //absolute file name with path
        String absoluteFilePath = "/Users/preislersmac/Desktop/DAT/*ProjektEventOrganizer*/file.txt";
        File file = new File(absoluteFilePath);
        if(file.createNewFile()){
            System.out.println(absoluteFilePath+" File Created");
        }else System.out.println("File "+absoluteFilePath+" already exists");
        
        
        try{    
             FileOutputStream fout=new FileOutputStream("/Users/preislersmac/Desktop/DAT/*ProjektEventOrganizer*/file.txt");
  
             String s=("Welcome to javaTpoint.");    
             byte b[]=s.getBytes();//converting string into byte array    
             fout.write(b);    
             fout.close();    
             System.out.println("success...");    
            }catch(Exception e){System.out.println(e);
    }

}

}