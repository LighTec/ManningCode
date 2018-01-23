/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gp5novelhistogram;

import java.io.IOException;

/**
 *
 * @author Kell
 */
public class GP5NovelHistogram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        String pathToText = ("C:\\Users\\Kell\\Desktop\\Code\\Text_Files\\Adventures_Of_Sherlock_Holmes.txt");
        TextFile textFile = new TextFile(pathToText);
        String text = textFile.readFile(pathToText);
        CharFrequency[] charFreqs = CryptoAnalysis.charFrequenciesOf(text);
        
        for(int i = 0; i < charFreqs.length; i++){
            System.out.println(charFreqs[i].toString());
        }
    }
    
}
