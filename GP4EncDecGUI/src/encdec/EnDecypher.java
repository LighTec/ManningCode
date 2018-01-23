/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encdec;

/**
 *
 * @author Kell
 */
public class EnDecypher {
    
    public static char[] encrypt(char[] plainText){
        //System.out.println("Char array length is " + plainText.length);  // For testing
        char[] cipherText = new char[plainText.length];                  //same length as the input array
        //System.out.println("New array length is " + cipherText.length);  // For testing
        for(int loop = 0; loop < cipherText.length; loop++)
        {
            cipherText[loop] = (char)(plainText[loop] + 13);
            //System.out.println("ran " + (loop + 1) + " times, turned " + plainText[loop] + " into " + cipherText[loop]);  // Diagnostic
        }
        //System.out.println("loop finished and String encrypted.");  // For testing
        return cipherText;
    }
    
    public static char[] decrypt(char[] cipherText){
        //System.out.println("Char array length is " + cipherText.length);  // For testing
        char[] plainText = new char[cipherText.length];                  //same length as the input array
        //System.out.println("New array length is " + plainText.length);  // For testing
        for(int loop = 0; loop < plainText.length; loop++)
        {
            plainText[loop] = (char)(cipherText[loop] - 13);
            //System.out.println("ran " + (loop + 1) + " times, turned " + cipherText[loop] + " into " + plainText[loop]); // Diagnostic
        }
        //System.out.println("loop finished and String decrypted.");  // For testing
        return plainText;
    }
}
