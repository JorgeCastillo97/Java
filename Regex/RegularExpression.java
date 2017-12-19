/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regularEx;

/**
 *
 * @author Jorge Castillo
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Random;


public class RegularExpression {
    
    //  L((0+10)*(e+1))

    public static void main(String[] args) throws InterruptedException, IOException {
        
        String source = "Exp.txt",s;
        Scanner sc = new Scanner(System.in);
        /*File f = new File(source);
        FileWriter fw = new FileWriter(f);
        PrintWriter w = new PrintWriter(fw);*/
        byte op;
        int num,i;
        
        if(WriteMessage("\t\t\tStrings Generated:", source)) {
            System.out.println("Message written successfully.");
            Thread.sleep(1000);
            do {
                
                System.out.println("Choose an option:\n1)Generate expressions\n2)Exit");
                op=sc.nextByte();
                if(op==1) {
                    System.out.println("How many strings will be generated?");
                    num = sc.nextInt();
                    
                    for(i=0;i<num;i++) {
                        s=Generate();
                        WriteFile(source,s,(i+1));
                    }
                }
            } while (op == 1);
        }
        ReadFile(source);
        System.out.println("Programm finished.");
        Thread.sleep(2000);
    }
    
    public static boolean WriteMessage(String msg, String src) {
        File f;
        FileWriter fw;
        PrintWriter w = null;
        try {
            f = new File(src);
            fw = new FileWriter(f);
            w = new PrintWriter(fw);
            
            w.println(msg);
            return true;
            
        } catch (IOException e) {
            e.getMessage();
            return false;
        } finally {
            if(w != null) {
                w.close();
            }
        }
    }
    
    public static String Generate() {
        
        StringBuilder exp = new StringBuilder();
        Random rnd = new Random();
        int r,cl,i;
        
        do {
            cl=rnd.nextInt(50);
        } while (cl == 0);
        r=rnd.nextInt(2);
        if(r==1) {
            for(i = 0; i < cl; i++) {
                exp.append("0");
            }
            r=rnd.nextInt(2);
            if(r==1) {
                exp.append("1");
            }
        }
        else {
            for(i = 0; i < cl; i++) {
                exp.append("10");
            }
            r=rnd.nextInt(2);
            if(r==1) {
                exp.append("1");
            }
        }
        return exp.toString();
    }
    
    public static void WriteFile(String src, String ex, int index) {
        
        File f;
        FileWriter fw = null;
        PrintWriter w = null;
        try {
            f = new File(src);
            if(f.exists()) {
                fw = new FileWriter(f,true);
            }
            else {
                System.out.println("File not found.");
                System.out.println("Programm finished.");
                System.exit(0);
            }
            
            w = new PrintWriter(fw);
            System.out.println("String " + index+" received: "+ex);
            w.println(ex);
            
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if(w != null) {
                w.close();
            }
        }
        
    }
    
    public static void ReadFile(String src) throws IOException {
        
        String line=null;
        int  numberOfStrings=5,i=0;
        
        FileReader fr;
        BufferedReader r =  null;
        try {
            fr = new FileReader(src);
            r = new BufferedReader(fr);
            while((line = r.readLine()) != null) {
                System.out.println(line);
                i++;
                if(i>numberOfStrings) {
                    break;
                }
            }
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (r != null) {
                r.close();
            }
        }
        
    }
    
}