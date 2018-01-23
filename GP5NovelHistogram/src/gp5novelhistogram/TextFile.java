/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gp5novelhistogram;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Kell
 */
public class TextFile {
    
    public String path;
    public String fileContent;
    
    public TextFile(String path) { // throws IOException ?
        this.path = path;
    }
    
    public void encrypt() {
        char[] tempArr = this.fileContent.toCharArray();
        char[] encryptedArr = EnDecypher.encrypt(tempArr);
        this.fileContent = String.valueOf(encryptedArr);
        //System.out.println("Encryption completed. Output:");  // For testing
        //System.out.println(this.fileContent);
    }
    
    public void decrypt(){
        char[] tempArr = this.fileContent.toCharArray();
        char[] encryptedArr = EnDecypher.decrypt(tempArr);
        this.fileContent = String.valueOf(encryptedArr);
        //System.out.println("Decryption completed. Output:");  // For testing
        //System.out.println(this.fileContent);
    }
    
    public void saveToDisk(String path) throws IOException
    {
        
        System.out.println(path);
        FileWriter write = new FileWriter(path);
        PrintWriter printr = new PrintWriter(write);
        printr.println(this.fileContent);
        printr.close();
        write.close();
    }

    public static String readFile(String path) throws IOException
    { 
        
        System.out.println(path);
        Scanner reader = new Scanner(new File(path));
        String text = reader.nextLine();
        while(reader.hasNextLine()){
            text += reader.nextLine() + " ";
        }
        reader.close();
        return text;
    }

}
