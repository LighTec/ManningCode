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

public class CharFrequency{

    private char letter;
    private int frequency;

    public CharFrequency(char letter) {
        this.letter = letter;
        this.frequency = 0;
    }
    
    public CharFrequency(char letter, int freq) {
        this.letter = letter;
        this.frequency = freq;
    }
        
    public int getFrequency() {
        return this.frequency;
    }

    public char getChar() {
        return this.letter;
    }

    public void plusOne() {
        frequency++;
    }
    
    @Override
    public String toString(){
        // convenience method for printing this object
        return letter + " = " + frequency;
    }    
}
