/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend_models;

/**
 *
 * @author Kell
 */
public class CryptoAnalysis {

    public static CharFrequency[] charFrequenciesOf(String theTextStr) {
        CharFrequency[] charFreqs = new CharFrequency[140]; // all ascii chars
        for (int lp = 0; lp < charFreqs.length; lp++) {
            charFreqs[lp] = new CharFrequency((char) (lp));
            //System.out.println(charFreqs[lp].toString());
        }

        for (int i = 0; i < theTextStr.length(); i++) {
            char c = theTextStr.charAt(i);
            for (CharFrequency currentChar : charFreqs) {
                if (c == currentChar.getChar()) {
                    currentChar.plusOne();
                    break;
                }
            }
        }

        return charFreqs;
    }

    public static CharProbability[] charProbabilitiesOf(String theTextStr) {
        CharFrequency[] charFreqs;
        CharProbability[] charProbs;
        charFreqs = charFrequenciesOf(theTextStr);
        charProbs = new CharProbability[charFreqs.length];

        int charSum = 0;

        for (int i = 0; i < charFreqs.length; i++) {
            charSum += charFreqs[i].getFrequency();
        }

        for (int i = 0; i < charFreqs.length; i++) {
            float freqMath = charFreqs[i].getFrequency() / (float) charSum;
            //System.out.println("Char freq: " + charFreqs[i].getChar() + "   " + freqMath);   // Prints off the floats before turning into an object
            CharProbability tempProb = new CharProbability(charFreqs[i].getChar(), freqMath);
            charProbs[i] = tempProb;
        }
        //System.out.println("Total chars: " + charSum);      // Prints off the sum of chars
        return charProbs;
    }

    public static CharProbability[] sortedCharProbabilitiesOf(String theTextStr) {

        CharFrequency[] charFreqs;
        CharProbability[] charProbs;
        charFreqs = charFrequenciesOf(theTextStr);
        charProbs = new CharProbability[charFreqs.length];

        int charSum = 0;

        for (int i = 0; i < charFreqs.length; i++) {
            charSum += charFreqs[i].getFrequency();
        }

        for (int i = 0; i < charFreqs.length; i++) {
            float freqMath = charFreqs[i].getFrequency() / (float) charSum;
            //System.out.println("Char freq: " + charFreqs[i].getChar() + "   " + freqMath);   // Prints off the floats before turning into an object
            CharProbability tempProb = new CharProbability(charFreqs[i].getChar(), freqMath);
            charProbs[i] = tempProb;
        }

        boolean sorted = false;
        boolean swapped;
        while (!sorted) {
            swapped = false;
            for (int i = 0; i < charProbs.length - 1; i++) {
                CharProbability curr = charProbs[i];
                CharProbability next = charProbs[i + 1];
                if (curr.getProbability() < next.getProbability()) {
                    charProbs[i] = next;
                    charProbs[i + 1] = curr;
                    swapped = true;
                }
            }
            if (!swapped) {
                sorted = true;
            }
        }

        int firstNumNull = -1;
        double cutOff = (1 / 10000);
        //System.out.println("cutoff = " + cutOff);
        for (int i = 0; i < charProbs.length; i++) {
            //if (charProbs[i].getProbability() < cutOff) {
            //    System.out.println("First sorted num that doesn't matter: " + charProbs[i].getChar());
            //    firstNumNull = i;
            //    break;
            //}
            if (firstNumNull == -1 && charProbs[i].getProbability() == 0) {
                firstNumNull = i;
                //System.out.println("First sorted num that doesn't matter: " + charProbs[i].getChar());
            }
        }

        CharProbability[] charProbsLimited = new CharProbability[firstNumNull];
        for (int i = 0; i < firstNumNull; i++) {
            charProbsLimited[i] = charProbs[i];
        }

        return charProbsLimited;
    }
    
    public static String approxDecrypt(String cipherTxt, String charListSortedByProbabilities) {
        //System.out.println("cipherText is: " + cipherTxt);
        //System.out.println("charListSortedByProbabilities is: " + charListSortedByProbabilities);
        CharProbability[] cipherCharListSortedByProbabilities = CryptoAnalysis.sortedCharProbabilitiesOf(cipherTxt);
        String cipherCharListSortedByProbsStr = "";
        for(int i = 0; i < cipherCharListSortedByProbabilities.length; i++){
            cipherCharListSortedByProbsStr += cipherCharListSortedByProbabilities[i].getChar();
        }
        //System.out.println("Prob char list is: " + cipherCharListSortedByProbsStr);
        int maxMatchedUpLetterCount = charListSortedByProbabilities.length();
        if (maxMatchedUpLetterCount > cipherCharListSortedByProbsStr.length()) {
            maxMatchedUpLetterCount = cipherCharListSortedByProbsStr.length();
        }
/**
 * 
 *              HOW TO FIX THIS
 *                  make it so you can save the sorted probability distribution
 *                  of the UNENCRYPTED version to compare. Then load it from a
 *                  file instead of the A to M triangle, and use that.
 * 
 * 
 */
        char[] cipherTextArray = cipherTxt.toCharArray();
        for (int i = 0; i < cipherTextArray.length; i++) {
            char currentCipherChar = cipherTextArray[i];
            int currentCipherCharIndex = -1;
            for (int j = 0; j < maxMatchedUpLetterCount; j++) {
                if (cipherCharListSortedByProbsStr.charAt(j) == currentCipherChar) {
                    currentCipherCharIndex = j;
                    //System.out.println("changed ");
                }
            }

            if (currentCipherCharIndex > -1) {
                char decryptedChar = charListSortedByProbabilities.charAt(currentCipherCharIndex);
                cipherTextArray[i] = decryptedChar;
                //System.out.println("changed "+currentCipherCharIndex+" to "+decryptedChar);
            }
        }
        String decryptedString = new String(cipherTextArray);
        return decryptedString;
    }
    
    
/*
    public static String approxDecrypt(String cipherTxt, String charListSortedByProbabilities) {
        CharProbability[] cipherCharListSortedByProbabilities = CryptoAnalysis.sortedCharProbabilitiesOf(cipherTxt);
        int maxMatchedUpLetterCount = charListSortedByProbabilities.length();
        if (maxMatchedUpLetterCount > cipherCharListSortedByProbabilities.length) {
            maxMatchedUpLetterCount = cipherCharListSortedByProbabilities.length;
        }

        char[] cipherTextArray = cipherTxt.toCharArray();
        for (int i = 0; i < cipherTextArray.length; i++) {
            char currentCipherChar = cipherTextArray[i];
            int currentCipherCharIndex = -1;
            for (int j = 0; j < maxMatchedUpLetterCount; j++) {
                if (cipherCharListSortedByProbabilities[j].getChar() == currentCipherChar) {
                    currentCipherCharIndex = j;
                    System.out.println("changed ");
                }
            }

            if (currentCipherCharIndex > -1) {
                char decryptedChar = charListSortedByProbabilities.charAt(currentCipherCharIndex);
                cipherTextArray[i] = decryptedChar;
                System.out.println("changed "+currentCipherCharIndex+" to "+decryptedChar);
            }
        }
        String decryptedString = new String(cipherTextArray);
        return decryptedString;
    }
*/
}
