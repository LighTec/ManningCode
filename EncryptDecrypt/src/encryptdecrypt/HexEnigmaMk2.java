/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryptdecrypt;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author kell-gigabyte
 */
public class HexEnigmaMk2 implements EncDec {

    public HexEnigmaMk2() {
        al = new AsciiLookup();
    }

    private char[] msgArray;
    private int direction = 0;
    private String finalMsg;
    private AsciiLookup al;

    @Override
    public String encrypt(String s) {
        // Split string into characters
        // multiply each index character's Ascii Character by the ASCII vaue of the index of the next character  (foo[1] = foo[1] * foo[2])
        // add the index value to each index ( index 5 will be +5 to the multiplied character) Note: maximum message length of 49152 characters due to integer overflow.
        // Turn to 4 hexidecimal characters

        finalMsg = "";
        msgArray = s.toCharArray(); // String to char array
        ArrayList<Integer> intArr = new ArrayList();
        for (char c : msgArray) {
            intArr.add((int) c); // char array to int array
        }
        ArrayList<Integer> multArr = new ArrayList();
        for (int i = 0; i < intArr.size(); i++) { // Does the multiplication step
            if (i + 1 == intArr.size()) {
                multArr.add(intArr.get(i));
            } else {
                multArr.add(intArr.get(i) * intArr.get(i + 1));
            }
        }
        System.out.println(multArr.toString());
        direction = 1; // direction and amplitude of enigma portion
        for (int up = 0; up < msgArray.length; up++) {
            char tempChar = al.shiftChar(msgArray[up], up * direction);
            String tempStr = al.charToHex(tempChar);
            finalMsg += tempStr;
            finalMsg = finalMsg.toUpperCase();

        }
        return finalMsg;
    }

    @Override
    public String decrypt(String s) {
        // Turn 4 hexidecimal numbers back to integers
        // subtract index values
        // take last character to find second last, continue until all integers divided into original form
        // Turn back into a string
        finalMsg = "";
        Scanner breaker = new Scanner(s);
        breaker.useDelimiter(" ");
        ArrayList<String> hexArr = new ArrayList();
        for (int i = 0; breaker.hasNext(); i++) {
            String temp = breaker.next();
            temp = temp.trim();
            hexArr.add(temp);
        }
        direction = -1;

        for (int up = 0; !hexArr.isEmpty(); up++) {

            char tempChar = al.shiftChar(al.hexToChar(hexArr.remove(0)), up * direction);
            finalMsg += tempChar;
        }
        return finalMsg;
    }

}
