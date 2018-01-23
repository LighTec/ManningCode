/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encdec;

import java.io.IOException;

/**
 *
 * @author Kell
 */
public class GP3EncDec {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        String plainFilePath = "Iliad_Homer.txt";
        String encryptedFilePath = "Iliad_Homer_Encrypted.txt";
        
        TextFile file = new TextFile(plainFilePath);
        file.fileContent = file.readFile(plainFilePath);
        System.out.println(file.fileContent);
        file.encrypt();
        file.saveToDisk(encryptedFilePath);
        file.decrypt();
        

    }

}
