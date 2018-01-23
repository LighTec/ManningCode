/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryptdecrypt;

/**
 *
 * @author kell-gigabyte
 */
public class AsciiLookup {

    private final int AsciiLength = 94;

    private final int min = 32;
    private final int max = 126;

    public AsciiLookup() {

    }

    /**
     *
     * @param initial The initial integer given, encrypted
     * @param offset The amount the original integer has been offset, can be
     * postive or negative.
     * @return
     */
    public char shiftChar(char initial, int offset) {
        char c;
        int charToBe = initial + offset;
        //System.out.println("Shifting char now.");
        while (this.min > charToBe || charToBe > this.max) {
            if (charToBe > this.max) {
                charToBe -= this.AsciiLength;
            } else if (charToBe < this.min) {
                charToBe += this.AsciiLength;
            }
        }
        c = (char) charToBe;
        return c;
    }

    /**
     *2
     * @param s Length of two, has to be 2 hex symbols.
     * @return the char
     */
    public char hexToChar(String s) {
        char c;
        //System.out.println(s);
        int i = Integer.parseInt(s, 16);
        c = (char) i;
        //System.out.println(c);
        return c;
    }
    
    public String charToHex(char c){
        return Integer.toHexString(c) + " ";
    }
}
