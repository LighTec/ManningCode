/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gp7sortedprobs;

import java.io.IOException;

/**
 *
 * @author Kell
 */
public class GP7SortedProbs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        String pathToText = ("Adventures_Of_Sherlock_Holmes.txt");
        TextFile textFile = new TextFile(pathToText);
        String text = textFile.readFile(pathToText);
        CharProbability[] charProbs = CryptoAnalysis.sortedCharProbabilitiesOf(text);
        
        for(int i = 0; i < charProbs.length; i++){
            System.out.println(charProbs[i].getChar() + " = " + charProbs[i].toString());
        }
    }
    
}
