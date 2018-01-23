/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz_revconsonant;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author kell-gigabyte
 */
public class Quiz_RevConsonant {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        System.out.println("enter name here");
        Scanner kbIn = new Scanner(System.in);
        String strRaw = kbIn.nextLine();
        kbIn.close();
        String strLetters = strRaw.replaceAll("\\s+","");
        String strRev = "";
        for (int i = 0; i < strLetters.length(); i++) {
            char c = strLetters.charAt(strLetters.length() - i - 1);

            switch (c) {
                case 'a':
                    break;
                case 'e':
                    break;
                case 'i':
                    break;
                case 'o':
                    break;
                case 'u':
                    break;
                default:
                    strRev += c;
                    break;

            }
        }
        String strLow = strRev.toLowerCase();
        System.out.println(strLow);
        strRev.toLowerCase();
        System.out.println(strRev);
    }

}
