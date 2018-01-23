/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpj36_fileinput;

import java.io.File;
import java.text.NumberFormat;
import java.util.Scanner;
import java.io.IOException;

/**
 *
 * @author kell-gigabyte
 */
public class FileInput {

    public static void readTheFile(String fileName) throws IOException{

        Scanner sf = new Scanner(new File(fileName));
        int maxIndx = -1; //-1 so when we increment below, the first index is 0
        String text[] = new String[1000]; //To be safe, declare more than we need
        while (sf.hasNext()) {
            maxIndx++;
            text[maxIndx] = sf.nextLine();
        } 
        //System.out.println(text[maxIndx]); //Remove rem for testing                     
        //maxIndx is now the highest index of text[]. Equals -1 if no text lines
        sf.close(); //We opened a file above, so close it when finished.
        //System.exit(0);  //Use this for testing… to temporarily end the program here
        for (int j = 0; j <= maxIndx; j++) {       //Typically, only one of the following two will be used.
            //StringTokenizer st = new StringTokenizer( text[j] );
            //Scanner sc = new Scanner(text[j]);
            //…code specific to the task…
            System.out.println(text[j]);  //Remove rem for testing
        }
    }
}
