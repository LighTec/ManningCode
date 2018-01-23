/*
 * Created By Kell Larson for the Computer Science AP program during school year 2016/2017. Please ask before copying code.
 */
package rng;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Kell
 */
public class RNG {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random rngGenerator = new Random();
        System.out.println("enter 1 for 33 random ints in an inclusive range of 71-99. Press 2 for 27 random doubles the the inclusive range of 99.79-147.22\nPress 3 for the Monte Carlo Technique project.");
        Scanner kbReader = new Scanner(System.in);
        int i = kbReader.nextInt();
        //int i = 3;    // used for testing
        switch (i) {
            case 1:
                //System.out.println("integers");
                for (int j = 0; j < 33; j++) {
                    int ran = 71 + rngGenerator.nextInt(29);
                    System.out.print(ran + " ");
                }
                break;
            case 2:
                //System.out.println("floats");
                for (int k = 0; k < 27; k++) {
                    double ran = 99.79 + 47.44 * rngGenerator.nextDouble();
                    System.out.print(ran + " ");
                }
                break;
            case 3:
                //System.out.println("Monte Carlo");
                MonteCarlo Tester = new MonteCarlo(5, 3, 2);
                int cirCount = 0;
                int sqrCount = 0;
                for (int l = 0; l < 1000000; l++, sqrCount++) {    // max 2147483647 runs
                    double rainDropX = Tester.nextRainDrop_x();
                    double rainDropY = Tester.nextRainDrop_y();
                    
                    boolean insideCircle = Tester.insideCircle(rainDropX, rainDropY);
                    if(insideCircle == true){
                        cirCount++;
                    }
                }
                System.out.println("sqrCount = " + sqrCount + " cirCount = " + cirCount);
                double sideSq = Tester.h * Tester.k;
                //double numerator = sideSq * (double)cirCount;
                
                double denominator = (double)sqrCount * Math.pow(Tester.radius, 2);
                
                double piGuess = 4 * (cirCount * sideSq / denominator);
                
                System.out.println("Guess of PI: " + piGuess);
                break;
            default:
                System.out.println("number given does not specify any programs, default case triggered.");
        }
    }

}
