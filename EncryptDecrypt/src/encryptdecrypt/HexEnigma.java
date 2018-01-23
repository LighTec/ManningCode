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
public class HexEnigma implements EncDec {

    public HexEnigma() {
        al = new AsciiLookup();
    }

    private char[] msgArray;
    private int direction = 0;
    private String finalMsg;
    private AsciiLookup al;

    @Override
    public String encrypt(String s) {
        finalMsg = "";
        msgArray = s.toCharArray();
        direction = 1;
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