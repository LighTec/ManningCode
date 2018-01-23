/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gp6novelprobabilities;

import java.io.IOException;

/**
 *
 * @author Kell
 */
public class GP6NovelProbs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        String pathToText = ("C:\\Users\\Kell\\Desktop\\Code\\Text_Files\\Adventures_Of_Sherlock_Holmes.txt");
        TextFile textFile = new TextFile(pathToText);
        String text = textFile.readFile(pathToText);
        CharProbability[] charProbs = CryptoAnalysis.charProbabilitiesOf(text);
        
        float sum = 0;
        
        for(int i = 0; i < charProbs.length; i++){
            System.out.println(charProbs[i].getChar() + " = " + charProbs[i].toString());
            sum = sum + charProbs[i].getProbability();
        }
        
        System.out.println("Sum = " + sum);
    }
    
}
