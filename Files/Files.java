package files;

import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Jorge Castillo
 */
public class Files {

    public static void main(String[] args) {
        
        //Renaming files:
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter the name of the file you want to seach for:");
        String fileName = kb.nextLine();
        fileName += ".txt";
        File f = new File(fileName);
        String newName=null;
        boolean status = false;
        
        /*if(f.exists()){
            System.out.println("File found.");
            System.out.println(fileName);
            System.out.println("Enter the new name of the file:");
            newName = kb.nextLine();
            status = RenameFile(f, fileName, newName);
            
            if(status) {
                System.out.println("Done!");
                System.out.println("New name: " + newName + ".txt");
            }
        }
        else {
            System.out.println("File not found.");
        }*/
        
        //Reading a file:
        ReadFile(fileName);
        
        //Writing into a file:
        WriteFile(fileName);
    }
    
    public static boolean RenameFile(File f, String source, String newName) {
        String extension = ".txt";
        
        System.out.println("Renaming file...");
            
        return (f.renameTo(new File(newName+extension)));
    }
    
    public static void ReadFile(String source) {
        
        String fileLine=null;
        
        try {
            FileReader fr = new FileReader(source);
            BufferedReader buffer = new BufferedReader(fr);
            
            System.out.println("File content:\n");
            while((fileLine = buffer.readLine()) != null) {
                System.out.println(fileLine);
            }
            System.out.println("End of File.");
            
            buffer.close();
            /*Another way to read the file using FileInputStream:
            
            FileInputStream in = new FileInputStream(source);
            Scanner fileReading = new Scanner(in,"UTF-8");
            String txt = fileReading.next();
            System.out.println(txt);
            System.out.println("End of File.");
            */
            
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        
    }
    
    public static void WriteFile(String source) {
        
        FileWriter fw;
        PrintWriter w = null;
        try {
            fw = new FileWriter(source,true);
            w = new PrintWriter(fw);
            
            w.append("New Line added!");
            
            w.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
}