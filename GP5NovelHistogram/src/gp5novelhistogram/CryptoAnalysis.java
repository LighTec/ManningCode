/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gp5novelhistogram;

/**
 *
 * @author Kell
 */
public class CryptoAnalysis {

    public static CharFrequency[] charFrequenciesOf(String theTextStr) {
        CharFrequency[] charFreqs = new CharFrequency[26 + 26 + 10]; // 0 to 9, a to z, A to Z
        int count = 0;
        for (int lp = 0; lp < 10; lp++) {                           // Numbers
            charFreqs[count] = new CharFrequency((char) (48 + lp));
            count++;
        }
        for (int lp = 0; lp < 26; lp++) {                           // Lower Case
            charFreqs[count] = new CharFrequency((char) (97 + lp));
            count++;
        }
        for (int lp = 0; lp < 26; lp++) {                           // Upper Case
            charFreqs[count] = new CharFrequency((char) (65 + lp));
            count++;
        }

        for (int i = 0; i < theTextStr.length(); i++) {
            char c = theTextStr.charAt(i);
            for (int chk = 0; chk < charFreqs.length; chk++) {
                CharFrequency currentChar = charFreqs[chk];
                if (c == currentChar.getChar()) {
                    currentChar.plusOne();
                    break;
                }
            }
        }
        
        return charFreqs;
    }

}
